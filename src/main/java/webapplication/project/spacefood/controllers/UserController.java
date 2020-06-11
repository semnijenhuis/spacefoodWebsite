package webapplication.project.spacefood.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import webapplication.project.spacefood.model.User;
import webapplication.project.spacefood.model.UserProvider;

@Controller
@RequestMapping("/users")
public class UserController {

    @GetMapping("")
    @ResponseBody
    public String getUsers() {
        if (UserProvider.users.isEmpty()){
            return "no users";
        }

        String results = "";
        for(User user : UserProvider.users){
            results+= user+"";
        }
        return results;
    }

    @PostMapping("")
    @ResponseBody
    public String addUser(@RequestBody String firstName, String lastName, String email, String password){

        UserProvider.addUser(firstName,lastName,email,password);
        return "Your account has been created";
    }

}
