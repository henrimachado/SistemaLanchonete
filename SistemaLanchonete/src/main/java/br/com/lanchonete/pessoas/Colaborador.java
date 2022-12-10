
package br.com.lanchonete.pessoas;

public class Colaborador extends Usuario {

    public Colaborador(String nomePessoa, String sobrenomePessoa, String CPF, String loginUsuario, String senhaUsuario) {
        super(nomePessoa, sobrenomePessoa, CPF, loginUsuario, senhaUsuario);
    }

    public Colaborador() {
        super();
    }
    
    @Override
    public String toString(){
        String text;
        text = "Nome: " + getNomePessoa() + 
                "\nSobrenome: " + getSobrenomePessoa() + 
                "\nCPF: " + getCPF() + 
                "\nLogin: " + getLoginUsuario()+
                "\nSenha:" + getSenhaUsuario();
        return text;
    }
    
}
