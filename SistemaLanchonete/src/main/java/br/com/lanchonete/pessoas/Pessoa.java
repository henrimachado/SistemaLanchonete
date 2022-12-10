
package br.com.lanchonete.pessoas;


public abstract class Pessoa {
    private String nomePessoa; 
    private String sobrenomePessoa;
    private String CPF; 


    //Construtor com parâmetros
    public Pessoa(String nomePessoa, String sobrenomePessoa, String CPF){
        this.nomePessoa = nomePessoa;
        this.sobrenomePessoa = sobrenomePessoa;
        this.CPF = CPF; 
    }
    
    //Construtor padrão 
    public Pessoa(){
        
    }
    
    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getSobrenomePessoa() {
        return sobrenomePessoa;
    }

    public void setSobrenomePessoa(String sobrenomePessoa) {
        this.sobrenomePessoa = sobrenomePessoa;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
    
   
    //Verificar se deve ser sobrescrito de fato
    @Override
    public String toString(){
        return "Pessoa";
    }
}
