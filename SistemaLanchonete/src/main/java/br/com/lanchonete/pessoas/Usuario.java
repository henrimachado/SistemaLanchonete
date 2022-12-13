package br.com.lanchonete.pessoas;

public class Usuario extends Pessoa {

    private String loginUsuario;
    private String senhaUsuario;

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

    public String getLoginUsuario() {
        return loginUsuario;
    }

    public void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

}
