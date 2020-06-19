package webapplication.project.spacefood.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import webapplication.project.spacefood.model.DataProvider;
import webapplication.project.spacefood.model.MenuItem;
import webapplication.project.spacefood.model.Restaurant;

@Controller
@RequestMapping("/shoppingcart")
public class ShoppingCartController {


    @GetMapping("/open")
    public String getShoppingcart(Model model) {
        model.addAttribute("shoppingcart",DataProvider.getShoppingcart());

        return "shoppingcart";

    }

    @PostMapping("/add")
    public String addShoppingcart(Integer rId,Integer iId, Integer quantity){

        for (int i = 0; i < quantity ; i++) {

            Restaurant restaurant = DataProvider.getRestaurantByIndex(rId);
            MenuItem menuItem = restaurant.getMenuItem(iId);
            DataProvider.shoppingcart.add(menuItem);
            System.out.println(DataProvider.shoppingcart.toString());
        }
        return "redirect:/homepage";
    }

    @PostMapping
    public String deleteItem(){

        return "redirect:/homepage";

    }



}