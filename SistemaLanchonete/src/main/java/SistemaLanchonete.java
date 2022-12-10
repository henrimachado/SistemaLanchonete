
public class SistemaLanchonete {

    public static void main(String[] args) {
        
        /*
        Chamando o cadastro
        ProxyAdministrador.cadastroColaborador();
        */
        
        ProxyAdministrador menuAdm = new ProxyAdministrador();
        menuAdm.cadastroColaborador();
        System.out.println(menuAdm.getColaboradores()[0]);
        menuAdm.cadastroCliente();
        System.out.println(menuAdm.getClientes());
        }
    
      
}

