
import br.com.lanchonete.pessoas.*;
import br.com.lanchonete.produtos.Produto;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author henri
 */
public class ProxyAdministrador {

    /**
     *
     */
    public ProxyAdministrador() {
    }

    //MANIPULAÇÃO DE COLABORADORES
    //Questão 01 - O sistema deve armazenar de forma estática 15 colaboradores
    private static Colaborador Colaboradores[] = new Colaborador[15];

    //GETTER DO ARRAY DE COLABORADORES
    /**
     *
     * @return
     */
    public static Colaborador[] getColaboradores() {
        return Colaboradores;
    }

    //FUNÇÃO PARA CADASTRO DE COLABORADORES
    /**
     *
     * @param C
     */
    public void addColaboradores(Colaborador C) {
        for (int i = 0; i < 15; i++) {
            if (ProxyAdministrador.Colaboradores[i] == null) {
                ProxyAdministrador.Colaboradores[i] = C;
                break;
            }
        }

    }

    //SETTER DE ARRAY DE COLABORADORES
    /**
     *
     * @param Colaboradores
     */
    public static void setColaboradores(Colaborador[] Colaboradores) {
        ProxyAdministrador.Colaboradores = Colaboradores;

    }

    //FUNÇÃO DE CADASTRO DE COLABORADORES
    public void cadastroColaborador() {

        String nomeColaborador, sobrenomeColaborador, CPF, loginColaborador, senhaColaborador;

        Scanner input = new Scanner(System.in);

        //Input de dados 
        System.out.printf("Nome: ");
        nomeColaborador = input.nextLine();

        System.out.printf("Sobrenome: ");
        sobrenomeColaborador = input.nextLine();

        do {
            System.out.printf("CPF: ");
            CPF = input.nextLine();
        } while (ProxyAdministrador.ValidaCPF(CPF) == false);

        System.out.printf("E-mail: ");
        loginColaborador = input.nextLine();

        System.out.printf("Senha: ");
        senhaColaborador = input.nextLine();

        //Cadastro
        Colaborador C = new Colaborador(nomeColaborador, sobrenomeColaborador, CPF, loginColaborador, senhaColaborador);
        addColaboradores(C);
        System.out.println("Cadastro realizado com sucesso!");
    }

    //CONSULTA O COLABORADOR NO BANCO DE COLABORADORS
    /**
     *
     * @param CPF
     * @return
     */
    public Colaborador consultaColaborador(String CPF) {

        String CPFColaborador = CPF;
        //Colaborador attColaborador = new Colaborador();
        Colaborador attColaborador = null;

        for (Colaborador colab : ProxyAdministrador.getColaboradores()) {
            if (CPFColaborador.equals(colab.getCPF())) {
                attColaborador = colab;
                break;
            }

        }
        return attColaborador;
    }

