package net.csdcodes;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author csdcodes.net
 * @since 2020/09/03
 */
@Repository
public class BookDaoImpl implements BookDao {

    private final MongoTemplate mongoTemplate;

    public BookDaoImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Book save(Book book) {
        return mongoTemplate.save(book);
    }

    @Override
    public Book getBookById(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        return mongoTemplate.findOne(query, Book.class);
    }

    @Override
    public List<Book> getAllBooks() {
        return mongoTemplate.findAll(Book.class);
    }

    @Override
    public Book deleteBookById(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        return mongoTemplate.findAndRemove(query, Book.class);
    }
}
