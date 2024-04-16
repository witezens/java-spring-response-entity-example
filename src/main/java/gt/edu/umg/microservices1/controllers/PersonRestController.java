package gt.edu.umg.microservices1.controllers;

import gt.edu.umg.microservices1.domain.Address;
import gt.edu.umg.microservices1.domain.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
/**
 * @RequestMapping establece un prefijo para todos los métodos expuestos en esta clase
 */
@RequestMapping("/personas")
public class PersonRestController {

    //mock
    ArrayList<Person> people = new ArrayList<>(
            List.of(
                    new Person(1L, "Adam", "Lopez"),
                    new Person(2L, "Dan", "Heins"),
                    new Person(3L, "Quin", "La")
            )
    );



    @GetMapping("{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        // buscar cual es tiene el id solicitado

        for (Person person : this.people) {
            if (person.getId().equals(id)) {

                /**
                 * ok devuelve el estatus 200
                 */
                return ResponseEntity.ok(person);
            }
        }


        /**
         * notFound devuelve el estatus 404 indicando que el recurso no fue encontrado
         */
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Person>> listPeople (){
        return ResponseEntity.ok(this.people);
    }

    /**
     * Es común que al momento de generar un nuevo recurso debe devolverse la URL del nuevo recurso creado
     * Para ello utilizamos URI para construir la URL hacia el nuevo recurso y este se envía en la petición de respuesta mediante
     * el HEADER Location
     *
     * @param person
     * @return
     */
    @PostMapping
    public ResponseEntity createPerson(@RequestBody Person person) {
        people.add(person);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(person.getId())
                .toUri();

        /**
         * created devuelve el estatus 201 indicando que el recurso fue creado
         */
        return ResponseEntity.created(location).build();
    }

    public Person updatePerson(Person person) {
        return person;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable Long id) {
        // buscar cual es tiene el id solicitado
        Optional<Person> optPerson = this.people.stream().filter(person -> person.getId().equals(id)).findFirst();

        if (optPerson.isPresent()) {
            this.people.remove(optPerson.get());
        } else {
            ResponseEntity.notFound().build();
        }

        /**
         * noContent devuelve el estatus 204
         */
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/direcciones")
    public ResponseEntity<?> listPersonAddresses(@PathVariable Long id) {
        List<Address> addresses = List.of(
                new Address("Zona 9", 1),
                new Address("Zona 10", 2),
                new Address("Zona 14", 3)
        );

        return ResponseEntity.ok(addresses);
    }

}
