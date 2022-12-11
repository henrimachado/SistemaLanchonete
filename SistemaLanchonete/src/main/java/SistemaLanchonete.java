
import br.com.lanchonete.pessoas.*;
import br.com.lanchonete.produtos.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.*;
import com.google.gson.Gson;
import java.io.IOException;

public class SistemaLanchonete {

    public static void main(String[] args) throws IOException {

        /*      
        Administrador admMain = new Administrador();
        admMain.setCPF("123");
        admMain.setLoginUsuario("email@gmail.com");
        admMain.setNomePessoa("Pedro");
        admMain.setSobrenomePessoa("Victor");
        admMain.setSenhaUsuario("123senha");
       
        jsonDump.dumpAdministrador(admMain);
        
        Administrador admMain = jsonDump.assimilateAdministrador();
        System.out.println(admMain);
         */
    }

    //Menu do administrador
    public static void menuAdministrador() {

        Scanner inputSwitch = new Scanner(System.in);

        System.out.println("\nEscolha uma opção do menu: "
                + "\n1 -  Colaboradores          "
                + "\n1 -  Cliente                "
                + "\n2 -  Produtos               "
                + "\n3 -  Relatorios             "
                + "\n4 -  Administrador          "
                + "\n5 -  Finalizar Sistema\n    ");

        int i = inputSwitch.nextInt();
        switch (i) {
            case 1:
                //menuOpcaoColaboradorAdmin();
                //menuAdministrador();
                break;
            case 2:
                //menuOpcaoCliente();
                //menuAdministrador();
                break;
            case 3:
                //menuOpcaoProduto();
                //menuAdministrador();
                break;
            case 4:
                //menuOpcaoRelatorio();
                //menuAdministrador();
                break;
            case 5:
                //menuOpcaoAdmin()
                //menuAdministrador();
                break;
            case 6:
                //System.out.println("O sistema foi finalizado.");
                break;
            default:
            // System.out.println("A opção selecionada é invalida.");
            //menuAdministrador()
        }
    }

    //Menu do colaborador
    public static void menuColaborador() {

        Scanner inputSwitch = new Scanner(System.in);

        System.out.println("\nEscolha uma opção do menu: "
                + "\n1 -  Perfil                 "
                + "\n2 -  Pedidos                "
                + "\n3 -  Relatorios             "
                + "\n5 -  Finalizar Sistema\n    ");

        int i = inputSwitch.nextInt();
        switch (i) {
            case 1:
                //menuOpcaoColaboradorColab();
                //menuColaborador();
                break;
            case 2:
                //menuOpcaoPedido();
                //menuColaborador();
                break;
            case 3:
                //menuOpcaoRelatorio();
                //menuColaborador();
                break;
            case 4:
                //System.out.println("O sistema foi finalizado.");
                break;
            default:
            // System.out.println("A opção selecionada é invalida.");
            //menuColaborador()
        }
    }

    //Menu do opção de colaborar quando logado pelo administrador
    public static void menuOpcaoColaboradorAdmin() {
        Scanner inputSwitch = new Scanner(System.in);

        System.out.println("\nDigite  o número da opção: "
                + "\n1 - Cadastrar colaborador   "
                + "\n2 - Editar    colaborador   "
                + "\n3 - Consultar colaborador   "
                + "\n4 - Remover   colaborador   "
                + "\n5 - Menu princial\n         ");

        int i = inputSwitch.nextInt();
        switch (i) {
            case 1:
                //ProxyAdministrador.cadastroColaborador();
                //menuOpcaoColaboradorAdmin();
                break;
            case 2:
                //ProxyAdministrador.modificarColaborador();
                //menuOpcaoColaboradorAdmin();
                break;
            case 3:
                //ProxyAdministrador.consultaCliente();
                //menuOpcaoColaboradorAdmin();
                break;
            case 4:
                //ProxyAdministrador.excluirColaborador();
                //menuOpcaoColaboradorAdmin();
                break;
            case 5:
                //menuAdministrador();  **Conferir se precisa de break; **
                break;
            default:
            // System.out.println("A opção selecionada é invalida.");
            //menuOpcaoColaboradorAdmin();
        }
    }

    //Menu do opção de colaborar quando logado pelo colaborador
    public static void menuOpcaoColaboradorColab() {
        Scanner inputSwitch = new Scanner(System.in);

        System.out.println("\nDigite  o número da opção: "
                + "\n1 - Alterar senha           "
                + "\n2 - Menu princial\n         ");

        int i = inputSwitch.nextInt();
        switch (i) {
            case 1:
                //Function alterar senha pessoal do colaborador...
                //menuOpcaoColaboradorColab();
                break;
            case 2:
                //menuColaborador();  **Conferir se precisa de break; **
                break;
            default:
            // System.out.println("A opção selecionada é invalida.");
            //menuOpcaoColaboradorColab();
        }
    }

