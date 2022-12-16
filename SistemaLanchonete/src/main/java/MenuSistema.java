import br.com.lanchonete.pessoas.Administrador;
import br.com.lanchonete.pessoas.Colaborador;
import br.com.lanchonete.pessoas.Usuario;
import java.io.IOException;
import java.util.Scanner;

public class MenuSistema {

    public MenuSistema() {
    }
    
    //Menu do administrador FEITO
    public void menuAdministrador(ProxyAdministrador menuAdm, ProxyColaborador menuColab, Usuario usuarioAtual) throws IOException {
        Scanner inputSwitch = new Scanner(System.in);

        boolean sairSistema = false;
        
        do {
            System.out.println("""
                           
                           Escolha uma opções do menu: 
                           1 -  Colaboradores          
                           2 -  Cliente                
                           3 -  Produtos               
                           4 -  Relatorios             
                           5 -  Administrador          
                           6 -  Finalizar Sistema
                               """);

        int j = inputSwitch.nextInt();
        switch (j) {
            case 1 -> {
                menuOpcaoColaboradorAdmin(menuAdm, menuColab, usuarioAtual);
                break;
            }
            case 2 -> {
                menuOpcaoCliente(menuAdm, menuColab, usuarioAtual);
                break;
            }
            case 3 -> {
                menuOpcaoProduto(menuAdm, menuColab, usuarioAtual);
                break;
            }
            case 4 -> {
                menuOpcaoRelatorio(menuAdm, menuColab, usuarioAtual);
                break;
            }
            case 5 -> {
                menuOpcaoAdmin(menuAdm, menuColab, usuarioAtual);
                break;
            }
            case 6 -> {
                System.out.println("O sistema foi finalizado.");
                sairSistema = true;
                break;
            }
            default -> {
                System.out.println("A opção selecionada é invalida.");
            }
        }
        } while (sairSistema == false);
        System.out.println("Estamos aqui!");
    }

    //Menu do colaborador FEITO
    public void menuColaborador(ProxyAdministrador menuAdm, ProxyColaborador menuColab, Usuario usuarioAtual) throws IOException {
        Scanner inputSwitch = new Scanner(System.in);
        boolean sairSistema = false;
        
        do {
            System.out.println("""
                           
                           Escolha uma opções do menu: 
                           1 -  Perfil                 
                           2 -  Pedidos                
                           3 -  Relatórios             
                           5 -  Finalizar Sistema
                               """);

        int i = inputSwitch.nextInt();
        switch (i) {
            case 1 -> {
                menuOpcaoColaboradorColab(menuAdm, menuColab, usuarioAtual);
                break;
            }
            case 2 -> {
                menuOpcaoPedido(menuAdm, menuColab, usuarioAtual);
                break;
            }
            case 3 -> {
                menuOpcaoRelatorio(menuAdm, menuColab, usuarioAtual);
                break;
            }
            case 4 -> {
                System.out.println("\nO sistema foi finalizado.\n");
                sairSistema = true;
                break;
            }
            default -> {
                System.out.println("A opção selecionada é invalida.\n");
            }
        }
        }while (sairSistema == false);
    }

    //Menu do opção de colaborar quando logado pelo administrador FEITO
    public void menuOpcaoColaboradorAdmin(ProxyAdministrador menuAdm, ProxyColaborador menuColab, Usuario usuarioAtual) throws IOException {
        Scanner inputSwitch = new Scanner(System.in);
        Scanner input = new Scanner(System.in);

        boolean menuAnterior = false;
        
        do{
            System.out.println("""
                           
                           Digite  o número da opção: 
                           1 - Cadastrar colaborador   
                           2 - Editar    colaborador   
                           3 - Consultar colaboradores   
                           4 - Remover   colaborador   
                           5 - Menu princial
                                    """);

        int i = inputSwitch.nextInt();
        String CPF;
        switch (i) {
            case 1 -> {
                menuAdm.cadastroColaborador();
                break;
            }
            case 2 -> {
                System.out.println("Insira o CPF do colaborador: ");
                CPF = input.nextLine();
                menuAdm.modificarColaborador(CPF);
                break;
            }

            case 3 -> {
                System.out.println("Insira o CPF do colaborador: ");
                CPF = input.nextLine();
                System.out.println(menuAdm.consultaColaborador(CPF));
                break;
            }
            case 4 -> {
                System.out.println("Insira o CPF do colaborador: ");
                CPF = input.nextLine();
                menuAdm.excluirColaborador(CPF);
                break;
            }
            case 5 -> {
                menuAnterior = true;
                break;
            }
            default -> {
                System.out.println("Opção inválida.");
            }
        }
        }while (menuAnterior == false);
    }

