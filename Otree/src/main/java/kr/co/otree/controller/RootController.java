package kr.co.otree.controller;


import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.otree.model.Member;
import kr.co.otree.service.MemberService;


@Controller

public class RootController {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	private final MemberService service;
	
	@Inject
	public RootController(MemberService service) {
		this.service = service;
	}
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="/signUp",method=RequestMethod.POST)
	public String signUp(Member member) {
		service.registMemeber(member);
		return "redirect:search/list";
		
	}
	
	@RequestMapping(value="/isExist",method=RequestMethod.GET)
	@ResponseBody
	public int isExist(String inputType,String inputValue) {

		return service.isExist(inputType,inputValue);
	}
	
}
