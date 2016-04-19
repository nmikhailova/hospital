package domen.exception;

/**
 * Created with IntelliJ IDEA.
 * User: настя
 * Date: 28.11.13
 * Time: 20:52
 */
public class InternalServerError extends RuntimeException {

    /**
     * work with exceptions.
     * @param e exception.
     */
    public InternalServerError(Throwable e) {
        super(e);
    }

}