    //FUNÇÃO PARA MODIFICAÇÃO DE DADOS DO COLABORADOR   
    /**
     *
     * @param CPF
     */
    public void modificarColaborador(String CPF) {
        Scanner inputSwitch = new Scanner(System.in);

        boolean menuAnterior = false;
        do {
            String CPFColab = CPF;
            if (consultaColaborador(CPFColab) != null) {
                Colaborador modColab = consultaColaborador(CPFColab);
                System.out.println("DADOS COLABORADOR");
                System.out.println(modColab + "________________________________");
                System.out.println("""
                               Escolha uma opção: 
                               1 - Alterar Nome 
                               2 - Alterar Sobrenome 
                               3 - Alterar CPF
                               4 - Alterar login
                               5 - Fechar
                                """);

                int i = inputSwitch.nextInt();
                Scanner inputDado = new Scanner(System.in);

                switch (i) {
                    case 1 -> {
                        System.out.printf("Novo nome: ");
                        String dado = inputDado.nextLine();
                        modColab.setNomePessoa(dado);
                        System.out.println("Alteração realizada com sucesso!");
                        break;
                    }

                    case 2 -> {
                        System.out.printf("Novo sobrenome: ");
                        String dado = inputDado.nextLine();
                        modColab.setSobrenomePessoa(dado);
                        System.out.println("Alteração realizada com sucesso!");
                        break;
                    }

                    case 3 -> {
                        String dado;
                        do {
                            System.out.printf("Novo CPF: ");
                            dado = inputDado.nextLine();
                        } while (ProxyAdministrador.ValidaCPF(dado) == false);
                        modColab.setCPF(dado);
                        System.out.println("Alteração realizada com sucesso!");
                        CPFColab = dado;
                        break;
                    }

                    case 4 -> {
                        String novoLogin;
                        String confirmLogin;
                        do {
                            System.out.printf("Novo login: ");
                            novoLogin = inputDado.nextLine();
                            System.out.printf("Confirmar novo login: ");
                            confirmLogin = inputDado.nextLine();

                            if (novoLogin.equals(confirmLogin)) {
                                modColab.setLoginUsuario(confirmLogin);
                                System.out.println("Alteração realizada com sucesso!");
                            } else {
                                System.out.println("Dados não conferem. Tente novamente!\n");
                            }

                        } while (!novoLogin.equals(confirmLogin));

                    }

                    case 5 -> {
                        menuAnterior = true;
                        break;
                    }

                    default -> {
                        System.out.println("Opção inválida");
                    }
                }
            } else {
                System.out.println("CPF inválido!");
            }
        } while (menuAnterior == false);

    }

    //FUNÇÃO PARA EXCLUSÃO DE COLABORADORES
    /**
     *
     * @param CPF
     */
    public void excluirColaborador(String CPF) {
        String CPFColaborador = CPF;

        for (Colaborador colab : ProxyAdministrador.getColaboradores()) {
            if (colab != null && colab.getCPF().equals(CPFColaborador)) {
                colab = null;
                break;
            }
        }
        System.out.println("Alteração realizada com sucesso!");

    }

    //Acessar informação colaborador 
    //IMPRIMIR COLABORADORES NA TELA
    public void printColaboradores() {
        for (Colaborador colab : ProxyAdministrador.getColaboradores()) {
            if (colab != null) {
                System.out.println(colab);
            }
        }
    }

    //ACESSAR INFORMAÇÕES DE UM COLABORADOR ESPECÍFICO
    /**
     *
     * @param CPF
     */
    public void printColaborador(String CPF) {
        if (consultaColaborador(CPF) != null) {
            System.out.println(consultaColaborador(CPF));
        } else {
            System.out.println("Colaborador não cadastrado.");
        }
    }

    //MANIPULAÇÃO DE CLIENTES
    //Questão 8 - Clientes e pedidos devem ser salvos de forma dinâmica
    private static ArrayList<Cliente> Clientes = new ArrayList<>();

    //Getter
    /**
     *
     * @return
     */
    public static ArrayList<Cliente> getClientes() {
        return Clientes;
    }

    private static int qntClientesPrivate;
    protected static int qntClientesProtected;

    /**
     *
     * @return
     */
    public static int getQntClientesPrivate() {
        return qntClientesPrivate;
    }

    /**
     *
     */
    public static void setQntClientesPrivate() {
        int qnt = 0;
        for (Cliente cl : ProxyAdministrador.getClientes()) {
            qnt++;
        }
        ProxyAdministrador.qntClientesPrivate = qnt;
    }

    /**
     *
     * @return
     */
    public static int getQntClientesProtected() {
        return qntClientesProtected;
    }

    public static void setQntClientesProtected() {
        int qnt = 0;
        for (Cliente cl : ProxyAdministrador.getClientes()) {
            qnt++;
        }
        qntClientesProtected = qnt;
    }

    //Setter
    /**
     *
     * @param Clientes
     */
    public static void setClientes(ArrayList<Cliente> Clientes) {
        ProxyAdministrador.Clientes = Clientes;
    }

