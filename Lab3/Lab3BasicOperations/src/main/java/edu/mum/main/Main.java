package edu.mum.main;


 import java.util.List;

 import edu.mum.dao.UserDao;
 import edu.mum.dao.impl.UserDaoImpl;
 import org.springframework.context.ApplicationContext;
 import org.springframework.context.support.ClassPathXmlApplicationContext;

 import edu.mum.domain.User;
 import edu.mum.service.UserService;

 import javax.persistence.EntityManager;
 import javax.persistence.EntityManagerFactory;
 import javax.persistence.Persistence;

public class Main {

    private static UserService service;

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "context/applicationContext.xml");
        service = (UserService) ctx.getBean("userServiceImpl");
        createUser();
        getUser();
    }

    public static void createUser() {

        User user = new User();
        user.setAdmin(false);
        user.setVersion(0);
        user.setRating(1);
        user.setEmail("dawit@gmail.com");
        user.setLastName("Woldegiorgis");
        user.setFirstName("Dawit");
        service.save(user);
    }

    public static void getUser() {
        User dbUser = service.findByEmail("dawit@gmail.com");
        System.out.println("*********  User  *********\n" +
                "User Name: " + dbUser.getFirstName() + " " + dbUser.getLastName());
    }
 }