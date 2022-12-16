
import br.com.lanchonete.pessoas.*;
import br.com.lanchonete.produtos.Pedido;
import java.util.Scanner;
import java.time.*;
import java.time.format.*;
import java.util.*;

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
    //FORMATADOR COM RESTRIÇÃO QUE NOS GARANTE A VERIFICAÇÃO DE DATAS VÁLIDAS
    DateTimeFormatter localDateFormatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
    DateTimeFormatter localHourFormatter = DateTimeFormatter.ofPattern("HH:mm");

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

            boolean finalizarPedido = false;
            do {
                System.out.println("""
                               Escolha uma opção: 
                               1 - Inserir adicionais 
                               2 - Finalizar pedido
                               """);

                int i = input.nextInt();
                switch (i) {
                    case 1 -> {
                        Integer idAdicional = input.nextInt();
                        novoPedido.setListaProdutos(idAdicional);
                        break;
                    }

                    case 2 -> {
                        finalizarPedido = true;
                        break;
                    }

                    default -> {
                        System.out.println("\nOpção inválida. Tente novamente!\n");
                    }
                }

            } while (finalizarPedido == false);

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
        boolean encerrarLista = false;
        do {
            System.out.println("""
                               Escolha uma opção: 
                               1 - Pesquisa por intervalo de data
                               2 - Pesquisa por intervalo de data e hora
                               3 - Voltar
                                """);
            Scanner input = new Scanner(System.in);
            int i = input.nextInt();

            switch (i) {
                case 1 -> {
                    String diaMin = "";
                    String diaMax = "";
                    String mesMin = "";
                    String mesMax = "";
                    String anoMin = "";
                    String anoMax = "";
                    boolean validaMax = false;
                    boolean validaMin = false;

                    while (validaMax == false || validaMin == false) {
                        System.out.println("Insira o intervalo (representação em números (dois digitos para dia e mês)):\n DE");

                        input = new Scanner(System.in);
                        System.out.printf("Dia: ");
                        diaMin = input.nextLine();
                        if (diaMin.length() == 1) {
                            diaMin = "0" + diaMin;
                        }

                        System.out.printf("Mes: ");
                        mesMin = input.nextLine();
                        if (mesMin.length() == 1) {
                            mesMin = "0" + mesMin;
                        }

                        System.out.printf("Ano: ");
                        anoMin = input.nextLine();

                        System.out.println("ATÉ\n");

                        System.out.printf("Dia:");
                        diaMax = input.nextLine();
                        if (diaMax.length() == 1) {
                            diaMax = "0" + diaMax;
                        }

                        System.out.printf("Mês: ");
                        mesMax = input.nextLine();
                        if (mesMax.length() == 1) {
                            mesMax = "0" + mesMax;
                        }

                        System.out.printf("Ano: ");
                        anoMax = input.nextLine();

                        String dataMin = anoMin + mesMin + diaMin;
                        String dataMax = anoMax + mesMax + diaMax;

                        validaMin = isDateValid(dataMin);
                        validaMax = isDateValid(dataMax);
                    }

                    LocalDate dataMin = LocalDate.parse(anoMin + "-" + mesMin + "-" + diaMin);
                    LocalDate dataMax = LocalDate.parse(anoMax + "-" + mesMax + "-" + diaMax);
                    System.out.println("""
                                   
                                   ------------------------------------------------------------------------------------------------------------
                                   |                                   PEDIDOS CADASTRADOS NO SISTEMA                                         |
                                   ------------------------------------------------------------------------------------------------------------
                                   """);

                    for (int k = 0; k < ProxyAdministrador.getClientes().size(); k++) {
                        for (int j = 0; j < ProxyAdministrador.getClientes().get(k).getPedidosCliente().size(); j++) {
                            LocalDate dataPedido = LocalDate.parse(ProxyAdministrador.getClientes().get(k).getPedidosCliente().get(j).getDataPedido());
                            LocalDate dataPrint = LocalDate.parse(ProxyAdministrador.getClientes().get(k).getPedidosCliente().get(j).getDataPedido());
                            LocalTime horaPrint = LocalTime.parse(ProxyAdministrador.getClientes().get(k).getPedidosCliente().get(j).getHoraPedido());
                            LocalTime horaEntregaPrint = LocalTime.parse(ProxyAdministrador.getClientes().get(k).getPedidosCliente().get(j).getHoraEntregaPedido());
                            if (((dataPedido.isEqual(dataMin)) || (dataPedido.isAfter(dataMin))) && ((dataPedido.isEqual(dataMax)) || (dataPedido.isBefore(dataMax)))) {
                                System.out.println("Cliente: " + ProxyAdministrador.getClientes().get(k).getNomePessoa() + " " + ProxyAdministrador.getClientes().get(k).getSobrenomePessoa()
                                        + "\nEndereço: " + ProxyAdministrador.getClientes().get(k).getEnderecoCliente()
                                        + "\nTelefone: " + ProxyAdministrador.getClientes().get(k).getTelefoneCliente()
                                        + "\nPedido: " + ProxyAdministrador.getClientes().get(k).getPedidosCliente().get(j).getIdPedido()
                                        + "\nData Pedido: " + dataPrint.format(localDateFormatter)
                                        + "\nHora Pedido: " + horaPrint.format(localHourFormatter)
                                        + "\nHora de entrega: " + horaEntregaPrint.format(localHourFormatter)
                                        + "\nStatus Pedido: " + ProxyAdministrador.getClientes().get(k).getPedidosCliente().get(j).getStatusPedido()
                                        + "\nValor Pedido: " + ProxyAdministrador.getClientes().get(k).getPedidosCliente().get(j).getValorTotalPedido());
                            }
                        }
                    }
                    break;
                }

                case 2 -> {
                    String diaMin = ""; //dia do limite inferior
                    String diaMax = ""; //dia do limite superior
                    String mesMin = ""; //mes do limite inferior
                    String mesMax = ""; //mes do limite superior
                    String anoMin = ""; //ano do limite inferior
                    String anoMax = ""; //ano do limite superior
                    String horaMin = ""; //hora do limite inferior
                    String horaMax = ""; //hora do limite superior
                    String minMin = ""; //minutos do limite inferior
                    String minMax = ""; //minutos do limite superior
                    boolean validaDataMin = false;
                    boolean validaDataMax = false;
                    boolean validaHoraMin = false;
                    boolean validaHoraMax = false;

                    while (validaDataMin == false || validaDataMax == false || validaHoraMin == false || validaHoraMax == false) {
                        System.out.println("Insira o intervalo (representação em números (dois digitos para dia e mês)):\n DE");

                        input = new Scanner(System.in);
                        System.out.printf("Dia: ");
                        diaMin = input.nextLine();
                        if (diaMin.length() == 1) {
                            diaMin = "0" + diaMin;
                        }

                        System.out.printf("Mes: ");
                        mesMin = input.nextLine();
                        if (mesMin.length() == 1) {
                            mesMin = "0" + mesMin;
                        }

                        System.out.printf("Ano: ");
                        anoMin = input.nextLine();

                        System.out.printf("Hora: ");
                        horaMin = input.nextLine();
                        if (horaMin.length() == 1) {
                            horaMin = "0" + horaMin;
                        }

                        System.out.printf("Minuto: ");
                        minMin = input.nextLine();
                        if (minMin.length() == 1) {
                            minMin = "0" + minMin;
                        }

                        System.out.println("ATÉ\n");

                        System.out.printf("Dia:");
                        diaMax = input.nextLine();
                        if (diaMax.length() == 1) {
                            diaMax = "0" + diaMax;
                        }

                        System.out.printf("Mês: ");
                        mesMax = input.nextLine();
                        if (mesMax.length() == 1) {
                            mesMax = "0" + mesMax;
                        }

                        System.out.printf("Ano: ");
                        anoMax = input.nextLine();

                        System.out.printf("Hora: ");
                        horaMax = input.nextLine();
                        if (horaMax.length() == 1) {
                            horaMax = "0" + horaMax;
                        }

                        System.out.printf("Minuto: ");
                        minMax = input.nextLine();
                        if (minMax.length() == 1) {
                            minMax = "0" + minMax;
                        }

                        String dataMin = anoMin + mesMin + diaMin;
                        String dataMax = anoMax + mesMax + diaMax;
                        String limHoraMin = horaMin + ":" + minMin;
                        String limHoraMax = horaMax + ":" + minMax;

                        validaDataMin = isDateValid(dataMin);
                        validaDataMax = isDateValid(dataMax);
                        validaHoraMin = isHourValid(limHoraMin);
                        validaHoraMax = isHourValid(limHoraMax);

                    }

                    LocalDate dataMin = LocalDate.parse(anoMin + "-" + mesMin + "-" + diaMin);
                    LocalDate dataMax = LocalDate.parse(anoMax + "-" + mesMax + "-" + diaMax);
                    LocalTime horaLimMin = LocalTime.parse(horaMin + ":" + minMin + ":" + "00");
                    LocalTime horaLimMax = LocalTime.parse(horaMax + ":" + minMax + ":" + "00");
                    System.out.println("""
                                   
                                   ------------------------------------------------------------------------------------------------------------
                                   |                                   PEDIDOS CADASTRADOS NO SISTEMA                                         |
                                   ------------------------------------------------------------------------------------------------------------
                                   """);

                    for (int k = 0; k < ProxyAdministrador.getClientes().size(); k++) {
                        for (int j = 0; j < ProxyAdministrador.getClientes().get(k).getPedidosCliente().size(); j++) {
                            LocalDate dataPedido = LocalDate.parse(ProxyAdministrador.getClientes().get(k).getPedidosCliente().get(j).getDataPedido());
                            LocalTime horaPedido = LocalTime.parse(ProxyAdministrador.getClientes().get(k).getPedidosCliente().get(j).getHoraPedido());
                            LocalDate dataPrint = LocalDate.parse(ProxyAdministrador.getClientes().get(k).getPedidosCliente().get(j).getDataPedido());
                            LocalTime horaPrint = LocalTime.parse(ProxyAdministrador.getClientes().get(k).getPedidosCliente().get(j).getHoraPedido());
                            LocalTime horaEntregaPrint = LocalTime.parse(ProxyAdministrador.getClientes().get(k).getPedidosCliente().get(j).getHoraEntregaPedido());
                            if (((dataPedido.isAfter(dataMin) || dataPedido.isEqual(dataMin)) && horaPedido.isAfter(horaLimMin))
                                    && ((dataPedido.isEqual(dataMax) || dataPedido.isBefore(dataMax)) && (horaPedido.isBefore(horaLimMax)))) {
                                System.out.println("Cliente: " + ProxyAdministrador.getClientes().get(k).getNomePessoa() + " " + ProxyAdministrador.getClientes().get(k).getSobrenomePessoa()
                                        + "\nEndereço: " + ProxyAdministrador.getClientes().get(k).getEnderecoCliente()
                                        + "\nTelefone: " + ProxyAdministrador.getClientes().get(k).getTelefoneCliente()
                                        + "\nPedido: " + ProxyAdministrador.getClientes().get(k).getPedidosCliente().get(j).getIdPedido()
                                        + "\nData Pedido: " + dataPrint.format(localDateFormatter)
                                        + "\nHora Pedido: " + horaPrint.format(localHourFormatter)
                                        + "\nHora de Entrega: " + horaEntregaPrint.format(localHourFormatter)
                                        + "\nStatus Pedido: " + ProxyAdministrador.getClientes().get(k).getPedidosCliente().get(j).getStatusPedido());
                            }
                        }
                    }

                    break;
                }

                case 3 -> {
                    encerrarLista = true;
                    break;
                }
                default -> {
                    System.out.println("\nOpção inválida. Tente novamente!\n");
                    break;
                }

            }

        } while (encerrarLista == false);
    }

    public void modificarPedido(int idPedido, Cliente Cl) {
        Scanner input = new Scanner(System.in);
        boolean menuAnterior = false;
        do {
            if (consultarPedido(idPedido, Cl) != null) {
                Pedido modPedido = consultarPedido(idPedido, Cl);
                System.out.println("DADOS DO PEDIDO\n------------------------\n");
                System.out.println("Id: " + modPedido.getIdPedido() + "    Data:" + modPedido.getDataPedido() + "     Hora: " + modPedido.getHoraPedido()
                        + "    Hora de entrega: " + modPedido.getHoraEntregaPedido() + "    Valor total: " + modPedido.getValorTotalPedido() + "     Status: " + modPedido.getStatusPedido()
                        + "\n-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
                System.out.println("""
                               \nEscolha uma opção: 
                               1 - Alterar Hora de Entrega do Pedido 
                               2 - Alterar Status do Pedido 
                               3 - Adicionar itens
                               4 - Remover itens
                               5 - Fechar
                                """);
                int i = input.nextInt();
                switch (i) {
                    case 1 -> {
                        System.out.println("Entre com a novo horário de entrega: ");
                        System.out.printf("Hora: ");
                        String novaHora = input.nextLine();
                        System.out.printf("Minutos: ");
                        String novoMin = input.nextLine();

                        modPedido.setHoraEntregaPedido(novaHora + ":" + novoMin + ":" + "00");
                        System.out.println("Alteração realizada com sucesso!");
                    }
                    case 2 -> {
                        System.out.println("""
                               \nInsira o código do novo status do pedido:  
                               1 - Aceito 
                               2 - Em andamento
                               3 - Saiu para entrega
                               4 - Entregue 
                               5 - Cancelado
                                """);
                        int novoStatus = input.nextInt();
                        if (novoStatus == 5) {
                            modPedido.setHoraEntregaPedido("00:00:00");
                        }
                        modPedido.setStatusPedido(novoStatus);
                        System.out.println("Alteração realizada com sucesso!");
                    }
                    case 3 -> {
                        System.out.printf("Insira o Id do item que deseja adicionar: ");
                        int novoItem = input.nextInt();

                        modPedido.setListaProdutos(novoItem);
                        modPedido.setValorTotalPedido(modPedido.getValorTotalPedido() + ProxyAdministrador.consultaProduto(novoItem).getValorProduto());
                        System.out.printf("Alteração realizada com sucesso!");
                    }
                    case 4 -> {
                        System.out.println("Insira o Id do item que deseja remover: ");
                        int removerItem = input.nextInt();
                        int f = 0;
                        for (int r = 0; r <= modPedido.getListaProdutos().size(); r++) {
                            f++;
                            if (modPedido.getListaProdutos().get(r) == removerItem) {
                                modPedido.getListaProdutos().remove(r);
                                modPedido.setValorTotalPedido(modPedido.getValorTotalPedido() - ProxyAdministrador.consultaProduto(removerItem).getValorProduto());
                                System.out.printf("Alteração realizada com sucesso!");
                                break;
                            } else if (f > modPedido.getListaProdutos().size()) {
                                System.out.println("Id inválido ou o produto não está associado a esse pedido. Tente novamente");
                                break;
                            }
                        }
                    }
                    case 5 -> {
                        menuAnterior = true;
                        break;
                    }

                    default -> {
                        System.out.println("\nOpção inválida, tente novamente.\n");

                    }

                }
            }

        } while (menuAnterior == false);

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

    public void excluirPedido() {
        System.out.printf("Digite o CPF do cliente: ");
        Scanner input = new Scanner(System.in);
        String CPF = input.nextLine();

        Cliente Cl = ProxyAdministrador.consultaCliente(CPF);

        if (Cl != null) {
            System.out.println("\nPEDIDOS CADASTRADOS\n--------------------------\n");
            for (int i = 0; i < Cl.getPedidosCliente().size(); i++) {
                LocalDate dataPedido = LocalDate.parse(Cl.getPedidosCliente().get(i).getDataPedido());
                System.out.println("Id: " + Cl.getPedidosCliente().get(i).getIdPedido()
                        + "    Data: " + Cl.getPedidosCliente().get(i).getDataPedido()
                        + "    Hora: " + dataPedido.format(localDateFormatter));
            }

            System.out.printf("\nDigite o ID do pedido que deseja remover: ");
            int idRemPedido = input.nextInt();

            for (int p = 0; p < Cl.getPedidosCliente().size(); p++) {
                if (Cl.getPedidosCliente().get(p).getIdPedido() == idRemPedido) {
                    Cl.getPedidosCliente().remove(p);
                    System.out.println("Pedido removido com sucesso.");
                }
            }
        }

    }

    //FUNÇÃO DE ESTATÍSTICA DE VENDAS EM UM INTERVALO DE DATA
    public void statsVendas() {
        Scanner input = new Scanner(System.in);
        String diaMin = "";
        String diaMax = "";
        String mesMin = "";
        String mesMax = "";
        String anoMin = "";
        String anoMax = "";
        boolean validaMax = false;
        boolean validaMin = false;

        while (validaMax == false || validaMin == false) {
            System.out.println("Insira o intervalo (representação em números (dois digitos para dia e mês)):\n DE");

            input = new Scanner(System.in);
            System.out.printf("Dia: ");
            diaMin = input.nextLine();
            if (diaMin.length() == 1) {
                diaMin = "0" + diaMin;
            }

            System.out.printf("Mes: ");
            mesMin = input.nextLine();
            if (mesMin.length() == 1) {
                mesMin = "0" + mesMin;
            }

            System.out.printf("Ano: ");
            anoMin = input.nextLine();

            System.out.println("ATÉ\n");

            System.out.printf("Dia:");
            diaMax = input.nextLine();
            if (diaMax.length() == 1) {
                diaMax = "0" + diaMax;
            }

            System.out.printf("Mês: ");
            mesMax = input.nextLine();
            if (mesMax.length() == 1) {
                mesMax = "0" + mesMax;
            }

            System.out.printf("Ano: ");
            anoMax = input.nextLine();

            String dataMin = anoMin + mesMin + diaMin;
            String dataMax = anoMax + mesMax + diaMax;

            validaMin = isDateValid(dataMin);
            validaMax = isDateValid(dataMax);
        }

        LocalDate dataMin = LocalDate.parse(anoMin + "-" + mesMin + "-" + diaMin);
        LocalDate dataMax = LocalDate.parse(anoMax + "-" + mesMax + "-" + diaMax);
        ArrayList<Cliente> listaClientes = ProxyAdministrador.getClientes();

        float receitaTotal = 0;
        int qntCancelados = 0;
        int qntAceitos = 0;
        int qntEntregues = 0;
        System.out.println("""
                                   \n
                                   ------------------------------------------------------------------------------------------------------------
                                   |                                       RELATÓRIO DE VENDAS                                                |     
                                   |                                   PEDIDOS CADASTRADOS NO SISTEMA                                         |
                                   ------------------------------------------------------------------------------------------------------------
                                   \n
                                   """);

        for (int k = 0; k < listaClientes.size(); k++) {
            for (int j = 0; j < listaClientes.get(k).getPedidosCliente().size(); j++) {
                LocalDate dataPedido = LocalDate.parse(listaClientes.get(k).getPedidosCliente().get(j).getDataPedido()); //passar o novo formater
                LocalDate dataPrint = LocalDate.parse(listaClientes.get(k).getPedidosCliente().get(j).getDataPedido()); //passar o novo formater
                if (((dataPedido.isEqual(dataMin)) || (dataPedido.isAfter(dataMin))) && ((dataPedido.isEqual(dataMax)) || (dataPedido.isBefore(dataMax)))) {
                    System.out.println("Cliente: " + listaClientes.get(k).getNomePessoa() + " " + listaClientes.get(k).getSobrenomePessoa()
                            + "\nPedido: " + listaClientes.get(k).getPedidosCliente().get(j).getIdPedido()
                            + "\nData Pedido: " + dataPrint.format(localDateFormatter) //usar o novo formater 
                            + "\nHora Pedido: " + listaClientes.get(k).getPedidosCliente().get(j).getHoraPedido() //usar o novo formater
                            + "\nStatus Pedido: " + listaClientes.get(k).getPedidosCliente().get(j).getStatusPedido()
                            + "\nValor Pedido: " + listaClientes.get(k).getPedidosCliente().get(j).getValorTotalPedido());
                    switch (listaClientes.get(k).getPedidosCliente().get(j).getStatusPedido()) {
                        case 1 ->
                            qntAceitos++;
                        case 4 -> {
                            qntEntregues++;
                            receitaTotal += listaClientes.get(k).getPedidosCliente().get(j).getValorTotalPedido();
                        }
                        case 5 ->
                            qntCancelados++;
                        default -> {
                        }
                    }
                }
            }
        }

        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"
                + "Estatísticas de venda para o intervalo de " + dataMin.format(localDateFormatter) + " à " + dataMax.format(localDateFormatter) + "\n");
        System.out.println("Qnt. Pedidos Aceitos: " + qntAceitos + "      Qnt. Pedidos Cancelados: " + qntCancelados + "      Qnt. Pedidos Entregues: " + qntEntregues + "      Receita total arrecadada: " + receitaTotal
                + "----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

    }

    public static boolean isDateValid(String strDate) {
        //Formatter de data
        String dateFormat = "uuuuMMdd";
        //Resolver Strict garante que seja feito dentro dos valores possíveis
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormat).withResolverStyle(ResolverStyle.STRICT);
        try {
            LocalDate date = LocalDate.parse(strDate, dateTimeFormatter);
            return true; //Se for válida
        } catch (DateTimeParseException e) {
            return false;
        }

    }

    public static boolean isHourValid(String strHour) {
        //Formatter de hora
        String hourFormat = "HH:mm";
        //Resolver Strict garante que seja feito dentro dos valores possíveis
        DateTimeFormatter hourTimeFormatter = DateTimeFormatter.ofPattern(hourFormat).withResolverStyle(ResolverStyle.STRICT);
        try {
            LocalTime hour = LocalTime.parse(strHour, hourTimeFormatter);
            return true; //Se for válida
        } catch (DateTimeParseException f) {
            return false; //Se for inválida
        }
    }

    public void modificarColaborador(Colaborador Colab) {
        String senhaAnt;
        String novaSenha;
        String senhaConf;
        Scanner input = new Scanner(System.in);
        System.out.println("Insira sua senha anterior: ");
        senhaAnt = input.nextLine();
        System.out.println("Insira sua nova senha: ");
        novaSenha = input.nextLine();
        System.out.println("Confirme sua nova senha: ");
        senhaConf = input.nextLine();

        if (Colab.getSenhaUsuario().equals(senhaAnt)) {
            if (novaSenha.equals(senhaConf)) {
                Colab.setSenhaUsuario(novaSenha);
                System.out.println("Alteração realizada com sucesso!\n");
            } else {
                System.out.println("Senhas não são iguais. Tente novamente.\n");
            }
        } else {
            System.out.println("Senha antiga não confere. Tente novamente.\n");
        }
    }
}
