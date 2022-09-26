package hiber.service;

import hiber.dao.UserDao;
import hiber.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   private final UserDao userDao;

   public UserServiceImp(UserDao userDao) {
      this.userDao = userDao;
   }

   @Override
   @Transactional
   public void addUser(User user) {
      userDao.addUser(user);
   }

   @Override
   @Transactional(readOnly = true)
   public List<User> getAllUsers() {
      return userDao.getAllUsers();
   }

   @Override
   @Transactional
   public User getUserFromCar(String model, int series) {
      return userDao.getUserFromCar(model, series);
   }

}
