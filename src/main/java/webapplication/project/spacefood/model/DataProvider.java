package webapplication.project.spacefood.model;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {

    public static List<User> users = new ArrayList<>();
    public static List<Restaurant> restaurants = new ArrayList<>();
    public static List<MenuItem> shoppingcart = new ArrayList<>();
    public static double totalPrice;

    static {
         User user1 = new User("Anh","Pham","test","pass");
         User user2 = new User("Sem","Nijenhuis","470066@student.saxion.nl","Test02");

         users.add(user1);
         users.add(user2);
         restaurants.add(new Restaurant("McDonalds","Dennenberg 38","7064HW","Silvolde","loveIt"));
         restaurants.add(new Restaurant("subway","Dennenberg 38","7064HW","Silvolde","loveIt"));
         restaurants.add(new Restaurant("kfc","Dennenberg 38","7064HW","Silvolde","loveIt"));
         restaurants.add(new Restaurant("dominos","Dennenberg 38","7064HW","Silvolde","loveIt"));

         MenuItem menuItem1 = new MenuItem("Fries1","Frech baked patatos",55.7);
         restaurants.get(0).addMenuItem(menuItem1);
         shoppingcart.add(menuItem1);

    }

    // calculates the total of the shopping cart
    public static double calculateTotal(){
        totalPrice = 0;
        for (MenuItem menuItem : shoppingcart) {
            totalPrice += menuItem.getPrice();
        }
        System.out.println(totalPrice);
        return totalPrice;
    }

    // search if the searched restaurant is there
    public static List<Restaurant> getSearchList(String search){
       List<Restaurant>  searchedRestaurants = new ArrayList<>();
        for (int i = 0; i < restaurants.size(); i++) {
            if (DataProvider.getRestaurants().get(i).getName().contains(search)){
                    searchedRestaurants.add(DataProvider.getRestaurants().get(i));
                }
        }
        return searchedRestaurants;
    }

    // adds item to the shopping cart
    public static void addToShoppingCart(MenuItem menuItem){
        shoppingcart.add(menuItem);
    }

    // adds a new user to the system
    public static void addUser(User user) {
        users.add(user);
    }

    // deletes a restaurant
    public static void deleteRestaurant(Restaurant restaurant) {
        for (int i = 0; i < restaurants.size() ; i++) {
            Restaurant delete = restaurants.get(i);
            if(restaurant.getId() == delete.getId()){
                restaurants.remove(i);
            }
        }
    }

    // gets restaurant by specific name
    public static Restaurant getRestaurantByIndex(Integer id) {
        for (Restaurant restaurant: restaurants) {
            if (restaurant.getId() == id) {
                return restaurant;
            }

        }
        return null;
    }

    // adds a new restaurant to the system
    public static void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);}

    public static List<MenuItem> getShoppingcart() {
        return shoppingcart;
    }

    public static List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public static List<User> getUsers() {
        return users;
    }



}
