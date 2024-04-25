package gt.edu.umg.microservices1.service;

import gt.edu.umg.microservices1.model.Department;
import gt.edu.umg.microservices1.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }


    public List<Department> getList() {
        return departmentRepository.findAll();
    }

    public Optional<Department> getById(Long id) {
        return departmentRepository.findById(id);
    }

    public Department create(Department department) {
        return departmentRepository.save(department);
    }

    public List<Department> getListByActive(Boolean active) {
        return departmentRepository.findByActive(active);
    }



}
