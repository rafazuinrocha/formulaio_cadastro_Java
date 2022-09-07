/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author ifsp
 */
public class Musica {
    // Define as variáveis que a música precisa
    private int id;
    private String nome;
    private int id_categoria;
    
    // 'Get' e 'Set' das variáveis
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public int getId_Categoria(){
        return id_categoria;
    }
    
    public void setId_Categoria(int id_categoria){
        this.id_categoria = id_categoria;
    }
}
