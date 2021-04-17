package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Address;
import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AddressRepository;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;
    private final AddressRepository addressRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository, AddressRepository addressRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        Author eric = new Author("Eric", "Evans");
        Book book= new Book("PrimeOfMyLife","90348934589");
        eric.getBooks().add(book);
        book.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(book);

        Author jkRowling = new Author("JK", "Rowling");
        Book harryPotter= new Book("Harry Potter","10048934989");
        jkRowling.getBooks().add(harryPotter);
        harryPotter.getAuthors().add(jkRowling);


        authorRepository.save(jkRowling);


        Address address = new Address("WeakHeart Lane","London","UK","09388");
        Publisher pubHouse = new Publisher("PubHouse");
        pubHouse.getAddresses().add(address);
        pubHouse.getBooks().add(harryPotter);
        address.setPublisher_address(pubHouse);
        publisherRepository.save(pubHouse);
        addressRepository.save(address);

        harryPotter.setPublisher_book(pubHouse);
        bookRepository.save(harryPotter);
        System.out.println("Started in Bootstrap....."+pubHouse.getAddresses());

    }
}
