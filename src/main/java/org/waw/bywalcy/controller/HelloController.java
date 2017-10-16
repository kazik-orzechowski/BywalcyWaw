package org.waw.bywalcy.controller;

import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("connect")
public class HelloController {

    private Facebook facebook;
    private ConnectionRepository connectionRepository;

    public HelloController(Facebook facebook, ConnectionRepository connectionRepository) {
        this.facebook = facebook;
        this.connectionRepository = connectionRepository;
    }

    @GetMapping("/status")
    public String helloFacebook(Model model) {
    	
    	System.err.println(1);
        if (connectionRepository.findPrimaryConnection(Facebook.class) == null) {
        	return "redirect:/connect/facebook";
        }
        PagedList<Post> feed = facebook.feedOperations().getFeed();

        
        model.addAttribute("feed", feed);

        return "hello";
    }


@GetMapping("/connect")
    public String loginFacebook(Model model) {
    	
            	return "redirect:/connect/facebook";
        }

} 
//    