    //CADASTRO DE NOVOS CLIENTES
    /**
     *
     */
    public void cadastroCliente() {
        String nomeCliente, sobrenomeCliente, CPF, enderecoCliente, telefoneCliente;

        Scanner input = new Scanner(System.in);

        //Input de dados 
        System.out.printf("Nome: ");
        nomeCliente = input.nextLine();
        System.out.printf("Sobrenome: ");
        sobrenomeCliente = input.nextLine();

        do {
            System.out.printf("CPF: ");
            CPF = input.nextLine();
        } while (ProxyAdministrador.ValidaCPF(CPF) == false);

        System.out.printf("Endereço: ");
        enderecoCliente = input.nextLine();
        System.out.printf("Telefone: ");
        telefoneCliente = input.nextLine();

        Cliente cl = new Cliente(nomeCliente, sobrenomeCliente, CPF, enderecoCliente, telefoneCliente);
        ProxyAdministrador.Clientes.add(cl);
        System.out.println("Cadastro realizado com sucesso!");
        //Manipulação com membro devidamente encapsulado, requer o uso de um método para tanto
        setQntClientesPrivate();

        //Manipulação com membro protected. Permite o acesso direto à variável;
        qntClientesProtected++;
    }

    //CONSULTA DE CLIENTES NO BANCO DE CLIENTES
    /**
     *
     * @param CPF
     * @return
     */
    public static Cliente consultaCliente(String CPF) {

        String CPFCliente = CPF;
        Cliente attCliente = new Cliente();
        attCliente = null;

        for (Cliente cliente : ProxyAdministrador.getClientes()) {
            if (CPFCliente.equals(cliente.getCPF())) {
                attCliente = cliente;
                break;
            }
        }
        return attCliente;
    }

    //FUNÇÃO DE EXCLUSÃO DE DADOS DE UM CLIENTE
    /**
     *
     * @param CPF
     */
    public void excluirCliente(String CPF) {
        String CPFCliente = CPF;

        for (Cliente cliente : ProxyAdministrador.getClientes()) {
            if (CPFCliente.equals(cliente.getCPF())) {
                ProxyAdministrador.getClientes().remove(cliente);
                break;
            }
        }
        System.out.println("Alteração realizada com sucesso!");
    }

    //FUNÇÃO DE MODIFICAÇÃO DE DADOS DE UM CLIENTE
    /**
     *
     * @param CPF
     */
    public void modificarCliente(String CPF) {

        Scanner inputSwitch = new Scanner(System.in);

        boolean menuAnterior = false;

        String CPFCli = CPF;
        do {
            if (consultaCliente(CPFCli) != null) {
                Cliente modCliente = consultaCliente(CPFCli);
                System.out.println("DADOS CLIENTE");
                System.out.println(modCliente + "______________________________");
                System.out.println("""
                               Escolha uma opção: 
                               1 - Alterar Nome 
                               2 - Alterar Sobrenome 
                               3 - Alterar CPF
                               4 - Alterar Endereço
                               5 - Alterar Telefone
                               6 - Fechar
                                """);

                int i = inputSwitch.nextInt();
                Scanner inputDado = new Scanner(System.in);

                switch (i) {
                    case 1 -> {
                        System.out.printf("Novo nome: ");
                        String dado = inputDado.nextLine();
                        modCliente.setNomePessoa(dado);
                        System.out.println("Alteração realizada com sucesso!");
                        break;
                    }

                    case 2 -> {
                        System.out.printf("Novo sobrenome: ");
                        String dado = inputDado.nextLine();
                        modCliente.setSobrenomePessoa(dado);
                        System.out.println("Alteração realizada com sucesso!");
                        break;
                    }

                    case 3 -> {
                        String dado;
                        do {
                            System.out.printf("Novo CPF: ");
                            dado = inputDado.nextLine();
                        } while (ProxyAdministrador.ValidaCPF(dado) == false);
                        modCliente.setCPF(dado);
                        System.out.println("Alteração realizada com sucesso!");
                        CPFCli = dado;
                        break;
                    }
                    case 4 -> {
                        System.out.printf("Novo endereço: ");
                        String dado = inputDado.nextLine();
                        modCliente.setEnderecoCliente(dado);
                        System.out.println("Alteração realizada com sucesso!");
                        break;
                    }
                    case 5 -> {
                        System.out.printf("Novo telefone: ");
                        String dado = inputDado.nextLine();
                        modCliente.setTelefoneCliente(dado);
                        System.out.printf("Alteração realizada com sucesso!");
                        break;
                    }

                    case 6 -> {
                        menuAnterior = true;
                        break;
                    }

                    default -> {
                        System.out.println("Opção inválida");
                    }
                }
            } else {
                System.out.println("CPF inválido!");
            }
        } while (menuAnterior == false);

    }