    //Menu do opção de colaborar quando logado pelo colaborador FEITO
    public void menuOpcaoColaboradorColab(ProxyAdministrador menuAdm, ProxyColaborador menuColab, Usuario usuarioAtual) throws IOException {
        Scanner inputSwitch = new Scanner(System.in);
        boolean menuAnterior = false;
        
        do {
            System.out.println("\n-------------------------------------------------------"
                + usuarioAtual.getNomePessoa() + " " + usuarioAtual.getSobrenomePessoa()
                + "-------------------------------------------------------\n");
        System.out.println("""
                           
                           Digite  o número da opção: 
                           1 - Alterar senha           
                           2 - Menu princial
                                    """);

        int i = inputSwitch.nextInt();
        switch (i) {
            case 1 -> {
                menuColab.modificarColaborador((Colaborador) usuarioAtual);
                break;
            }
            case 2 -> {
                menuAnterior = true;
                break;
            }
            default -> {
                System.out.println("A opção selecionada é invalida.");
            }
        }
        }while(menuAnterior == false);
    }

    //Menu de opção de produtos FEITO
    public void menuOpcaoProduto(ProxyAdministrador menuAdm, ProxyColaborador menuColab, Usuario usuarioAtual) throws IOException {
        Scanner inputSwitch = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        boolean menuAnterior = false;
        
        do {
            System.out.println("""
                           
                           Digite  o número da opção: 
                           1 - Cadastrar Produto       
                           2 - Editar    Produto       
                           3 - Consultar Produto       
                           4 - Remover   Produto       
                           5 - Menu princial
                                    """);

        int i = inputSwitch.nextInt();
        int idProduto;
        switch (i) {
            case 1 -> {
                menuAdm.cadastroProduto();
                break;
            }
            case 2 -> {
                System.out.println("Digite o ID do produto que deseja alterar: ");
                idProduto = input.nextInt();
                menuAdm.modificarProduto(idProduto);
                break;
            }
            case 3 -> {
                System.out.println("Dite o ID do produto que deseja alterar");
                idProduto = input.nextInt();
                System.out.println(ProxyAdministrador.consultaProduto(idProduto));
                break;
            }
            case 4 -> {
                menuAdm.excluirProduto();
                break;
            }
            case 5 -> {
                menuAnterior = true;
                break;
            }
            default -> {
                System.out.println("A opção selecionada é invalida.");
            }
        }
        }while (menuAnterior == false);
    }

    //Menu de opção de relatorios FEITO
    public void menuOpcaoRelatorio(ProxyAdministrador menuAdm, ProxyColaborador menuColab, Usuario usuarioAtual) throws IOException {
        Scanner inputSwitch = new Scanner(System.in);
        boolean menuAnterior = false; 
        
        do {
            System.out.println("""
                           Insira a opção desejada:          
                           
                           1 -   Relatorio de clientes      
                           2 -   Relatorio de colaboradores 
                           3 -   Relatorio de produtos      
                           4 -   Relatorio de pedido        
                           5 -   Estatistica de venda       
                           6 -   Menu princial
                                       """);

        int i = inputSwitch.nextInt();
        switch (i) {
            case 1 -> {
                System.out.println("""
                                                   -------------------------------------------------------------------------------------------------------------------------
                                                   |                                         CLIENTES CADASTRADOS NO SISTEMA                                               |
                                                   -------------------------------------------------------------------------------------------------------------------------
                                                   """);
                menuAdm.printClientes();
            }
            case 2 -> {
                System.out.println("""
                                                   -------------------------------------------------------------------------------------------------------------------------
                                                   |                                       COLABORADORES CADASTRADOS NO SISTEMA                                             |
                                                   -------------------------------------------------------------------------------------------------------------------------
                                                   """);
                menuAdm.printColaboradores();
            }
            case 3 -> {
                System.out.println("""
                                                   -------------------------------------------------------------------------------------------------------------------------
                                                   |                                          PRODUTOS CADASTRADOS NO SISTEMA                                               |
                                                   -------------------------------------------------------------------------------------------------------------------------
                                                   """);
                menuAdm.consultaListaProdutos();
            }
            case 4 -> {
                menuColab.listarPedidos();
            }
            case 5 -> {
                menuColab.statsVendas();
            }
            case 6 -> {
                
                /*
                if (usuarioAtual instanceof Administrador) {
                    menuAdministrador(menuAdm, menuColab, usuarioAtual);
                } else if (usuarioAtual instanceof Colaborador) {
                    menuColaborador(menuAdm, menuColab, usuarioAtual);
                }
                */
                menuAnterior = true;
                break;

            }
            default -> {
                System.out.println("A opção selecionada é invalida.");
            }
        }
        }while (menuAnterior == false);
    }

