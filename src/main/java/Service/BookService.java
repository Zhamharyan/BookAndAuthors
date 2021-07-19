package Service;

import Controller.Models.AuthorRequestModel;
import Controller.Models.BookRequestModel;
import Data.DAO;
import Service.Models.Author;
import Service.Models.Book;

import java.util.List;

public class BookService {
    private DAO dao;
    public void create(BookRequestModel bookRequestModel) throws Exception{
        if(bookRequestModel.getTitle().equals("")){
            throw new Exception("The book title can not be null");
        }
        Book book = new Book();
        book.setAuthor(bookRequestModel.getAuthorId());
        book.setTitle(bookRequestModel.getTitle());
        book.setGenre(bookRequestModel.getGenre());
        dao.createBook(book);
    }
    public void deleteById(String id) throws Exception{
        int bookId = 0;
        try {
            bookId = Integer.parseInt(id);
        }catch (Exception e){
            throw new Exception("The book id must be number");
        }
        boolean isFind = false;
        List<Book> bookList = readAll();
        for(int i = 0;i<bookList.size();i++){
            if(bookList.get(i).getId()==bookId){
                isFind = true;
            }
        }
        if(!isFind){
            throw new Exception("There is no book with such id");
        }
        dao.deleteBook(bookId);
    }
    public List<Book> readAll(){
        return dao.readAllBooks();
    }
    public void setDao(DAO dao) {
        this.dao = dao;
    }
}
