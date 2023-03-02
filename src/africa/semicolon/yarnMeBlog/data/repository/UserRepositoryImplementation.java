package africa.semicolon.yarnMeBlog.data.repository;

import africa.semicolon.yarnMeBlog.data.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImplementation implements UserRepository {
    private int count;
    private List<User> users = new ArrayList<>();

    @Override
    public User save(User user) {
        boolean userHasNotBeenSaved = user.getId() == 0;
        if (userHasNotBeenSaved) saveNew(user);
        user.setId(generateUserId());
        users.add(user);
        count++;

        return user;
    }

    private void saveNew(User user) {
        user.setId(generateUserId());
        users.add(user);
    }

    private int generateUserId() {
        return count + 1;
    }

    @Override
    public User findById(int id) {
        for (User user : users)
            if (user.getId() == id) return user;
        return null;
    }

    @Override
    public long count() {
        return count;
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public void delete(User user) {
        for (User user1 : users) {
            users.remove(user);
            count--;
            break;
        }

    }

    @Override
    public void delete(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                users.remove(user);
                count--;
                break;
            }
        }

    }

    @Override
    public void deleteAll() {
        users.clear();
        count = 0;
    }

    @Override
    public User findByUsername(String userName) {
        for(User user : users){
            if(user.getUsername().equalsIgnoreCase(userName));
            return user;
        } return null;
    }



}