package br.com.lanchonete.produtos;

import java.util.ArrayList;
import java.time.*;

public class Pedido {

    private String dataPedido;
    private String horaPedido;
    private String horaEntregaPedido;
    private int statusPedido;
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

    public int getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(int statusPedido) {
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
        String text;
        String adicionais = "";
        for (int i = 1;  i < getListaProdutos().size(); i++){
            adicionais = adicionais + ", " + Integer.toString(getListaProdutos().get(i));
        }
        text = "[" + getIdPedido() + "]   Data: " + getDataPedido() + "   Hora: " + getHoraPedido() + "   Entrega: " +
                getHoraEntregaPedido() + "   IdProduto: " + getListaProdutos().get(0) + "   IdAdicionais: " + adicionais +
                "    Valor total: " + getValorTotalPedido() + "   Status: " + getStatusPedido();
        return text;
    }

}

