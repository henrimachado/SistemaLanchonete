package br.com.lanchonete.produtos;

/**
 *
 * @author henri
 */
public class Produto {

    private String nomeProduto;
    private float valorProduto;
    private int idProduto;
    private String descricaoProduto;

    /**
     *
     * @param nomeProduto
     * @param valorProduto
     * @param idProduto
     * @param descricaoProduto
     */
    //Construtor parametrizado
    public Produto(String nomeProduto, float valorProduto, int idProduto, String descricaoProduto) {
        this.nomeProduto = nomeProduto;
        this.valorProduto = valorProduto;
        this.idProduto = idProduto;
        this.descricaoProduto = descricaoProduto;
    }

    //Construtor Padrão
    public Produto() {
    }

    /**
     *
     * @return
     */
    public String getNomeProduto() {
        return nomeProduto;
    }

    /**
     *
     * @param nomeProduto
     */
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    /**
     *
     * @return
     */
    public float getValorProduto() {
        return valorProduto;
    }

    /**
     *
     * @param valorProduto
     */
    public void setValorProduto(float valorProduto) {
        this.valorProduto = valorProduto;
    }

    /**
     *
     * @return
     */
    public int getIdProduto() {
        return idProduto;
    }

    /**
     *
     * @param idProduto
     */
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    /**
     *
     * @return
     */
    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    /**
     *
     * @param descricaoProduto
     */
    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
         return  "[" + idProduto + "]   " + nomeProduto.toUpperCase() + "    R$" + valorProduto + "      " + descricaoProduto; 
    }

}
