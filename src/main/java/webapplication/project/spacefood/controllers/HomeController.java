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

    @GetMapping("/home")
    public String getHome() {
        return "homepage";
    }


    @GetMapping("")
    public String getHomepage(Model model) {
        model.addAttribute("restaurants",DataProvider.getRestaurants());
        return "homepage";
    }


    @GetMapping("/delete/{id}")
    public String getDeleteRestaurantDetails(@PathVariable("id")Integer id, HttpSession session) {
        DataProvider.deleteRestaurant(DataProvider.getRestaurantByIndex(id));
        return "redirect:/homepage";

    }

        @GetMapping("/edit/{id}")
        public String getEditRestaurantDetails(@PathVariable("id")Integer id, HttpSession session) {
            session.setAttribute("editrestaurant",DataProvider.getRestaurantByIndex(id));
        return "editrestaurant";

    }



    @PostMapping("/edit/{id}")
    public String getSetEditRestaurantDetails(@PathVariable("id")Integer id, HttpSession session, Model model) {
        model.addAttribute("restaurants",DataProvider.getRestaurants());
        DataProvider.editRestaurant(DataProvider.getRestaurantByIndex(id));
        return DataProvider.getRestaurantByIndex(id).toString();

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

    @PostMapping("/filterAZ")
    public String filterAZ(){


        return "redirect:/homepage";
    }


}


//mediaqurie