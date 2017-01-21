package br.com.valemobi.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.valemobi.dominio.Mercadoria;
import br.com.valemobi.factory.ConexaoFactory;

@Repository("mercDao")
public class MercadoriaDao {
	ConexaoFactory conexaoFactory;
	Connection conection;
	private static String SQL_SALVAR = "INSERT INTO tb_mercadoria(cod_mercadoria, tipo_mercadoria, nome_mercadoria, "
			+ "qtde_mercadoria, preco_mercadoria, tipoNeg_mercadoria) values(?,?,?,?,?,?)";
	
	private static String SQL_ALTERAR = "UPDATE tb_mercadoria SET cod_mercadoria = ?, tipo_mercadoria = ?, nome_mercadoria = ?, "
			+ "qtde_mercadoria = ?, preco_mercadoria = ?, tipoNeg_mercadoria = ? where cod_mercadoria = ?";
	
	private static String SQL_EXCLUIR = "DELETE FROM tb_mercadoria where cod_mercadoria = ?";
	
	private static String SQL_LISTAR = "SELECT * from tb_mercadoria";
	
	private static String SQL_CONSULTAR = "SELECT * from tb_mercadoria where cod_mercadoria = ?";
	
	public boolean salvar(Mercadoria mercadoria){
		PreparedStatement comando = null;
		conection = conexaoFactory.conectar();
		try {
			comando = conection.prepareStatement(SQL_SALVAR);
			comando.setInt(1, mercadoria.getCodigo());
			comando.setString(2, mercadoria.getTipoMercad());
			comando.setString(3, mercadoria.getNome());
			comando.setInt(4, mercadoria.getQtde());
			comando.setDouble(5, mercadoria.getPreco());
			comando.setString(6, mercadoria.getTipoNegoc());
			comando.executeUpdate();
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conection.close();
				comando.close();				
			} catch(Exception e) {
				e.printStackTrace();
				return false;
			}
		}

		return true;
	}
	
	
	public boolean alterar(Mercadoria mercadoria){
		PreparedStatement comando = null;
		conection = conexaoFactory.conectar();
		try {
			comando = conection.prepareStatement(SQL_ALTERAR);
			comando.setInt(1, mercadoria.getCodigo());
			comando.setString(2, mercadoria.getTipoMercad());
			comando.setString(3, mercadoria.getNome());
			comando.setInt(4, mercadoria.getQtde());
			comando.setDouble(5, mercadoria.getPreco());
			comando.setString(6, mercadoria.getTipoNegoc());
			comando.setInt(7, mercadoria.getCodigo());
			comando.executeUpdate();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		
		} finally {
			try {
				conection.close();
				comando.close();				
			} catch(Exception e) {
				e.printStackTrace();
				return false;
			}
		}

		return true;
	}
	
	
	public boolean excluir(int id){
		PreparedStatement comando = null;
		conection = conexaoFactory.conectar();
		try {
			comando = conection.prepareStatement(SQL_EXCLUIR);
			comando.setInt(1, id);
			
			comando.executeUpdate();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		
		} finally {
			try {
				conection.close();
				comando.close();				
			} catch(Exception e) {
				e.printStackTrace();
				return false;
			}
		}

		return true;
	}
	
	public List<Mercadoria> listar(){
		ArrayList<Mercadoria> lista = new ArrayList<Mercadoria>();
		PreparedStatement comando = null;
		conection = conexaoFactory.conectar();
		try {
			comando = conection.prepareStatement(SQL_LISTAR);
			ResultSet result =  comando.executeQuery();
			while(result.next()){
				Mercadoria mercadoria = new Mercadoria();
				mercadoria.setCodigo(result.getInt("cod_mercadoria"));
				mercadoria.setTipoMercad(result.getString("tipo_mercadoria"));
				mercadoria.setNome(result.getString("nome_mercadoria"));
				mercadoria.setQtde(result.getInt("qtde_mercadoria"));
				mercadoria.setPreco(result.getDouble("preco_mercadoria"));
				mercadoria.setTipoNegoc(result.getString("tipoNeg_mercadoria"));
				lista.add(mercadoria);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conection.close();
				comando.close();				
			} catch(Exception e) {
				e.printStackTrace();
			}			
		}
		
		return lista;
	}
	
	public List<Mercadoria> consultar(Mercadoria mercadoria){
		ArrayList<Mercadoria> lista = new ArrayList<Mercadoria>();
		PreparedStatement comando = null;
		conection = conexaoFactory.conectar();
		try {
			comando = conection.prepareStatement(SQL_CONSULTAR);
			comando.setInt(1, mercadoria.getCodigo());
			ResultSet result =  comando.executeQuery();
			while(result.next()){
				Mercadoria merc = new Mercadoria();
				merc.setCodigo(result.getInt("cod_mercadoria"));
				merc.setTipoMercad(result.getString("tipo_mercadoria"));
				merc.setNome(result.getString("nome_mercadoria"));
				merc.setQtde(result.getInt("qtde_mercadoria"));
				merc.setPreco(result.getDouble("preco_mercadoria"));
				merc.setTipoNegoc(result.getString("tipoNeg_mercadoria"));
				lista.add(merc);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conection.close();
				comando.close();				
			} catch(Exception e) {
				e.printStackTrace();
			}			
		}
		
		return lista;
	}
	
	// se existe código vai alterar a mercadoria correspondente a este código, se código não existe não vai salvar
	public boolean verificaAcao(Mercadoria mercadoria){
		if(!this.consultar(mercadoria).isEmpty())
			return this.alterar(mercadoria);
		else
			return this.salvar(mercadoria);
		
	}
}