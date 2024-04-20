package gt.edu.umg.microservices1.service;

import org.springframework.stereotype.Service;
import gt.edu.umg.microservices1.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ReviewService {

    /**
     * Usamos el principio de inyección de dependencia para inyectar el Repositorio
     */
    private final ReviewRepository repository;

    @Autowired
    public ReviewService(ReviewRepository repository) {
        this.repository = repository;
    }

    public void someMethod() {
//        repository.save(entity);
//        repository.delete(entity);
//        repository.findByProductId(productId);
    }
}