    //Menu de opção de produtos
    public static void menuOpcaoProduto() {
        Scanner inputSwitch = new Scanner(System.in);

        System.out.println("\nDigite  o número da opção: "
                + "\n1 - Cadastrar Produto       "
                + "\n2 - Editar    Produto       "
                + "\n3 - Consultar Produto       "
                + "\n4 - Remover   Produto       "
                + "\n5 - Menu princial\n         ");

        int i = inputSwitch.nextInt();
        switch (i) {
            case 1:
                //ProxyAdministrador.cadastroProduto();
                //menuOpcaoProduto();
                break;
            case 2:
                //ProxyAdministrador.modificarProduto();
                //menuOpcaoProduto();
                break;
            case 3:
                //ProxyAdministrador.consultaProduto();
                //menuOpcaoProduto();
                break;
            case 4:
                //ProxyAdministrador.cadastroProduto();
                //menuOpcaoProduto();
                break;
            case 5:
                //menuAdministrador();  **Conferir se precisa de break **
                break;
            default:
            // System.out.println("A opção selecionada é invalida.");
            // menuOpcaoProduto();
        }
    }

    //Menu de opção de relatorios
    public static void menuOpcaoRelatorio() {
        Scanner inputSwitch = new Scanner(System.in);

        System.out.println("Insira a opção desejada:          "
                + "\n\n1 - Relatorio de clientes      "
                + "\n2 -   Relatorio de colaboradores "
                + "\n3 -   Relatorio de produtos      "
                + "\n4 -   Relatorio de pedido        "
                + "\n5 -   Estatistica de venda       "
                + "\n6 -   Menu princial\n            ");

        int i = inputSwitch.nextInt();
        switch (i) {
            case 1:
                // ProxyAdministrador.printClientes();
                //menuOpcaoRelatorio());
                break;
            case 2:
                //ProxyAdministrador.printColaboradores();
                //menuOpcaoProduto();
                break;
            case 3:
                //ProxyAdministrador.consultaListaProdutos()
                //menuOpcaoRelatorio();
                break;
            case 4:
                //Relatorio de pedido...
                //menuOpcaoRelatorio();
                break;
            case 5:
                //Relatorio de venda...
                //menuOpcaoRelatorio();
                break;
            case 6:
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
                break;
            default:
            // System.out.println("A opção selecionada é invalida.");
            // menuOpcaoRelatorio();
        }
    }

    //Menu de opção de administrador
    public static void menuOpcaoAdmin() {
        Scanner inputSwitch = new Scanner(System.in);

        System.out.println("\nDigite  o número da opção: "
                + "\n1 - Dados admin             "
                + "\n2 - Alterar dados admin     "
                + "\n4 - Menu princial\n         ");

        int i = inputSwitch.nextInt();
        switch (i) {
            case 1:
                //Consulta dados admin..
                //menuOpcaoAdmin();
                break;
            case 2:
                //Function alterar dados (e-amil e senha )do admin...
                //menuOpcaoAdmin();
                break;
            case 3:
                //menuAdministrador();  **Conferir se precisa de break **
                break;
            default:
            // System.out.println("A opção selecionada é invalida.");
            // menuOpcaoProduto();
        }
    }

    //Menu de opção de pedido
    public static void menuOpcaoPedido() {
        Scanner inputSwitch = new Scanner(System.in);

        System.out.println("\nDigite  o número da opção: "
                + "\n1 - Cadastrar pedido        "
                + "\n2 - Editar    pedido        "
                + "\n3 - Consultar pedido        "
                + "\n4 - Remover   pedido        "
                + "\n5 - Lista pedidos cliente   "
                + "\n5 - Menu princial\n         ");

        int i = inputSwitch.nextInt();
        switch (i) {
            case 1:
                //ProxyAdministrador.cadastroProduto();
                //menuOpcaoPedido();
                break;
            case 2:
                //ProxyAdministrador.modificarProduto();
                //menuOpcaoPedido();
                break;
            case 3:
                //ProxyAdministrador.consultaProduto();
                //menuOpcaoPedido();
                break;
            case 4:
                //ProxyAdministrador.cadastroProduto();
                //menuOpcaoPedido();
                break;
            case 5:
                //function que retorna os pedidos de um cliente...
                //menuOpcaoPedido();
                break;
            case 6:
                //menuColaborador();  **Conferir se precisa de break **
                break;
            default:
            // System.out.println("A opção selecionada é invalida.");
            // menuOpcaoPedido();
        }
    }

    //Menu de opção de pedido
    public static void menuOpcaoCliente() {
        Scanner inputSwitch = new Scanner(System.in);

        System.out.println("\nDigite  o número da opção: "
                + "\n1 - Cadastrar cliente       "
                + "\n2 - Editar    cliente       "
                + "\n3 - Consultar cliente       "
                + "\n4 - Remover   cliente       "
                + "\n5 - Menu princial\n         ");

        int i = inputSwitch.nextInt();
        switch (i) {
            case 1:
                //ProxyAdministrador.cadastroCliente();
                //menuOpcaoCliente();
                break;
            case 2:
                //ProxyAdministrador.modificarCliente();
                //menuOpcaoCliente();
                break;
            case 3:
                //ProxyAdministrador.consultaCliente();
                //menuOpcaoCliente();
                break;
            case 4:
                //ProxyAdministrador.excluirCliente();
                //menuOpcaoCliente();
                break;
            case 5:
                //menuAdministrador();  **Conferir se precisa de break **
                break;
            default:
            // System.out.println("A opção selecionada é invalida.");
            // menuOpcaoCliente();
        }
    }

}
