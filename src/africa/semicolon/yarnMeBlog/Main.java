package africa.semicolon.yarnMeBlog;

import africa.semicolon.yarnMeBlog.controllers.ArticleController;
import africa.semicolon.yarnMeBlog.controllers.UserController;
import africa.semicolon.yarnMeBlog.dto.request.RegisterRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;


@SpringBootApplication

public class Main {
    private static UserController userController = new UserController();

    private static ArticleController articleController = new ArticleController();
    public static void main(String[] args){
        SpringApplication.run(Main.class, args);

//        startApp();
    }
    private static void startApp(){
        String message = """
                Hi,what are you looking for?
                1-> Register
                2-> Find user
                """;
        String input = input(message);
        switch (input.charAt(0)){
            case '1'-> register();
            case '2'-> findUser();
            default -> {
                display("Invalid input try again");
                startApp();
            }
        }
    }
    private static void display(String message){
        JOptionPane.showMessageDialog(null,message);
    }
    private static void findUser(){
        String userInput = input("Enter user ID to search for");
        display(userController.findUserById(Integer.parseInt(userInput)).toString());
        startApp();
    }
    private static void register(){
        RegisterRequest request = new RegisterRequest();
        request.setFirstName(input("Enter first name"));
        request.setLastName(input("Enter last name"));
        request.setUserName(input("Enter userName"));
        request.setPassword(input("Enter password"));
        var result= userController.register(request);
        display(result.toString());
        startApp();
    }
    public static String input(String prompt){
        return JOptionPane.showInputDialog(prompt);
    }
}