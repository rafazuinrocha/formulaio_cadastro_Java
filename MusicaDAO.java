/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.Conexao;
import beans.Musica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ifsp
 */
public class MusicaDAO {
    // Puxa a conexão com o banco de dados
    private Connection conn;
    
    public MusicaDAO(){
        this.conn = Conexao.getConexao();
    }
    
    // Método para inserir uma música
    public void insert(Musica m){
        String sql = "insert into musica(nome, id_categoria) VALUES(?, ?)";
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, m.getNome());
            stmt.setInt(2, m.getId_Categoria());
            stmt.execute();
        } catch (Exception e) {
            System.out.println("Houve um erro ao tentar adicionar uma nova música -> " + e.getMessage());
        }
    }
    
    // Método para excluir uma música
    public void delete(int id){
        String sql = "delete from musica where id = ?";
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        } catch (Exception e) {
            System.out.println("Houve um erro ao tentar excluir esta música -> " + e.getMessage());
        }
    }
    
    // Método para editar uma música
    public void update(Musica m){
        String sql = "update musica set nome = ?, id_categoria = ? where id = ?";
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, m.getNome());
            stmt.setInt(2, m.getId_Categoria());
            stmt.setInt(3, m.getId());
            stmt.execute();
        } catch (Exception e) {
            System.out.println("Houve um erro ao tentar editar esta música " + e.getMessage());
        }
    }
    
    // Listagem de todas as músicas registradas
    public List<Musica> getMusicas() {
        List<Musica> lista = new ArrayList();
        String sql = "select * from musica";
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Musica m = new Musica();
                m.setId(rs.getInt("id"));
                m.setNome(rs.getString("nome"));
                m.setId_Categoria(rs.getInt("id_categoria"));
                lista.add(m);
            }
        } catch (Exception e) {
            System.out.println("Houve um erro ao tentar buscar músicas -> " + e.getMessage());
        }
        return lista;
    }
    
    // Listagem da música selecionada
    public Musica getMusica(int id) {
        Musica m = new Musica();
        String sql = "select * from musica where id = ?";
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.first();
            m.setId(rs.getInt("id"));
            m.setNome(rs.getString("nome"));
            m.setId_Categoria(rs.getInt("id_categoria"));
            
        } catch (Exception e) {
            System.out.println("Houve um erro ao tentar buscar esta musica -> " + e.getMessage());
        }
        return m;
    }
}
