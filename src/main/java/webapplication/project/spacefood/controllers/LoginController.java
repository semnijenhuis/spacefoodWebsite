package webapplication.project.spacefood.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import webapplication.project.spacefood.model.User;
import webapplication.project.spacefood.model.DataProvider;

import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.util.ArrayList;

@Controller
@RequestMapping("")
public class LoginController {

    private ArrayList<String> usernames = new ArrayList<>();
    private ArrayList<String> password = new ArrayList<>();
    private ArrayList<String> firstnames = new ArrayList<>();
    private ArrayList<String> lastname = new ArrayList<>();

    public LoginController(){

        for (int i = 0; i < DataProvider.getUsers().size(); i++) {
            usernames.add(DataProvider.getUsers().get(i).getEmail());
            password.add(DataProvider.getUsers().get(i).getPassword());
            lastname.add(DataProvider.getUsers().get(i).getLastName());
        }

    }

    @GetMapping("/login")
    public String getLoginPage( ) {
        return "loginscreen";
    }

    @GetMapping("/logout")
    public String logOut(HttpSession session ) {
        session.removeAttribute("userobject");

        return "loginscreen";
    }

    @GetMapping("/createaccount")
    public String getCreateAccountPage( ) {
        return "createaccount";
    }

    @PostMapping("/createaccount")
    public String addAccount(User user, Model model) {


        DataProvider.addUser(user);
        usernames.add(user.getEmail());
        password.add(user.getPassword());

        return "redirect:/login";
    }

    @PostMapping("/login")
    public String checkAccount(HttpSession session, User user, Model model) {

        if(usernames.contains(user.getEmail()) && password.contains(user.getPassword() )){

            for (int i = 0; i < DataProvider.users.size() ; i++) {
                User search = DataProvider.getUsers().get(i);

                if (search.getEmail().equals(user.getEmail())){


                    if (search.getPassword().equals(user.getPassword())){

                        session.setAttribute("userobject",search);
                        return "redirect:/homepage";
                    }
                    model.addAttribute("errormessage","password incorrect ");
                    return "loginscreen";
                }

            }

            return "redirect:/homepage";
        }
        model.addAttribute("errormessage","email doesnot excist");
        return "loginscreen";
    }



}
