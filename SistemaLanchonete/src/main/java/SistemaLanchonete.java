
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
        Locale locale = new Locale("pt","BR");
        Locale.setDefault(locale);
        
        ProxyAdministrador menuAdm = new ProxyAdministrador();
        ProxyColaborador menuColab = new ProxyColaborador();
        menuAdm.cadastroCliente();
        menuColab.cadastroPedido();
        menuColab.cadastroPedido();
        menuColab.listarPedidos();
        
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
    public static Usuario loginSistema() throws IOException{
        Administrador adm = jsonDump.assimilateAdministrador();
        Scanner input = new Scanner(System.in);
        System.out.println("Digite seu login: ");
        String loginUsuario = input.nextLine();
        System.out.println("Digite sua senha: ");{
        String senhaUsuario = input.nextLine();
        
        Usuario usuarioAtual = null;
        
        if(loginUsuario.equals(adm.getLoginUsuario())){
            if(senhaUsuario.equals(adm.getSenhaUsuario())){
                usuarioAtual = adm;
            }
        }
        
        else{
            for (int i = 0; i < 15; i++){
                if(senhaUsuario.equals(ProxyAdministrador.getColaboradores()[i].getLoginUsuario())){
                    if(loginUsuario.equals(ProxyAdministrador.getColaboradores()[i].getSenhaUsuario())){
                        usuarioAtual = ProxyAdministrador.getColaboradores()[i];
                    }
                }
            }
        }
        
        if(usuarioAtual == null){
            System.out.println("Login inválido. Tente novamente");
        }
        return usuarioAtual;
        
    }
        
    }
    //Menu do administrador
    public static void menuAdministrador() {

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

        System.out.println("""
                           
                           Escolha uma opções do menu: 
                           1 -  Perfil                 
                           2 -  Pedidos                
                           3 -  Relatórios             
                           5 -  Finalizar Sistema
                               """);

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

        System.out.println("""
                           
                           Digite  o número da opção: 
                           1 - Cadastrar colaborador   
                           2 - Editar    colaborador   
                           3 - Consultar colaborador   
                           4 - Remover   colaborador   
                           5 - Menu princial
                                    """);

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

        System.out.println("""
                           
                           Digite  o número da opção: 
                           1 - Alterar senha           
                           2 - Menu princial
                                    """);

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

        System.out.println("""
                           
                           Digite  o número da opção: 
                           1 - Cadastrar Produto       
                           2 - Editar    Produto       
                           3 - Consultar Produto       
                           4 - Remover   Produto       
                           5 - Menu princial
                                    """);

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

        System.out.println("""
                           
                           Digite  o número da opção: 
                           1 - Dados admin             
                           2 - Alterar dados admin     
                           4 - Menu princial
                                    """);

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

        System.out.println("""
                           
                           Digite  o número da opção: 
                           1 - Cadastrar cliente       
                           2 - Editar    cliente       
                           3 - Consultar cliente       
                           4 - Remover   cliente       
                           5 - Menu princial
                                    """);

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
