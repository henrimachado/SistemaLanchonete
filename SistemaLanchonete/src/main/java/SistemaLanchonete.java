
import br.com.lanchonete.pessoas.*;
import java.util.Scanner;
import java.io.IOException;
import java.util.Locale;

public class SistemaLanchonete {

    public static void main(String[] args) throws IOException {
        //https://www.arquivodecodigos.com.br/dicas/2445-java-definindo-o-locale-padrAo-da-jvm.html
        Locale locale = new Locale("pt", "BR");
        Locale.setDefault(locale);

        //Inicializando o sistema
        
        
        
        SistemaLanchonete.startSistema();

    }

    //Função login
    public static Usuario loginSistema(manipularJson mJson) throws IOException {
        Administrador adm = mJson.assimilateAdministrador();
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

    public static void startSistema() throws IOException {
        //Uso de json
        manipularJson mJson = new manipularJson();
        mJson.assimilateAll();

        
        Usuario usuarioAtual = null;
        
        //Inicializando sistema
        ProxyAdministrador menuAdm = new ProxyAdministrador();
        ProxyColaborador menuColab = new ProxyColaborador();
        MenuSistema menuSistema = new MenuSistema();
        
        //Login
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
                mJson.dumpAll();
                break;
            }
            default -> {
                System.out.println("Opção inválida, reinicie o programa");
            }
        }
    }
}
