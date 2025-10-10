package com.pap.freejobs_website.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String loginPage(@RequestParam(value = "error" , required = false) String error,
                            @RequestParam(value = "logout" , required = false) String logout,
                            Model model,
                            Authentication authentication){

        //Se utilizador estiver logado, é redirecionado para homepage
        if(authentication != null && authentication.isAuthenticated()){
            return "redirect:/";
        }

        if (error != null){
            model.addAttribute("errorMsg" , "true");

        }
        if (logout != null){
            model.addAttribute("logoutMsg" , "true");
        }

        return "login";

    }

    @GetMapping("/loginredirecionado")
    public String loginRedirect(RedirectAttributes redirectAttributes,
                                Authentication authentication){
        //Se utilizador estiver logado, é redirecionado para homepage
        if(authentication != null && authentication.isAuthenticated()){
            return "redirect:/";
        }

        redirectAttributes.addFlashAttribute("loginnecessario", true);
        return "redirect:/login";
    }
}
