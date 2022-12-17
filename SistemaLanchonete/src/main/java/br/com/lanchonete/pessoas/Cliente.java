package br.com.lanchonete.pessoas;

import java.util.ArrayList;
import br.com.lanchonete.produtos.*;
/**
 * 
 * @author henri
 */
public class Cliente extends Pessoa {
    
    private String enderecoCliente;
    private String telefoneCliente;
    private ArrayList<Pedido> pedidosCliente = new ArrayList<>();
    //private Pedido vetor de pedido 

    /**
     *
     * @param nomePessoa
     * @param sobrenomePessoa
     * @param CPF
     * @param enderecoCliente
     * @param telefoneCliente
     */
    //Construtor parametrizado
    public Cliente(String nomePessoa, String sobrenomePessoa, String CPF, String enderecoCliente, String telefoneCliente) {
        super(nomePessoa, sobrenomePessoa, CPF);
        this.enderecoCliente = enderecoCliente;
        this.telefoneCliente = telefoneCliente;
    }

    //Construtor padrão
    public Cliente() {
        super();
    }

    /**
     *
     * @return
     */
    public ArrayList<Pedido> getPedidosCliente() {
        return pedidosCliente;
    }

    /**
     *
     * @param novoPedido
     */
    public void setPedidosCliente(Pedido novoPedido) {
        this.pedidosCliente.add(0, novoPedido);
    }

    /**
     *
     * @return
     */
    public String getEnderecoCliente() {
        return enderecoCliente;
    }

    /**
     *
     * @param enderecoCliente
     */
    public void setEnderecoCliente(String enderecoCliente) {
        this.enderecoCliente = enderecoCliente;
    }

    /**
     *
     * @return
     */
    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    /**
     *
     * @param telefoneCliente
     */
    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        return getCPF() + "    " + getNomePessoa().toUpperCase() + " " + getSobrenomePessoa().toUpperCase() + "    " + 
                getTelefoneCliente() + "    " +  getEnderecoCliente().toUpperCase();
    }
}
