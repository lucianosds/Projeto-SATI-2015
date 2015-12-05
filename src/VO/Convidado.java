/*
 * Luciano Santos - RA 1589490.
 * lucianosds@gmail.com
 * 
 * 
 */
package VO;

/**
 *
 * @author Luciano Santos <lucianosds@gmail.com>
 */
public class Convidado extends Participante{

    protected String Origem; // ouviu falar da SATI por?
     
    public Convidado(int IdParticipante, String Nome, int RA, String Email, String Origem) {
        super(IdParticipante, Nome, RA, Email);
        this.Origem = Origem;
    }
    
}
