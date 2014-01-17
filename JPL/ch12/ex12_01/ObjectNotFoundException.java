package ch12.ex12_01;

@SuppressWarnings("serial")
public class ObjectNotFoundException extends Exception {

    private Object obj;

    public ObjectNotFoundException() {
    }

    public ObjectNotFoundException(String message) {
        super(message);
    }

    public ObjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ObjectNotFoundException(Throwable cause) {
        super(cause);
    }

    public Object getObj() {
        return obj;
    }

    public ObjectNotFoundException setObj(Object obj) {
        this.obj = obj;
        return this;
    }

}
