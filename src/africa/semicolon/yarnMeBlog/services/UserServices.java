package africa.semicolon.yarnMeBlog.services;

import africa.semicolon.yarnMeBlog.data.models.User;
import africa.semicolon.yarnMeBlog.dto.request.RegisterRequest;
import africa.semicolon.yarnMeBlog.dto.responses.FindUserResponse;

public interface UserServices {
    User register(RegisterRequest registerRequest);


    FindUserResponse findUser(int id);

    User register(String firstName, String lastName, String userName, String password);

    void delete(User user);

    void delete(int id);
}
