package pro.sky.Usserword;


public class WrongLoginException extends Exception{
public WrongLoginException(String messege) {
    super(messege);
    System.out.println(messege);



}
}
