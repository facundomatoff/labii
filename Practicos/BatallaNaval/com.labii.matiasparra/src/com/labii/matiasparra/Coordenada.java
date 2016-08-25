package com.labii.matiasparra;

public class Coordenada {
	String columna;
	int fila;
	boolean estado;
	public String getColumna() {
		return columna;
	}
	public void setColumna(String columna) {
		this.columna = columna;
	}
	public int getFila() {
		return fila;
	}
	public void setFila(int fila) {
		this.fila = fila;
	}
	@Override
	public String toString() {
		return "( " + columna + " ; " + fila + ")";
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
}
