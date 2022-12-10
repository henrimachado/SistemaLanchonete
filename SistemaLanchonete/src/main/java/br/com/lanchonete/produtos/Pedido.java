package br.com.lanchonete.produtos;

import java.util.ArrayList;
import java.time.*;

public class Pedido {

    private LocalDate dataPedido;
    private LocalTime horaPedido;
    private LocalTime horaEntregaPedido;
    private String statusPedido;
    private static int numPedido = 0; 
    private int idPedido;
    
    private ArrayList<Integer> listaProdutos = new ArrayList<>();

    //Construtor Parametrizado 

    public Pedido(LocalDate dataPedido, LocalTime horaPedido, LocalTime horaEntregaPedido) {
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

    public static void setNumPedido(int idPedido) {
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

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public LocalTime getHoraPedido() {
        return horaPedido;
    }

    public void setHoraPedido(LocalTime horaPedido) {
        this.horaPedido = horaPedido;
    }

    public LocalTime getHoraEntregaPedido() {
        return horaEntregaPedido;
    }

    public void setHoraEntregaPedido(LocalTime horaEntregaPedido) {
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
