package batalla.clases;

/**
 * Created by Usuario1 on 19/08/2016.
 */
public class Block {
    private String dimB1;
    private int dimB2;

    public Block(String dimB1, int dimB2){
        this.dimB1=dimB1;
        this.dimB2=dimB2;
    }
    public Block(){
    }
    public String getDimB1() {
        return dimB1;
    }
    public int getDimB2() {
        return dimB2;
    }

    @Override
    public String toString() {
        return "("
                + dimB1 + " "
                +dimB2 +
                ")";
    }
    public boolean equals(Object obj){
        if (obj instanceof  Block){
            Block otro=(Block) obj;
            if (this.getDimB1().equals(otro.getDimB1()) && this.getDimB2()== otro.getDimB2()){
                return true;
            }else{
                return false;
            }
        } else{
            return false;
        }
    }
}
