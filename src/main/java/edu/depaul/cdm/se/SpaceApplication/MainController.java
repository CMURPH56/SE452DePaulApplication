package edu.depaul.cdm.se.SpaceApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;
import java.util.Optional;
import java.util.*;

@Controller
public class MainController {

    @Autowired
    private MemberRepository memberRepository;


    @GetMapping("/main")
     public String homepage(){
        return "main";
    }


    @GetMapping(path="/all")
    public @ResponseBody void getAllMembers(){
        System.out.println(memberRepository.getOne("CAM"));
        //return memberRepository.findAll();
    }

    @GetMapping(path="find")
    public @ResponseBody Optional<Members> checkMember(@RequestParam String UserName){
        return memberRepository.findById(UserName);
    }

    @GetMapping(path="/")
    public String loginPage(Model model){
        //System.out.println("Hello");
        model.addAttribute("login", new Login());
        return "login";
    }

    @GetMapping(path="/moon")
    public String moonPage(Model model){
        model.addAttribute("moon", new Moon());
        return "moon";
    }
    @GetMapping(path="/mars")
    public String marsPage(Model model){
        model.addAttribute("mars", new Mars());
        return "mars";
    }

    @GetMapping(path="/venus")
    public String venusPage(Model model){
        model.addAttribute("venus", new Venus());
        return "venus";
    }


    // Add users to database
    @PostMapping(path = "/login")
    public String loginSubmit(@ModelAttribute Login login){
        return "result";
    }


    @GetMapping(path="/count")
    public @ResponseBody long getNumberOfMembers(){
            return memberRepository.count();
    }


    @GetMapping(path="/members")
    public @ResponseBody List getMembers(){
        return memberRepository.findAll();
    }
}

