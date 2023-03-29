package com.jcg.mapstruct.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jcg.mapstruct.model.FeedBack;
import com.jcg.mapstruct.service.FeedBackService;
//mark ascontroller
@RestController
@RequestMapping("/FeedBack")
public class FeedBackController {
	@Autowired
	private FeedBackService feedBackService;
	//simple api
	@GetMapping("/fb")
	public String getFeedBack()
	{
		return "FeedBack";
		
	}
	//creating a get mapping that retrieves the detail of a specific book
	@PostMapping("/save")
	public FeedBack CreateFeedBack(@RequestBody FeedBack feedBack)
	{
		return feedBackService.addFeedBack(feedBack);
		
	}
	
	
	public FeedBackService getFeedBackService() {
		return feedBackService;
	}
	public void setFeedBackService(FeedBackService feedBackService) {
		this.feedBackService = feedBackService;
	}
	

}
