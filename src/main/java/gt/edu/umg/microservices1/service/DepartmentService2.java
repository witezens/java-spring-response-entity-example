package gt.edu.umg.microservices1.service;

import gt.edu.umg.microservices1.model.DepartmentEntity;
import gt.edu.umg.microservices1.repository.DepartmentRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService2 {
    private final DepartmentRepository2 repository;

    @Autowired
    public DepartmentService2(DepartmentRepository2 repository) {
        this.repository = repository;
    }

    public List<DepartmentEntity> getAll() {
        return repository.findAll();
    }

    public Optional<DepartmentEntity> getById(Long id) {
        return repository.findById(id);
    }

    public DepartmentEntity create(DepartmentEntity departmentEntity) {
        return repository.save(departmentEntity);
    }

    public List<DepartmentEntity> getDeparmentByActive(boolean active) {
        return repository.findByActive(active);
    }

}
