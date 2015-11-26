/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RN;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lucas
 */
public class Inscricao {
    public Inscricao(){
        
    }
    
    public DefaultComboBoxModel getDadosComboBox(DefaultComboBoxModel modelo){
        PERS.Inscricao inscricao = new PERS.Inscricao();
        inscricao.getDadosComboBox(modelo);
        return modelo;
    }

    public void insertDados(VO.Inscricao inscricao) {
        PERS.Inscricao persInscricao = new PERS.Inscricao();
        persInscricao.insertDados(inscricao);
    }
    
    public DefaultTableModel getDadosTabela(DefaultTableModel modelo2){
        
        
        PERS.Inscricao tabela2 = new PERS.Inscricao();
        tabela2.getDadosTabela(modelo2);
        modelo2.fireTableDataChanged();
        return modelo2;
    }

    public void excluirDado(VO.Inscricao inscricao) {
        PERS.Inscricao tabela = new PERS.Inscricao();
        tabela.excluirDado(tabela.getIDInscricao(inscricao));
    }

    public void updateDados(VO.Inscricao inscricao) {
        PERS.Inscricao update = new PERS.Inscricao();
        update.updateDados(inscricao, update.getIDInscricao(inscricao));
    }
}
