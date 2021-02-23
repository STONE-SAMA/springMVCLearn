package Exception;
//自定义异常，当用户姓名非法时，抛出异常
public class NameException extends MyUserException{
    public NameException() {
        super();
    }

    public NameException(String message) {
        super(message);
    }
}
