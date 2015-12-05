/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tela;

import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author a1589490
 */
public class InscricaoTest {

    public InscricaoTest() {
    }

    @Test
    //public void btnInserirMiniCursoActionPerformed(java.awt.event.ActionEvent evt) {
    public void btnInserirMiniCursoActionPerformed(java.awt.event.ActionEvent evt) {
        VO.MiniCurso minicurso = new VO.MiniCurso();
        minicurso.setAssunto("Gaming");
        minicurso.setDuracao("2 horas");
        minicurso.setPreco(15.00);
        RN.MiniCurso rnMinicurso = new RN.MiniCurso();
        rnMinicurso.validaDados(minicurso);
        String expectativa = "Atualizada Tabela";
        String resultado = updateTabela();
        Assert.assertEquals(expectativa, resultado);
    }

   

}

    
}
