import Controller.Start;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        Start startController = context.getBean("startController", Start.class);
        startController.start();
        System.out.println();
    }
}
