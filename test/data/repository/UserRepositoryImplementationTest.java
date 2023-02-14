package data.repository;

import data.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryImplementationTest {
    private UserRepository userRepository;
    private  User user;
    @BeforeEach
    public void setUp(){
        userRepository = new UserRepositoryImplementation();
        user = new User();
        user.setFirstName("Prince");
        user.setLastName("Nwaimo");
        user.setUsername("UserName");
        user.setPassWord("Password");
    }
 @Test
    public void saveOneUser_CountIsOneTest(){
     User user = new User();
     userRepository.save(user);
     assertEquals(1,userRepository.count());

 }
 @Test
    public void saveOneUser_idOfUserIsOneTest(){
        User savedUser = userRepository.save(user);
        assertEquals(1,savedUser.getId());

 }
 @DisplayName("Update User test")
 @Test
    public void saveTwoUsersWithSameId_countIsOneTest(){
        User savedUser = userRepository.save(user);
        assertEquals(1,userRepository.count());
        savedUser.setLastName("Nwaimo");
        userRepository.save(savedUser);
        assertEquals(1,userRepository.count());

 }
 @Test
    public void saveOneUser_findUserById(){
        User savedUser =userRepository.save(user);
        assertEquals(1,savedUser.getId());
        User foundUser = userRepository.findById(1);
        assertEquals(foundUser,savedUser);
 }
 @Test
    public void saveOneUser_deleteOneUser_countIsZeroTest(){
        User savedUser = userRepository.save(user);
        assertEquals(1,userRepository.count());
        userRepository.delete(1);
        assertEquals(0,userRepository.count());
 }
 @Test
    public void deleteUsersTest(){
        User savedUser = userRepository.save(user);
        assertEquals(1,userRepository.count());
        userRepository.delete(user);
        assertEquals(0,userRepository.count());
 }
 @Test
   public void deleteAllUsersTest(){
        User savedUser = userRepository.save(user);
         savedUser = userRepository.save(user);
         assertEquals(2,userRepository.count());
         userRepository.deleteAll();
         assertEquals(0,userRepository.count());

 }
 @Test
    public void findAllUsersTest(){
        User savedUser = userRepository.save(user);
        savedUser = userRepository.save(user);
        assertEquals(2,userRepository.count());
        userRepository.findAll();
     assertEquals(2,userRepository.count());
 }
}