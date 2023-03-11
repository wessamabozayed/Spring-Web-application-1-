package wessam.spring.springWebApp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import wessam.spring.springWebApp.domain.Author;
import wessam.spring.springWebApp.domain.Book;
import wessam.spring.springWebApp.domain.Publisher;
import wessam.spring.springWebApp.repository.AuthorRepository;
import wessam.spring.springWebApp.repository.BookRepository;
import wessam.spring.springWebApp.repository.PublisherRepostiory;

@Component // Spring managed component
public class BootstrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepostiory publisherRepostiory;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepostiory publisherRepostiory) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepostiory =  publisherRepostiory;
    }

    @Override
    public void run(String ...arg) throws Exception{
        System.out.println("Started in bootstrap");
        Publisher publisher = new Publisher();
        publisher.setName("Ameer");
        publisher.setCity("Khaldyia");
        publisher.setState("Dubai");
        publisherRepostiory.save(publisher);
        System.out.println("Publisher Count Is:   "+ publisherRepostiory.count());

        Author wessam = new Author("Wessam","AZ");
        Book w_book = new Book("Light Night","123456");
        wessam.getBooks().add(w_book);
        w_book.getAuthors().add(wessam);

        w_book.setPublisher(publisher);
        publisher.getBooks().add(w_book);
        // To Save in H2 DB:
        authorRepository.save(wessam);
        bookRepository.save(w_book);
        publisherRepostiory.save(publisher);

        Author mhd = new Author("MHD","M");
        Book mhd_book = new Book("White Night","789123");
        mhd.getBooks().add(mhd_book);
        mhd_book.getAuthors().add(mhd);

        mhd_book.setPublisher(publisher);
        publisher.getBooks().add(w_book);

        authorRepository.save(mhd);
        bookRepository.save(mhd_book);
        publisherRepostiory.save(publisher);


        System.out.println("Number Of Books is:  " + bookRepository.count());
        System.out.println("Publisher Number of Book:   " + publisher.getBooks().size());
    }
}
