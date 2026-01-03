package org.agoncal.quarkus.starting;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepository {
    @ConfigProperty(name="books.genre", defaultValue = "fantasy")
    String genre;

    public List<Book> getAllBooks(){

        return List.of(
                new Book(1, "george", "georghe", 2004, genre),
                new Book(2, "george2", "georghe2", 2004, genre)
        );
    }


    public Optional<Book> getBook(@PathParam("id") int id){
        return getAllBooks().stream().filter(book -> book.id() == id).findFirst();
    }
}
