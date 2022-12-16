
import br.com.lanchonete.pessoas.*;
import br.com.lanchonete.produtos.Produto;
import java.util.Scanner;
import java.util.ArrayList;

public class ProxyAdministrador {

    //Construtor
    public ProxyAdministrador() {
    }

    //MANIPULAÇÃO DE COLABORADORES
    //Questão 01 - O sistema deve armazenar de forma estática 15 colaboradores
    private static Colaborador Colaboradores[] = new Colaborador[15];

    //GETTER DO ARRAY DE COLABORADORES
    public static Colaborador[] getColaboradores() {
        return Colaboradores;
    }

    //FUNÇÃO PARA CADASTRO DE COLABORADORES
    public static void addColaboradores(Colaborador C) {
        /*
        int i = 0;
        if (ProxyAdministrador.Colaboradores != null) {
            while (ProxyAdministrador.Colaboradores[i] != null & i <= 15) {
                i = i + 1;
            }
            if (i < 15) {
                ProxyAdministrador.Colaboradores[i] = C;
            } else {
                System.out.println("Vagas preenchidas. Não foi possível cadastrar novos colaboradores.");
            }
        }
        else{
            ProxyAdministrador.Colaboradores[i] = C;
        }
         */
        for (int i = 0; i < 15; i++) {
            if (ProxyAdministrador.Colaboradores[i] == null) {
                ProxyAdministrador.Colaboradores[i] = C;
                break;
            }
        }

    }

    //SETTER DE ARRAY DE COLABORADORES
    public static void setColaboradores(Colaborador[] Colaboradores) {
        ProxyAdministrador.Colaboradores = Colaboradores;

    }

    //FUNÇÃO DE CADASTRO DE COLABORADORES
    public void cadastroColaborador() {

        String nomeColaborador;
        String sobrenomeColaborador;
        String CPF;
        String loginColaborador;
        String senhaColaborador;

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
        ProxyAdministrador.addColaboradores(C);
    }

    //CONSULTA O COLABORADOR NO BANCO DE COLABORADORES
    public Colaborador consultaColaborador(String CPF) {

        String CPFColaborador = CPF;
        Colaborador attColaborador = new Colaborador();
        attColaborador = null;

        for (Colaborador colab : ProxyAdministrador.getColaboradores()) {
            if (CPFColaborador.equals(colab.getCPF())) {
                attColaborador = colab;
                break;
            }

        }
        return attColaborador;
    }