    //Acessar informações cliente 
    //ACESSO A TODOS OS CLIENTES DE UMA VEZ SÓ
    public void printClientes() {
        for (Cliente cliente : ProxyAdministrador.getClientes()) {
            if (cliente != null) {
                System.out.println(cliente);
            }
        }

    }

    //ACESSO A UM ÚNICO CLIENTE
    /**
     *
     * @param CPF
     */
    public void printCliente(String CPF) {
        if (consultaCliente(CPF) != null) {
            System.out.println(consultaCliente(CPF));
        }
    }

    //PRODUTOS
    //LISTA DE PRODUTOS
    public static ArrayList<Produto> listaProdutos = new ArrayList<>();

    //Controle da id dos produtos
    private static int numProdutos = 0;

    /**
     *
     * @return
     */
    public static int getNumProdutos() {
        return numProdutos;
    }

    /**
     *
     * @param numProdutos
     */
    public static void setNumProdutos(int numProdutos) {
        ProxyAdministrador.numProdutos = numProdutos + 1;
    }

    //getter da lista de produtos
    /**
     *
     * @return
     */
    public static ArrayList<Produto> getListaProdutos() {
        return listaProdutos;
    }

    //Setter de produtos na lista
    /**
     *
     * @param listaProdutos
     */
    public static void setListaProdutos(ArrayList<Produto> listaProdutos) {
        ProxyAdministrador.listaProdutos = listaProdutos;
    }

    //Cadastro produto 
    public void cadastroProduto() {
        String nomeProduto, descricaoProduto;
        float valorProduto;
        int idProduto;

        Scanner input = new Scanner(System.in);

        //INPUT DE DADOS
        System.out.printf("Nome: ");
        nomeProduto = input.nextLine();

        System.out.printf("Descrição: ");
        descricaoProduto = input.nextLine();

        System.out.printf("Valor: ");
        valorProduto = input.nextFloat();

        idProduto = ProxyAdministrador.getNumProdutos();

        Produto Pr = new Produto(nomeProduto, valorProduto, idProduto, descricaoProduto);
        ProxyAdministrador.getListaProdutos().add(Pr);
        ProxyAdministrador.setNumProdutos(numProdutos);

    }

    //FUNÇÃO DE EXCLUSÃO DE PRODUTO
    public void excluirProduto() {
        System.out.println("PRODUTOS CADASTRADOS\n___________________________");
        
        for(Produto produto : ProxyAdministrador.listaProdutos){
            System.out.println("[" + produto.getIdProduto() + "]   " + produto.getNomeProduto());
        }
        
        System.out.println("""
                           _________________________________________________
                           Exclusão de produtos
                           """);
        System.out.printf("Id do Produto: ");
        Scanner input = new Scanner(System.in);
        int idProduto = input.nextInt();

        for (Produto produto : ProxyAdministrador.getListaProdutos()) {
            if (idProduto == produto.getIdProduto()) {
                ProxyAdministrador.listaProdutos.remove(produto);
                break;
            }
        }
        System.out.println("Produto removido com sucesso.");
    }

    //CONSULTA PRODUTO
    /**
     *
     * @param idProduto
     * @return
     */
    public static Produto consultaProduto(int idProduto) {
        Produto attProduto = new Produto();
        attProduto = null;

        for (Produto produto : ProxyAdministrador.listaProdutos) {
            if (idProduto == produto.getIdProduto()) {
                attProduto = produto;
                break;
            }
        }

        return attProduto;
    }

