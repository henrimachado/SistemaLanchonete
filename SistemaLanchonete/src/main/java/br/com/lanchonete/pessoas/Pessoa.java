package br.com.lanchonete.pessoas;

/**
 *
 * @author henri
 */
public abstract class Pessoa {

    private String nomePessoa;
    private String sobrenomePessoa;
    private String CPF;

    /**
     *
     * @param nomePessoa
     * @param sobrenomePessoa
     * @param CPF
     */
    //Construtor com parâmetros
    public Pessoa(String nomePessoa, String sobrenomePessoa, String CPF) {
        this.nomePessoa = nomePessoa;
        this.sobrenomePessoa = sobrenomePessoa;
        this.CPF = CPF;
    }

    //Construtor padrão 
    public Pessoa() {

    }

    /**
     *
     * @return
     */
    public String getNomePessoa() {
        return nomePessoa;
    }

    /**
     *
     * @param nomePessoa
     */
    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    /**
     *
     * @return
     */
    public String getSobrenomePessoa() {
        return sobrenomePessoa;
    }

    /**
     *
     * @param sobrenomePessoa
     */
    public void setSobrenomePessoa(String sobrenomePessoa) {
        this.sobrenomePessoa = sobrenomePessoa;
    }

    /**
     *
     * @return
     */
    public String getCPF() {
        return CPF;
    }

    /**
     *
     * @param CPF
     */
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    /**
     *
     * @return
     */

    @Override
    public String toString() {
        return CPF + "    " + nomePessoa.toUpperCase() + " " + sobrenomePessoa.toUpperCase();
    }
}
