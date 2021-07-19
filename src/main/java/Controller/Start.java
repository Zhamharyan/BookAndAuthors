package Controller;

import Service.AuthorService;
import Service.BookService;

import java.util.Scanner;

public class Start {
    private AuthorController authorController;
    private BookController bookController;

    public void start() {
        while(true) {
            Scanner scanner = new Scanner(System.in);
            suggest();
            String response = scanner.nextLine();
            if (response.equals("1")) {
                try{
                    authorController.create();
                }
                catch (Exception e){
                    System.out.println(e.getMessage());
                }
            } else if (response.equals("2")) {
                try{
                    bookController.create();
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }

            } else if (response.equals("3")) {
                try {
                    authorController.delete();
                }
                catch (Exception e){
                    System.out.println(e.getMessage());
                }
            } else if (response.equals("4")) {
                try {
                    bookController.delete();
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }

            } else if (response.equals("5")) {
                authorController.read();
            } else if (response.equals("6")) {
                bookController.read();
            } else if (response.equals("7")) {
                authorController.update();
            } else if (response.equals("8")) {
                bookController.update();
            }
            else{
                System.out.println("Input valid key");
            }
        }
    }

    public void suggest() {
        System.out.println("Press 1 to create Author");
        System.out.println("Press 2 to create Book");
        System.out.println("Press 3 to delete Author");
        System.out.println("Press 4 to delete Book");
        System.out.println("Press 5 to read Author");
        System.out.println("Press 6 to read Book");
        System.out.println("Press 7 to update Author");
        System.out.println("Press 8 to update Book");
    }


    public void setAuthorController(AuthorController authorController) {
        this.authorController = authorController;
    }

    public void setBookController(BookController bookController) {
        this.bookController = bookController;
    }
}
