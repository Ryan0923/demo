package http.ning;

public class HttpIoException extends RuntimeException {

    private static final long serialVersionUID = 5456613924966363824L;

    public HttpIoException(Exception e) {
        super(e);
    }

}
