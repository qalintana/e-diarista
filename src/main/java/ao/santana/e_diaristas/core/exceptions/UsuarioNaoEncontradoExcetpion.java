package ao.santana.e_diaristas.core.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class UsuarioNaoEncontradoExcetpion extends EntityNotFoundException {

  public UsuarioNaoEncontradoExcetpion(String message) {
    super(message);
  }

}
