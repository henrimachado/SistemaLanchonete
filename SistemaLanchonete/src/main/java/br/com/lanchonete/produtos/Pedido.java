package br.com.lanchonete.produtos;

import java.util.ArrayList;
import java.time.*;

/**
 *
 * @author henri
 */
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
    /**
     *
     * @param dataPedido
     * @param horaPedido
     * @param horaEntregaPedido
     */
    public Pedido(String dataPedido, String horaPedido, String horaEntregaPedido) {
        this.dataPedido = dataPedido;
        this.horaPedido = horaPedido;
        this.horaEntregaPedido = horaEntregaPedido;

    }

    //Construtor Padrão
    public Pedido() {
    }

    /**
     *
     * @return
     */
    public static int getNumPedido() {
        return numPedido;
    }

    /**
     *
     */
    public static void setNumPedido() {
        Pedido.numPedido = numPedido + 1;
    }

    /**
     *
     * @return
     */
    public int getIdPedido() {
        return idPedido;
    }

    /**
     *
     */
    public void setIdPedido() {
        this.idPedido = Pedido.getNumPedido();
    }

    /**
     *
     * @return
     */
    public ArrayList<Integer> getListaProdutos() {
        return listaProdutos;
    }

    /**
     *
     * @param idProduto
     */
    public void setListaProdutos(Integer idProduto) {
        this.listaProdutos.add(idProduto);
    }

    /**
     *
     * @return
     */
    public String getDataPedido() {
        return dataPedido;
    }

    /**
     *
     * @param dataPedido
     */
    public void setDataPedido(String dataPedido) {
        this.dataPedido = dataPedido;
    }

    /**
     *
     * @return
     */
    public String getHoraPedido() {
        return horaPedido;
    }

    /**
     *
     * @param horaPedido
     */
    public void setHoraPedido(String horaPedido) {
        this.horaPedido = horaPedido;
    }

    /**
     *
     * @return
     */
    public String getHoraEntregaPedido() {
        return horaEntregaPedido;
    }

    /**
     *
     * @param horaEntregaPedido
     */
    public void setHoraEntregaPedido(String horaEntregaPedido) {
        this.horaEntregaPedido = horaEntregaPedido;
    }

    /**
     *
     * @return
     */
    public int getStatusPedido() {
        return statusPedido;
    }

    /**
     *
     * @param statusPedido
     */
    public void setStatusPedido(int statusPedido) {
        this.statusPedido = statusPedido;
    }

    /**
     *
     * @return
     */
    public float getValorTotalPedido() {
        return valorTotalPedido;
    }

    /**
     *
     * @param valorTotalPedido
     */
    public void setValorTotalPedido(float valorTotalPedido) {
        this.valorTotalPedido = valorTotalPedido;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        String status = " ";
        
        switch (statusPedido) {
            case 1 -> {
                status = "ACEITO";
                break;
            }
            case 2 -> {
                status = "EM ANDAMENTO";
                break;
            }
            case 3 -> {
                status = "SAIU PARA ENTREGA";
                break;
            }
            case 4 -> {
                status = "ENTREGUE";
                break;
            }
            case 5 ->{
                status = "CANCELADO";
                break;
            }
            default -> {
                
            }
        }

        return "[" + idPedido + "]    FEITO EM: " + dataPedido + " às " + horaPedido +
                "    ITENS (ID): " + listaProdutos + "    R$" + valorTotalPedido 
                + "    STATUS: " + status.toUpperCase() 
                + "    HORA ESPERADA DE ENTREGA: " + horaEntregaPedido;  
    }

}
