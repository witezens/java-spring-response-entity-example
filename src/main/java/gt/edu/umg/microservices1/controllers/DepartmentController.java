package gt.edu.umg.microservices1.controllers;

import gt.edu.umg.microservices1.dto.DepartmentDTO;
import gt.edu.umg.microservices1.model.Department;
import gt.edu.umg.microservices1.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departmentssssss")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public ResponseEntity<List<Department>> list() {
        return ResponseEntity.ok(departmentService.getList());
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Department>> getById(@PathVariable Long id) {
        Optional<Department> department = departmentService.getById(id);

        if (department.isPresent()) {
            return ResponseEntity.ok(department);

        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Department> create(@RequestBody DepartmentDTO departmentJson) {
        Department department = new Department(); // entity

        department.setName(departmentJson.getName());
        department.setBudget(departmentJson.getBudget());
        department.setActive(departmentJson.getActive());

        Department response = departmentService.create(department);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("search")
    public ResponseEntity<List<Department>> list(
            @RequestParam(required = false) Boolean active,
            @RequestParam(required = false) Long budget
    ) {
        return ResponseEntity.ok(departmentService.getListByActive(active));
    }


}
