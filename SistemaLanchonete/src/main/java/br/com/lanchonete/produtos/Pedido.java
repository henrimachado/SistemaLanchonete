
package br.com.lanchonete.produtos;

import java.util.ArrayList;

public class Pedido {
    private String dataPedido; 
    private String horaPedido;
    private String horaEntregaPedido; 
    private String statusPedido;
    private ArrayList<Produto> listaProdutos = new ArrayList<>();
    

    
    //Construtor Parametrizado 
    public Pedido(String dataPedido, String horaPedido, String horaEntregaPedido, String statusPedido) {    
        this.dataPedido = dataPedido;
        this.horaPedido = horaPedido;
        this.horaEntregaPedido = horaEntregaPedido;
        this.statusPedido = statusPedido;
    }

    //Construtor Padrão
    public Pedido() {
    }

    public ArrayList<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(ArrayList<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public String getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(String dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getHoraPedido() {
        return horaPedido;
    }

    public void setHoraPedido(String horaPedido) {
        this.horaPedido = horaPedido;
    }

    public String getHoraEntregaPedido() {
        return horaEntregaPedido;
    }

    public void setHoraEntregaPedido(String horaEntregaPedido) {
        this.horaEntregaPedido = horaEntregaPedido;
    }

    public String getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(String statusPedido) {
        this.statusPedido = statusPedido;
    }

    @Override
    public String toString() {
        return "Pedido{" + "dataPedido=" + dataPedido + ", horaPedido=" + horaPedido + ", horaEntregaPedido=" + horaEntregaPedido + ", statusPedido=" + statusPedido + '}';
    }
    
    
    
   
}