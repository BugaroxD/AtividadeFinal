package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

/* 

+ Curso: Análise e Desenvolvimento de Sistemas (ADS)
+ Aluno: Jefferson Luiz Martins Clemente
+ Professor: Jackson Machado
+ Matéria: Programação Orientada a Objeto
+ Atividade Avaliativa Final

*/

public class Conexao {

    public Connection connect;

    public Connection initConnect() throws Exception {
        if (this.connect != null && !connect.isClosed()) {
            return this.connect;
        }

        this.connect = getConnect();

        return this.connect;
    }

    public void finalConnect() throws SQLException, Exception {
        initConnect().close();
    }

    public static Connection getConnect() throws Exception {
        try {
            final String url = "jdbc:mysql://localhost:3306/atividadefinal?useTimezone=true&serverTimezone=UTC";
            final String user = "root";
            final String password = "";

            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}