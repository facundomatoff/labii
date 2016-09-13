package naval;

//Creado por Favio Veron

public class Nave {
	
	private int life = 2;
	private int[] posicion={0,0,0,0};
	
	
	public Nave (int[] posicion){
		this.posicion[0]=posicion[0];
		this.posicion[1]=posicion[1];
		this.posicion[2]=posicion[2];
		this.posicion[3]=posicion[3];
	}
	
	
	public boolean recibirAtaque(int tiro1,int tiro2){
		if((posicion[0]== tiro1 && posicion[1]== tiro2) || (posicion[2]== tiro1 && posicion[3]== tiro2)){
			System.out.println("\nACERTASTE\n");
			debilitarNave();
			return true;
		}else {
			return false;
		}
	}
	
	public boolean destruirNave(){
		if (getLife()==0){
			System.out.println("Destruiste la nave ");
			return true;
		} else {
			return false;
		}
	}
	
	public void debilitarNave(){
		life-=1;
	}
	
	public int getLife() {
		return life;
	}
	
	public void setLife(int life) {
		this.life = life;
	}
	
	public int getCoordenadaX() {
		return posicion[0];
	}
	
	public int getCoordenadaY() {
		return posicion[1];
	}
	
	public int getCoordenadaX2() {
		return posicion[2];
	}
	
	public int getCoordenadaY2() {
		return posicion[3];
	}
	
	public int[] getCoordenada(){
		return posicion;
	}
	
	
	public void setPosicion(int[] posicion) {
		this.posicion = posicion;
	}
	
	
	public String toString(){
		return posicion[0]+" "+posicion[1]+" "+posicion[2]+" "+posicion[3];
		
	}
	
	
}
