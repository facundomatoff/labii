package batalla.clases;

/**
 * Created by Usuario1 on 19/08/2016.
 */
public class Nave {
    private Block dim1;
    private Block dim2;
    private int d1;
    private int d2;

    public Nave(Block dim1, Block dim2, int d1, int d2){
        this.dim1=dim1;
        this.dim2=dim2;
        this.d1=d1;
        this.d2=d2;
    }
    public Block getDim1() {
        return dim1;
    }
    public Block getDim2() {
        return dim2;
    }
    public int getD1() {
        return d1;
    }
    public int getD2() {
        return d2;
    }
    public void setD1(int d1) {
        this.d1 = d1;
    }
    public void setD2(int d2) {
        this.d2 = d2;
    }

    @Override
    public String toString() {
        return "("
                 + dim1 + ' '
                +dim2 +
                ") - "+ d1+ " - "+ d2;
    }
}
