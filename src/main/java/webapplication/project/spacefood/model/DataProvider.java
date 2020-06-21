package webapplication.project.spacefood.model;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {

    public static List<User> users = new ArrayList<>();
    public static List<Restaurant> restaurants = new ArrayList<>();
    public static List<MenuItem> shoppingcart = new ArrayList<>();
    public static double totalPrice;

    static {
         User user1 = new User("Anh","Pham","anhpham@spacefood","spacefood");
         User user2 = new User("Sem","Nijenhuis","semnijenhuis@spacefood","spacefood");

         users.add(user1);
         users.add(user2);

         restaurants.add(new Restaurant("Yume Deventer","Boreelplein 52","7411EH","Deventer","yume"));
         restaurants.add(new Restaurant("Ayami","Keizerstraat 41","7411HE","Deventer","love this"));
         restaurants.add(new Restaurant("I Love Sushi","Smedenstraat 54","7411RE","Deventer","i love shushi"));
         restaurants.add(new Restaurant("Pokélivery","Keizerstraat 41","7411HE","Deventer","poke"));
         restaurants.add(new Restaurant("Shalom","Grote Overstraat 69","7411JB","Deventer","master grill"));
         restaurants.add(new Restaurant("Brink Express","T.g. Gibsonstraat 24","7411RS","Deventer","Brink brink"));
         restaurants.add(new Restaurant("Barnies Kipcorner","Hoge Rij 101","7413WX","Deventer","barnes"));
         restaurants.add(new Restaurant("Big Burger Delivery","Kamperstraat 24","7418CB","Deventer","Bigger better"));
         restaurants.add(new Restaurant("Domino's Pizza","Achter de Broederen 13","7411PS","Deventer","take a slice"));
         restaurants.add(new Restaurant("Subway","Smedenstraat 14","7411RC","Deventer","the best bread"));


        MenuItem menuItem1 = new MenuItem("Fries","Frech baked patatos",1.50);
        MenuItem menuItem2 = new MenuItem("Pizza magerita","The one and only classic",5.50);
        MenuItem menuItem3 = new MenuItem("Doner kabab","the meal for the night",6.00);
        MenuItem menuItem4 = new MenuItem("Cookie","For all cookiemonsters",1.00);
        MenuItem menuItem5 = new MenuItem("Fresh Salad","to lose weight?",1.50);
        MenuItem menuItem6 = new MenuItem("Brownie","Now we are talkin!",1.50);
        MenuItem menuItem7 = new MenuItem("Milkshake","Why is it so crowed in my yard?",2.00);

        restaurants.get(0).addMenuItem(menuItem1);
        restaurants.get(0).addMenuItem(menuItem2);
        restaurants.get(0).addMenuItem(menuItem3);
        restaurants.get(0).addMenuItem(menuItem4);
        restaurants.get(0).addMenuItem(menuItem5);
        restaurants.get(0).addMenuItem(menuItem6);
        restaurants.get(0).addMenuItem(menuItem7);



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
