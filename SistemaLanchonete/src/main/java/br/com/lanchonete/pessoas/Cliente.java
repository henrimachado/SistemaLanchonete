package br.com.lanchonete.pessoas;

import java.util.ArrayList;
import br.com.lanchonete.produtos.*;

public class Cliente extends Pessoa {

    private String enderecoCliente;
    private String telefoneCliente;
    private ArrayList<Pedido> pedidosCliente = new ArrayList<>();
    //private Pedido vetor de pedido 

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

    public ArrayList<Pedido> getPedidosCliente() {
        return pedidosCliente;
    }

    public void setPedidosCliente(Pedido novoPedido) {
        this.pedidosCliente.add(0, novoPedido);
    }

    public String getEnderecoCliente() {
        return enderecoCliente;
    }

    public void setEnderecoCliente(String enderecoCliente) {
        this.enderecoCliente = enderecoCliente;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    @Override
    public String toString() {
        String text = "Nome: " + getNomePessoa() + "\nSobrenome: " + getSobrenomePessoa() + "\nCPF: "
                + getCPF() + "\nEndereço: " + getEnderecoCliente() + "\nTelefone: " + getTelefoneCliente();
        return text;

    }
}
