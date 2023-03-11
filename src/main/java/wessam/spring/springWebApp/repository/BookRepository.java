package wessam.spring.springWebApp.repository;

import org.springframework.data.repository.CrudRepository;
import wessam.spring.springWebApp.domain.Book;

public interface BookRepository extends CrudRepository<Book,Long> {
}
