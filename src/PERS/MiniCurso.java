/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PERS;


import Conexao.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lucas
 */
public class MiniCurso {

    public void InsertMinicurso(VO.MiniCurso minicurso) {
        Conexao conn = new Conexao();
        conn.conectar(); 
        
        try{
            Statement sessao = conn.getConnection().createStatement();
            String sql = "SELECT assunto FROM minicurso WHERE assunto = '"+minicurso.getAssunto()+"'";
            ResultSet select = sessao.executeQuery(sql);
            if(select.next()){
                JOptionPane.showMessageDialog(null, "O minicurso ja esta cadastrado!");
            }else{
                String query = "INSERT INTO minicurso (assunto, duracao, preco) VALUES ('"+minicurso.getAssunto()+"', '"+minicurso.getDuracao()+"', '"+minicurso.getPreco()+"')";
                int rs = sessao.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "O minicurso foi cadastrado com sucesso!");
                
                
            }
        
        }catch(SQLException ex){
            Logger.getLogger(PERS.MiniCurso.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro");
        }
        
        conn.desconectar();
        
    }
    
    public DefaultTableModel getDadosTabela(DefaultTableModel modelo){
        Conexao conn = new Conexao();
        conn.conectar(); 
        
        
        try{
            Statement sessao = conn.getConnection().createStatement();
            String query = "SELECT * FROM minicurso";
            ResultSet rs = sessao.executeQuery(query);
      
            while(rs.next()){ 
               
              String assunto = rs.getString("assunto");
              String duracao = rs.getString("duracao");
              double preco = rs.getDouble("preco");
              modelo.addRow(new Object[]{assunto, duracao, preco});
            }

              }catch(SQLException ex){
                  Logger.getLogger(PERS.MiniCurso.class.getName()).log(Level.SEVERE, null, ex);
                  System.out.println("Erro");
        }
        
        conn.desconectar();
        return modelo;
    }

    public void excluirDado(VO.MiniCurso minicurso) {
        Conexao conn = new Conexao();
        conn.conectar(); 
        
        try{
            Statement sessao = conn.getConnection().createStatement();
            String query = "DELETE FROM minicurso WHERE assunto = '"+minicurso.getAssunto()+"'";
            int rs = sessao.executeUpdate(query);
            if(rs > 0){
                JOptionPane.showMessageDialog(null, "Minicurso excluido com sucesso!");
                
            }
            }catch(SQLException ex){
                  Logger.getLogger(PERS.MiniCurso.class.getName()).log(Level.SEVERE, null, ex);
                  System.out.println("Erro");
        }
        
        conn.desconectar();
        
    }

    public void updateDados(VO.MiniCurso minicurso){
        Conexao conn = new Conexao();
        conn.conectar(); 
        
        try{
            Statement sessao = conn.getConnection().createStatement();
            String query = "UPDATE minicurso SET assunto = '"+minicurso.getAssunto()+"', duracao = '"+minicurso.getDuracao()+"', preco = '"+minicurso.getPreco()+"' WHERE assunto = '"+minicurso.getVelho()+"'";
            int rs = sessao.executeUpdate(query);
            if(rs > 0){
                JOptionPane.showMessageDialog(null, "Minicurso alterado com sucesso!");
                
            }
            }catch(SQLException ex){
                  Logger.getLogger(PERS.MiniCurso.class.getName()).log(Level.SEVERE, null, ex);
                  System.out.println("Erro");
        }
        
        conn.desconectar();
    }
    
}
