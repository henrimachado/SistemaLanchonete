
import br.com.lanchonete.pessoas.*;
import br.com.lanchonete.produtos.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.*;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.Locale;

public class SistemaLanchonete {

    public static void main(String[] args) throws IOException {
        //https://www.arquivodecodigos.com.br/dicas/2445-java-definindo-o-locale-padrAo-da-jvm.html
        Locale locale = new Locale("pt", "BR");
        Locale.setDefault(locale);

        ProxyAdministrador menuAdm = new ProxyAdministrador();
        ProxyColaborador menuColab = new ProxyColaborador();
        Usuario usuarioAtual = null;

        Scanner inputSistema = new Scanner(System.in);

        int i;
        System.out.println("""
                           
                           Escolha uma opções do menu: 
                           1 -  Login          
                           2 -  Encerrar
                               """);
        i = inputSistema.nextInt();
        switch (i) {
            case 1 -> {
                while (usuarioAtual == null) {
                    usuarioAtual = SistemaLanchonete.loginSistema();
                }

                if (usuarioAtual instanceof Administrador) {
                    SistemaLanchonete.menuAdministrador(menuAdm, menuColab, usuarioAtual);
                } else if (usuarioAtual instanceof Colaborador) {
                    SistemaLanchonete.menuAdministrador(menuAdm, menuColab, usuarioAtual);
                }
                break;
            }
            case 2 -> {
                break;
            }
            default -> {
                System.out.println("Opção inválida, reinicie o programa");
            }
        }

        /*     
        Administrador adm1 = new Administrador();
        adm1.setCPF("123");
        adm1.setLoginUsuario("email@gmail.com");
        adm1.setNomePessoa("Pedro");
        adm1.setSobrenomePessoa("Victor");
        adm1.setSenhaUsuario("123senha");
       
        jsonDump.dumpAdministrador(adm1);
        
        Administrador adm2 = jsonDump.assimilateAdministrador();
        System.out.println(adm1);
         */
    }

    //Função login
    public static Usuario loginSistema() throws IOException {
        Administrador adm = jsonDump.assimilateAdministrador();
        Scanner input = new Scanner(System.in);
        System.out.println("Digite seu login: ");
        String loginUsuario = input.nextLine();
        System.out.println("Digite sua senha: ");
        {
            String senhaUsuario = input.nextLine();

            Usuario usuarioAtual = null;

            if (loginUsuario.equals(adm.getLoginUsuario())) {
                if (senhaUsuario.equals(adm.getSenhaUsuario())) {
                    usuarioAtual = adm;
                }
            } else {
                for (int i = 0; i < 15; i++) {
                    if (senhaUsuario.equals(ProxyAdministrador.getColaboradores()[i].getLoginUsuario())) {
                        if (loginUsuario.equals(ProxyAdministrador.getColaboradores()[i].getSenhaUsuario())) {
                            usuarioAtual = ProxyAdministrador.getColaboradores()[i];
                        }
                    }
                }
            }

            if (usuarioAtual == null) {
                System.out.println("Login inválido. Tente novamente");
            }
            return usuarioAtual;

        }

    }

    //Menu do administrador
    public static void menuAdministrador(ProxyAdministrador menuAdm, ProxyColaborador menuColab, Usuario usuarioAtual) {
        Scanner inputSwitch = new Scanner(System.in);

        System.out.println("""
                           
                           Escolha uma opções do menu: 
                           1 -  Colaboradores          
                           1 -  Cliente                
                           2 -  Produtos               
                           3 -  Relatorios             
                           4 -  Administrador          
                           5 -  Finalizar Sistema
                               """);

        int i = inputSwitch.nextInt();
        switch (i) {
            case 1 -> {
                menuOpcaoColaboradorAdmin(menuAdm, menuColab, usuarioAtual);
                menuAdministrador(menuAdm, menuColab, usuarioAtual);
                break;
            }
            case 2 -> {
                menuOpcaoCliente(menuAdm, menuColab, usuarioAtual);
                menuAdministrador(menuAdm, menuColab, usuarioAtual);
                break;
            }
            case 3 -> {
                menuOpcaoProduto(menuAdm, menuColab, usuarioAtual);
                menuAdministrador(menuAdm, menuColab, usuarioAtual);
                break;
            }
            case 4 -> {
                menuOpcaoRelatorio(menuAdm, menuColab, usuarioAtual);
                menuAdministrador(menuAdm, menuColab, usuarioAtual);
                break;
            }
            case 5 -> {
                menuOpcaoAdmin(menuAdm, menuColab, usuarioAtual);
                menuAdministrador(menuAdm, menuColab, usuarioAtual);
                break;
            }
            case 6 -> {
                System.out.println("O sistema foi finalizado.");
                break;
            }
            default -> {
                System.out.println("A opção selecionada é invalida.");
                menuAdministrador(menuAdm, menuColab, usuarioAtual);
            }
        }
    }

