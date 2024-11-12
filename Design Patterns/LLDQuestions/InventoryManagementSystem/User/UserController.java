package LLDQuestions.InventoryManagementSystem.User;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    private List<User> users;
    private static volatile UserController userControllerInstance;

    private UserController() {
        this.users = new ArrayList<>();
    }

    public static UserController getInstance() {
        if(userControllerInstance == null) {
            synchronized(UserController.class) {
                if(userControllerInstance == null) {
                    userControllerInstance = new UserController();
                }
            }
        }
        return userControllerInstance;
    }
 
    public void signup(User user) {
        users.add(user);
    }
}
