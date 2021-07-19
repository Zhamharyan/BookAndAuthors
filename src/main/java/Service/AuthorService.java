package Service;

import Controller.Models.AuthorRequestModel;
import Data.DAO;
import Service.Models.Author;
import org.hibernate.Session;

import java.util.List;

public class AuthorService {
    private DAO dao;
    public void create(AuthorRequestModel authorRequestModel) throws Exception{
        if(authorRequestModel.getName().equals("")){
            throw new Exception("The author name can not be null");
        }
        Author author = new Author();
        author.setName(authorRequestModel.getName());
        dao.createAuthor(author);
    }
    public List<Author> readAll(){
        return dao.readAllAuthors();
    }
    public Author read(String id) throws Exception{
        int authorIdInt = 0;
        try {
            authorIdInt = Integer.parseInt(id);
        }
        catch (Exception e){
            throw new Exception("The author id must be number");
        }
        return dao.readAuthorById(authorIdInt);
    }

    public void deleteById(String id)throws Exception{
        try {
            int authorId = Integer.parseInt(id);
            if(!readAll().stream().anyMatch(each->each.getId()==authorId)){
                throw new Exception("There is no author witch such id");
            }
            dao.deleteAuthor(authorId);
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new Exception("The author id must be number");
        }

    }





    public void setDao(DAO dao) {
        this.dao = dao;
    }
}
