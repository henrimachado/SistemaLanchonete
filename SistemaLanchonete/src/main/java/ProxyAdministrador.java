import br.com.lanchonete.pessoas.*;
import java.util.Scanner;
import java.util.ArrayList;

public class ProxyAdministrador {
    
    
    
    //Construtor
    public ProxyAdministrador() {
    }
    
    //CADASTRO DE COLABORADORES
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
    
    
       
    
    //CADASTRO DE CLIENTES
    private static final ArrayList<Cliente> Clientes = new ArrayList<>();

    
    public ArrayList<Cliente> getClientes() {
        return Clientes;
    }

    public static void setClientes(ArrayList<Cliente> Clientes, Cliente Cl) {
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
   

    //PESQUISA O CLIENTE NOS CLIENTES CADASTRADOS E O RETORNA SE ESTIVER
    public Cliente validaCliente(String CPF){
        
        String CPFCliente = CPF;
        Cliente attCliente = new Cliente();
        attCliente = null; 
        
        for (int i = 0; i <= ProxyAdministrador.Clientes.size(); i++){
            if (CPFCliente.equals(ProxyAdministrador.Clientes.get(i).getCPF())){
                attCliente = ProxyAdministrador.Clientes.get(i);
                break; 
            }
 
        }
        return attCliente; 
    }
    
    public void excluirCliente (String CPF){
       String CPFCliente = CPF;
       for (int i = 0; i <= ProxyAdministrador.Clientes.size(); i++){
           if (CPFCliente.equals(ProxyAdministrador.Clientes.get(i).getCPF())){
               ProxyAdministrador.Clientes.remove(i);              
               break;
        }
    }
 }
    public void modificarCliente(String CPF){
           
        /*System.out.println("Insira o CPF do cliente: ");
        Scanner input = new Scanner(System.in);
        String CPF = input.nextLine();*/
         
        Scanner inputSwitch = new Scanner(System.in);
        
        if (validaCliente(CPF) != null){
           
            System.out.println("""
                               Escolha uma opção: 
                               1 - Alterar Nome 
                               2 - Alterar Sobrenome 
                               3 - Alterar CPF
                               4 - Alterar Endereço
                               5 - Alterar Telefone
                               6 - fechar
                                """);
            
            int i = inputSwitch.nextInt();
            Scanner inputDado = new Scanner (System.in);
            
            
                switch(i){
                    case 1 -> {
                        System.out.println("Digite o novo nome: ");
                        String dado = inputDado.nextLine();

                        validaCliente(CPF).setNomePessoa(dado);
                        System.out.println("Alteração realizada com sucesso!");
                        modificarCliente(CPF);
                        break;
                    }
                
                    case 2 ->{
                        System.out.println("Digite o novo sobrenome: ");
                        String dado = inputDado.nextLine();

                        validaCliente(CPF).setSobrenomePessoa(dado);
                        System.out.println("Alteração realizada com sucesso!");
                        modificarCliente(CPF);
                        break;
                    }
                
                    case 3 ->{
                        System.out.println("Digite o novo CPF: ");
                        String dado = inputDado.nextLine();

                        validaCliente(CPF).setCPF(dado);
                        System.out.println("Alteração realizada com sucesso!");
                        modificarCliente(dado);
                        break;
                    }
                    case 4 -> {
                        System.out.println("Digite o novo endereço: ");
                        String dado = inputDado.nextLine();

                        validaCliente(CPF).setEnderecoCliente(dado);
                        System.out.println("Alteração realizada com sucesso!");
                        modificarCliente(CPF);
                        break;
                    }
                    case 5 -> {
                        System.out.println("Digite o novo telefone: ");
                        String dado = inputDado.nextLine();

                        validaCliente(CPF).setTelefoneCliente(dado);
                        System.out.println("Alteração realizada com sucesso!");
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
        }
        else {System.out.println("CPF inválido!");}
        
    }
}
            
        


