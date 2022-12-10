import br.com.lanchonete.pessoas.*;
import br.com.lanchonete.produtos.Pedido;
import java.util.Scanner;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ProxyColaborador {
    
    
    /*Colaborador
    *Alterar senha
    *Cadastrar Pedido
    *Alterar pedido
    *Consultar pedidos
    *Excluir pedidos 
    *Pesquisar intervalo de pedidos
    */
    
    
    //PEDIDOS
    public void cadastroPedido (){
        System.out.printf("Digite o CPF do cliente: ");
        
        Scanner input = new Scanner(System.in);
        String CPFCliente = input.nextLine();
        
        Cliente Cl = ProxyAdministrador.consultaCliente(CPFCliente);
        
        if (Cl != null){
            
            Pedido novoPedido = new Pedido();
            novoPedido.setIdPedido();
            
            System.out.print("Insira a ID do produto principal do pedido: ");
            Integer idProduto = input.nextInt();
            novoPedido.setListaProdutos(idProduto);
            
            
            System.out.println("""
                               Escolha uma opção: 
                               1 - Inserir adicionais 
                               2 - Finalizar pedido
                               """);
            
            int i = input.nextInt();
            switch(i){
                case 1 ->{
                    int j = 0;
                    
                    while (j == 0){
                        System.out.printf("Insira o Id do adicional: ");
                        Integer idAdicional = input.nextInt();
                        novoPedido.setListaProdutos(idAdicional);
                        
                        System.out.println("""
                                            Escolha uma opção: 
                                            1 - Inserir novos adicionais 
                                            2 - Finalizar pedido
                                            """);
                        j = input.nextInt();
                    }
                    
                }
                
                case 2 ->{
                    break;
                }
            }
            
            Date dataHoraAtual = new Date();
            novoPedido.setHoraPedido(new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual));
            novoPedido.setDataPedido(new SimpleDateFormat("dd/MM/YY").format(dataHoraAtual));
            
            
        }
        
        
       
    }
    
}
