import br.com.lanchonete.pessoas.*;
import java.util.Scanner;
import java.util.LinkedList;

public class ProxyAdministrador {
    
    
    //Construtor
    public ProxyAdministrador() {
    }
    
    //Vetor estático de colaboradores
    private static final Colaborador Colaboradores[] = new Colaborador[15];

    public Colaborador[] getColaboradores() {
        return Colaboradores;
    }

    public static void setColaboradores(Colaborador[] Colaboradores, Colaborador C) {
        
        int i = 0;
        while (ProxyAdministrador.Colaboradores[i] != null & i < 15 ){
           i = i+1;
        }
        ProxyAdministrador.Colaboradores[i] = C;
    }
    
    //Questão 01 - O sistema deve armazenar de forma estática 15 colaboradores
    public void cadastroColaborador (){
       
       String nomeColaborador;
       String sobrenomeColaborador;
       String CPF;
       String loginColaborador;
       String senhaColaborador;
       
       
       Scanner input = new Scanner(System.in);
       
       //Input de dados 
        System.out.println("Nome: ");
        nomeColaborador = input.nextLine();
        
        System.out.println("Sobrenome: ");
        sobrenomeColaborador = input.nextLine();
        
        System.out.println("CPF: ");
        CPF = input.nextLine();
        
        System.out.println("E-mail: ");
        loginColaborador = input.nextLine();
        
        System.out.println("Senha: ");
        senhaColaborador = input.nextLine();
       
        
       //Cadastro
       Colaborador C = new Colaborador(nomeColaborador, sobrenomeColaborador, CPF, loginColaborador, senhaColaborador);
       ProxyAdministrador.setColaboradores(Colaboradores, C);
    }
    
    
    //Cadastro de clientes
    private static final LinkedList<Cliente> Clientes = new LinkedList<>();

    public LinkedList<Cliente> getClientes() {
        return Clientes;
    }

    public static void setClientes(LinkedList<Cliente> Clientes, Cliente Cl) {
        ProxyAdministrador.Clientes.add(Cl);
    }
    
    public void cadastroCliente(){
       String nomeCliente;
       String sobrenomeCliente;
       String CPF;
       String enderecoCliente;
       String telefoneCliente;
       
       
       Scanner input = new Scanner(System.in);
       
       //Input de dados 
        System.out.println("Nome: ");
        nomeCliente = input.nextLine();
        
        System.out.println("Sobrenome: ");
        sobrenomeCliente = input.nextLine();
        
        System.out.println("CPF: ");
        CPF = input.nextLine();
        
        System.out.println("Endereço: ");
        enderecoCliente = input.nextLine();
        
        System.out.println("Telefone: ");
        telefoneCliente = input.nextLine();
        
        Cliente cl = new Cliente(nomeCliente, sobrenomeCliente, CPF, enderecoCliente, telefoneCliente);
        ProxyAdministrador.setClientes(Clientes, cl);
    }
    
}

