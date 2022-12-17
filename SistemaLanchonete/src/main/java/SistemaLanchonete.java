import br.com.lanchonete.pessoas.*;
import java.util.Scanner;
import java.io.IOException;
import java.util.Locale;

/**
 *
 * @author henri
 */
public class SistemaLanchonete {

    public static void main(String[] args) throws IOException {
        //https://www.arquivodecodigos.com.br/dicas/2445-java-definindo-o-locale-padrAo-da-jvm.html
        Locale locale = new Locale("pt", "BR");
        Locale.setDefault(locale);

        SistemaLanchonete.startSistema();

        //ANTES DE ENVIAR, USAR ISSO DAQUI PRA PODER INICIALIZAR COM NULO PRA DAR BOM
        /*manipularJson mJson = new manipularJson();
        mJson.dumpColaborador(ProxyAdministrador.getColaboradores());
        mJson.dumpCliente(ProxyAdministrador.getClientes());
        mJson.dumpProdutos(ProxyAdministrador.getListaProdutos());*/
    }

    //Função login
    /**
     *
     * @param mJson
     * @return
     * @throws IOException
     */
    public static Usuario loginSistema(manipularJson mJson) throws IOException {
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
     *
     * @throws IOException
     */
    public static void startSistema() throws IOException {
        //Uso de json
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
        do {
            System.out.printf("""
                           
                           Escolha uma opção:
                           _________________________________________
                           1 -  Login          
                           2 -  Sair
                           _________________________________________
                               """);
            i = inputSistema.nextInt();
            switch (i) {
                case 1 -> {
                    while (usuarioAtual == null) {
                        usuarioAtual = SistemaLanchonete.loginSistema(mJson);
                    }

                    if (usuarioAtual instanceof Administrador) {
                        menuSistema.menuAdministrador(menuAdm, menuColab, usuarioAtual);
                        mJson.dumpAdministrador((Administrador) usuarioAtual);

                    } else if (usuarioAtual instanceof Colaborador) {
                        menuSistema.menuColaborador(menuAdm, menuColab, usuarioAtual);
                    }
                    break;
                }
                case 2 -> {
                    mJson.dumpAll(menuColab);
                    sairSistema = true;
                    break;
                }
                default -> {
                    System.out.println("Opção inválida. Tente novamente.");
                }
            }
        } while (sairSistema == false);
    }

    @Override
    public String toString() {
        return "SistemaLanchonete";
    }

}
