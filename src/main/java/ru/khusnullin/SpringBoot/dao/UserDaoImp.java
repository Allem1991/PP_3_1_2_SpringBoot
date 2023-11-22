package ru.khusnullin.SpringBoot.dao;

import org.springframework.stereotype.Repository;
import ru.khusnullin.SpringBoot.model.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
   @PersistenceContext private EntityManager entityManager;

   @Override
   public void addUser(User user) {
      entityManager.persist(user);
   }

   @Override
   public void deleteUser(long id) {
      entityManager.remove(entityManager.find(User.class, id));
   }

   @Override
   public User getUserById(long id) {
      return entityManager.find(User.class, id);
   }

   @Override
   public void updateUser(User user) {
      entityManager.merge(user);
   }

   @Override
   public List<User> listUsers() {
      TypedQuery<User> query= entityManager.createQuery("from User u", User.class);
      return query.getResultList();
   }

}
