
package br.com.lanchonete.produtos;


public class Produto {
    private String nomeProduto; 
    private double valorProduto;
    private int idProduto; 
    private String descricaoProduto;
   
    //Construtor parametrizado
    public Produto(String nomeProduto, double valorProduto, int idProduto, String descricaoProduto) {
        this.nomeProduto = nomeProduto;
        this.valorProduto = valorProduto;
        this.idProduto = idProduto;
        this.descricaoProduto = descricaoProduto;
    }
    
    //Construtor Padrão
    public Produto(){
    }  
    
    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    @Override
    public String toString() {
        return "Produto{" + "nomeProduto=" + nomeProduto + ", valorProduto=" + valorProduto + ", idProduto=" + idProduto + ", descricaoProduto=" + descricaoProduto + '}';
    }
    
    
    
}