    //Menu de opção de administrador FEITO
    public void menuOpcaoAdmin(ProxyAdministrador menuAdm, ProxyColaborador menuColab, Usuario usuarioAtual) throws IOException {
        Scanner inputSwitch = new Scanner(System.in);
        boolean menuAnterior = false; 
        do{
            System.out.println("""
                           
                           Digite  o número da opção: 
                           1 - Dados admin             
                           2 - Alterar dados admin     
                           3 - Menu princial
                                    """);

        int i = inputSwitch.nextInt();
        switch (i) {
            case 1 -> {
                menuAdm.consultaAdm((Administrador) usuarioAtual);
                //menuOpcaoAdmin(menuAdm, menuColab, usuarioAtual);
                break;
            }
            case 2 -> {
                menuAdm.modificarAdm((Administrador) usuarioAtual);
                //menuOpcaoAdmin(menuAdm, menuColab, usuarioAtual);
                break;
            }
            case 3 -> {
                //menuAdministrador(menuAdm, menuColab, usuarioAtual);
                menuAnterior = true;
                break;
            }
            default -> {
                System.out.println("A opção selecionada é invalida.");
                //menuOpcaoAdmin(menuAdm, menuColab, usuarioAtual);
            }
        }
        }while(menuAnterior == false);
    }

    //Menu de opção de pedido FEITO
    public void menuOpcaoPedido(ProxyAdministrador menuAdm, ProxyColaborador menuColab, Usuario usuarioAtual) throws IOException {
        Scanner inputSwitch = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        boolean menuAnterior = false;

        do{
            System.out.println("""
                           
                           Digite  o número da opção: 
                           1 - Cadastrar pedido        
                           2 - Editar    pedido        
                           3 - Consultar pedido        
                           4 - Remover   pedido        
                           5 - Listar pedidos de cliente   
                           5 - Menu princial
                                    """);

        int i = inputSwitch.nextInt();
        String CPF;
        int idPedido;
        switch (i) {
            case 1 -> {
                menuColab.cadastroPedido();
                break;
            }
            case 2 -> {
                System.out.println("Insira o CPF do cliente: ");
                CPF = input.nextLine();
                System.out.println("Lista de pedidos do Cliente: ");
                for (int k = 0; k < ProxyAdministrador.consultaCliente(CPF).getPedidosCliente().size(); k++) {
                    System.out.println(ProxyAdministrador.consultaCliente(CPF).getPedidosCliente().get(k));
                }

                System.out.println("Digite o ID do pedido que deseja modificar: ");
                idPedido = input.nextInt();
                menuColab.modificarPedido(idPedido, ProxyAdministrador.consultaCliente(CPF));
                break;
            }
            case 3 -> {
                System.out.println("Insira o CPF do cliente: ");
                CPF = input.nextLine();
                System.out.println("Lista de pedidos do Cliente: ");
                for (int k = 0; k < ProxyAdministrador.consultaCliente(CPF).getPedidosCliente().size(); k++) {
                    System.out.println(ProxyAdministrador.consultaCliente(CPF).getPedidosCliente().get(k));
                }

                System.out.println("Digite o ID do pedido que deseja acessar: ");
                idPedido = input.nextInt();
                System.out.println(menuColab.consultarPedido(idPedido, ProxyAdministrador.consultaCliente(CPF)));
                break;
            }
            case 4 -> {
                menuColab.excluirPedido();
                break;
            }
            case 5 -> {
                System.out.println("Insira o CPF do cliente: ");
                CPF = input.nextLine();
                System.out.println("Lista de pedidos do Cliente: ");
                for (int k = 0; k < ProxyAdministrador.consultaCliente(CPF).getPedidosCliente().size(); k++) {
                    System.out.println(ProxyAdministrador.consultaCliente(CPF).getPedidosCliente().get(k));
                }
                break;
            }
            case 6 -> {
                menuAnterior = true;
                break;
            }
            default -> {
                System.out.println("A opção selecionada é invalida.");
            }
        }
        }while(menuAnterior == false);
    }

    //Menu de opção de pedido
    public void menuOpcaoCliente(ProxyAdministrador menuAdm, ProxyColaborador menuColab, Usuario usuarioAtual) throws IOException {
        Scanner inputSwitch = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        boolean menuAnterior = false;
        do{
            System.out.println("""
                           
                           Digite  o número da opção: 
                           1 - Cadastrar cliente       
                           2 - Editar    cliente       
                           3 - Consultar cliente       
                           4 - Remover   cliente       
                           5 - Menu princial
                                    """);

        int i = inputSwitch.nextInt();
        String CPF;
        switch (i) {
            case 1 -> {
                menuAdm.cadastroCliente();
            }
            case 2 -> {
                System.out.println("Insira o CPF do cliente: ");
                CPF = input.nextLine();
                menuAdm.modificarCliente(CPF);
            }
            case 3 -> {
                System.out.println("Insira o CPF do cliente: ");
                CPF = input.nextLine();
                System.out.println(ProxyAdministrador.consultaCliente(CPF));
            }
            case 4 -> {
                System.out.println("Insira o CPF do cliente: ");
                CPF = input.nextLine();
                menuAdm.excluirCliente(CPF);
            }
            case 5 -> {
                menuAnterior = true;
            }
            default -> {
                System.out.println("A opção selecionada é invalida.");
            }
        }
        }while(menuAnterior == false);
    }
}
