package one.digitalinnovation.personapi;

import one.digitalinnovation.personapi.dto.MessageResponseDTO;
import one.digitalinnovation.personapi.dto.PersonDTO;
import one.digitalinnovation.personapi.entities.Person;
import one.digitalinnovation.personapi.repositories.PersonRepository;
import one.digitalinnovation.personapi.services.exceptions.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonService {
//    private final PersonMapper personMapper = PersonMapper.INSTANCE;
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional
    public MessageResponseDTO createPerson(PersonDTO dto) {
        Person person = new Person(null, dto.getFirstName(), dto.getLastName(), dto.getCpf(), dto.getBirthDate(), dto.getPhones());
        person = personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID: " + person.getId())
                .build();
    }

    @Transactional(readOnly = true)
    public PersonDTO findById(Long id) {
        Person person = verifyIfExists(id);

        PersonDTO dto = new PersonDTO(person);
        return dto;
    }

    @Transactional
    public void deleteById(Long id) {
        verifyIfExists(id);
        personRepository.deleteById(id);
    }

    private Person verifyIfExists(Long id) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
        return person;
    }
}
