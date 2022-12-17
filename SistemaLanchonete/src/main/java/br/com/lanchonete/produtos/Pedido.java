package br.com.lanchonete.produtos;

import java.util.ArrayList;

/**
 * Classe representativa dos pedidos cadastrados no sistema
 * @author Mateus Henrique Machado 
 * @author Iago Mateus Ávila Fernandes 
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


    /**
     * Construtor parametrizado
     * @param dataPedido Define uma data para o pedido 
     * @param horaPedido Define uma hora para o pedido
     * @param horaEntregaPedido Define uma hora estimada para a entrega do pedido
     */
    public Pedido(String dataPedido, String horaPedido, String horaEntregaPedido) {
        this.dataPedido = dataPedido;
        this.horaPedido = horaPedido;
        this.horaEntregaPedido = horaEntregaPedido;

    }

    /**
     * Construtor padrão
     */
    public Pedido() {
    }

    /**
     *
     * @return Quantidade de pedidos cadastrados no sistema
     */
    public static int getNumPedido() {
        return numPedido;
    }

    /**
     * Incrementa a quantidade de pedidos cadastrados no sistema
     */
    public static void setNumPedido() {
        Pedido.numPedido = numPedido + 1;
    }

    /**
     *
     * @return Número de identificação associado ao pedido
     */
    public int getIdPedido() {
        return idPedido;
    }

    /**
     * Define o identificador para o pedido
     */
    public void setIdPedido() {
        this.idPedido = Pedido.getNumPedido();
    }

    /**
     *
     * @return Lista de itens associado ao pedido
     */
    public ArrayList<Integer> getListaProdutos() {
        return listaProdutos;
    }

    /**
     *
     * @param idProduto Adiciona um item ao pedido através do seu ID
     */
    public void setListaProdutos(Integer idProduto) {
        this.listaProdutos.add(idProduto);
    }

    /**
     *
     * @return Data de cadastro do pedido no sistema
     */
    public String getDataPedido() {
        return dataPedido;
    }

    /**
     *
     * @param dataPedido Define uma data para o pedido no momento do cadastro
     */
    public void setDataPedido(String dataPedido) {
        this.dataPedido = dataPedido;
    }

    /**
     *
     * @return Hora do cadastro do pedido no sistema
     */
    public String getHoraPedido() {
        return horaPedido;
    }

    /**
     *
     * @param horaPedido Define uma hora para o pedido no momento do cadastro
     */
    public void setHoraPedido(String horaPedido) {
        this.horaPedido = horaPedido;
    }

    /**
     *
     * @return Hora estimada de entrega para o pedido
     */
    public String getHoraEntregaPedido() {
        return horaEntregaPedido;
    }

    /**
     *
     * @param horaEntregaPedido Define a hora esperada de entrega para o pedido 
     */
    public void setHoraEntregaPedido(String horaEntregaPedido) {
        this.horaEntregaPedido = horaEntregaPedido;
    }

    /**
     *
     * @return Identificador associado ao status do pedido 
     */
    public int getStatusPedido() {
        return statusPedido;
    }

    /**
     *
     * @param statusPedido Define um identificador de status para o pedido
     */
    public void setStatusPedido(int statusPedido) {
        this.statusPedido = statusPedido;
    }

    /**
     *
     * @return Valor total associado ao pedido
     */
    public float getValorTotalPedido() {
        return valorTotalPedido;
    }

    /**
     *
     * @param valorTotalPedido Define um valor total para o pedido
     */
    public void setValorTotalPedido(float valorTotalPedido) {
        this.valorTotalPedido = valorTotalPedido;
    }

    /**
     *
     * @return Representação String de um objeto pedido
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
            case 5 -> {
                status = "CANCELADO";
                break;
            }
            default -> {

            }
        }

        return "[" + idPedido + "]    FEITO EM: " + dataPedido + " às " + horaPedido
                + "    ITENS (ID): " + listaProdutos + "    R$" + valorTotalPedido
                + "    STATUS: " + status.toUpperCase()
                + "    HORA ESPERADA DE ENTREGA: " + horaEntregaPedido;
    }

}
