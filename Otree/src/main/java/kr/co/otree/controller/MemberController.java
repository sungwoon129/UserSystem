package kr.co.otree.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.otree.model.Member;
import kr.co.otree.service.MemberService;
import kr.co.otree.util.Pager;

@Controller
@RequestMapping("/search")
public class MemberController {
	private final MemberService service;
	@Inject
	public MemberController(MemberService service) {
		this.service = service;
	}

	@RequestMapping("/list")
	public String list(Model model,Pager pager) {
		
		pager.setSearch(Member.getSearch(pager.getSearchMode()));
		List<Member> list = service.getList(pager);
	
		model.addAttribute("list", list);
		return "search";
	}
	

}
