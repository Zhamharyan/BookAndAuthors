package Controller;

import Controller.Models.BookRequestModel;
import Controller.Models.Genre;
import Service.BookService;
import Service.Models.Author;
import Service.Models.Book;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class BookController {
    private AuthorController authorController;
    private BookService bookService;
    Scanner scanner = new Scanner(System.in);

    public void create() throws Exception{
        BookRequestModel bookRequestModel = new BookRequestModel();
        System.out.println("Input book title");
        String title = scanner.nextLine();
        System.out.println("Input book Genre");
        HashMap<String, Genre> genreHashMap = new HashMap<>();
        genreHashMap.put("1",Genre.HORROR);
        genreHashMap.put("2",Genre.FANTASY);
        genreHashMap.put("3",Genre.CLASSIC);
        System.out.println("1: HORROR");
        System.out.println("2: FANTASY");
        System.out.println("3: CLASSIC");
        String genreType = scanner.nextLine();
        if(!(genreType.equals("1") || genreType.equals("2") || genreType.equals("3"))){
            throw new Exception("Invalid key for genre");
        }
        System.out.println("Input author id");
        List<Author> authorList = authorController.readAll();
        authorList.forEach(each->{
            System.out.println(each.getId()+": "+each.getName());
        });
        String authorId = scanner.nextLine();
        if(!authorList.stream().anyMatch(a->a.getId() == Integer.parseInt(authorId))){
            throw new Exception("There is no author with such id");
        };
        bookRequestModel.setAuthor(authorController.read(authorId));
        bookRequestModel.setTitle(title);
        bookRequestModel.setGenre(genreHashMap.get(genreType));
        System.out.println();
        bookService.create(bookRequestModel);
    }

    public void read(){

    }
    public void update(){

    }

    public void delete() throws Exception{
        System.out.println("Input the book id which you want to delete");
        List<Book> authorList = bookService.readAll();
        authorList.stream().forEach(each->{
            System.out.println(each.getId()+": "+each.getTitle());
        });
        String response = scanner.nextLine();
        bookService.deleteById(response);
    }

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    public void setAuthorController(AuthorController authorController) {
        this.authorController = authorController;
    }
}
