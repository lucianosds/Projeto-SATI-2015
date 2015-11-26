package VO;


public class Participante {

	protected int IdParticipante;
	protected String Nome;
	protected int RA;
	protected String Email;
	
	public Participante(int IdParticipante, String Nome, int RA, String Email){
		this.IdParticipante = IdParticipante;
		this.Nome = Nome;
		this.RA = RA;
		this.Email = Email;
	}
	
	public String getNome(){
		    return Nome;
	}
	
}
