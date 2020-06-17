package webapplication.project.spacefood.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import webapplication.project.spacefood.model.DataProvider;
import webapplication.project.spacefood.model.Restaurant;
import webapplication.project.spacefood.model.User;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/homepage")
public class HomeController {

    @GetMapping("")
    public String getHomepage(Model model) {

        model.addAttribute("restaurants",DataProvider.getRestaurants());
        return "homepage";
    }

    @GetMapping("/restaurant/{id}")
    public String getRestaurantDetails(@PathVariable("id")Integer id, HttpSession session) {
        session.setAttribute("choosenrestaurant",DataProvider.getRestaurantByIndex(id));
        return "restaurant";

    }

    @PostMapping("/createrestaurant")
    public String createRestaurant(Restaurant restaurant) {
        DataProvider.addRestaurant(restaurant);



        System.out.print(DataProvider.getRestaurants());

        return "redirect:/homepage";
    }
}
