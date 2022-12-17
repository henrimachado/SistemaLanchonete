import br.com.lanchonete.pessoas.Administrador;
import br.com.lanchonete.pessoas.Colaborador;
import br.com.lanchonete.pessoas.Usuario;
import java.io.IOException;
import java.util.Scanner;

/**
 * Classe representativa do Menu de Opções do Sistema 
 * @author Mateus Henrique Machado 
 * @author Iago Mateus Ávila Fernandes 
 */
public class MenuSistema {

    /**
     * Construtor padrão do Menu do Sistema
     */
    public MenuSistema() {
    }

    /**
     * Função padrão para acesso às opções acessíveis ao Administrador
     * @param menuAdm Recebe um objeto da classe intermediária de funcionalidades disponíveis ao Administrador
     * @param menuColab Recebe um objeto da classe intermediária de funcionalidades disponíveis ao Colaborador
     * @param usuarioAtual Recebe o objeto referente ao usuário logado no sistema
     * @throws IOException Exceção associada à manipulação de dados em arquivo Json
     */
    public void menuAdministrador(ProxyAdministrador menuAdm, ProxyColaborador menuColab, Usuario usuarioAtual) throws IOException {
        Scanner inputSwitch = new Scanner(System.in);

        boolean sairSistema = false;

        do {
            System.out.println("""
                           
                           Escolha uma opção do menu: 
                           _________________________________________
                           1 -  Colaboradores          
                           2 -  Cliente                
                           3 -  Produtos               
                           4 -  Relatórios             
                           5 -  Perfil         
                           6 -  Encerrar
                           _________________________________________
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
    }

    /**
     *
     * Função padrão para acesso às opções acessíveis ao Colaborador
     * @param menuAdm Recebe um objeto da classe intermediária de funcionalidades disponíveis ao Administrador
     * @param menuColab Recebe um objeto da classe intermediária de funcionalidades disponíveis ao Colaborador
     * @param usuarioAtual Recebe o objeto referente ao usuário logado no sistema
     * @throws IOException Exceção associada à manipulação de dados em arquivo Json
     */
    public void menuColaborador(ProxyAdministrador menuAdm, ProxyColaborador menuColab, Usuario usuarioAtual) throws IOException {
        Scanner inputSwitch = new Scanner(System.in);
        boolean sairSistema = false;

        do {
            System.out.println("""
                           
                           Escolha uma opção do menu: 
                           _________________________________________ 
                           1 -  Perfil                 
                           2 -  Pedidos                
                           3 -  Relatórios             
                           4 -  Encerrar
                           _________________________________________
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
        } while (sairSistema == false);
    }

    /**
     * Função padrão para acesso às opções de manipulação de Colaborador
     * @param menuAdm Recebe um objeto da classe intermediária de funcionalidades disponíveis ao Administrador
     * @param menuColab Recebe um objeto da classe intermediária de funcionalidades disponíveis ao Colaborador
     * @param usuarioAtual Recebe o objeto referente ao usuário logado no sistema
     * @throws IOException Exceção associada à manipulação de dados em arquivo Json
     */

    public void menuOpcaoColaboradorAdmin(ProxyAdministrador menuAdm, ProxyColaborador menuColab, Usuario usuarioAtual) throws IOException {
        Scanner inputSwitch = new Scanner(System.in);
        Scanner input = new Scanner(System.in);

        boolean menuAnterior = false;

        do {
            System.out.println("""
                           
                           Escolha uma opção: 
                           _________________________________________
                           1 - Cadastrar  
                           2 - Editar     
                           3 - Consultar 
                           4 - Remover      
                           5 - Voltar
                           _________________________________________
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
        } while (menuAnterior == false);
    }

    /**
     * Função padrão para acesso às opções de manipulação de dados pessoais do Colaborador
     * @param menuAdm Recebe um objeto da classe intermediária de funcionalidades disponíveis ao Administrador
     * @param menuColab Recebe um objeto da classe intermediária de funcionalidades disponíveis ao Colaborador
     * @param usuarioAtual Recebe o objeto referente ao usuário logado no sistema
     * @throws IOException Exceção associada à manipulação de dados em arquivo Json
     */

    public void menuOpcaoColaboradorColab(ProxyAdministrador menuAdm, ProxyColaborador menuColab, Usuario usuarioAtual) throws IOException {
        Scanner inputSwitch = new Scanner(System.in);
        boolean menuAnterior = false;

        do {
            System.out.println("_______________________________\n"
                    + usuarioAtual.getNomePessoa() + " " + usuarioAtual.getSobrenomePessoa()
                    + "________________________________________\n");
            System.out.println("""
                           
                           Escolha uma opção:
                           _________________________________________
                           1 - Alterar senha           
                           2 - Voltar
                           _________________________________________
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
        } while (menuAnterior == false);
    }

    /**
     * Função padrão para acesso às opções de manipulação de Produtos 
     * @param menuAdm Recebe um objeto da classe intermediária de funcionalidades disponíveis ao Administrador
     * @param menuColab Recebe um objeto da classe intermediária de funcionalidades disponíveis ao Colaborador
     * @param usuarioAtual Recebe o objeto referente ao usuário logado no sistema
     * @throws IOException Exceção associada à manipulação de dados em arquivo Json
     */

    public void menuOpcaoProduto(ProxyAdministrador menuAdm, ProxyColaborador menuColab, Usuario usuarioAtual) throws IOException {
        Scanner inputSwitch = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        boolean menuAnterior = false;

        do {
            System.out.println("""
                           
                           Escolha uma opção:
                           _________________________________________
                               
                           1 - Cadastrar      
                           2 - Editar       
                           3 - Consultar       
                           4 - Remover          
                           5 - Voltar
                           _________________________________________
                                    """);

            int i = inputSwitch.nextInt();
            int idProduto;
            switch (i) {
                case 1 -> {
                    menuAdm.cadastroProduto();
                    break;
                }
                case 2 -> {
                    System.out.printf("Digite o ID do produto que deseja alterar: ");
                    idProduto = input.nextInt();
                    menuAdm.modificarProduto(idProduto);
                    break;
                }
                case 3 -> {
                    System.out.printf("Digite o ID do produto que deseja alterar: ");
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
        } while (menuAnterior == false);
    }

    /**
     * Função padrão para acesso às opções de visualização de relatórios com base em dados do sistema
     * @param menuAdm Recebe um objeto da classe intermediária de funcionalidades disponíveis ao Administrador
     * @param menuColab Recebe um objeto da classe intermediária de funcionalidades disponíveis ao Colaborador
     * @param usuarioAtual Recebe o objeto referente ao usuário logado no sistema
     * @throws IOException Exceção associada à manipulação de dados em arquivo Json
     */

    public void menuOpcaoRelatorio(ProxyAdministrador menuAdm, ProxyColaborador menuColab, Usuario usuarioAtual) throws IOException {
        Scanner inputSwitch = new Scanner(System.in);
        boolean menuAnterior = false;

        do {
            System.out.println("""
                               
                           Escolha uma opção:          
                           _________________________________________
                               
                           1 -   Clientes     
                           2 -   Colaboradores
                           3 -   Produtos     
                           4 -   Pedido      
                           5 -   Estatística de venda     
                           6 -   Voltar
                           _________________________________________
                                       """);

            int i = inputSwitch.nextInt();
            switch (i) {
                case 1 -> {
                    System.out.println("""
                                         CLIENTES CADASTRADOS NO SISTEMA
                                         ______________________________________
                                        """);
                    menuAdm.printClientes();
                    ProxyAdministrador.setQntClientesProtected();
                    ProxyAdministrador.setQntClientesPrivate();
                    System.out.println("Total de clientes cadastrados: " + ProxyAdministrador.qntClientesProtected);
                }
                case 2 -> {
                    System.out.printf("""
                                            COLABORADORES CADASTRADOS NO SISTEMA
                                            _________________________________________
                                            """);
                    menuAdm.printColaboradores();
                }
                case 3 -> {
                    System.out.printf("""
                                            PRODUTOS CADASTRADOS NO SISTEMA
                                            _________________________________________
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
                    menuAnterior = true;
                    break;

                }
                default -> {
                    System.out.println("A opção selecionada é invalida.");
                }
            }
        } while (menuAnterior == false);
    }

    /**
     * Função padrão para acesso às opções de manipulação de informações pessoais do Administrador
     * @param menuAdm Recebe um objeto da classe intermediária de funcionalidades disponíveis ao Administrador
     * @param menuColab Recebe um objeto da classe intermediária de funcionalidades disponíveis ao Colaborador
     * @param usuarioAtual Recebe o objeto referente ao usuário logado no sistema
     * @throws IOException Exceção associada à manipulação de dados em arquivo Json
     */

    public void menuOpcaoAdmin(ProxyAdministrador menuAdm, ProxyColaborador menuColab, Usuario usuarioAtual) throws IOException {
        Scanner inputSwitch = new Scanner(System.in);
        boolean menuAnterior = false;
        do {
            System.out.println("""
                           
                           Escolha uma opção: 
                           _________________________________________
                           1 - Exibir dados           
                           2 - Alterar dados   
                           3 - Voltar
                           _________________________________________
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
        } while (menuAnterior == false);
    }

    /**
     * Função padrão de acesso às opções de manipulação de Pedidos
     * @param menuAdm Recebe um objeto da classe intermediária de funcionalidades disponíveis ao Administrador
     * @param menuColab Recebe um objeto da classe intermediária de funcionalidades disponíveis ao Colaborador
     * @param usuarioAtual Recebe o objeto referente ao usuário logado no sistema
     * @throws IOException Exceção associada à manipulação de dados em arquivo Json
     */
    public void menuOpcaoPedido(ProxyAdministrador menuAdm, ProxyColaborador menuColab, Usuario usuarioAtual) throws IOException {
        Scanner inputSwitch = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        boolean menuAnterior = false;

        do {
            System.out.println("""
                           
                           Escolha uma opção: 
                           _________________________________________
                           1 - Cadastrar       
                           2 - Editar           
                           3 - Consultar        
                           4 - Remover          
                           5 - Extratos    
                           6 - Voltar
                           _________________________________________
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
                    System.out.println("CPF: ");
                    CPF = input.nextLine();
                    System.out.println("Lista de pedidos do Cliente: ");
                    for (int k = 0; k < ProxyAdministrador.consultaCliente(CPF).getPedidosCliente().size(); k++) {
                        System.out.println(ProxyAdministrador.consultaCliente(CPF).getPedidosCliente().get(k));
                    }

                    System.out.println("ID do Pedido: ");
                    idPedido = input.nextInt();
                    menuColab.modificarPedido(idPedido, ProxyAdministrador.consultaCliente(CPF));
                    break;
                }
                case 3 -> {
                    System.out.println("CPF do Cliente: ");
                    CPF = input.nextLine();
                    System.out.println("Lista de pedidos do Cliente: ");
                    for (int k = 0; k < ProxyAdministrador.consultaCliente(CPF).getPedidosCliente().size(); k++) {
                        System.out.println(ProxyAdministrador.consultaCliente(CPF).getPedidosCliente().get(k));
                    }

                    System.out.println("ID do Pedido: ");
                    idPedido = input.nextInt();
                    System.out.println(menuColab.consultarPedido(idPedido, ProxyAdministrador.consultaCliente(CPF)));
                    break;
                }
                case 4 -> {
                    menuColab.excluirPedido();
                    break;
                }
                case 5 -> {
                    manipularJson mJson = new manipularJson();
                    mJson.dumpExtratosPedidos(menuColab.extratosPedidos());
                    ProxyColaborador.setExtratosPedidos(mJson.assimilateExtratosPedidos());
                    for (String extratoPedido : ProxyColaborador.getExtratosPedidos()) {
                        System.out.println(extratoPedido);
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
        } while (menuAnterior == false);
    }

    /**
     * Função padrão de acesso às opções de manipulação de Clientes
     * @param menuAdm Recebe um objeto da classe intermediária de funcionalidades disponíveis ao Administrador
     * @param menuColab Recebe um objeto da classe intermediária de funcionalidades disponíveis ao Colaborador
     * @param usuarioAtual Recebe o objeto referente ao usuário logado no sistema
     * @throws IOException Exceção associada à manipulação de dados em arquivo Json
     */
    public void menuOpcaoCliente(ProxyAdministrador menuAdm, ProxyColaborador menuColab, Usuario usuarioAtual) throws IOException {
        Scanner inputSwitch = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        boolean menuAnterior = false;
        do {
            System.out.println("""
                           
                           Escolha uma opção: 
                           _________________________________________
                           1 - Cadastrar      
                           2 - Editar      
                           3 - Consultar       
                           4 - Remover 
                           5 - Listar pedidos  
                           6 - Voltar
                           _________________________________________
                                    """);

            int i = inputSwitch.nextInt();
            String CPF;
            switch (i) {
                case 1 -> {
                    menuAdm.cadastroCliente();
                }
                case 2 -> {
                    System.out.printf("CPF do cliente: ");
                    CPF = input.nextLine();
                    menuAdm.modificarCliente(CPF);
                }
                case 3 -> {
                    System.out.printf("CPF do cliente: ");
                    CPF = input.nextLine();
                    System.out.println(ProxyAdministrador.consultaCliente(CPF));
                }
                case 4 -> {
                    System.out.printf("CPF do cliente: ");
                    CPF = input.nextLine();
                    menuAdm.excluirCliente(CPF);
                }
                case 5 -> {
                    System.out.println("CPF do cliente: ");
                    CPF = input.nextLine();
                    System.out.println("Lista de pedidos do Cliente: ");
                    for (int k = 0; k < ProxyAdministrador.consultaCliente(CPF).getPedidosCliente().size(); k++) {
                        System.out.println(ProxyAdministrador.consultaCliente(CPF).getPedidosCliente().get(k));
                    }
                    break;
                }
                case 6 -> {
                    menuAnterior = true;
                }
                default -> {
                    System.out.println("A opção selecionada é invalida.");
                }
            }
        } while (menuAnterior == false);
    }

    /**
     * 
     * @return Representação String da Classe
     */
    @Override
    public String toString() {
        return "Menu do Sistema";
    }

}
