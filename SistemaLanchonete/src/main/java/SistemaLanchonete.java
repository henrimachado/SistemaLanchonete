import br.com.lanchonete.pessoas.*;
import br.com.lanchonete.produtos.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.*;
import com.google.gson.Gson;
import java.io.IOException;

public class SistemaLanchonete {

    public static void main(String[] args) throws IOException {
        
              
        ProxyAdministrador menuAdm = new ProxyAdministrador();
        ProxyColaborador menuColab = new ProxyColaborador();
        /*
        menuAdm.cadastroColaborador();
        jsonDump.dumpColaborador(menuAdm.getColaboradores()[0]);
        */
        
        menuAdm.cadastroCliente();
        menuColab.cadastroPedido();
        menuColab.cadastroPedido();
        menuColab.listarPedidos();
        }
    
       
       
        
}

