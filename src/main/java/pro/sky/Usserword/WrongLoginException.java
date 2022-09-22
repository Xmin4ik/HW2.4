package pro.sky.Usserword;


public class WrongLoginException extends RuntimeException{
public WrongLoginException(String messege) {
    super(messege);
    System.out.println(messege);



}
}
