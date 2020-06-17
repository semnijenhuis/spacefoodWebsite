package webapplication.project.spacefood.model;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {

    public static List<User> users = new ArrayList<>();
    public static List<Restaurant> restaurants = new ArrayList<>();

    static {

         User user1 = new User("Anh","Pham","test","pass");
         User user2 = new User("Sem","Nijenhuis","470066@student.saxion.nl","Test02");

         users.add(user1);
         users.add(user2);

         restaurants.add(new Restaurant("McDonalds","Dennenberg 38","7064HW","Silvolde","loveIt"));
        restaurants.add(new Restaurant("subway","Dennenberg 38","7064HW","Silvolde","loveIt"));
        restaurants.add(new Restaurant("kfc","Dennenberg 38","7064HW","Silvolde","loveIt"));
        restaurants.add(new Restaurant("dominos","Dennenberg 38","7064HW","Silvolde","loveIt"));
    }

    public static User findUserByEmail(String email){
        for (User user :users)
            if (user.getEmail() == email) {
                return user;
            }
        return null;
    }


    public static List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public static List<User> getUsers() {
        return users;
    }

    public static void addUser(User user) {
        users.add(user);
    }

    public static void addRestaurant(Restaurant restaurant) {restaurants.add(restaurant);}

    public static User verifyUser(String email, String password){
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if (user.getEmail() == email && user.getPassword()== password){
                return user;
            }
        }
        return null;
    }

    public static Restaurant getRestaurantByIndex(Integer id) {
        for (Restaurant restaurant: restaurants) {
            if (restaurant.getId() == id) {
                return restaurant;
            }

        }
        return null;
    }
}
