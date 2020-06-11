package webapplication.project.spacefood.model;

import java.util.ArrayList;
import java.util.List;

public class UserProvider {

    public static List<User> users = new ArrayList<>();

    static {

         User user1 = new User("Anh","Pham","470999@student.saxion.nl","Test01");
         User user2 = new User("Sem","Nijenhuis","470066@student.saxion.nl","Test02");

         users.add(user1);
         users.add(user2);
    }

    public static User findUserByEmail(String email){
        for (User user :users)
            if (user.getEmail() == email) {
                return user;
            }
        return null;
    }

    public static void addUser(String firstName, String lastName, String email, String password){
        users.add(new User(firstName,lastName,email,password));
    }


}
