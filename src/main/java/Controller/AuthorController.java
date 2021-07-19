package Controller;

import Controller.Models.AuthorRequestModel;
import Service.AuthorService;
import Service.Models.Author;

import java.util.List;
import java.util.Scanner;

public class AuthorController {
    private BookController bookController;
    private AuthorService authorService;
    Scanner scanner = new Scanner(System.in);
    public void create() throws Exception{
        AuthorRequestModel authorRequestModel = new AuthorRequestModel();
        System.out.println("Enter author name");
        String authorName = scanner.nextLine();
        authorRequestModel.setName(authorName);
        authorService.create(authorRequestModel);
    }
    public Author read(String authorId) throws Exception{
        return authorService.read(authorId);
    }
    public void update(){

    }
    public List<Author> readAll(){
        return authorService.readAll();
    }
    public void delete() throws Exception{
        System.out.println("Input the author id wich you want to delete");
        List<Author> authorList = authorService.readAll();
        authorList.stream().forEach(each->{
            System.out.println(each.getId()+": "+each.getName());
        });
        String response = scanner.nextLine();
        authorService.deleteById(response);
    }

    public void setAuthorService(AuthorService authorService) {
        this.authorService = authorService;
    }

    public void setBookController(BookController bookController) {
        this.bookController = bookController;
    }

}
