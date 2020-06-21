package webapplication.project.spacefood.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import webapplication.project.spacefood.model.User;
import webapplication.project.spacefood.model.DataProvider;
import javax.servlet.http.HttpSession;
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

    // opens the login page
    @GetMapping("/login")
    public String getLoginPage( ) {
        return "loginscreen";
    }

    // let's you log out
    @GetMapping("/logout")
    public String logOut(HttpSession session ) {
        session.removeAttribute("userobject");
        return "loginscreen";
    }

    // the creating account page
    @GetMapping("/createaccount")
    public String getCreateAccountPage( ) {
        return "createaccount";
    }

    // creates a new account with the provided information
    @PostMapping("/createaccount")
    public String addAccount(User user) {
        DataProvider.addUser(user);
        usernames.add(user.getEmail());
        password.add(user.getPassword());
        return "redirect:/login";
    }

    // lets you login, with check if the email or password is correct
    @PostMapping("/login")
    public String checkAccount(HttpSession session, User user, Model model) {
        if(usernames.contains(user.getEmail()) ){
            for (int i = 0; i < DataProvider.users.size() ; i++) {
                User search = DataProvider.getUsers().get(i);
                System.out.println("fase1");
                if (search.getEmail().equals(user.getEmail())){
                    System.out.println("fase2");
                    if (search.getPassword().equals(user.getPassword())){
                        System.out.println("fase3");
                        session.setAttribute("userobject",search);
                        return "redirect:/homepage";
                    }
                    System.out.println("fase4");
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