    /**
     *
     * @param idProduto
     */
    public void modificarProduto(int idProduto) {

        Scanner inputSwitch = new Scanner(System.in);

        boolean menuAnterior = false;
        do {
            if (consultaProduto(idProduto) != null) {
                Produto modProduto = consultaProduto(idProduto);
                System.out.println("DADOS DO PEDIDO");
                System.out.println(modProduto + "_____________________________________");
                System.out.println("""
                               Escolha uma opção: 
                               1 - Alterar Nome 
                               2 - Alterar Descrição 
                               3 - Alterar Valor
                               4 - Fechar
                                """);

                int i = inputSwitch.nextInt();
                Scanner inputDado = new Scanner(System.in);

                switch (i) {
                    case 1 -> {
                        System.out.printf("Novo nome: ");
                        String dado = inputDado.nextLine();

                        modProduto.setNomeProduto(dado);
                        System.out.println("Alteração realizada com sucesso!");
                        break;
                    }

                    case 2 -> {
                        System.out.printf("Nova descrição: ");
                        String dado = inputDado.nextLine();

                        modProduto.setDescricaoProduto(dado);
                        System.out.println("Alteração realizada com sucesso!");
                        break;
                    }

                    case 3 -> {
                        System.out.printf("Novo CPF: ");
                        float dado = inputDado.nextFloat();

                        modProduto.setValorProduto(dado);
                        System.out.println("Alteração realizada com sucesso!");
                        break;
                    }

                    case 4 -> {
                        menuAnterior = true;
                        break;
                    }

                    default -> {
                        System.out.println("Opção inválida");
                    }
                }
            } else {
                System.out.println("Identificador de produto inválido!");
            }
        } while (menuAnterior == false);

    }

    public void consultaListaProdutos() {
        System.out.println("PRODUTOS CADASTRADOS\n___________________________");
        for (int i = 0; i < ProxyAdministrador.listaProdutos.size(); i++) {
            System.out.println("Id: " + ProxyAdministrador.listaProdutos.get(i).getIdProduto()
                    + "\t|\t Nome: " + ProxyAdministrador.listaProdutos.get(i).getNomeProduto());
        }
    }

    //Acessar produto 
    public void printProduto() {
        System.out.println("PRODUTOS CADASTRADOS\n___________________________");
        for(Produto produto : ProxyAdministrador.listaProdutos){
            System.out.println("[" + produto.getIdProduto() + "]   " + produto.getNomeProduto());
        }
        System.out.println("CONSULTA\n_______________________");
        System.out.printf("Id do Produto: ");
        Scanner input = new Scanner(System.in);
        int idProduto = input.nextInt();

        if (consultaProduto(idProduto) != null) {
            System.out.println(consultaProduto(idProduto));
        }
    }

    //ADMINISTRADORES
    //Acessar Administrador
    /**
     *
     * @param Adm
     */
    public void consultaAdm(Administrador Adm) {
        System.out.println(Adm);
    }

