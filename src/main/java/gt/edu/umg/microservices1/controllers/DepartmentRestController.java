package gt.edu.umg.microservices1.controllers;

import gt.edu.umg.microservices1.dto.DepartmentDTO;
import gt.edu.umg.microservices1.model.DepartmentEntity;
import gt.edu.umg.microservices1.service.DepartmentService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("departments")
public class DepartmentRestController {
    private final DepartmentService2 departmentService2;

    @Autowired
    public DepartmentRestController(DepartmentService2 departmentService2) {
        this.departmentService2 = departmentService2;
    }

    @GetMapping
    public ResponseEntity<List<DepartmentEntity>> getList() {
        return ResponseEntity.ok(departmentService2.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<DepartmentEntity>> getById(@PathVariable Long id) {
        Optional<DepartmentEntity> responseOfService = departmentService2.getById(id);

        if(responseOfService.isPresent()) {
            ResponseEntity.ok(responseOfService);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<DepartmentEntity> create(@RequestBody DepartmentDTO departmentJson) {

        DepartmentEntity departmentEntity = new DepartmentEntity();
        departmentEntity.setName(departmentJson.getName());
        departmentEntity.setBudget(departmentJson.getBudget());
        departmentEntity.setActive(departmentJson.getActive());

        DepartmentEntity responseOfService = departmentService2.create(departmentEntity);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(responseOfService.getId())
                .toUri();

        return ResponseEntity.created(location).body(responseOfService);
    }

    @GetMapping("search")
    public List<DepartmentEntity> getDepartmentByActive(
            @RequestParam(required = false) boolean active,
            @RequestParam(required = false) Double budget
    ) {
        return departmentService2.getDeparmentByActive(active);
    }

}
