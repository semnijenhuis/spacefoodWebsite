package webapplication.project.spacefood.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("")
public class CookieController {

    @GetMapping(path = "cookiehome")
    public String getCookie(HttpServletResponse response,
                            @CookieValue(value = "homecount", defaultValue = "0") int counterValue,
                            Model model) {
        counterValue++;
        Cookie cookie = new Cookie("homecount", "" + counterValue);

        cookie.setMaxAge(3600*24 * 7); //
        response.addCookie(cookie);

        model.addAttribute("numberOfVisits", counterValue);

        return "redirect:/homepage/";
    }

}
