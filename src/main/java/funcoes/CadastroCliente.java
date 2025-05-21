package funcoes;

import view.TelaMenuPrincipal;

public class CadastroCliente {

    public static void main(String[] args) {
        Conexao.conectar();
//
//        funcoes.Cadastro cliente = new funcoes.Cadastro();
//        cliente.setNome("jose");
//        cliente.setCPF("123.654.789-00");
//        cliente.setTelefone("119101001010");
//        cliente.setEmail("jo@email.com");
//
//        funcoes.ClienteDAO dao = new funcoes.ClienteDAO();
//        dao.inserir(cliente);
//        System.out.println("Teste realizado");


        /*
        Teste buscar cliente pelo nome
        funcoes.ClienteDAO dao = new funcoes.ClienteDAO();
        funcoes.Cadastro cliente = dao.buscar("Alexandre");
        if (cliente != null) {
            System.out.println("Cliente encontrado:");
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("CPF: " + cliente.getCpf());
            System.out.println("Telefone: " + cliente.getTelefone());
            System.out.println("Email: " + cliente.getEmail());
        } else {
            System.out.println("Cliente não encontrado.");
        }
         */

 /*
        Teste cadastro alterar/parcial
        funcoes.Cadastro cliente = new funcoes.Cadastro();
        cliente.setId(3);
        cliente.setNome("Alexxx");
        cliente.setCPF("123.987.456-00");

        funcoes.ClienteDAO dao = new funcoes.ClienteDAO();
        dao.alterarParcial(cliente);
         */

 /*
        Teste para excluir o cadastro
         funcoes.ClienteDAO dao = new funcoes.ClienteDAO();
        dao.deletar(4);       
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaMenuPrincipal().setVisible(true);
            }
        });

    }
}
