package entities;

public class chamado {

private String solicitante;
private int numero;
private String problema;
private String tecnico;

public static final int AGUARDANDO = 1;
public static final int EM_PROGRESSO = 2;
public static final int CONCLUÍDO = 3;

private int status;



public chamado(String solicitante, int numero, String problema, int status) {

	this.solicitante = solicitante;
	this.numero = numero;
	this.problema = problema;
	this.status = status;
}
public String getSolicitante() {
	return solicitante;
}
public void setSolicitante(String solicitante) {
	this.solicitante = solicitante;
}
public int getNumero() {
	return numero;
}
public void setNumero(int numero) {
	this.numero = numero;
}
public String getProblema() {
	return problema;
}
public void setProblema(String problema) {
	this.problema = problema;
}
public String getTecnico() {
	return tecnico;
}
public void setTecnico(String tecnico) {
	this.tecnico = tecnico;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}








}
