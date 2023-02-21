package services;

import data.models.User;
import dto.request.RegisterRequest;
import dto.responses.FindUserResponse;

public interface UserServices {
    User register(RegisterRequest registerRequest);


    FindUserResponse findUser(int id);

    User register(String firstName, String lastName, String userName, String password);
}
