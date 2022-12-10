
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
    private static final Colaborador Colaboradores[] = new Colaborador[15];

    //GETTER DO ARRAY DE COLABORADORES
    public Colaborador[] getColaboradores() {
        return Colaboradores;
    }

    //SETTER DE ARRAY DE COLABORADORES
    public static void setColaboradores(Colaborador[] Colaboradores, Colaborador C) {

        int i = 0;

        while (ProxyAdministrador.Colaboradores[i] != null & i <= 15) {
            i = i + 1;
        }

        if (i < 15) {
            ProxyAdministrador.Colaboradores[i] = C;
        } else {
            System.out.println("Vagas preenchidas. Não foi possível cadastrar novos colaboradores.");
        }

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

        System.out.printf("CPF: ");
        CPF = input.nextLine();

        System.out.printf("E-mail: ");
        loginColaborador = input.nextLine();

        System.out.printf("Senha: ");
        senhaColaborador = input.nextLine();

        //Cadastro
        Colaborador C = new Colaborador(nomeColaborador, sobrenomeColaborador, CPF, loginColaborador, senhaColaborador);
        ProxyAdministrador.setColaboradores(Colaboradores, C);
    }

    //CONSULTA O COLABORADOR NO BANCO DE COLABORADORES
    public Colaborador consultaColaborador(String CPF) {

        String CPFColaborador = CPF;
        Colaborador attColaborador = new Colaborador();
        attColaborador = null;

        for (int i = 0; i < 15; i++) {
            if (CPFColaborador.equals(ProxyAdministrador.Colaboradores[i].getCPF())) {
                attColaborador = ProxyAdministrador.Colaboradores[i];
                break;
            }

        }
        return attColaborador;
    }

    //FUNÇÃO PARA MODIFICAÇÃO DE DADOS DO COLABORADOR
    public void modificarColaborador(String CPF) {

        Scanner inputSwitch = new Scanner(System.in);

        if (consultaColaborador(CPF) != null) {

            System.out.println("""
                               Escolha uma opção: 
                               1 - Alterar Nome 
                               2 - Alterar Sobrenome 
                               3 - Alterar CPF
                               4 - Fechar
                                """);

            int i = inputSwitch.nextInt();
            Scanner inputDado = new Scanner(System.in);

            switch (i) {
                case 1 -> {
                    System.out.printf("Digite o novo nome: ");
                    String dado = inputDado.nextLine();

                    consultaColaborador(CPF).setNomePessoa(dado);
                    System.out.println("Alteração realizada com sucesso!");
                    modificarColaborador(CPF);
                    break;
                }

                case 2 -> {
                    System.out.printf("Digite o novo sobrenome: ");
                    String dado = inputDado.nextLine();

                    consultaColaborador(CPF).setSobrenomePessoa(dado);
                    System.out.println("Alteração realizada com sucesso!");
                    modificarColaborador(CPF);
                    break;
                }

                case 3 -> {
                    System.out.printf("Digite o novo CPF: ");
                    String dado = inputDado.nextLine();

                    consultaColaborador(CPF).setCPF(dado);
                    System.out.println("Alteração realizada com sucesso!");
                    modificarColaborador(dado);
                    break;
                }

                case 4 -> {
                    break;
                }

                default -> {
                    System.out.println("Opção inválida");
                }
            }
        } else {
            System.out.println("CPF inválido!");
        }

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
    protected static final ArrayList<Cliente> Clientes = new ArrayList<>();

    //Getter
    public ArrayList<Cliente> getClientes() {
        return Clientes;
    }

    //Setter
    public static void setClientes(ArrayList<Cliente> Clientes, Cliente Cl) {
        ProxyAdministrador.Clientes.add(Cl);
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

        System.out.printf("CPF: ");
        CPF = input.nextLine();

        System.out.printf("Endereço: ");
        enderecoCliente = input.nextLine();

        System.out.printf("Telefone: ");
        telefoneCliente = input.nextLine();

        Cliente cl = new Cliente(nomeCliente, sobrenomeCliente, CPF, enderecoCliente, telefoneCliente);
        ProxyAdministrador.setClientes(Clientes, cl);
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

        if (consultaCliente(CPF) != null) {

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

                    consultaCliente(CPF).setNomePessoa(dado);
                    System.out.println("Alteração realizada com sucesso!");
                    modificarCliente(CPF);
                    break;
                }

                case 2 -> {
                    System.out.printf("Digite o novo sobrenome: ");
                    String dado = inputDado.nextLine();

                    consultaCliente(CPF).setSobrenomePessoa(dado);
                    System.out.println("Alteração realizada com sucesso!");
                    modificarCliente(CPF);
                    break;
                }

                case 3 -> {
                    System.out.printf("Digite o novo CPF: ");
                    String dado = inputDado.nextLine();

                    consultaCliente(CPF).setCPF(dado);
                    System.out.println("Alteração realizada com sucesso!");
                    modificarCliente(dado);
                    break;
                }
                case 4 -> {
                    System.out.printf("Digite o novo endereço: ");
                    String dado = inputDado.nextLine();

                    consultaCliente(CPF).setEnderecoCliente(dado);
                    System.out.println("Alteração realizada com sucesso!");
                    modificarCliente(CPF);
                    break;
                }
                case 5 -> {
                    System.out.printf("Digite o novo telefone: ");
                    String dado = inputDado.nextLine();

                    consultaCliente(CPF).setTelefoneCliente(dado);
                    System.out.printf("Alteração realizada com sucesso!");
                    modificarCliente(CPF);
                    break;
                }

                case 6 -> {
                    break;
                }

                default -> {
                    System.out.println("Opção inválida");
                }
            }
        } else {
            System.out.println("CPF inválido!");
        }

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
    private static ArrayList<Produto> listaProdutos = new ArrayList<>();

    //Controle da id dos produtos
    private static int numProdutos = 0;

    public static int getNumProdutos() {
        return numProdutos;
    }

    public static void setNumProdutos(int numProdutos) {
        ProxyAdministrador.numProdutos = numProdutos + 1;
    }

    //getter da lista de produtos
    public ArrayList<Produto> getListaProdutos() {
        return listaProdutos;
    }

    //Setter de produtos na lista
    public static void setListaProdutos(ArrayList<Produto> listaProdutos, Produto Pr) {
        ProxyAdministrador.listaProdutos.add(Pr);
    }

    //Cadastro produto 
    public void cadastroProduto() {
        String nomeProduto;
        double valorProduto;
        String descricaoProduto;
        int idProduto;

        Scanner input = new Scanner(System.in);

        //INPUT DE DADOS
        System.out.printf("Digite o nome do produto: ");
        nomeProduto = input.nextLine();

        System.out.printf("Digite a descrição do produto: ");
        descricaoProduto = input.nextLine();

        System.out.printf("Digite o valor do produto: ");
        valorProduto = input.nextDouble();

        idProduto = ProxyAdministrador.getNumProdutos();

        Produto Pr = new Produto(nomeProduto, valorProduto, idProduto, descricaoProduto);
        ProxyAdministrador.setListaProdutos(listaProdutos, Pr);
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
    public Produto consultaProduto(int idProduto) {
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

        if (consultaProduto(idProduto) != null) {

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

                    consultaProduto(idProduto).setNomeProduto(dado);
                    System.out.println("Alteração realizada com sucesso!");
                    modificarProduto(idProduto);
                    break;
                }

                case 2 -> {
                    System.out.printf("Digite a nova descrição: ");
                    String dado = inputDado.nextLine();

                    consultaProduto(idProduto).setDescricaoProduto(dado);
                    System.out.println("Alteração realizada com sucesso!");
                    modificarProduto(idProduto);
                    break;
                }

                case 3 -> {
                    System.out.printf("Digite o novo CPF: ");
                    double dado = inputDado.nextDouble();

                    consultaProduto(idProduto).setValorProduto(dado);
                    System.out.println("Alteração realizada com sucesso!");
                    modificarProduto(idProduto);
                    break;
                }

                case 4 -> {
                    break;
                }

                default -> {
                    System.out.println("Opção inválida");
                }
            }
        } else {
            System.out.println("Identificador de produto inválido!");
        }

    }
    
    public void consultaListaProdutos(){
        System.out.println("\nPRODUTOS CADASTRADOS\n-----------------------------");
        for (int i = 0; i < ProxyAdministrador.listaProdutos.size(); i++) {
            System.out.println("Id: " + ProxyAdministrador.listaProdutos.get(i).getIdProduto()
                    + "\t|\t Nome: " + ProxyAdministrador.listaProdutos.get(i).getNomeProduto());
        }
    }
    
    //Acessar produto 
    public void printProduto(){
        System.out.println("\nPRODUTOS CADASTRADOS\n-----------------------------");
        for (int i = 0; i < ProxyAdministrador.listaProdutos.size(); i++) {
            System.out.println("Id: " + ProxyAdministrador.listaProdutos.get(i).getIdProduto()
                    + "\t|\t Nome: " + ProxyAdministrador.listaProdutos.get(i).getNomeProduto());
        }
        
        System.out.printf("\nDigite o ID do produto que deseja verificar: ");
        Scanner input = new Scanner(System.in);
        int idProduto = input.nextInt();
        
        if (consultaProduto(idProduto) != null){
            System.out.println(consultaProduto(idProduto));
        }
    }
    
    
    
    
    
    //ADMINISTRADORES
    //Acessar Administrador
    
    //Modificar admnistrador 
}
