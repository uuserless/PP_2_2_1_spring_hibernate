package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   private final SessionFactory sessionFactory;

   public UserDaoImp(SessionFactory sessionFactory) {
      this.sessionFactory = sessionFactory;
   }

   @Override
   @Transactional
   public void addUser(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @Transactional
   public List<User> getAllUsers() {
      return sessionFactory.getCurrentSession()
              .createQuery("from User", User.class).getResultList();
   }

   @Override
   @Transactional
   public User getUserFromCar(String model, int series) {
      Car car = sessionFactory.getCurrentSession().
              createQuery("select car " +
                      "from Car car " +
                      "where car.model = :model " +
                      "and car.series = :series", Car.class)
              .setParameter("model", model)
              .setParameter("series", series)
              .getSingleResult();
      return car.getUser();
   }

}