    //FUNÇÃO PARA MODIFICAÇÃO DE DADOS DO COLABORADOR
    public void modificarColaborador(String CPF) {

        Scanner inputSwitch = new Scanner(System.in);

        boolean menuAnterior = false;

        do {
            String CPFColab = CPF;
            if (consultaColaborador(CPFColab) != null) {
                Colaborador modColab = consultaColaborador(CPFColab);
                System.out.println("\nDADOS COLABORADOR\n----------------------------------------------------\n");
                System.out.println(modColab + "\n---------------------------------------------------------------------------------------------------------------------------------\n");
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
                        System.out.printf("Digite o novo nome: ");
                        String dado = inputDado.nextLine();

                        modColab.setNomePessoa(dado);
                        System.out.println("Alteração realizada com sucesso!");
                        break;
                    }

                    case 2 -> {
                        System.out.printf("Digite o novo sobrenome: ");
                        String dado = inputDado.nextLine();

                        modColab.setSobrenomePessoa(dado);
                        System.out.println("Alteração realizada com sucesso!");
                        break;
                    }

                    case 3 -> {
                        String dado;
                        do {
                            System.out.printf("Digite o novo CPF: ");
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
                        do{
                            System.out.printf("Digite o novo login: ");
                            novoLogin = inputDado.nextLine();
                            System.out.printf("Digite a confirmação do novo login: ");
                            confirmLogin = inputDado.nextLine();
                            
                            if(novoLogin.equals(confirmLogin)){
                                modColab.setLoginUsuario(confirmLogin);
                                System.out.println("\nAlteração realizada com sucesso!");
                            }
                            else{
                                System.out.println("\nDados não conferem. Tente novamente!\n");
                            }
                            
                        }while(!novoLogin.equals(confirmLogin));
                        
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
    public void excluirColaborador(String CPF) {
        String CPFColaborador = CPF;

        for (int i = 0; i < 15; i++) {
            if (CPFColaborador.equals(ProxyAdministrador.Colaboradores[i].getCPF())) {
                ProxyAdministrador.Colaboradores[i] = null;
            }
        }
    }

    //Acessar informação colaborador 
    //IMPRIMIR COLABORADORES NA TELA
    public void printColaboradores() {
        for (int i = 0; i < 15; i++) {
            if (ProxyAdministrador.Colaboradores[i] != null) {
                System.out.println("\n" + ProxyAdministrador.Colaboradores[i]);
            }
        }
    }

    //ACESSAR INFORMAÇÕES DE UM COLABORADOR ESPECÍFICO
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
    public static ArrayList<Cliente> getClientes() {
        return Clientes;
    }

    private static int qntClientesPrivate;
    protected static int qntClientesProtected;

    public static int getQntClientesPrivate() {
        return qntClientesPrivate;
    }

    public static void setQntClientesPrivate() {
        ProxyAdministrador.qntClientesPrivate = qntClientesPrivate + 1;
    }

    public static int getQntClientesProtected() {
        return qntClientesProtected;
    }

    public static void setQntClientesProtected() {
        qntClientesProtected++;
    }

    //Setter
    public static void setClientes(ArrayList<Cliente> Clientes) {
        ProxyAdministrador.Clientes = Clientes;
    }

    //CADASTRO DE NOVOS CLIENTES
    public void cadastroCliente() {
        String nomeCliente;
        String sobrenomeCliente;
        String CPF;
        String enderecoCliente;
        String telefoneCliente;

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

        //Manipulação com membro devidamente encapsulado, requer o uso de um método para tanto
        setQntClientesPrivate();

        //Manipulação com membro protected. Permite o acesso direto à variável;
        qntClientesProtected++;
    }

    //CONSULTA DE CLIENTES NO BANCO DE CLIENTES
    public static Cliente consultaCliente(String CPF) {

        String CPFCliente = CPF;
        Cliente attCliente = new Cliente();
        attCliente = null;

        for (int i = 0; i <= ProxyAdministrador.Clientes.size(); i++) {
            if (CPFCliente.equals(ProxyAdministrador.Clientes.get(i).getCPF())) {
                attCliente = ProxyAdministrador.Clientes.get(i);
                break;
            }

        }
        return attCliente;
    }

    //FUNÇÃO DE EXCLUSÃO DE DADOS DE UM CLIENTE
    public void excluirCliente(String CPF) {
        String CPFCliente = CPF;
        for (int i = 0; i <= ProxyAdministrador.Clientes.size(); i++) {
            if (CPFCliente.equals(ProxyAdministrador.Clientes.get(i).getCPF())) {
                ProxyAdministrador.Clientes.remove(i);
                break;
            }
        }
    }

    //FUNÇÃO DE MODIFICAÇÃO DE DADOS DE UM CLIENTE
    public void modificarCliente(String CPF) {

        Scanner inputSwitch = new Scanner(System.in);

        boolean menuAnterior = false;

        String CPFCli = CPF;
        do {
            if (consultaCliente(CPFCli) != null) {
                Cliente modCliente = consultaCliente(CPFCli);
                System.out.println("DADOS CLIENTE\n--------------------------------\n");
                System.out.println(modCliente + "\n------------------------------------------------------------------------------------------------------------------------------------------------------\n");
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
                        System.out.printf("Digite o novo nome: ");
                        String dado = inputDado.nextLine();

                        modCliente.setNomePessoa(dado);
                        System.out.println("Alteração realizada com sucesso!");
                        break;
                    }

                    case 2 -> {
                        System.out.printf("Digite o novo sobrenome: ");
                        String dado = inputDado.nextLine();

                        modCliente.setSobrenomePessoa(dado);
                        System.out.println("Alteração realizada com sucesso!");
                        break;
                    }

                    case 3 -> {
                        String dado;
                        do {
                            System.out.printf("Digite o novo CPF: ");

                            System.out.printf("CPF: ");
                            dado = inputDado.nextLine();
                        } while (ProxyAdministrador.ValidaCPF(dado) == false);

                        modCliente.setCPF(dado);
                        System.out.println("Alteração realizada com sucesso!");
                        CPFCli = dado;
                        break;
                    }
                    case 4 -> {
                        System.out.printf("Digite o novo endereço: ");
                        String dado = inputDado.nextLine();

                        modCliente.setEnderecoCliente(dado);
                        System.out.println("Alteração realizada com sucesso!");
                        break;
                    }
                    case 5 -> {
                        System.out.printf("Digite o novo telefone: ");
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
        for (int i = 0; i < ProxyAdministrador.Clientes.size(); i++) {
            if (ProxyAdministrador.Clientes.get(i) != null) {
                System.out.println(ProxyAdministrador.Clientes.get(i));
                System.out.println("\n");
            }
        }
    }

    //ACESSO A UM ÚNICO CLIENTE
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

    public static int getNumProdutos() {
        return numProdutos;
    }

    public static void setNumProdutos(int numProdutos) {
        ProxyAdministrador.numProdutos = numProdutos + 1;
    }

    //getter da lista de produtos
    public static ArrayList<Produto> getListaProdutos() {
        return listaProdutos;
    }

    //Setter de produtos na lista
    public static void setListaProdutos(ArrayList<Produto> listaProdutos) {
        ProxyAdministrador.listaProdutos = listaProdutos;
    }

    //Cadastro produto 
    public void cadastroProduto() {
        String nomeProduto;
        float valorProduto;
        String descricaoProduto;
        int idProduto;

        Scanner input = new Scanner(System.in);

        //INPUT DE DADOS
        System.out.printf("Digite o nome do produto: ");
        nomeProduto = input.nextLine();

        System.out.printf("Digite a descrição do produto: ");
        descricaoProduto = input.nextLine();

        System.out.printf("Digite o valor do produto: ");
        valorProduto = input.nextFloat();

        idProduto = ProxyAdministrador.getNumProdutos();

        Produto Pr = new Produto(nomeProduto, valorProduto, idProduto, descricaoProduto);
        ProxyAdministrador.getListaProdutos().add(Pr);
        ProxyAdministrador.setNumProdutos(numProdutos);

    }

    //FUNÇÃO DE EXCLUSÃO DE PRODUTO
    public void excluirProduto() {
        System.out.println("\nPRODUTOS CADASTRADOS\n-----------------------------");
        for (int i = 0; i < ProxyAdministrador.listaProdutos.size(); i++) {
            System.out.println("Id: " + ProxyAdministrador.listaProdutos.get(i).getIdProduto()
                    + "\t|\t Nome: " + ProxyAdministrador.listaProdutos.get(i).getNomeProduto());
        }
        System.out.printf("\nDigite o ID do produto que deseja remover: ");
        Scanner input = new Scanner(System.in);
        int idProduto = input.nextInt();

        for (int i = 0; i < ProxyAdministrador.listaProdutos.size(); i++) {
            if (ProxyAdministrador.listaProdutos.get(i).getIdProduto() == idProduto) {
                ProxyAdministrador.listaProdutos.remove(i);
            }
        }
        System.out.println("Produto removido com sucesso.");
    }

    //CONSULTA PRODUTO
    public static Produto consultaProduto(int idProduto) {
        Produto attProduto = new Produto();
        attProduto = null;

        for (int i = 0; i < ProxyAdministrador.listaProdutos.size(); i++) {
            if (ProxyAdministrador.listaProdutos.get(i).getIdProduto() == idProduto) {
                attProduto = ProxyAdministrador.listaProdutos.get(i);
                break;
            }
        }
        return attProduto;
    }

    public void modificarProduto(int idProduto) {

        Scanner inputSwitch = new Scanner(System.in);

        boolean menuAnterior = false;
        do {
            if (consultaProduto(idProduto) != null) {
                Produto modProduto = consultaProduto(idProduto);
                System.out.println("DADOS DO PEDIDO\n------------------------\n");
                System.out.println(modProduto + "\n-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
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
                        System.out.printf("Digite o novo nome: ");
                        String dado = inputDado.nextLine();

                        modProduto.setNomeProduto(dado);
                        System.out.println("Alteração realizada com sucesso!");
                        break;
                    }

                    case 2 -> {
                        System.out.printf("Digite a nova descrição: ");
                        String dado = inputDado.nextLine();

                        modProduto.setDescricaoProduto(dado);
                        System.out.println("Alteração realizada com sucesso!");
                        break;
                    }

                    case 3 -> {
                        System.out.printf("Digite o novo CPF: ");
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
        System.out.println("\nPRODUTOS CADASTRADOS\n-----------------------------");
        for (int i = 0; i < ProxyAdministrador.listaProdutos.size(); i++) {
            System.out.println("Id: " + ProxyAdministrador.listaProdutos.get(i).getIdProduto()
                    + "\t|\t Nome: " + ProxyAdministrador.listaProdutos.get(i).getNomeProduto());
        }
    }

    //Acessar produto 
    public void printProduto() {
        System.out.println("\nPRODUTOS CADASTRADOS\n-----------------------------");
        for (int i = 0; i < ProxyAdministrador.listaProdutos.size(); i++) {
            System.out.println("Id: " + ProxyAdministrador.listaProdutos.get(i).getIdProduto()
                    + "\t|\t Nome: " + ProxyAdministrador.listaProdutos.get(i).getNomeProduto());
        }

        System.out.printf("\nDigite o ID do produto que deseja verificar: ");
        Scanner input = new Scanner(System.in);
        int idProduto = input.nextInt();

        if (consultaProduto(idProduto) != null) {
            System.out.println(consultaProduto(idProduto));
        }
    }

    //ADMINISTRADORES
    //Acessar Administrador
    public void consultaAdm(Administrador Adm) {
        System.out.println(Adm);
    }

    //Modificar admnistrador 
    public void modificarAdm(Administrador Adm) {

        boolean menuAnterior = false;
        do {
            System.out.println("---------------------------------------------------------------\n" + Adm + "\n---------------------------------------------------------------\n");
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
                    System.out.printf("Digite o novo login: ");
                    String novoLogin = input.nextLine();
                    System.out.println("Confirme o login: ");
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
                    System.out.println("Digite a sua senha anterior: ");
                    String senhaAnt = input.nextLine();
                    System.out.println("Digite a nova senha: ");
                    String novaSenha = input.nextLine();
                    System.out.println("Confirme a nova senha: ");
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
                        System.out.println("Digite o novo CPF: ");
                        novoCPF = input.nextLine();
                    } while (ProxyAdministrador.ValidaCPF(novoCPF) == false);
                    Adm.setCPF(novoCPF);
                    System.out.println("Alteração realizada com sucesso!");
                    break;
                }

                case 4 -> {
                    System.out.printf("Digite o novo nome: ");
                    String novoNome = input.nextLine();
                    Adm.setNomePessoa(novoNome);

                    System.out.printf("Digite o novo sobrenome: ");
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
                || cpf.equals("99999999999") || (cpf.length() != 11)) {
            System.out.println("\nCPF inválido. Digite novamente.\n");
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
                System.out.println("\nCPF inválido. Digite novamente.\n");
                return (false);
            }
        } catch (Exception e) {
            System.out.println("Não foi possivel validar o CPF.");
            return (false);
        }
    }
}
