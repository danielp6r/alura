package br.com.alura.screenmatch.desafios;

public class SenhaInvalidaException extends RuntimeException {
  public SenhaInvalidaException(String message) {
    super(message);
  }
}
