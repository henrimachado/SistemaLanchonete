package br.com.lanchonete.pessoas;

/**
 *
 * @author henri
 */
public class Usuario extends Pessoa {

    private String loginUsuario;
    private String senhaUsuario;

    /**
     *
     * @param nomePessoa
     * @param sobrenomePessoa
     * @param CPF
     * @param loginUsuario
     * @param senhaUsuario
     */
    //Construtor Padrão
    public Usuario(String nomePessoa, String sobrenomePessoa, String CPF, String loginUsuario, String senhaUsuario) {
        super(nomePessoa, sobrenomePessoa, CPF);

        this.loginUsuario = loginUsuario;
        this.senhaUsuario = senhaUsuario;
    }

    //Construtor padrão
    public Usuario() {
        super();
    }

    /**
     *
     * @return
     */
    public String getLoginUsuario() {
        return loginUsuario;
    }

    /**
     *
     * @param loginUsuario
     */
    public void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }

    /**
     *
     * @return
     */
    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    /**
     *
     * @param senhaUsuario
     */
    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        return  getCPF() +  "    " + getNomePessoa().toUpperCase() + " " + getSobrenomePessoa().toUpperCase() + 
                "    " + loginUsuario;
                
    }

    
}
