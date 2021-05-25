package one.digitalinnovation.personapi.services.exceptions;

public class PersonNotFoundException extends RuntimeException {
    public PersonNotFoundException(Long id) {
        super("Person not found with ID:" + id);
    }
}
