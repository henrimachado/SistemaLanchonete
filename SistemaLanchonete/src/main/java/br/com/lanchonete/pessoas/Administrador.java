package br.com.lanchonete.pessoas;

/**
 * 
 * @author henri
 */
public final class Administrador extends Usuario {
    
    private static int admCount;

    //Construtor
    /**
     * 
     * @param nomePessoa define um nome para o Administrador do programa
     * @param sobrenomePessoa define o sobrenome para o Administrador do programa
     * @param CPF define o CPF, usado como identificador único, para o Administrador do programa
     * @param loginUsuario define o login utilizado pelo Administrador do programa
     * @param senhaUsuario define a senha utilizada pelo Administrador do programa
     */
    public Administrador(String nomePessoa, String sobrenomePessoa, String CPF, String loginUsuario, String senhaUsuario) {
        super(nomePessoa, sobrenomePessoa, CPF, loginUsuario, senhaUsuario);
        setAdmCount(admCount);
    }

    
    public Administrador() {
        super();
    }

    public static int getAdmCount() {
        return admCount;
    }

    /**
     * 
     * @param admCount Define a contagem de administradores no sistema
     */
    public static void setAdmCount(int admCount) {
        Administrador.admCount = admCount + 1;
    }

    /**
     * 
     * @return retorna a representação em String do Administrador conforme estabelecido 
     */
    @Override
    public String toString() {
        return getCPF() +  "    " + getNomePessoa().toUpperCase() + " " + getSobrenomePessoa().toUpperCase() +
                "    " +  getLoginUsuario();
    }
}
