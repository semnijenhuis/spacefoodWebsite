package webapplication.project.spacefood.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import webapplication.project.spacefood.model.DataProvider;
import webapplication.project.spacefood.model.MenuItem;
import webapplication.project.spacefood.model.Restaurant;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
@RequestMapping("/shoppingcart")
public class ShoppingCartController {


    @GetMapping("")
    public String getShoppingcart(Model model) {
        model.addAttribute("shoppingcart",DataProvider.getShoppingcart());
        model.addAttribute("totalPrice",DataProvider.calculateTotal());

        return "shoppingcart";

    }


    @PostMapping("/testadd/{name}")
    public String testRestaurant(@PathVariable("name")String name) {

        String string = name;
        String[] parts = string.split("-");
        String restaurantName = parts[0];
        String menuName = parts[1];

        int restaurantIDint=Integer.parseInt(restaurantName);
        int menuIDint=Integer.parseInt(menuName);

        DataProvider.addToShoppingCart(DataProvider.getRestaurantByIndex(restaurantIDint).getMenuItem(menuIDint));
        DataProvider.calculateTotal();

        String url = "redirect:/homepage/restaurant/"  +restaurantIDint ;

        return url;
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
