package net.csdcodes;

import java.util.List;

public interface BookDao {
    Book save(Book book);
    Book getBookById(String id);
    List<Book> getAllBooks();
    Book deleteBookById(String id);
}
