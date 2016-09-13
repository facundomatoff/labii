/**
 * Created by Contrarian on 08/09/2016.
 */

public class Ship {
    private char corX,corA;
    private int corY,corB;
    private String estado;

    public Ship(){
        estado="A flote";
    }

    public String getEstado(){
        return estado;
    }

    public void hundir(){
        if (estado.equals("A flote")) estado="Dañado";
            else estado="Hundido";
    }

    public char getCorX(){
        return corX;
    }

    public void setCorX(char x){
        corX=x;
    }

    public int getCorY(){
        return corY;
    }

    public void setCorY(int y){
        corY=y;
    }

    public char getCorA(){
        return corA;
    }

    public void setCorA(char a){
        corA=a;
    }

    public int getCorB(){
        return corB;
    }

    public void setCorB(int b){
        corB=b;
    }

}