    //Modificar admnistrador 
    /**
     *
     * @param Adm
     */
    public void modificarAdm(Administrador Adm) {

        boolean menuAnterior = false;
        do {
            System.out.println(Adm + "\n____________________________________________");
            Scanner input = new Scanner(System.in);
            System.out.println("""
                           Escolha uma opção:
                           1 - Alterar login
                           2 - Alterar senha
                           3 - Alterar CPF
                           4 - Alterar nome
                           5 - Fechar
                           """);
            int i = input.nextInt();
            switch (i) {
                case 1 -> {
                    System.out.printf("Novo login: ");
                    String novoLogin = input.nextLine();
                    System.out.printf("Confirme o login: ");
                    String confirLogin = input.nextLine();

                    if (novoLogin.equals(confirLogin)) {
                        Adm.setLoginUsuario(confirLogin);
                        break;
                    } else {
                        System.out.println("Dados inseridos não conferem. Tente novamente");
                        break;
                    }
                }
                case 2 -> {
                    input = new Scanner(System.in);
                    System.out.printf("Senha anterior: ");
                    String senhaAnt = input.nextLine();
                    System.out.printf("Nova senha: ");
                    String novaSenha = input.nextLine();
                    System.out.printf("Nova senha: ");
                    String confirmSenha = input.nextLine();

                    if (Adm.getSenhaUsuario().equals(senhaAnt)) {
                        if (novaSenha.equals(confirmSenha)) {
                            Adm.setSenhaUsuario(novaSenha);
                            System.out.println("Alteração realizada com sucesso!");
                            break;
                        } else {
                            System.out.println("Senhas diferentes. Tente novamente.");
                            break;
                        }
                    } else {
                        System.out.println("Senha antiga não confere. Tente novamente");
                        break;
                    }
                }

                case 3 -> {

                    String novoCPF;
                    do {
                        System.out.println("Novo CPF: ");
                        novoCPF = input.nextLine();
                    } while (ProxyAdministrador.ValidaCPF(novoCPF) == false);
                    Adm.setCPF(novoCPF);
                    System.out.println("Alteração realizada com sucesso!");
                    break;
                }

                case 4 -> {
                    System.out.printf("Novo nome: ");
                    String novoNome = input.nextLine();
                    Adm.setNomePessoa(novoNome);

                    System.out.printf("Novo sobrenome: ");
                    String novoSobrenome = input.nextLine();
                    Adm.setSobrenomePessoa(novoSobrenome);

                    System.out.println("Alteração realizada com sucesso!");
                    break;
                }

                case 5 -> {
                    menuAnterior = true;
                    break;
                }

                default -> {
                    System.out.println("Opção inválida, tente novamente.");
                    break;
                }

            }

        } while (menuAnterior == false);

    }

    /**
     *
     * @param cpf
     * @return
     */
    public static boolean ValidaCPF(String cpf) {
        // importar a java.util.InputMismatchException

        //Validando se o CPF é formado apenas por numeros iguais
        if (cpf.equals("00000000000")
                || cpf.equals("11111111111")
                || cpf.equals("22222222222")
                || cpf.equals("33333333333")
                || cpf.equals("44444444444")
                || cpf.equals("55555555555")
                || cpf.equals("66666666666")
                || cpf.equals("77777777777")
                || cpf.equals("88888888888")
                || cpf.equals("99999999999")
                || (cpf.length() != 11)) {
            System.out.println("CPF inválido. Digite novamente.");
            return false;
        }

        // variaveis do décimo e décimo primeiro 
        char digito10;
        char digito11;
        int soma;
        int i;
        int r;
        int numero;
        int peso;

        try {
            // para calcular o primeiro digito "verificador"
            soma = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                // para converter o caractere do CPF em um número inteiro
                // o 48 representa o zero tabela ASCII
                numero = (int) (cpf.charAt(i) - 48);
                soma = soma + (numero * peso);
                peso = peso - 1;
            }

            r = 11 - (soma % 11);
            if ((r == 10) || (r == 11)) {
                digito10 = '0';
            } else {
                digito10 = (char) (r + 48);
            }

            //para calcular o segundo digito "verificador"
            soma = 0;
            //peso igual a 11, pois, o primeiro digito verificador já foi calculado
            peso = 11;
            for (i = 0; i < 10; i++) {
                // xS é a variavel a qual vai receber os valores das somas
                numero = (int) (cpf.charAt(i) - 48);
                soma = soma + (numero * peso);
                // O xpeso sempre diminui de uma soma para a outra
                peso = peso - 1;
            }

            r = 11 - (soma % 11);

            if ((r == 10) || (r == 11)) {
                digito11 = '0';
            } else {
                digito11 = (char) (r + 48);
            }

            //Valida se os numeros informados batem o valor com os numeros 
            if ((digito10 == cpf.charAt(9))
                    && (digito11 == cpf.charAt(10))) {
                return (true);
            } else {
                System.out.println("CPF inválido. Digite novamente.");
                return (false);
            }
        } catch (Exception e) {
            System.out.println("Não foi possivel validar o CPF.");
            return (false);
        }
    }

    @Override
    public String toString() {
        return "ProxyAdministrador";
    }

}
