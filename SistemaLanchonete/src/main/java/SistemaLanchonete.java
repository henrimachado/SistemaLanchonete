
import br.com.lanchonete.pessoas.*;
import java.util.Scanner;
import java.io.IOException;
import java.util.Locale;

/**
 * Classe principal para o Sistema da Lanchonete contendo o método main()
 *
 * @author Mateus Henrique Machado
 * @author Iago Mateus Ávila Fernandes
 * @version 1.2
 */
//Questão 1 - Implementar todas as classes com base no diagrama de classes criado
public class SistemaLanchonete {

    public static void main(String[] args) throws IOException {

        Locale locale = new Locale("pt", "BR");
        Locale.setDefault(locale);

        SistemaLanchonete.startSistema();

        //ANTES DE ENVIAR, USAR ISSO DAQUI PRA PODER INICIALIZAR COM NULO PRA DAR BOM
        /*manipularJson mJson = new manipularJson();
        mJson.dumpColaborador(ProxyAdministrador.getColaboradores());
        mJson.dumpCliente(ProxyAdministrador.getClientes());
        mJson.dumpProdutos(ProxyAdministrador.getListaProdutos());*/
    }

    /**
     * Função padrão para login no sistema
     *
     * @param mJson Objeto da classe manipularJson para assimilação de dados
     * @return Usuario logado no sistema desde que as credenciais estejam
     * cadastradas
     * @throws IOException Exceção associada à manipulação de arquivos Json
     */
    
    //Questão 2 - O sistema será utilizado por colaboradores e pelo administrador
    public static Usuario loginSistema(manipularJson mJson) throws IOException {
        //Questão 13 - Salve e recupere todas as informações do sistema em um arquivo json
        Administrador adm = mJson.assimilateAdministrador();

        Scanner input = new Scanner(System.in);
        System.out.printf("E- mail: ");
        String loginUsuario = input.nextLine();
        System.out.printf("Senha: ");
        {
            String senhaUsuario = input.nextLine();

            Usuario usuarioAtual = null;

            if (loginUsuario.equals(adm.getLoginUsuario()) && senhaUsuario.equals(adm.getSenhaUsuario())) {
                usuarioAtual = adm;

            } else {
                for (Colaborador colab : ProxyAdministrador.getColaboradores()) {
                    if (colab != null) {
                        if (loginUsuario.equals(colab.getLoginUsuario()) && senhaUsuario.equals(colab.getSenhaUsuario())) {
                            usuarioAtual = colab;
                            break;
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

    /**
     * Função padrão de inicialização do sistema como um todo
     *
     * @throws IOException Exceção associada à manipulação de dados Json
     */
    public static void startSistema() throws IOException {
        //Uso de json
        //Questão 13 - Salve e recupere todas as informações do sistema em um arquivo json
        manipularJson mJson = new manipularJson();
        mJson.assimilateAll();

        Usuario usuarioAtual = null;

        //Inicializando sistema
        ProxyAdministrador menuAdm = new ProxyAdministrador();
        ProxyColaborador menuColab = new ProxyColaborador();
        ProxyColaborador.setExtratosPedidos(mJson.assimilateExtratosPedidos());
        MenuSistema menuSistema = new MenuSistema();

        //Login
        Scanner inputSistema = new Scanner(System.in);
        int i;
        boolean sairSistema = false;

        System.out.printf("""
                           
                           Escolha uma opção:
                           _________________________________________
                           1 -  Login          
                           2 -  Sair
                           _________________________________________
                               """);
        inputSistema = new Scanner(System.in);
        i = inputSistema.nextInt();
        //Questão 2 - O sistema será utilizado por colaboradores e pelo administrador
        switch (i) {
            case 1 -> {
                while (usuarioAtual == null) {
                    usuarioAtual = SistemaLanchonete.loginSistema(mJson);
                }

                if (usuarioAtual instanceof Administrador) {
                    menuSistema.menuAdministrador(menuAdm, menuColab, usuarioAtual);
                    //Questão 13 - Salve e recupere todas as informações do sistema em um arquivo json
                    mJson.dumpAdministrador((Administrador) usuarioAtual);

                } else if (usuarioAtual instanceof Colaborador) {
                    menuSistema.menuColaborador(menuAdm, menuColab, usuarioAtual);
                }
                break;
            }
            case 2 -> {
                //Questão 13 - Salve e recupere todas as informações do sistema em um arquivo json
                mJson.dumpAll(menuColab);
                sairSistema = true;
                break;
            }
            default -> {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

    }

    /**
     *
     * @return Representação String do Sistema da Lanchonete
     */
    //Questão 3 - Sobrescrever o método toString() de todas as classes implementadas
    @Override
    public String toString() {
        return "SistemaLanchonete";
    }

}
