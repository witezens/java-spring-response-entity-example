package gt.edu.umg.microservices1.domain;

/**
 * DTO sin utilizar anotaciones lombok
 */
public class Persona {
    private Long id;
    private String name;
    private String lastname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "person's name is " + this.name + " " + this.lastname;
    }
}
