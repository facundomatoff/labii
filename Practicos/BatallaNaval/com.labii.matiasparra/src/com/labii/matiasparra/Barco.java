package com.labii.matiasparra;



public class Barco {
	Coordenada[] pos = new Coordenada[4];
	String estado;
	
	public Coordenada[] getPos() {
		return pos;
	}
	public void setPos(Coordenada[] pos) {
		this.pos = pos;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String imprimirCoordenada(){
		return pos[0]+";"+pos[1];
	}
	
	
}
