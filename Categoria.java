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
public class Categoria {
    // Define as variáveis que a categoria precisa ter
    private int id;
    private String nome;
    
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
}
