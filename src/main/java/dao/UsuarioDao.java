package dao;

import model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao implements Dao<Usuario> {
        @Override
	public int create(Usuario obj) {
            
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pst = null;
		final String sql = "insert into usuario (nm_usuario, ds_cpf, ds_email, ds_senha, flag_online)"
			+ " values (?, ?, ?, ?, 0)";

		try {
			pst = con.prepareStatement(sql);

			pst.setString(1, obj.getNome());
			pst.setString(2, obj.getCpf());
			pst.setString(3, obj.getEmail());
			pst.setString(4, obj.getSenha());

			return pst.executeUpdate();

		} catch (SQLException ex) {
                        System.err.print(ex);
			throw new RuntimeException();
		} finally {
			ConnectionFactory.closeConnection(con, pst);
		}

	}

	@Override
	public List<Usuario> read() {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		final String sql = "select * from usuario where flag_online = 1";

		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			List usuarios = new ArrayList();

			while (rs.next()) {
				long id = rs.getLong("id_usuario");
				String nome = rs.getString("nm_usuario");
				String cpf = rs.getString("ds_cpf");
				String email = rs.getString("ds_email");
                                
				usuarios.add(new Usuario(nome, cpf, email));
			}

			return usuarios;

		} catch (SQLException ex) {
			throw new RuntimeException();
		} finally {
			ConnectionFactory.closeConnection(con, pst, rs);
		}
	}
        
        public static int validateUser(Usuario user){
        
        
           Connection con = ConnectionFactory.getConnection();
           PreparedStatement pst = null;
           
           int retorno = 0;
             
            String query = "SELECT COUNT(*) FROM usuario WHERE ds_email = ? and ds_senha = ?";
            
       
            try{
            
                pst = con.prepareStatement(query);
                
                pst.setString(1,user.getEmail());
		pst.setString(2, user.getSenha());
            
                ResultSet result = pst.executeQuery();
            
                while(result.next()){
                    retorno = result.getInt("count(*)");
                    System.out.println(retorno);
                }
            
            
            }catch(SQLException e){
                e.printStackTrace();
            }
        
            return retorno;
    }
        
    	public static List<String> block() {
            
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
                ArrayList<String> result = new ArrayList<>();
                
		final String sql = "SELECT * FROM PALAVRAS";

		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			List usuarios = new ArrayList();

			while (rs.next()) {
                                String palavras = rs.getString("palavras");                           
				result.add(palavras);
			}
                        
			return result;

		} catch (SQLException ex) {
			throw new RuntimeException();
		} finally {
			ConnectionFactory.closeConnection(con, pst, rs);
		}
	}
        
    public static String returnName(Usuario user){
        
        
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement pst = null;
           
           String nome = "";
             
            String query = "SELECT * FROM usuario WHERE ds_email = ? and ds_senha = ?";
            
       
            try{
            
                pst = con.prepareStatement(query);
                
                pst.setString(1,user.getEmail());
		pst.setString(2, user.getSenha());
            
                ResultSet result = pst.executeQuery();
            
                while(result.next()){
                    nome = result.getString("nm_usuario");                  
                }
            
            
            }catch(SQLException e){
                e.printStackTrace();
            }
            
 
        
        return nome;
    }
        
 
        
}
