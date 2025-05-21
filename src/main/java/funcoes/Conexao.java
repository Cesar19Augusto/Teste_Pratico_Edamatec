package funcoes;

import java.sql.DriverManager;
import java.util.Properties;
import java.sql.Connection;

public class Conexao {
    private static Connection conexao;

    public static void conectar (){
        try{
            if (conexao == null){
                String url = "jdbc:mysql://localhost:3306/db_cliente?useSSL=false&serverTimezone=UTC";
                Properties props = new Properties();
                props.setProperty("user","root");
                props.setProperty("password","N608BC0");
                conexao = DriverManager.getConnection(url, props);
                System.out.println("Conexão realizada com sucesso!");
            }
        }catch (Exception error) {
            error.printStackTrace();
        }
    }
    public static Connection getConexao () {
        return conexao;
    }
}
