
import com.google.gson.*;
import br.com.lanchonete.pessoas.*;
import br.com.lanchonete.produtos.*;
import com.google.gson.reflect.TypeToken;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class jsonDump {

    public static void dumpColaborador(Colaborador Co) throws IOException {
        Gson jsonObject = new Gson();
        File colaboradorFile = new File("src\\main\\java\\SistemaLanchoneteArquivos\\Colaboradores.json");

        FileWriter colaboradorWriter = null;
        String dadosColaboradores = jsonObject.toJson(Co);

        try {
            colaboradorWriter = new FileWriter("src\\main\\java\\SistemaLanchoneteArquivos\\Colaboradores.json");
            colaboradorWriter.write(dadosColaboradores);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            colaboradorWriter.close();
        }
    }

    public static void dumpCliente(Cliente Cl) throws IOException {
        Gson jsonObject = new Gson();
        File clienteFile = new File("src\\main\\java\\SistemaLanchoneteArquivos\\Clientes.json");
        FileWriter clienteWriter = null;
        String dadosCliente = jsonObject.toJson(Cl);

        try {
            clienteWriter = new FileWriter("src\\main\\java\\SistemaLanchoneteArquivos\\Clientes.json");
            clienteWriter.write(dadosCliente);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            clienteWriter.close();
        }

    }
    
    public static void dumpPedidos(Pedido Pe) throws IOException {
        Gson jsonObject = new Gson();
        File pedidoFile = new File("src\\main\\java\\SistemaLanchoneteArquivos\\Pedidos.json");
        FileWriter pedidoWriter = null;
        String dadosPedidos = jsonObject.toJson(Pe);

        try {
            pedidoWriter = new FileWriter("src\\main\\java\\SistemaLanchoneteArquivos\\Pedidos.json");
            pedidoWriter.write(dadosPedidos);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            pedidoWriter.close();
        }
    }
    
    public static void dumpProdutos(Produto Po) throws IOException {
        Gson jsonObject = new Gson();
        File produtoFile = new File("src\\main\\java\\SistemaLanchoneteArquivos\\Produtos.json");
        FileWriter produtoWriter = null;
        String dadosProdutos = jsonObject.toJson(Po);
        try {
            produtoWriter = new FileWriter("src\\main\\java\\SistemaLanchoneteArquivos\\Produtos.json");
            produtoWriter.write(dadosProdutos);
        }
        
        catch(IOException e){
            e.printStackTrace();
        }
        
        finally{
            produtoWriter.close();
        }

    }
    
    public static void dumpAdministrador(Administrador Adm) throws IOException{
        Gson jsonObject = new Gson();
        File admFile = new File("src\\main\\java\\SistemaLanchoneteArquivos\\Administrador.json");
        FileWriter admWriter = null;
        String dadosAdm = jsonObject.toJson(Adm);
        try {
            admWriter = new FileWriter("src\\main\\java\\SistemaLanchoneteArquivos\\Administrador.json");
           admWriter.write(dadosAdm);
        }
        
        catch(IOException e){
            e.printStackTrace();
        }
        
        finally{
            admWriter.close();
        }
    }

    public static Administrador assimilateAdministrador() throws IOException {
        
        Gson jsonObject = new Gson(); 
        File admFile = new File ("src\\main\\java\\SistemaLanchoneteArquivos\\Administrador.json");
        try{
            String dadosAdm = new String(Files.readAllBytes(Paths.get(admFile.toURI())));
            Administrador admMain = jsonObject.fromJson(dadosAdm, new TypeToken<Administrador>() {}.getType());
            return admMain;
        }
        
        catch(IOException e){
            e.printStackTrace();
        }
       
        return null;
    }
}
