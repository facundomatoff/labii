package ExcepLab;

/**
 * Created by umantram on 24/11/16.
 */
public class AtrapaError extends Exception {

    String msg;

    public AtrapaError(String message) {
        super(message);
        //this.msg = msg;
    }
}
