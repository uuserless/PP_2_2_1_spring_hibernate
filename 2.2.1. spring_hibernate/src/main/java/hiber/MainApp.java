package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
      User user3 = new User("User3", "Lastname3", "user3@mail.ru");
      User user4 = new User("User4", "Lastname4", "user4@mail.ru");

      Car car1 = new Car("Chevrolet", 1564345);
      Car car2 = new Car("Mercedes", 252645);
      Car car3 = new Car("Porsche", 3563445);
      Car car4 = new Car("Kia", 4455645);

      user1.setCar(car1);
      user2.setCar(car2);
      user3.setCar(car3);
      user4.setCar(car4);
      car1.setUser(user1);
      car2.setUser(user2);
      car3.setUser(user3);
      car4.setUser(user4);

      userService.addUser(user1);
      userService.addUser(user2);
      userService.addUser(user3);
      userService.addUser(user4);

      List<User> users = userService.getAllUsers();
      for (User user : users) {
         System.out.println(user.toString());
      }

      System.out.println(userService
              .getUserFromCar("Porsche", 3563445)
              .toString());

      context.close();
   }
}
