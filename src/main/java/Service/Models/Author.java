package Service.Models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Author {
    public Author(){

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    private List<Book> bookList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
}
