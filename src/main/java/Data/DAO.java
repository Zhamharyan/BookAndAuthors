package Data;

import Service.Models.Author;
import Service.Models.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DAO {
    private final SessionFactory sessionFactory;
    public DAO(){
        sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Author.class)
                .addAnnotatedClass(Book.class)
                .buildSessionFactory();
    }
    public void createAuthor(Author author){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(author);
        session.getTransaction().commit();
        session.close();
    }
    public void createBook(Book book){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(book);
        session.getTransaction().commit();
        session.close();
    }
    public List<Author> readAllAuthors(){
        Session current = sessionFactory.openSession();
        List<Author> authorList = current.createQuery("from Author").list();
        current.close();
        return authorList;
    }
    public List<Book> readAllBooks(){
        Session session = sessionFactory.openSession();
        List<Book> bookList = session.createQuery("from Book").list();
        session.close();
        return bookList;
    }

    public Author readAuthorById(int id){
        Session session = sessionFactory.openSession();
        Author author = session.find(Author.class,id);
        session.close();
        return author;
    }
    public Book readBookById(int id){
        Session session = sessionFactory.openSession();
        Book book = session.find(Book.class,id);
        session.close();
        return book;
    }
    public void deleteAuthor(int authorId){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(readAuthorById(authorId));
        session.getTransaction().commit();
        session.close();
    }
    public void deleteBook(int id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.remove(readBookById(id));
        session.getTransaction().commit();
        session.close();
    }
}

