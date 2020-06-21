package webapplication.project.spacefood.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import webapplication.project.spacefood.model.DataProvider;
import webapplication.project.spacefood.model.MenuItem;
import webapplication.project.spacefood.model.Restaurant;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
@RequestMapping("/homepage")
public class HomeController {

    // opens the homepage
    @GetMapping("")
    public String getHomepage(Model model) {
        model.addAttribute("restaurants",DataProvider.getRestaurants());
        return "homepage";
    }

    // search a restaurant
    @GetMapping("/searchrestaurant")
    public String searchRestaurant(String name, Model model) {
        model.addAttribute("restaurants",DataProvider.getSearchList(name));
        return "homepage";
    }

    // opens the restaurant you've clicked
    @GetMapping("/restaurant/{id}")
    public String getRestaurantDetails(@PathVariable("id")Integer id, HttpSession session,Model model) {
        model.addAttribute("restaurants",DataProvider.getRestaurants());
        model.addAttribute("menu",DataProvider.getRestaurants().get(id).getMenu());
        session.setAttribute("openrestaurant",DataProvider.getRestaurantByIndex(id));
        return "restaurant";

    }

    // creates a new restaurant
    @PostMapping("/createrestaurant")
    public String createRestaurant(Restaurant restaurant) {
        DataProvider.addRestaurant(restaurant);
        System.out.print(DataProvider.getRestaurants());
        return "redirect:/homepage";
    }

    // Deletes restaurant you've choosen
    @GetMapping("/delete/{id}")
    public String getDeleteRestaurantDetails(@PathVariable("id") Integer id) {
        DataProvider.deleteRestaurant(DataProvider.getRestaurantByIndex(id));
        return "redirect:/homepage";

    }

    // creates a new menu item inside the restaurant you are
    @PostMapping("/additem/{name}")
    public String addItem(@PathVariable("name")Integer name, MenuItem menuItem) {
       Objects.requireNonNull(DataProvider.getRestaurantByIndex(name)).addMenuItem(menuItem);
        return "redirect:/homepage/restaurant/"  +name;
    }

    // Deletes a  menu item inside the restaurant you are
    @PostMapping("/delete/item/{name}")
    public String deleteItem(@PathVariable("name")String name) {

        String[] parts = name.split("-");
        String restaurantName = parts[0];
        String menuName = parts[1];

        int restaurantIDint=Integer.parseInt(restaurantName);
        int menuIDint=Integer.parseInt(menuName);

        DataProvider.getRestaurants().get(restaurantIDint).getMenu().remove(menuIDint);

        return "redirect:/homepage/restaurant/"  +restaurantIDint;
    }
}
