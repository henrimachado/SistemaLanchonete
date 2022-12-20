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
        
        /*
        TESTES DE FUNÇÕES 
        As chamadas a seguir representam testes de funções conforme as questões que poderiam ser identificadas
        pelo uso de funções. Questões como salvamento dinâmico podem ser conferidas usando CTRL+SHIFT+F e buscando
        pela chave da questão (Ex.: Questão 1), uma vez que dizem mais da estrutura que está associada na declaração
        das variáveis. 
        
        Ainda, tenha em mente que essas funções foram pensadas para serem executadas enquanto um sistema completo
        e cujos diferentes componentes interagem entre si. Assim, as chamadas individuais das funções podem não apresentar 
        o mesmo comportamento que aconteceria se estivessem sido chamadas pelo sistema (função startSistema que será a última
        a ser chamada nessa lista. 
        
        QUESTÃO X
        */
        
        System.out.println("""
                           TESTE DE CHAMADAS INDIVIDUAIS DE FUNÇÕES
                           Obs.: Chamadas individuais podem levar a comportamentos um pouco diferentes daqueles objetivados 
                           com o funcionamento do programa como um sistema completo.\n""");
        

        /*
        FUNCIONAMENTO DO SISTEMA (FUNÇÃO STARTSISTEMA)
        Devido à modularização do sistema em classes que agrupam funções semelhantes ou correlatas, 
        as chamadas de função foram 'ocultadas' nas funções correspondentes que fazem o tratamento. 
        Dessa forma, o teste do sistema depende da execução do mesmo, no qual será possível executar todas 
        as funções propostas. 
        
        Para tanto, deixamos um administrador e um colaborador já cadastrados que permitem o login no sistema. 
        Seus dados são: 
        
        ADMINISTRADOR:
            login: admin
            senha: admin
        
        COLABORADOR
            login: colab1
            senha: colab1
        
        Por sua vez, quanto as identificações das questões, estas estão feitas nas funções que contemplam 
        as soluções propostas. Assim, podem ser encontradas no código através do comando CTRL+SHIT+F com as chaves de busca:
        
        Questão 1
        Questão 2
        Questão 3
        Questão 4
        Questão 5
        Questão 6
        Questão 7
        Questão 8
        Questão 9
        Questão 10a 
        Questão 10b
        Questão 11
        Questão 12 
        Questão 13
  
        Assim, para que o programa seja testado, basta que seja executado. 
        Esperamos que tenha uma boa experiência!
        */
        
        System.out.println("""
                           TESTE DE FUNCIONAMENTO DO SISTEMA - FUNÇÃO STARTSISTEMA()
                           Esse teste se baseia no funcionamento do programa como um sistema completo
                           cujos elementos interagem entre si para produzir funcinalidades. 
                           Dessa forma, determinadas funcionalidades podem apresentar comportamentos 
                           levemente diferentes daqueles observados em chamadas individuais às funções\n
                           """);
        SistemaLanchonete.startSistema();
        
        
        
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
