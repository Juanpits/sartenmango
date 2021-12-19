package com.example.sarten.repositorio;

import com.example.sarten.interfaces.InterfaceUser;
import com.example.sarten.modelo.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Juan Pablo
 */
@Repository
public class UserRepositorio {
    /**
     * 
     */
    @Autowired
    private InterfaceUser userCrudRepository;
    /**
     * 
     */
    @Autowired
    private MongoTemplate mongoTemplate;
    /**
     * 
     * @return 
     */
    public List<User> getAll() {
        return (List<User>) userCrudRepository.findAll();
    }
    /**
     * 
     * @param id
     * @return 
     */
    public Optional<User> getUser(int id) {
        return userCrudRepository.findById(id);
    }
    /**
     * 
     * @param user
     * @return 
     */
    public User create(User user) {
        return userCrudRepository.save(user);
    }
    /**
     * 
     * @param user 
     */
    public void update(User user) {
        userCrudRepository.save(user);
    }
    /**
     * 
     * @param user 
     */
    public void delete(User user) {
        userCrudRepository.delete(user);
    }
    /**
     * 
     * @param email
     * @return 
     */
    public boolean emailExists(String email) {
        Optional<User> usuario = userCrudRepository.findByEmail(email);
        
        return !usuario.isEmpty();
    }
    /**
     * 
     * @param email
     * @param password
     * @return 
     */
    public Optional<User> authenticateUser(String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }
    /**
     * 
     * @return 
     */
    public Optional<User> lastUserId(){
        return userCrudRepository.findTopByOrderByIdDesc();
    }
    /**
     * 
     * @param monthBirthtDay
     * @return 
     */
    //Reto 5
    public List<User> birthtDayList(String monthBirthtDay) {
        return userCrudRepository.findByMonthBirthtDay(monthBirthtDay);
    }
}