    //Menu do colaborador
    public static void menuColaborador(ProxyAdministrador menuAdm, ProxyColaborador menuColab, Usuario usuarioAtual) {
        Scanner inputSwitch = new Scanner(System.in);

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
                menuColaborador(menuAdm, menuColab, usuarioAtual);
                break;
            }
            case 2 -> {
                menuOpcaoPedido(menuAdm, menuColab, usuarioAtual);
                menuColaborador(menuAdm, menuColab, usuarioAtual);
                break;
            }
            case 3 -> {
                menuOpcaoRelatorio(menuAdm, menuColab, usuarioAtual);
                menuColaborador(menuAdm, menuColab, usuarioAtual);
                break;
            }
            case 4 -> {
                System.out.println("O sistema foi finalizado.");
                break;
            }
            default -> {
                System.out.println("A opção selecionada é invalida.");
                menuColaborador(menuAdm, menuColab, usuarioAtual);
            }
        }
    }

    //Menu do opção de colaborar quando logado pelo administrador
    public static void menuOpcaoColaboradorAdmin(ProxyAdministrador menuAdm, ProxyColaborador menuColab, Usuario usuarioAtual) {
        Scanner inputSwitch = new Scanner(System.in);
        Scanner input = new Scanner(System.in);

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
                menuOpcaoColaboradorAdmin(menuAdm, menuColab, usuarioAtual);
                break;
            }
            case 2 -> {
                System.out.println("Insira o CPF do colaborador: ");
                CPF = input.nextLine();
                menuAdm.modificarColaborador(CPF);
                //ProxyAdministrador.modificarColaborador();
                menuOpcaoColaboradorAdmin(menuAdm, menuColab, usuarioAtual);
                break;
            }

            case 3 -> {
                System.out.println("Insira o CPF do colaborador: ");
                CPF = input.nextLine();
                System.out.println(menuAdm.consultaColaborador(CPF));
                menuOpcaoColaboradorAdmin(menuAdm, menuColab, usuarioAtual);
                break;
            }
            case 4 -> {
                System.out.println("Insira o CPF do colaborador: ");
                CPF = input.nextLine();
                menuAdm.excluirColaborador(CPF);
                menuOpcaoColaboradorAdmin(menuAdm, menuColab, usuarioAtual);
                break;
            }
            case 5 -> {
                menuAdministrador(menuAdm, menuColab, usuarioAtual);
                break;
            }
            default -> {
                System.out.println("Opção inválida.");
                menuOpcaoColaboradorAdmin(menuAdm, menuColab, usuarioAtual);
            }
        }
    }

    //Menu do opção de colaborar quando logado pelo colaborador
    public static void menuOpcaoColaboradorColab(ProxyAdministrador menuAdm, ProxyColaborador menuColab, Usuario usuarioAtual) {
        Scanner inputSwitch = new Scanner(System.in);
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
                menuOpcaoColaboradorColab(menuAdm, menuColab, usuarioAtual);
                break;
            }
            case 2 -> {
                menuColaborador(menuAdm, menuColab, usuarioAtual);
                break;
            }
            default -> {
                System.out.println("A opção selecionada é invalida.");
                menuOpcaoColaboradorColab(menuAdm, menuColab, usuarioAtual);
            }
        }
    }

    //Menu de opção de produtos
    public static void menuOpcaoProduto(ProxyAdministrador menuAdm, ProxyColaborador menuColab, Usuario usuarioAtual) {
        Scanner inputSwitch = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
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
                menuOpcaoProduto(menuAdm, menuColab, usuarioAtual);
                break;
            }
            case 2 -> {
                System.out.println("Digite o ID do produto que deseja alterar: ");
                idProduto = input.nextInt();
                menuAdm.modificarProduto(idProduto);
                menuOpcaoProduto(menuAdm, menuColab, usuarioAtual);
                break;
            }
            case 3 -> {
                System.out.println("Dite o ID do produto que deseja alterar");
                idProduto = input.nextInt();
                System.out.println(ProxyAdministrador.consultaProduto(idProduto));
                menuOpcaoProduto(menuAdm, menuColab, usuarioAtual);
                break;
            }
            case 4 -> {
                menuAdm.excluirProduto();
                menuOpcaoProduto(menuAdm, menuColab, usuarioAtual);
                break;
            }
            case 5 -> {
                menuAdministrador(menuAdm, menuColab, usuarioAtual);
                break;
            }
            default -> {
                System.out.println("A opção selecionada é invalida.");
                menuOpcaoProduto(menuAdm, menuColab, usuarioAtual);
            }
        }
    }

    //Menu de opção de relatorios
    public static void menuOpcaoRelatorio(ProxyAdministrador menuAdm, ProxyColaborador menuColab, Usuario usuarioAtual) {
        Scanner inputSwitch = new Scanner(System.in);

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
                                                                    ------------------------------------------------------------------------------------------------------------
                                                   |                                   CLIENTES CADASTRADOS NO SISTEMA                                         |
                                                   ------------------------------------------------------------------------------------------------------------
                                                   """);
                menuAdm.printClientes();
                menuOpcaoRelatorio(menuAdm, menuColab, usuarioAtual);
            }
            case 2 -> {
                System.out.println("""
                                                                    ------------------------------------------------------------------------------------------------------------
                                                   |                                   COLABORADORES CADASTRADOS NO SISTEMA                                         |
                                                   ------------------------------------------------------------------------------------------------------------
                                                   """);
                menuAdm.printColaboradores();
                menuOpcaoRelatorio(menuAdm, menuColab, usuarioAtual);
            }
            case 3 -> {
                System.out.println("""
                                                                    ------------------------------------------------------------------------------------------------------------
                                                   |                                   PRODUTOS CADASTRADOS NO SISTEMA                                         |
                                                   ------------------------------------------------------------------------------------------------------------
                                                   """);
                menuAdm.consultaListaProdutos();
                menuOpcaoRelatorio(menuAdm, menuColab, usuarioAtual);
            }
            case 4 -> {
                menuColab.listarPedidos();
                menuOpcaoRelatorio(menuAdm, menuColab, usuarioAtual);
            }
            case 5 -> {
                menuColab.statsVendas();
                menuOpcaoRelatorio(menuAdm, menuColab, usuarioAtual);
            }
            case 6 -> {
                if (usuarioAtual instanceof Administrador) {
                    menuAdministrador(menuAdm, menuColab, usuarioAtual);
                } else if (usuarioAtual instanceof Colaborador) {
                    menuColaborador(menuAdm, menuColab, usuarioAtual);
                }
                break;
                /*                **Conferir se precisa de break **
                Tanto o colaborador quando o administrador possuem acesso
                ao menu de relatorio, necessario fazer uma validação, que ao
                selecionar a opçao "Menu princial" o sistema volte ou para o
                menuAdministrador() ou para o  menuColaborador() dependendo
                de qual user estiver logado.
                Exemplo:
                If tipo.user = adm then
                menuAdministrador()
                else
                menuColaborador()
                 */
            }
            default -> {
                System.out.println("A opção selecionada é invalida.");
                menuOpcaoRelatorio(menuAdm, menuColab, usuarioAtual);
            }
        }
    }

    //Menu de opção de administrador
    public static void menuOpcaoAdmin(ProxyAdministrador menuAdm, ProxyColaborador menuColab, Usuario usuarioAtual) {
        Scanner inputSwitch = new Scanner(System.in);
        System.out.println("""
                           
                           Digite  o número da opção: 
                           1 - Dados admin             
                           2 - Alterar dados admin     
                           4 - Menu princial
                                    """);

        int i = inputSwitch.nextInt();
        switch (i) {
            case 1 -> {
                menuAdm.consultaAdm((Administrador) usuarioAtual);
                menuOpcaoAdmin(menuAdm, menuColab, usuarioAtual);
                break;
            }
            case 2 -> {
                menuAdm.modificarAdm((Administrador) usuarioAtual);
                //Function alterar dados (e-amil e senha )do admin...
                menuOpcaoAdmin(menuAdm, menuColab, usuarioAtual);
                break;
            }
            case 3 -> {
                menuAdministrador(menuAdm, menuColab, usuarioAtual);
                break;
            }
            default -> {
                System.out.println("A opção selecionada é invalida.");
                menuOpcaoAdmin(menuAdm, menuColab, usuarioAtual);
            }
        }
    }

    //Menu de opção de pedido
    public static void menuOpcaoPedido(ProxyAdministrador menuAdm, ProxyColaborador menuColab, Usuario usuarioAtual) {
        Scanner inputSwitch = new Scanner(System.in);
        Scanner input = new Scanner(System.in);

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
                menuOpcaoPedido(menuAdm, menuColab, usuarioAtual);
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
                menuOpcaoPedido(menuAdm, menuColab, usuarioAtual);
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
                menuOpcaoPedido(menuAdm, menuColab, usuarioAtual);
                break;
            }
            case 4 -> {
                menuColab.excluirPedido();
                menuOpcaoPedido(menuAdm, menuColab, usuarioAtual);
                break;
            }
            case 5 -> {
                System.out.println("Insira o CPF do cliente: ");
                CPF = input.nextLine();
                System.out.println("Lista de pedidos do Cliente: ");
                for (int k = 0; k < ProxyAdministrador.consultaCliente(CPF).getPedidosCliente().size(); k++) {
                    System.out.println(ProxyAdministrador.consultaCliente(CPF).getPedidosCliente().get(k));
                }
                menuOpcaoPedido(menuAdm, menuColab, usuarioAtual);
                break;
            }
            case 6 -> {
                menuColaborador(menuAdm, menuColab, usuarioAtual);
                break;
            }
            default -> {
                System.out.println("A opção selecionada é invalida.");
                menuOpcaoPedido(menuAdm, menuColab, usuarioAtual);
            }
        }
    }

    //Menu de opção de pedido
    public static void menuOpcaoCliente(ProxyAdministrador menuAdm, ProxyColaborador menuColab, Usuario usuarioAtual) {
        Scanner inputSwitch = new Scanner(System.in);
        Scanner input = new Scanner(System.in);

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
                menuOpcaoCliente(menuAdm, menuColab, usuarioAtual);
            }
            case 2 -> {
                System.out.println("Insira o CPF do cliente: ");
                CPF = input.nextLine();
                menuAdm.modificarCliente(CPF);
                menuOpcaoCliente(menuAdm, menuColab, usuarioAtual);
            }
            case 3 -> {
                System.out.println("Insira o CPF do cliente: ");
                CPF = input.nextLine();
                System.out.println(ProxyAdministrador.consultaCliente(CPF));
                menuOpcaoCliente(menuAdm, menuColab, usuarioAtual);
            }
            case 4 -> {
                System.out.println("Insira o CPF do cliente: ");
                CPF = input.nextLine();
                menuAdm.excluirCliente(CPF);
                menuOpcaoCliente(menuAdm, menuColab, usuarioAtual);
            }
            case 5 -> {
                menuAdministrador(menuAdm, menuColab, usuarioAtual);
            }
            default -> {
                System.out.println("A opção selecionada é invalida.");
                menuOpcaoCliente(menuAdm, menuColab, usuarioAtual);
            }
        }
    }

}
