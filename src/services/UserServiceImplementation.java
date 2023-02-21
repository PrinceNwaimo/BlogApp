package services;

import controllers.UserController;
import data.models.User;
import data.repository.UserRepository;
import data.repository.UserRepositoryImplementation;
import dto.request.RegisterRequest;
import dto.responses.FindUserResponse;
import utils.Mapper;

import java.time.format.DateTimeFormatter;


public class UserServiceImplementation implements UserServices{
    private UserRepository userRepository = new UserRepositoryImplementation();
    @Override
    public User register(RegisterRequest registerRequest) {
//        if(userExist(registerRequest.getUserName()))throw new IllegalArgumentException(registerRequest.getUserName() + "already exist");
//        return userRepository.save(Mapper.map(registerRequest));//first code
//        //second mapper
//        if(userExist(registerRequest.getUserName()))throw new IllegalArgumentException(registerRequest.getUserName() + "already exist");
        User user = new User();
        Mapper.map(registerRequest,user);
        return userRepository.save(user);
    }
    private boolean userExist(String userName){
        User foundUser = userRepository.findByUsername(userName);
        if (foundUser!= null)return true;
        return false;
    }

    @Override
    public FindUserResponse findUser(int id) {
        User foundUser = userRepository.findById(id);
        FindUserResponse response = new FindUserResponse();
       response.setFullName(foundUser.getFirstName()+ " "+ foundUser.getLastName());
       response.setUserId(foundUser.getId());
       response.setUserName(foundUser.getUsername());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E,dd/mm/yyyy, hh:mm a");
        response.setDateRegistered(formatter.format(foundUser.getDateRegistered));
        Mapper.map(foundUser,response);
        return response;
    }

    @Override
    public User register(String firstName, String lastName, String userName, String password) {
        return null;
    }


}
