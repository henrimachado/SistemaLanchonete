package br.com.lanchonete.produtos;

import java.util.ArrayList;
import java.time.*;

public class Pedido {

    private String dataPedido;
    private String horaPedido;
    private String horaEntregaPedido;
    private String statusPedido;
    private float valorTotalPedido;
    private static int numPedido = 0; 
    private int idPedido;
    
    private ArrayList<Integer> listaProdutos = new ArrayList<>();

    //Construtor Parametrizado 

    public Pedido(String dataPedido, String horaPedido, String horaEntregaPedido) {
        this.dataPedido = dataPedido;
        this.horaPedido = horaPedido;
        this.horaEntregaPedido = horaEntregaPedido;

    }


    //Construtor Padrão
    public Pedido() {
    }

    public static int getNumPedido() {
        return numPedido;
    }

    public static void setNumPedido() {
        Pedido.numPedido = numPedido + 1;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido() {
        this.idPedido = Pedido.getNumPedido();
    }

    
    public ArrayList<Integer> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(Integer idProduto) {
        this.listaProdutos.add(idProduto);
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

    public float getValorTotalPedido() {
        return valorTotalPedido;
    }

    public void setValorTotalPedido(float valorTotalPedido) {
        this.valorTotalPedido = valorTotalPedido;
    }

   
    @Override
    public String toString() {
        return "Pedido{" + "dataPedido=" + dataPedido + ", horaPedido=" + horaPedido + ", horaEntregaPedido=" + horaEntregaPedido + ", statusPedido=" + statusPedido + '}';
    }

}

