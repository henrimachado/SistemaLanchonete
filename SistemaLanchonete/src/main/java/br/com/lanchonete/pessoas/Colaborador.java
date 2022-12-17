package br.com.lanchonete.pessoas;
/**
 * 
 * @author henri
 */
public class Colaborador extends Usuario {

    /**
     * 
     * @param nomePessoa
     * @param sobrenomePessoa
     * @param CPF
     * @param loginUsuario
     * @param senhaUsuario 
     */
    public Colaborador(String nomePessoa, String sobrenomePessoa, String CPF, String loginUsuario, String senhaUsuario) {
        super(nomePessoa, sobrenomePessoa, CPF, loginUsuario, senhaUsuario);
    }

    public Colaborador() {
        super();
    }

    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        return getCPF() + "    " + getNomePessoa().toUpperCase() + " " + getSobrenomePessoa().toUpperCase() + 
                "     " + getLoginUsuario();
    }

}
