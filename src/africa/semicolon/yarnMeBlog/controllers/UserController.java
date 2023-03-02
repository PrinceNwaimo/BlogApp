package africa.semicolon.yarnMeBlog.controllers;

import africa.semicolon.yarnMeBlog.dto.request.RegisterRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import africa.semicolon.yarnMeBlog.services.UserServiceImplementation;
import africa.semicolon.yarnMeBlog.services.UserServices;

@RestController
public class UserController {
    private UserServices userService = new UserServiceImplementation();

    @PatchMapping("/register")
    public Object register(RegisterRequest request) {
        try {
            return userService.register(request);
        } catch (IllegalArgumentException ex) {
            return ex.getMessage();
        }
    }
@GetMapping("/{id}")
    public Object findUserById(@PathVariable("userId") int id) {
//        try {
//            return userService.findUser(id);
//        } catch (NullPointerException ex) {
//            return ex.getMessage();
//        }

return userService.findUser(id);
    }
}