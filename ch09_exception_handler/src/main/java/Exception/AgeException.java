package Exception;
//年龄有问题时，抛出异常
public class AgeException extends MyUserException{
    public AgeException() {
        super();
    }

    public AgeException(String message) {
        super(message);
    }
}
