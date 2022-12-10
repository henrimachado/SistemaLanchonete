import br.com.lanchonete.pessoas.*;
import java.util.Scanner;
import java.util.ArrayList;

public class SistemaLanchonete {

    public static void main(String[] args) {
        
        /*
        Chamando o cadastro
        ProxyAdministrador.cadastroColaborador();
        */
        
        ProxyAdministrador menuAdm = new ProxyAdministrador();
        menuAdm.cadastroCliente();
        menuAdm.cadastroCliente();
        
        //System.out.println("\n" + menuAdm.getClientes().get(0) + "\n"); 
        
        System.out.println("\n"+ menuAdm.getClientes()+"\n");
        
        System.out.println("\nInsira o CPF do cliente: ");
        Scanner input = new Scanner(System.in);
        String CPF = input.nextLine();
        
        menuAdm.excluirCliente(CPF);
        
        System.out.println("\n" + menuAdm.getClientes());

        /*menuAdm.modificarCliente(CPF);
        System.out.println(menuAdm.getClientes().get(0));
        */

  
        }
    
      
       
        
}

