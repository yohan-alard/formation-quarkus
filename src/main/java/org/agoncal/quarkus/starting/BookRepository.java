package org.agoncal.quarkus.starting;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepository {

    public List<Book> getAllBooks(){
        return List.of(
                new Book(1, "george", "georghe", 2004, "fantasy"),
                new Book(2, "george2", "georghe2", 2004, "fantasy")
        );
    }


    public Optional<Book> getBook(@PathParam("id") int id){
        return getAllBooks().stream().filter(book -> book.id() == id).findFirst();
    }
}
