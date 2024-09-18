package ao.santana.e_diaristas.core.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class ServicoNaoEncontradoException extends EntityNotFoundException {

    public ServicoNaoEncontradoException(String message) {
        super(message);
    }

}
