package webapplication.project.spacefood.model;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {

    private static Alphabet alphabetcheck;
    public static List<User> users = new ArrayList<>();
    public static List<Restaurant> restaurants = new ArrayList<>();
    public static List<MenuItem> shoppingcart = new ArrayList<>();
    public static char[] list = {'a','b'};
   public static char[] alphabets = "abcdefghijklmnopqrstuvwxyz".toCharArray();


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


    public  static void checkWord (){
        List<Restaurant> beginalphabetRestaurant = getRestaurants();
        List<Restaurant> endalphabetRestaurant = null;


        String lowest;
        int index = 0;

        for (int i = 0; i < beginalphabetRestaurant.size(); i++) {
            Restaurant chosenOne = beginalphabetRestaurant.get(i);
            int number = alphabetcheck.check(chosenOne.getName().charAt(0));

            for (int j = 0; j < restaurants.size() ; j++) {
                if( alphabetcheck.check(restaurants.get(j).getName().charAt(0)) <number){
                    chosenOne = beginalphabetRestaurant.get(j);
                }

                endalphabetRestaurant.add(chosenOne);
                //beginalphabetRestaurant.remove(chosenOne);
                System.out.println(" ");
                System.out.println(beginalphabetRestaurant);
                System.out.println(endalphabetRestaurant);



            }
        }



    }



    public static List<MenuItem> getShoppingcart() {
        return shoppingcart;
    }

    public static void addToShoppingCart(MenuItem menuItem){
        shoppingcart.add(menuItem);
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

    public static void editRestaurant(Restaurant restaurant) {
        for (int i = 0; i < restaurants.size() ; i++) {
            Restaurant edit = restaurants.get(i);
            if(restaurant.getId() == edit.getId()){
                restaurants.get(i).setName(restaurant.getName());
                restaurants.get(i).setQuote(restaurant.getQuote());
                restaurants.get(i).setAddress(restaurant.getAddress());
                restaurants.get(i).setZipCode(restaurant.getZipCode());
                restaurants.get(i).setCity(restaurant.getCity());
            }
        }
    }


    public static void deleteRestaurant(Restaurant restaurant) {
        for (int i = 0; i < restaurants.size() ; i++) {
            Restaurant delete = restaurants.get(i);
            if(restaurant.getId() == delete.getId()){
                restaurants.remove(i);
            }
        }
    }

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

    public static MenuItem getMenuItembyIndex(Integer rId, Integer iId) {
        for (int i = 0; i <getRestaurantByIndex(rId).getMenu().size() ; i++) {
            MenuItem menuItem = getRestaurantByIndex(rId).getMenu().get(i);

            if(menuItem.getId() == iId){
                return menuItem;
            }
        }
        return null;
    }

}
