package cl.ucn.web.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HomeController {

    @GetMapping({ "/home", "/", "" })
    public String index(Model model) {
	return "home";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
	SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
	logoutHandler.logout(request, null, null);
	return "redirect:/";
    }

    @ModelAttribute("rutUser")
    public String auth() {
	return SecurityContextHolder.getContext().getAuthentication().getName();
    }

}
