package br.com.lojaDeRoupas.Domain.Exceptions;

public class EntityAlreadyExistsException extends RuntimeException  {
  public EntityAlreadyExistsException(String message) {
    super(message);
  }
}
