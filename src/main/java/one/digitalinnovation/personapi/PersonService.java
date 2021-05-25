package one.digitalinnovation.personapi;

import lombok.AllArgsConstructor;
import one.digitalinnovation.personapi.dto.MessageResponseDTO;
import one.digitalinnovation.personapi.dto.PersonDTO;
import one.digitalinnovation.personapi.entities.Person;
import one.digitalinnovation.personapi.entities.Phone;
import one.digitalinnovation.personapi.repositories.PersonRepository;
import one.digitalinnovation.personapi.services.exceptions.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {
    private final PersonRepository personRepository;

    @Transactional
    public MessageResponseDTO createPerson(PersonDTO dto) {
        Person person = new Person(null, dto.getFirstName(), dto.getLastName(), dto.getCpf(), dto.getBirthDate(), dto.getPhones());
        person = personRepository.save(person);
        return createMensageResponse("Created person with ID: ", person.getId());
    }

    @Transactional(readOnly = true)
    public PersonDTO findById(Long id) {
        Person person = verifyIfExists(id);

        return new PersonDTO(person);
    }

    @Transactional
    public void deleteById(Long id) {
        verifyIfExists(id);
        personRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(Long id, PersonDTO dto) {
        Person person = verifyIfExists(id);
        updateData(person, dto);
        person = personRepository.save(person);
        return createMensageResponse("Updated person with ID:", person.getId());
    }

    private Person verifyIfExists(Long id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    private MessageResponseDTO createMensageResponse(String message, Long id) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }

    private void updateData(Person person, PersonDTO dto){
        person.setFirstName(dto.getFirstName());
        person.setLastName(dto.getLastName());
        person.setCpf(dto.getCpf());
        person.setBirthDate(dto.getBirthDate());
        for (Phone phone : dto.getPhones()){
            person.getPhones().add(phone);
        }
    }
}
