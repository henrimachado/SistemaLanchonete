
import br.com.lanchonete.pessoas.*;
import br.com.lanchonete.produtos.*;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author henri
 */
public class manipularJson {

    public manipularJson() {
    }

    /**
     *
     * @param Co
     * @throws IOException
     */
    public void dumpColaborador(Colaborador[] Co) throws IOException {
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

    /**
     *
     * @return @throws IOException
     */
    public Colaborador[] assimilateColaborador() throws IOException {
        Gson jsonObject = new Gson();
        File colabFile = new File("src\\main\\java\\SistemaLanchoneteArquivos\\Colaboradores.json");

        try {
            String dadosColab = new String(Files.readAllBytes(Paths.get(colabFile.toURI())));
            Colaborador[] colabC = jsonObject.fromJson(dadosColab, new TypeToken<Colaborador[]>() {
            }.getType());
            return colabC;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     *
     * @param Cl
     * @throws IOException
     */
    public void dumpCliente(ArrayList<Cliente> Cl) throws IOException {
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

    /**
     *
     * @return @throws IOException
     */
    public ArrayList<Cliente> assimilateCliente() throws IOException {
        Gson jsonObject = new Gson();
        File clienteFile = new File("src\\main\\java\\SistemaLanchoneteArquivos\\Clientes.json");

        try {
            String dadosCliente = new String(Files.readAllBytes(Paths.get(clienteFile.toURI())));
            ArrayList<Cliente> ClienteC = jsonObject.fromJson(dadosCliente, new TypeToken<ArrayList<Cliente>>() {
            }.getType());
            return ClienteC;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 
     * @param extratosPedidos
     * @throws IOException 
     */
    public void dumpExtratosPedidos(ArrayList<String> extratosPedidos) throws IOException {
        Gson jsonObject = new Gson();
        File pedidoFile = new File("src\\main\\java\\SistemaLanchoneteArquivos\\Pedidos.json");
        FileWriter pedidoWriter = null;
        String dadosPedidos = jsonObject.toJson(extratosPedidos);

        try {
            pedidoWriter = new FileWriter("src\\main\\java\\SistemaLanchoneteArquivos\\Pedidos.json");
            pedidoWriter.write(dadosPedidos);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            pedidoWriter.close();
        }
    }
    
    /**
     * 
     * @return
     * @throws IOException 
     */
    public ArrayList<String> assimilateExtratosPedidos() throws IOException {
        Gson jsonObject = new Gson();
        File clienteFile = new File("src\\main\\java\\SistemaLanchoneteArquivos\\Pedidos.json");

        try {
            String dadosCliente = new String(Files.readAllBytes(Paths.get(clienteFile.toURI())));
            ArrayList<String> extratosPedidos = jsonObject.fromJson(dadosCliente, new TypeToken<ArrayList<String>>() {
            }.getType());
            return extratosPedidos;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
    
    
    /**
     *
     * @param Po
     * @throws IOException
     */
    public void dumpProdutos(ArrayList<Produto> Po) throws IOException {
        Gson jsonObject = new Gson();
        File produtoFile = new File("src\\main\\java\\SistemaLanchoneteArquivos\\Produtos.json");
        FileWriter produtoWriter = null;
        String dadosProdutos = jsonObject.toJson(Po);
        try {
            produtoWriter = new FileWriter("src\\main\\java\\SistemaLanchoneteArquivos\\Produtos.json");
            produtoWriter.write(dadosProdutos);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            produtoWriter.close();
        }

    }

    /**
     *
     * @return @throws IOException
     */
    public ArrayList<Produto> assimilateProduto() throws IOException {
        Gson jsonObject = new Gson();
        File produtoFile = new File("src\\main\\java\\SistemaLanchoneteArquivos\\Produtos.json");

        try {
            String dadosProduto = new String(Files.readAllBytes(Paths.get(produtoFile.toURI())));
            ArrayList<Produto> ProdutoP = jsonObject.fromJson(dadosProduto, new TypeToken<ArrayList<Produto>>() {
            }.getType());
            return ProdutoP;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     *
     * @param Adm
     * @throws IOException
     */
    public void dumpAdministrador(Administrador Adm) throws IOException {
        Gson jsonObject = new Gson();
        File admFile = new File("src\\main\\java\\SistemaLanchoneteArquivos\\Administrador.json");
        FileWriter admWriter = null;
        String dadosAdm = jsonObject.toJson(Adm);
        try {
            admWriter = new FileWriter("src\\main\\java\\SistemaLanchoneteArquivos\\Administrador.json");
            admWriter.write(dadosAdm);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            admWriter.close();
        }
    }

    /**
     *
     * @return @throws IOException
     */
    public Administrador assimilateAdministrador() throws IOException {

        Gson jsonObject = new Gson();
        File admFile = new File("src\\main\\java\\SistemaLanchoneteArquivos\\Administrador.json");
        try {
            String dadosAdm = new String(Files.readAllBytes(Paths.get(admFile.toURI())));
            Administrador admMain = jsonObject.fromJson(dadosAdm, new TypeToken<Administrador>() {
            }.getType());
            return admMain;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     *
     * @throws IOException
     */
    public void assimilateAll() throws IOException {
        ProxyAdministrador.setColaboradores(assimilateColaborador());
        ProxyAdministrador.setClientes(assimilateCliente());
        ProxyAdministrador.setListaProdutos(assimilateProduto());

    }

    /**
     *
     * @param menuColab
     * @throws IOException
     */
    public void dumpAll(ProxyColaborador menuColab) throws IOException {
        dumpColaborador(ProxyAdministrador.getColaboradores());
        dumpCliente(ProxyAdministrador.getClientes());
        dumpProdutos(ProxyAdministrador.getListaProdutos());
        dumpExtratosPedidos(menuColab.extratosPedidos());
    }

    @Override
    public String toString() {
        return "Manipulação de Arquivos JSON";
    }
    
    
}
