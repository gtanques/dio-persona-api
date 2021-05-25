package one.digitalinnovation.personapi.controllers.exceptions;

import one.digitalinnovation.personapi.controllers.exceptions.dto.ErroPadraoExceptionDTO;
import one.digitalinnovation.personapi.services.exceptions.PersonNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<ErroPadraoExceptionDTO> recursoNaoEncontrado(PersonNotFoundException e, HttpServletRequest requisicao) {
        String error = "Não encontrado!";
        HttpStatus status = HttpStatus.NOT_FOUND;

        ErroPadraoExceptionDTO erroPadrao = new ErroPadraoExceptionDTO(Instant.now(), status.value(), e.getMessage(), error,
                requisicao.getRequestURI());

        return ResponseEntity.status(status).body(erroPadrao);

    }
}
