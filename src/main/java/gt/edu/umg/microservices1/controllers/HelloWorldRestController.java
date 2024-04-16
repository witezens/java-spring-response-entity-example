package gt.edu.umg.microservices1.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRestController {
    /**
     * ResponseEntity representa la respuesta HTTP completa:
     * **código de estado**,
     * **encabezados** y
     * **cuerpo** .
     *
     * Como resultado, podemos usarlo para configurar completamente la respuesta HTTP.
     *
     * Si queremos usarlo, tenemos que devolverlo desde el enpoint y spring se encarga del resto.
     *
     * ResponseEntity es un tipo genérico. En consecuencia, podemos utilizar cualquier tipo como cuerpo de respuesta:
     *
     * ResponseEntity<String>
     * ResponseEntity<Long>
     * ResponseEntity<List>
     * ResponseEntity<Model>
     *
     *
     * @param user
     * @return
     */
    @GetMapping("/greetings/{user}")
    public ResponseEntity<String> HelloWorld(@PathVariable String user) {
        return ResponseEntity.ok("hola mundo " + user);
    }
}
