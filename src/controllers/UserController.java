package controllers;

import dto.request.RegisterRequest;
import services.UserServiceImplementation;
import services.UserServices;

public class UserController {
    private UserServices userService = new UserServiceImplementation();

    public Object register(RegisterRequest request) {
        try {
            return userService.register(request);
        } catch (IllegalArgumentException ex) {
            return ex.getMessage();
        }
    }

    public Object findUserById(int id) {
        try {
            return userService.findUser(id);
        } catch (NullPointerException ex) {
            return ex.getMessage();
        }

    }
}