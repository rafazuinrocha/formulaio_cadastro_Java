/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.Conexao;
import beans.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ifsp
 */
public class CategoriaDAO {
    // Puxa a conexão com o banco de dados
    private Connection conn;
    
    public CategoriaDAO(){
        this.conn = Conexao.getConexao();
    }
    
    // Método para inserir uma categoria
    public void insert(Categoria c){
        String sql = "insert into categoria(nome)values(?)";
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, c.getNome());
            stmt.execute();
        } catch (Exception e) {
            System.out.println("Houve um erro ao tentar adicionar esta categoria -> " + e.getMessage());
        }
    }
    
    // Método para excluir uma categoria
    public void delete(int id){
        String sql = "delete from categoria where id = ?";
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        } catch (Exception e) {
            System.out.println("Houve um erro ao tentar excluir esta categoria -> " + e.getMessage());
        }
    }
    
    // Método para atualizar uma categoria
    public void update(Categoria c){
        String sql = "update categoria set nome = ? where id = ?";
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, c.getNome());
            stmt.setInt(2, c.getId());
            stmt.execute();
        } catch (Exception e) {
            System.out.println("Houve um erro ao tentar editar esta categoria -> " + e.getMessage());
        }
    }
    
    // Listagem de todas as categorias registradas
    public List<Categoria> getCategorias() {
        List<Categoria> lista = new ArrayList();
        String sql = "select * from categoria";
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Categoria c = new Categoria();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                lista.add(c);
            }
        } catch (Exception e) {
            System.out.println("Houve um erro ao tentar buscar categorias -> " + e.getMessage());
        }
        return lista;
    }
    
    // Listagem da categoria selecionada
    public Categoria getCategoria(int id) {
        Categoria c = new Categoria();
        String sql = "select * from categoria where id = ?";
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.first();
            c.setId(rs.getInt("id"));
            c.setNome(rs.getString("nome"));
            
        } catch (Exception e) {
            System.out.println("Houve um erro ao tentar buscar esta categoria -> " + e.getMessage());
        }
        return c;
    }
}
