package br.com.fiap.GlobalSolutionJava.exceptions;

public class GeminiModelError extends RuntimeException {

  public GeminiModelError() {
    super("gemini.model.error");
  }

  public GeminiModelError(String message) {
    super(message);
  }
}
