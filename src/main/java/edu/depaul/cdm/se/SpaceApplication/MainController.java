package edu.depaul.cdm.se.SpaceApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private CustomerRepository planetRepository;

    @GetMapping("/")
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


    @GetMapping(path = "/login")
    public String loginPage(Model model) {
        System.out.println("login");
        model.addAttribute("member", new Members());
        return "login";
    }

    @PostMapping(path = "/new_member")
    public String loginSubmit(Model model, @ModelAttribute Members member){
        memberRepository.save(member);
        model.addAttribute("members", memberRepository.findAll());
        return "members";
    }

    @GetMapping(path="/count")
    public @ResponseBody long getNumberOfMembers(){
            return memberRepository.count();
    }

    @GetMapping(path="/members")
    public String getMembers(Model model){
        model.addAttribute("members", memberRepository.findAll());
        return "members";
    }
    @GetMapping(path="/venus")
    public  String getVenus(Model model){
        model.addAttribute("planets", planetRepository.findByFirstName("Venus"));
        System.out.println(planetRepository.findAll());
        return "venus";
    }
    @GetMapping(path="/neptune")
    public String getNeptune(Model model){
        model.addAttribute("planets", planetRepository.findByFirstName("Neptune"));
        return "Neptune";
    }
    @GetMapping(path="/mars")
    public String getMars(Model model){
        model.addAttribute("planets", planetRepository.findByFirstName("Mars"));
        return "mars";
    }


}