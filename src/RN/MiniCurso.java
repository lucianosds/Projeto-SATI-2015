/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author a1590294
 */
public class MiniCurso {
    
    
    
    public MiniCurso(){
        
    }
    
    public VO.MiniCurso validaDados(VO.MiniCurso minicurso){
        if(minicurso.getAssunto().equals("")){
            JOptionPane.showMessageDialog(null, "Assunto nao pode ser vazio!");
        }
        else if(minicurso.getDuracao().equals("")){
            JOptionPane.showMessageDialog(null, "Duracao nao pode ser vazio!");
        }
        else if(minicurso.getPreco() == 0){
            JOptionPane.showMessageDialog(null, "Forneca o preco do minicurso!");
        }
        else if(minicurso.getPreco() < 0){
            JOptionPane.showMessageDialog(null, "Forneca um preco valido!");
        }
        else{
            PERS.MiniCurso persMinicurso = new PERS.MiniCurso();
            persMinicurso.InsertMinicurso(minicurso);
            System.out.println("sucesso");
        }
        return null;
    }
    
    public DefaultTableModel getDadosTabela(DefaultTableModel modelo){
        
        
        PERS.MiniCurso tabela = new PERS.MiniCurso();
        tabela.getDadosTabela(modelo);
        modelo.fireTableDataChanged();
        return modelo;
    }

    public void excluirDado(VO.MiniCurso minicurso) {
        PERS.MiniCurso tabela = new PERS.MiniCurso();
        tabela.excluirDado(minicurso);
        
        
    }
    
    public void updateDados(VO.MiniCurso minicurso){
        PERS.MiniCurso update = new PERS.MiniCurso();
        update.updateDados(minicurso);
    }
    
    
    
}
