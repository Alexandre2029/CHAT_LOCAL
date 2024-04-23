package dao;

import javax.swing.*;
import java.sql.*;

public class ConnectionFactory {

    private static final String url = "jdbc:mysql://localhost/chat";
    private static final String user = "root";
    private static final String pass = "781220";
    
/**
 * Retorna uma conexão com o banco de dados com a url de conexão e o driver especifico do banco utilizado
 * @return 
 */
    
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(url,user,pass);
		} catch (SQLException ex) {
			String message = "Erro de conexão";
			String erro = "Erro!!";

			JOptionPane.showMessageDialog(null, message, erro, JOptionPane.ERROR_MESSAGE);
			throw new RuntimeException();
		}
	}
/**
 * Fecha a conexão com o banco de dados, a conexão a ser fechada deve ser passada como parametro.
 * @param con 
 */
	public static void closeConnection(Connection con) {
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException ex) {
			String message = "Erro de fechamento da conexão";
			String erro = "Erro!!";

			JOptionPane.showMessageDialog(null, message, erro, JOptionPane.ERROR_MESSAGE);
			throw new RuntimeException();
		}
	}
/**
 * Fecha a conexão com o banco de dados, a conexão e o PreparedStatement a serem fechados devem ser passados como parametro.
 * @param con
 * @param pst 
 */
	public static void closeConnection(Connection con, PreparedStatement pst) {
		try {
			if (con != null) {
				pst.close();
				closeConnection(con);
			}
			;
		} catch (SQLException ex) {
			String message = "Erro de fechamento da conexão";
			String erro = "Erro!!";

			JOptionPane.showMessageDialog(null, message, erro, JOptionPane.ERROR_MESSAGE);
			throw new RuntimeException();
		}
	}
/**
 * Fecha a conexão com o banco de dados, a conexão, PreparedStatement e o ResultSet a serem fechados devem ser passados como parametro.
 * @param con
 * @param pst
 * @param rs 
 */
	public static void closeConnection(Connection con, PreparedStatement pst, ResultSet rs) {
		try {
			if (con != null) {
				closeConnection(con, pst);
				rs.close();
			}

		} catch (SQLException ex) {
			String message = "Erro de fechamento da conexão";
			String erro = "Erro!!";

			JOptionPane.showMessageDialog(null, message, erro, JOptionPane.ERROR_MESSAGE);
			throw new RuntimeException();
		}
	}
}
