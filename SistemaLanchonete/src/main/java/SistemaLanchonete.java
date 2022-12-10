import br.com.lanchonete.pessoas.*;
import br.com.lanchonete.produtos.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.*;


public class SistemaLanchonete {

    public static void main(String[] args) {
        
              
        ProxyAdministrador menuAdm = new ProxyAdministrador();
       
        ProxyColaborador menuColab = new ProxyColaborador();
        
        menuAdm.cadastroCliente();
        menuAdm.cadastroProduto();
        menuAdm.consultaListaProdutos();
        menuColab.cadastroPedido();
        
        System.out.println(ProxyAdministrador.consultaCliente("123").getPedidosCliente());
        
        menuColab.listarPedidos();
        }
    
       
       
        
}

