package pro.sky.Usserword;

public class WrongPasswordException extends Exception{
    public WrongPasswordException(String messege) {
        super(messege);
        System.out.println(messege);


    }
}

