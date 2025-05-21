package funcoes;//inserir, buscar, alterar e deletar

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
        private Connection conexao;

    public ClienteDAO() {
        this.conexao = Conexao.getConexao();  // pega a conexão pronta da classe Conexao
        if (this.conexao == null) {
            System.out.println("Erro: conexão está nula no ClienteDAO!");
        }
    }
    public void inserir (Cadastro cadastro){
        try{
            String intrucaoSQL= "INSERT INTO db_cliente.cliente(nome, cpf, telefone, email)VALUES(?, ?, ?, ?);";
            PreparedStatement pst = conexao.prepareStatement(intrucaoSQL);
            pst.setString(1, cadastro.getNome());
            pst.setString(2,cadastro.getCpf());
            pst.setString(3, cadastro.getTelefone());
            pst.setString(4,cadastro.getEmail());
            pst.execute();
            System.out.println("funcoes.Cadastro realizada com sucesso!");
        }catch (Exception error){
            error.printStackTrace();
        }
    }
    public Cadastro buscar (String nome){
        Cadastro cadastro = null;
        try{
            String intrucaoSQL= "SELECT id, nome, cpf, telefone, email FROM db_cliente.cliente WHERE nome= ?;";
            PreparedStatement statement= conexao.prepareStatement(intrucaoSQL);
            statement.setString (1, nome);
            ResultSet result = statement.executeQuery();
            if (result.next()){
                Integer id = result.getInt("id");
                String nomeCliente = result.getString("nome");
                String cpf = result.getString("cpf");
                String telefone = result.getString("telefone");
                String email = result.getString("email");

                cadastro= new Cadastro();
                cadastro.setId(id);
                cadastro.setNome(nomeCliente);
                cadastro.setCPF(cpf);
                cadastro.setTelefone(telefone);
                cadastro.setEmail(email);
            }
        }catch (Exception error){
            error.printStackTrace();
        }
        return cadastro;
    }
    public void alterar (Cadastro cadastro){
        try{
            Conexao.conectar();
            String intrucaoSQL= "UPDATE db_cliente.cliente SET nome= ? , cpf= ? , telefone= ? , email= ? WHERE id=?;";
            PreparedStatement pst = conexao.prepareStatement(intrucaoSQL);
            pst.setString(1,cadastro.getNome());
            pst.setString(2, cadastro.getCpf());
            pst.setString(3, cadastro.getTelefone());
            pst.setString(4, cadastro.getEmail());
            pst.setInt(5, cadastro.getId());
            pst.execute();
            System.out.println("Alteração realizada com sucesso!");
        }catch (Exception error){
            error.printStackTrace();
        }
    }
    public void alterarParcial(Cadastro cadastro) {
        try {
            StringBuilder sql = new StringBuilder("UPDATE db_cliente.cliente SET ");
            List<Object> parametros = new ArrayList<>();

            if (cadastro.getNome() != null && !cadastro.getNome().isEmpty()) {
                sql.append("nome = ?, ");
                parametros.add(cadastro.getNome());
            }

            if (cadastro.getCpf() != null && !cadastro.getCpf().isEmpty()) {
                sql.append("cpf = ?, ");
                parametros.add(cadastro.getCpf());
            }

            if (cadastro.getTelefone() != null && !cadastro.getTelefone().isEmpty()) {
                sql.append("telefone = ?, ");
                parametros.add(cadastro.getTelefone());
            }

            if (cadastro.getEmail() != null && !cadastro.getEmail().isEmpty()) {
                sql.append("email = ?, ");
                parametros.add(cadastro.getEmail());
            }

            if (parametros.isEmpty()) {
                System.out.println("Nenhum campo preenchido para atualizar.");
                return;
            }

            sql.setLength(sql.length() - 2);
            sql.append(" WHERE id = ?");
            parametros.add(cadastro.getId());
            PreparedStatement pst = conexao.prepareStatement(sql.toString());

            for (int i = 0; i < parametros.size(); i++) {
                pst.setObject(i + 1, parametros.get(i));
            }

            pst.execute();
            System.out.println("Alteração realizada com sucesso!");

        } catch (Exception error) {
            error.printStackTrace();
        }
    }
    public void deletar (Integer id){
        try{
            String intrucaoSQL= "DELETE FROM db_cliente.cliente WHERE id=?;";
            PreparedStatement pst = conexao.prepareStatement(intrucaoSQL);
            pst.setInt(1, id);
            pst.execute();
            System.out.println("Exluido com sucesso!");
        }catch (Exception error){
            error.printStackTrace();
        }
    }
}
