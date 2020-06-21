package webapplication.project.spacefood.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import webapplication.project.spacefood.model.DataProvider;

import webapplication.project.spacefood.model.MenuItem;
import webapplication.project.spacefood.model.Restaurant;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/homepage")
public class HomeController {



    @GetMapping("")
    public String getHomepage(Model model) {
        model.addAttribute("restaurants",DataProvider.getRestaurants());
        return "homepage";
    }

    @GetMapping("/redirect")
    public String getredirect( ) {

        return "redirect:/homepage";
    }


    @GetMapping("/delete/{id}")
    public String getDeleteRestaurantDetails(@PathVariable("id")Integer id, HttpSession session) {
        DataProvider.deleteRestaurant(DataProvider.getRestaurantByIndex(id));
        return "redirect:/homepage";

    }


    @GetMapping("/restaurant/{id}")
    public String getRestaurantDetails(@PathVariable("id")Integer id, HttpSession session,Model model) {
        model.addAttribute("restaurants",DataProvider.getRestaurants());
        model.addAttribute("menu",DataProvider.getRestaurants().get(id).getMenu());
        session.setAttribute("openrestaurant",DataProvider.getRestaurantByIndex(id));
        return "restaurant";

    }

    @PostMapping("/createrestaurant")
    public String createRestaurant(Restaurant restaurant) {
        DataProvider.addRestaurant(restaurant);

        System.out.print(DataProvider.getRestaurants());

        return "redirect:/homepage";
    }

    @PostMapping("/createmenuitem/{id}")
    public String createMenuItem(@PathVariable("id")Integer id,MenuItem menuItem,HttpSession session, Model model) {


        DataProvider.getRestaurantByIndex(id).addMenuItem(menuItem);
        System.out.println(DataProvider.getRestaurantByIndex(0).getMenu().toString());


        return "redirect:/homepage";
    }

    @PostMapping("/additem/{name}")
    public String addItem(@PathVariable("name")Integer name, MenuItem menuItem) {

       DataProvider.getRestaurantByIndex(name).addMenuItem(menuItem);



        String url = "redirect:/homepage/restaurant/"  +name ;

        return url;
    }



    @PostMapping("/delete/item/{name}")
    public String deleteItem(@PathVariable("name")String name) {

        String string = name;
        String[] parts = string.split("-");
        String restaurantName = parts[0];
        String menuName = parts[1];

        int restaurantIDint=Integer.parseInt(restaurantName);
        int menuIDint=Integer.parseInt(menuName);

        DataProvider.getRestaurants().get(restaurantIDint).getMenu().remove(menuIDint);

        DataProvider.calculateTotal();

        String url = "redirect:/homepage/restaurant/"  +restaurantIDint ;

        return url;
    }




}


//mediaqurie