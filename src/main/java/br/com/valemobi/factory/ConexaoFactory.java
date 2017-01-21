package br.com.valemobi.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
	
		private static final String USUARIO = "root";
		private static final String SENHA = "abc123";
		// java database conector = driver, n precisa da porta
		private static final String URL = "jdbc:mysql:mysqlnode108293-valemobi.jelasticlw.com.br/valemobi";
		
		// método que abre a conexão, retorna um tipo connection do pacote SQL
		public static Connection conectar(){
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		// variavel do tipo Connection q vai guardar a conexão
		Connection conexao = null;
		try {
			conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conexao;
		}

}
