
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

            Cl.setPedidosCliente(novoPedido);
        }

    }

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
                        if (((dataPedido.isEqual(dataMin)) || (dataPedido.isAfter(dataMin))) && ((dataPedido.isEqual(dataMax))||(dataPedido.isBefore(dataMax)))) {
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

            }

            case 2 -> {
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
}
