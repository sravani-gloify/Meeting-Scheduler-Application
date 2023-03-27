package com.jcg.mapstruct.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcg.mapstruct.model.FeedBack;
import com.jcg.mapstruct.repository.FeedBackRepository;

@Service
public class FeedBackService {
    
	@Autowired
	private FeedBackRepository feedBackRepository;
		
	
	
	public FeedBack addFeedBack(FeedBack feedBack) {
		
		return feedBackRepository.save(feedBack);
	}



	public FeedBackRepository getFeedBackRepository() {
		return feedBackRepository;
	}



	public void setFeedBackRepository(FeedBackRepository feedBackRepository) {
		this.feedBackRepository = feedBackRepository;
	}
	

}
