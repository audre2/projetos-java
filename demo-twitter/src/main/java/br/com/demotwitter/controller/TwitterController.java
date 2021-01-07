package br.com.demotwitter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.demotwitter.model.DemoTwitterResponseDto;
import br.com.demotwitter.service.TwitterService;

@RestController
public class TwitterController {
	
	@Autowired
	TwitterService twitterService;
	
	@GetMapping("/user/{username}")
    public DemoTwitterResponseDto getTopHashtagFromUser(@PathVariable("username") String username) {
		String user = twitterService.getUsernameId(username);
		return twitterService.getTopHashtagFromUser(user);
    }

}
