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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static sun.security.krb5.Confounder.intValue;

/**
 *
 * @author Lucas
 */
public class Inscricao {
    public Inscricao(){
        
    }
    
    public DefaultComboBoxModel getDadosComboBox(DefaultComboBoxModel modelo){
        Conexao conn = new Conexao();
        conn.conectar(); 
        
        
        try{
            Statement sessao = conn.getConnection().createStatement();
            String query = "SELECT assunto FROM minicurso";
            ResultSet rs = sessao.executeQuery(query);
      
            while(rs.next()){ 
               
              modelo.addElement(rs.getString("assunto"));
            }

              }catch(SQLException ex){
                  Logger.getLogger(PERS.MiniCurso.class.getName()).log(Level.SEVERE, null, ex);
                  System.out.println("Erro");
        }
        
        conn.desconectar();
        return modelo;
    }

    public void insertDados(VO.Inscricao inscricao) {
        Conexao conn = new Conexao();
        conn.conectar(); 
        
        try{
            Statement sessao0 = conn.getConnection().createStatement();
            String sql0 = "SELECT * FROM inscricao I "
                    + "INNER JOIN minicurso ON I.minicurso_idminicurso = "
                    + "(SELECT idminicurso FROM minicurso WHERE assunto = '"+inscricao.getMinicurso()+"') "
                    + "INNER JOIN participante ON I.participante_idparticipante = "
                    + "(SELECT idparticipante FROM participante WHERE ra = '"+inscricao.getRa()+"') ";
            ResultSet select0 = sessao0.executeQuery(sql0);
            if(select0.next()){
                JOptionPane.showMessageDialog(null, "Entrada invalida! O usuario ja esta inscrito nesse evento!");
                
            }else{
                Statement sessao = conn.getConnection().createStatement();
                Statement sessao2 = conn.getConnection().createStatement();
                String sql = "SELECT * FROM participante WHERE ra = '"+inscricao.getRa()+"'";
                String sql2 = "SELECT idminicurso FROM minicurso WHERE assunto = '"+inscricao.getMinicurso()+"'";
                ResultSet select = sessao.executeQuery(sql);
                ResultSet select2 = sessao2.executeQuery(sql2);
                select2.next();


                if(select.next()){

                    String query = "INSERT INTO inscricao (tipo, status, participante_idparticipante, minicurso_idminicurso) VALUES "
                            + "('"+inscricao.getTipo()+"', '"+inscricao.getStatus()+"', '"+select.getString("idparticipante")+"', '"+select2.getString("idminicurso")+"')";
                    int rs = sessao.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Inscricao realizada com sucesso!");
                }else{
                   JOptionPane.showMessageDialog(null, "RA Invalido!");


                }
            }
            
        
        }catch(SQLException ex){
            Logger.getLogger(PERS.MiniCurso.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro");
        }
        
        conn.desconectar();
    }
    
    public DefaultTableModel getDadosTabela(DefaultTableModel modelo2){
        Conexao conn = new Conexao();
        conn.conectar(); 
        
        
        try{
            Statement sessao = conn.getConnection().createStatement();
            String query = "SELECT * FROM inscricao I "
                    + "INNER JOIN minicurso M ON I.minicurso_idminicurso = M.idminicurso "
                    + "INNER JOIN participante P ON I.participante_idparticipante = P.idparticipante "
                    + "ORDER BY assunto";
            ResultSet rs = sessao.executeQuery(query);
      
            while(rs.next()){ 
               
              String assunto = rs.getString("assunto");
              String nome = rs.getString("nome");
              String tipo = rs.getString("tipo");
              String status = rs.getString("status");
              modelo2.addRow(new Object[]{assunto, nome, tipo, status});
            }

              }catch(SQLException ex){
                  Logger.getLogger(PERS.MiniCurso.class.getName()).log(Level.SEVERE, null, ex);
                  System.out.println("Erro");
        }
        
        conn.desconectar();
        return modelo2;
    }

    public void excluirDado(int idinscricao) {
        Conexao conn = new Conexao();
        conn.conectar();
        
        try{
            Statement sessao = conn.getConnection().createStatement();
            String query = "DELETE FROM inscricao WHERE idinscricao = '"+idinscricao+"'";
            int rs = sessao.executeUpdate(query);
            if(rs > 0){
                JOptionPane.showMessageDialog(null, "Inscricao excluida com sucesso!");
                
            }
            }catch(SQLException ex){
                  Logger.getLogger(PERS.MiniCurso.class.getName()).log(Level.SEVERE, null, ex);
                  System.out.println("Erro");
        }
        
        conn.desconectar();
    }
    
    public int getIDInscricao(VO.Inscricao inscricao){
        Conexao conn = new Conexao();
        conn.conectar();
        
        try{
            Statement sessao = conn.getConnection().createStatement();
            Statement sessao2 = conn.getConnection().createStatement();
            Statement sessao3 = conn.getConnection().createStatement();
            String sqlParticipante = "SELECT * FROM participante WHERE nome = '"+inscricao.getNome()+"'";
            String sqlMinicurso = "SELECT * FROM minicurso WHERE assunto = '"+inscricao.getMinicurso()+"'";
            
            ResultSet rs1 = sessao.executeQuery(sqlParticipante);
            ResultSet rs2 = sessao2.executeQuery(sqlMinicurso);
            rs1.next();
            int idParticipante = (Integer) rs1.getObject("idparticipante");
            rs2.next();
            int idMinicurso = rs2.getInt("idminicurso");
            String sqlInscricao = "SELECT * FROM inscricao WHERE participante_idparticipante = '"+idParticipante+"' "
                    + "AND minicurso_idminicurso = '"+idMinicurso+"'";
            ResultSet rs3 = sessao3.executeQuery(sqlInscricao);
            rs3.next();
            int idInscricao = rs3.getInt("idinscricao");
            
            return idInscricao;
            
            }catch(SQLException ex){
                  Logger.getLogger(PERS.MiniCurso.class.getName()).log(Level.SEVERE, null, ex);
                  System.out.println("Erro");
        }
        
        conn.desconectar();
        return 0;
    }

    public void updateDados(VO.Inscricao inscricao, int idInscricao) {
        Conexao conn = new Conexao();
        conn.conectar(); 
        
        try{
            Statement sessao = conn.getConnection().createStatement();
            String query = "UPDATE inscricao SET status = '"+inscricao.getStatus()+"' "
                    + "WHERE idinscricao = '"+idInscricao+"'";
            int rs = sessao.executeUpdate(query);
            if(rs > 0){
                JOptionPane.showMessageDialog(null, "Situacao alterada com sucesso!");
                
            }
            }catch(SQLException ex){
                  Logger.getLogger(PERS.MiniCurso.class.getName()).log(Level.SEVERE, null, ex);
                  System.out.println("Erro");
        }
        
        conn.desconectar();
    }
}
