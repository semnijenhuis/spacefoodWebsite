package webapplication.project.spacefood.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import webapplication.project.spacefood.model.DataProvider;

import java.util.Objects;

@Controller
@RequestMapping("/shoppingcart")
public class ShoppingCartController {

    // opens the shopping cart and calculates the total
    @GetMapping("")
    public String getShoppingcart(Model model) {
        model.addAttribute("shoppingcart",DataProvider.getShoppingcart());
        model.addAttribute("totalPrice",DataProvider.calculateTotal());
        return "shoppingcart";
    }

    // adds the choosen menu item to the shopping cart
    @PostMapping("/testadd/{name}")
    public String testRestaurant(@PathVariable("name")String name) {

        String[] parts = name.split("-");
        String restaurantName = parts[0];
        String menuName = parts[1];

        int restaurantIDint=Integer.parseInt(restaurantName);
        int menuIDint=Integer.parseInt(menuName);

        DataProvider.addToShoppingCart(Objects.requireNonNull(DataProvider.getRestaurantByIndex(restaurantIDint)).getMenuItem(menuIDint));
        DataProvider.calculateTotal();

        return "redirect:/homepage/restaurant/"  +restaurantIDint;
    }
}
