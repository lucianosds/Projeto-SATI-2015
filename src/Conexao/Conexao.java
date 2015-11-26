/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexao;

import java.sql.Connection;
import com.mysql.jdbc.Statement; 
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author a1590294
 */
public class Conexao {
    private Statement stm;
    private ResultSet rs;
    private String driver;
    private String caminho;
    private String usuario;
    private String senha;
    private Connection conn;
    
    public Conexao(){
        this.driver = "com.mysql.jdbc.Driver";
        this.caminho = "jdbc:mysql://localhost:3306/projetodesoftware?zeroDateTimeBehavior=convertToNull";
        this.usuario = "root";
        this.senha = "";
    }
    
    public void conectar(){
        try {
            Class.forName(this.driver);
            this.conn = DriverManager.getConnection(this.caminho, this.usuario, this.senha);
            //JOptionPane.showMessageDialog(null, "Conectado com sucesso!");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar" + ex.getMessage());
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar" + ex.getMessage());
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void desconectar(){
        try {
            this.conn.close();
            //JOptionPane.showMessageDialog(null, "Desconectado com Sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Connection getConnection(){
        return conn;
    }
}