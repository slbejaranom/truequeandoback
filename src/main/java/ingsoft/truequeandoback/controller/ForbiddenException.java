package ingsoft.truequeandoback.controller;

public class ForbiddenException extends RuntimeException{

  public ForbiddenException(){
    super();
  }

  public ForbiddenException(String message){
    super(message);
  }
}
