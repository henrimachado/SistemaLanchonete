
import br.com.lanchonete.pessoas.*;
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
    public void printColaborador(String CPF){
        if (consultaColaborador(CPF) != null){
            System.out.println(consultaColaborador(CPF));
        }
        
        else {System.out.println("Colaborador não cadastrado.");}
    }
    
    
    //MANIPULAÇÃO DE CLIENTES
    //Questão 8 - Clientes e pedidos devem ser salvos de forma dinâmica
    private static final ArrayList<Cliente> Clientes = new ArrayList<>();

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
    public Cliente consultaCliente(String CPF) {

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

        /*System.out.println("Insira o CPF do cliente: ");
        Scanner input = new Scanner(System.in);
        String CPF = input.nextLine();*/
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
    public void printClientes(){
        for(int i = 0; i < ProxyAdministrador.Clientes.size(); i++){
            if (ProxyAdministrador.Clientes.get(i) != null){
                System.out.println(ProxyAdministrador.Clientes.get(i));
                System.out.println("\n");
            }
        }
    }
    
    //ACESSO A UM ÚNICO CLIENTE
    public void printCliente(String CPF){
        if (consultaCliente(CPF) != null){
            System.out.println(consultaCliente(CPF));
        }
    }
    
    //PRODUTOS
    //Cadastro produto 
    //Excluir produto 
    //Modificar produto 
    //Acessar produto 
    //Acessar Administrador
    //Modificar admnistrador 
}
