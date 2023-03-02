package utils;

import data.models.Article;
import data.models.User;
import dto.request.CreateArticleRequest;
import dto.request.RegisterRequest;
import dto.responses.FindUserResponse;

import java.time.format.DateTimeFormatter;

public class Mapper {
    public static User map(RegisterRequest registerRequest){
        User user = new User();
        user.setUsername(registerRequest.getUserName());
        user.setFirstName(registerRequest.getFirstName());
        user.setLastName(registerRequest.getLastName());
        user.setPassWord(registerRequest.getPassword());
        return user;
    }
    //or you use map like this
    public static void map(RegisterRequest registerRequest, User user){
        user.setUsername(registerRequest.getUserName());
        user.setFirstName(registerRequest.getFirstName());
        user.setLastName(registerRequest.getLastName());
        user.setPassWord(registerRequest.getPassword());

    }

    public static void map(User foundUser, FindUserResponse response){
        response.setFullName(foundUser.getFirstName()+ " "+ foundUser.getLastName());
        response.setUserId(foundUser.getId());
        response.setUserName(foundUser.getUsername());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E,dd/mm/yyyy, hh:mm a");
        response.setDateRegistered(formatter.format(foundUser.getDateRegistered));
    }
    public static void map(CreateArticleRequest createArticleRequest, Article article) {
        article.setBody(createArticleRequest.getBody());
        article.setTitle(createArticleRequest.getTitle());
        article.setAuthorID(createArticleRequest.getAuthorID());
    }
}
