package africa.semicolon.yarnMeBlog.services;

import africa.semicolon.yarnMeBlog.data.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplementationTest {
    private UserServices userService;
    @BeforeEach
    public void setUp(){
        userService = new UserServiceImplementation();
    }
@Test
    public void test_thatNewUser_IDIsNotZero(){
        User savedUser = userService.register("Prince","Nwaimo","Ababa","1234");
        assertTrue(savedUser.getId()!=0);
}
@Test
    public void test_duplicatedUserNameThrowsException(){
    User savedUser = userService.register("prince","Nwaimo","Ababa","1234");
    assertThrows (IllegalArgumentException.class,()-> userService.register("Prince","Nwaimo","Ababa","1234"));

}
@Test
    public void test_findUserByID(){
    User savedUser = userService.register("Prince","Nwaimo","Ababa","1234");
    assertEquals("Prince",userService.findUser(1).getFullName());
}
}