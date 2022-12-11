
import br.com.lanchonete.pessoas.*;
import br.com.lanchonete.produtos.Pedido;
import java.util.Scanner;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ProxyColaborador {

    /*Colaborador
    *Alterar senha
    *Cadastrar Pedido *
    *Alterar pedido
    *Consultar pedidos
    *Excluir pedidos 
    *Pesquisar intervalo de pedidos (metade)
     */
    //PEDIDOS
    DateTimeFormatter localDateFormatter = DateTimeFormatter.ofPattern("dd MM yyyy", new Locale("PT", "br"));

    public void cadastroPedido() {
        System.out.printf("Digite o CPF do cliente: ");

        Scanner input = new Scanner(System.in);
        String CPFCliente = input.nextLine();

        Cliente Cl = ProxyAdministrador.consultaCliente(CPFCliente);

        if (Cl != null) {

            Pedido novoPedido = new Pedido();
            novoPedido.setIdPedido();
            Pedido.setNumPedido();

            System.out.print("Insira a ID do produto principal do pedido: ");
            Integer idProduto = input.nextInt();
            novoPedido.setListaProdutos(idProduto);

            System.out.println("""
                               Escolha uma opção: 
                               1 - Inserir adicionais 
                               2 - Finalizar pedido
                               """);

            int i = input.nextInt();
            switch (i) {
                case 1 -> {
                    int j = 1;

                    while (j == 1) {
                        System.out.printf("Insira o Id do adicional: ");
                        Integer idAdicional = input.nextInt();
                        novoPedido.setListaProdutos(idAdicional);

                        System.out.println("""
                                            Escolha uma opção: 
                                            1 - Inserir novos adicionais 
                                            2 - Finalizar pedido
                                            """);
                        j = input.nextInt();
                    }
                    break;

                }

                case 2 -> {
                    break;
                }
            }
            novoPedido.setDataPedido(LocalDate.now().toString());
            novoPedido.setHoraPedido(LocalTime.now().toString());
            novoPedido.setHoraEntregaPedido(LocalTime.now().plusMinutes(50).toString());

            float valorTotal = 0;
            for (int k = 0; k < novoPedido.getListaProdutos().size(); k++) {
                for (int j = 0; j < ProxyAdministrador.getListaProdutos().size(); k++) {
                    if (novoPedido.getListaProdutos().get(k).equals(ProxyAdministrador.getListaProdutos().get(j).getIdProduto())) {
                        valorTotal += ProxyAdministrador.getListaProdutos().get(j).getValorProduto();
                    }
                }
            }
            novoPedido.setValorTotalPedido(valorTotal);
            novoPedido.setStatusPedido(1);
            Cl.setPedidosCliente(novoPedido);
        }

    }

    /*
    Status pedido
    *1 = Aceito
    *2 = Em andamento
    *3 = Saiu para entrega
    *4 = Entregue
    *0 = Cancelado*/
    public void listarPedidos() {
        System.out.println("""
                               Escolha uma opção: 
                               1 - Pesquisa por intervalo de data
                               2 - Pesquisa por intervalo de data e hora
                               3 - Fechar
                                """);
        Scanner input = new Scanner(System.in);
        int i = input.nextInt();

        switch (i) {
            case 1 -> {
                /*Scanner inputMin = new Scanner(System.in);
                Scanner inputMax = new Scanner(System.in);
                String intMin, intMax;
                System.out.println("Insira o intervalo (REPRESENTAÇÃO ANO-MÊS-DIA em número):\n DE: ");
                intMin = inputMin.nextLine();
                System.out.println("ATÉ\n");
                intMax = inputMax.nextLine();

                LocalDate dataMin = LocalDate.parse(intMin);
                LocalDate dataMax = LocalDate.parse(intMax);
                 */

                String diaMin;
                String diaMax;
                String mesMin;
                String mesMax;
                String anoMin;
                String anoMax;

                System.out.println("Insira o intervalo (representação em números (dois digitos para dia e mês)):\n DE");

                input = new Scanner(System.in);
                System.out.printf("Dia: ");
                diaMin = input.nextLine();

                System.out.printf("Mes: ");
                mesMin = input.nextLine();

                System.out.printf("Ano: ");
                anoMin = input.nextLine();

                System.out.println("ATÉ\n");

                System.out.printf("Dia:");
                diaMax = input.nextLine();

                System.out.printf("Mês: ");
                mesMax = input.nextLine();

                System.out.printf("Ano: ");
                anoMax = input.nextLine();

                LocalDate dataMin = LocalDate.parse(anoMin + "-" + mesMin + "-" + diaMin);
                LocalDate dataMax = LocalDate.parse(anoMax + "-" + mesMax + "-" + diaMax);

                for (int k = 0; k < ProxyAdministrador.Clientes.size(); k++) {
                    for (int j = 0; j < ProxyAdministrador.Clientes.get(k).getPedidosCliente().size(); j++) {
                        LocalDate dataPedido = LocalDate.parse(ProxyAdministrador.Clientes.get(k).getPedidosCliente().get(j).getDataPedido());
                        LocalDate dataPrint = LocalDate.parse(ProxyAdministrador.Clientes.get(k).getPedidosCliente().get(j).getDataPedido());
                        if (((dataPedido.isEqual(dataMin)) || (dataPedido.isAfter(dataMin))) && ((dataPedido.isEqual(dataMax)) || (dataPedido.isBefore(dataMax)))) {
                            System.out.println("Cliente: " + ProxyAdministrador.Clientes.get(k).getNomePessoa() + " " + ProxyAdministrador.Clientes.get(k).getSobrenomePessoa()
                                    + "\nEndereço: " + ProxyAdministrador.Clientes.get(k).getEnderecoCliente()
                                    + "\nTelefone: " + ProxyAdministrador.Clientes.get(k).getTelefoneCliente()
                                    + "\nPedido: " + ProxyAdministrador.Clientes.get(k).getPedidosCliente().get(j).getIdPedido()
                                    + "\nData Pedido: " + dataPrint.format(localDateFormatter)
                                    + "\nHora Pedido: " + ProxyAdministrador.Clientes.get(k).getPedidosCliente().get(j).getHoraPedido()
                                    + "\nStatus Pedido: " + ProxyAdministrador.Clientes.get(k).getPedidosCliente().get(j).getStatusPedido());
                        }
                    }
                }
                break;
            }

            case 2 -> {
                String diaMin;
                String diaMax;
                String mesMin;
                String mesMax;
                String anoMin;
                String anoMax;
                String horaMin;
                String horaMax;
                String minMin;
                String minMax;

                System.out.println("Insira o intervalo (representação em números (dois digitos para dia e mês)):\n DE");

                input = new Scanner(System.in);
                System.out.printf("Dia: ");
                diaMin = input.nextLine();

                System.out.printf("Mes: ");
                mesMin = input.nextLine();

                System.out.printf("Ano: ");
                anoMin = input.nextLine();

                System.out.printf("Hora: ");
                horaMin = input.nextLine();

                System.out.printf("Minuto: ");
                minMin = input.nextLine();

                System.out.println("ATÉ\n");

                System.out.printf("Dia:");
                diaMax = input.nextLine();

                System.out.printf("Mês: ");
                mesMax = input.nextLine();

                System.out.printf("Ano: ");
                anoMax = input.nextLine();

                System.out.printf("Hora: ");
                horaMax = input.nextLine();

                System.out.printf("Minuto: ");
                minMax = input.nextLine();

                LocalDate dataMin = LocalDate.parse(anoMin + "-" + mesMin + "-" + diaMin);
                LocalDate dataMax = LocalDate.parse(anoMax + "-" + mesMax + "-" + diaMax);
                LocalTime horaLimMin = LocalTime.parse(horaMin + ":" + minMin + ":" + "00");
                LocalTime horaLimMax = LocalTime.parse(horaMax + ":" + minMax + ":" + "00");

                for (int k = 0; k < ProxyAdministrador.Clientes.size(); k++) {
                    for (int j = 0; j < ProxyAdministrador.Clientes.get(k).getPedidosCliente().size(); j++) {
                        LocalDate dataPedido = LocalDate.parse(ProxyAdministrador.Clientes.get(k).getPedidosCliente().get(j).getDataPedido());
                        LocalTime horaPedido = LocalTime.parse(ProxyAdministrador.Clientes.get(k).getPedidosCliente().get(j).getHoraPedido());
                        LocalDate dataPrint = LocalDate.parse(ProxyAdministrador.Clientes.get(k).getPedidosCliente().get(j).getDataPedido());
                        if (((dataPedido.isAfter(dataMin) || dataPedido.isEqual(dataMin)) && horaPedido.isAfter(horaLimMin))
                                && ((dataPedido.isEqual(dataMax) || dataPedido.isBefore(dataMax)) && (horaPedido.isBefore(horaLimMax)))) {
                            System.out.println("Cliente: " + ProxyAdministrador.Clientes.get(k).getNomePessoa() + " " + ProxyAdministrador.Clientes.get(k).getSobrenomePessoa()
                                    + "\nEndereço: " + ProxyAdministrador.Clientes.get(k).getEnderecoCliente()
                                    + "\nTelefone: " + ProxyAdministrador.Clientes.get(k).getTelefoneCliente()
                                    + "\nPedido: " + ProxyAdministrador.Clientes.get(k).getPedidosCliente().get(j).getIdPedido()
                                    + "\nData Pedido: " + dataPrint.format(localDateFormatter)
                                    + "\nHora Pedido: " + ProxyAdministrador.Clientes.get(k).getPedidosCliente().get(j).getHoraPedido()
                                    + "\nStatus Pedido: " + ProxyAdministrador.Clientes.get(k).getPedidosCliente().get(j).getStatusPedido());
                        }
                    }
                }

                break;
            }

            case 3 -> {
                break;
            }
            default -> {
                break;
            }

        }
    }

    public void modificarPedido(int idPedido, Cliente Cl) {
        /*
        String CPF;
        System.out.printf("Digite o CPF do cliente: ");
        CPF = input.nextLine();
        Cliente Cl = ProxyAdministrador.consultaCliente(CPF);

        System.out.println("Pedidos feitos pelo Cliente " + Cl.getNomePessoa() + " " + Cl.getSobrenomePessoa() + ": ");
        for (int i = 0; i < Cl.getPedidosCliente().size(); i++) {
            System.out.println("IdPedido: " + Cl.getPedidosCliente().get(i).getIdPedido() + "    Data: "
                    + Cl.getPedidosCliente().get(i).getDataPedido());
        }
        System.out.println("Digite o ID do pedido que deseja alterar ");
        int idPedido = input.nextInt();
        */
        Scanner input = new Scanner(System.in);
        if (consultarPedido(idPedido, Cl) != null) {
            Pedido modPedido = consultarPedido(idPedido, Cl);
            System.out.println("DADOS DO PEDIDO\n------------------------\n");
            System.out.println("Id: " + modPedido.getIdPedido() + "    Data:" + modPedido.getDataPedido() + "     Hora: " + modPedido.getHoraPedido() +
                    "    Hora de entrega: " + modPedido.getHoraEntregaPedido() + "    Valor total: " + modPedido.getValorTotalPedido() + "     Status: " + modPedido.getStatusPedido() +
                     "\n-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
            System.out.println("""
                               Escolha uma opção: 
                               1 - Alterar Hora de Entrega do Pedido 
                               2 - Alterar Status do Pedido 
                               3 - Adicionar itens
                               4 - Remover itens
                               5 - Fechar
                                """);
            int i = input.nextInt();
            switch(i){
                case 1 ->{
                    System.out.println("Entre com a novo horário de entrega: ");
                    System.out.printf("Hora: ");
                    String novaHora = input.nextLine();
                    System.out.printf("Minutos: ");
                    String novoMin = input.nextLine();
                    
                    modPedido.setHoraEntregaPedido(novaHora + ":" + novoMin + ":" + "00"); 
                    System.out.println("Alteração realizada com sucesso!");
                    modificarPedido(idPedido, Cl);
                }
                case 2->{
                    System.out.println("""
                               Insira o código do novo status do pedido:  
                               1 - Aceito 
                               2 - Em andamento
                               3 - Saiu para entrega
                               4 - Entregue 
                               5 - Cancelado
                                """);
                    int novoStatus = input.nextInt();
                    modPedido.setStatusPedido(novoStatus);
                    System.out.println("Alteração realizada com sucesso!");
                    modificarPedido(idPedido, Cl);
                }
                case 3 ->{
                    System.out.printf("Insira o Id do item que deseja adicionar: ");
                    int novoItem = input.nextInt();
                    
                    modPedido.setListaProdutos(novoItem);
                    modPedido.setValorTotalPedido(modPedido.getValorTotalPedido() + ProxyAdministrador.consultaProduto(novoItem).getValorProduto());
                    System.out.printf("Alteração realizada com sucesso!");
                    modificarPedido(idPedido, Cl);
                }
                case 4 ->{
                    System.out.println("Insira o Id do item que deseja remover: ");
                    int removerItem = input.nextInt();
                    int f = 0;
                    for (int r = 0; r <= modPedido.getListaProdutos().size(); r++){
                        f++;
                        if (modPedido.getListaProdutos().get(r) == removerItem){
                            modPedido.getListaProdutos().remove(r);
                            modPedido.setValorTotalPedido(modPedido.getValorTotalPedido() - ProxyAdministrador.consultaProduto(removerItem).getValorProduto());
                            System.out.printf("Alteração realizada com sucesso!");
                            break;
                        }
                        else if (f > modPedido.getListaProdutos().size()){
                        System.out.println("Id inválido ou o produto não está associado a esse pedido. Tente novamente");
                        break;
                        }
                    modificarPedido(idPedido, Cl);
                    }
                }
                case 5 -> {
                    break;
                }
                
                default ->{
                    System.out.println("Opção inválida, tente novamente.");
                    modificarPedido(idPedido, Cl);
                }
                
            }
        }

    }

    public Pedido consultarPedido(int idPedido, Cliente Cl) {
        Pedido attPedido = new Pedido();
        attPedido = null;

        for (int i = 0; i < Cl.getPedidosCliente().size(); i++) {
            if (Cl.getPedidosCliente().get(i).getIdPedido() == idPedido) {
                attPedido = Cl.getPedidosCliente().get(i);
            }
        }
        return attPedido;
    }
    
    public void excluirPedido(){
        System.out.printf("Digite o CPF do cliente: ");
        Scanner input = new Scanner(System.in);
        String CPF = input.nextLine();
        
        Cliente Cl = ProxyAdministrador.consultaCliente(CPF);
        
        if (Cl != null){
            System.out.println("\nPEDIDOS CADASTRADOS\n--------------------------\n");
            for(int i = 0; i < Cl.getPedidosCliente().size(); i++){
                LocalDate dataPedido = LocalDate.parse(Cl.getPedidosCliente().get(i).getDataPedido());
                System.out.println("Id: " + Cl.getPedidosCliente().get(i).getIdPedido() +
                        "    Data: " + Cl.getPedidosCliente().get(i).getDataPedido() +
                        "    Hora: " + dataPedido.format(localDateFormatter));
            }
            
            System.out.printf("\nDigite o ID do pedido que deseja remover: ");
            int idRemPedido = input.nextInt();
            
            for (int p = 0; p < Cl.getPedidosCliente().size(); p++){
                if (Cl.getPedidosCliente().get(p).getIdPedido() == idRemPedido){
                    Cl.getPedidosCliente().remove(p);
                    System.out.println("Pedido removido com sucesso.");
                }
            }
        }
        
        
    }
}
