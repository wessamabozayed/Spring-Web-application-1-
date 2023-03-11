package wessam.spring.springWebApp.repository;

import org.springframework.data.repository.CrudRepository;
import wessam.spring.springWebApp.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
