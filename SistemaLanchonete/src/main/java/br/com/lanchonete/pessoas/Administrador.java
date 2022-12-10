package br.com.lanchonete.pessoas;

public final class Administrador extends Usuario {

    private static int admCount;

    //Construtor
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

    public static void setAdmCount(int admCount) {
        Administrador.admCount = admCount + 1;
    }

    @Override
    public String toString() {
        String text;
        text = "{Nome:" + getNomePessoa() + "\tSobrenome: " + getSobrenomePessoa()
                + "\tCPF: " + getCPF() + "\tEmail: " + getLoginUsuario()
                + "\tSenha: " + getSenhaUsuario() + "}";
        return text;
    }
}
