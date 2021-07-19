import Service.AuthorService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SptringApplicationContext {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
        AuthorService authorSerive = context.getBean("authorSerive", AuthorService.class);


    }
}
