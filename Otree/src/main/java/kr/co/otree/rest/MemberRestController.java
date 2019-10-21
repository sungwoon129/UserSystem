package kr.co.otree.rest;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import kr.co.otree.model.Member;
import kr.co.otree.service.MemberService;
import kr.co.otree.util.Pager;


@RestController

public class MemberRestController {
	
	private final MemberService service;
	
	@Inject
	public MemberRestController(MemberService service) {
		
		this.service = service;
	}
	
	
	@RequestMapping(value="/member/list",method=RequestMethod.GET)
	public ResponseEntity<List<Member>> getList(Pager pager) {
		final List<Member> allMembers = service.getList(pager);
		if(allMembers.isEmpty()) {
			return new ResponseEntity<List<Member>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Member>>(allMembers,HttpStatus.OK);
	}
	

	
	@RequestMapping(value="/member/{name}",method=RequestMethod.POST)
	public ResponseEntity<Void> registerMember(@RequestBody Member member, 
			@PathVariable("name") String name,UriComponentsBuilder ucBuilder) {
		

		final Member savedMember = service.registMemeber(member);
		
	
		HttpHeaders headers =new HttpHeaders();
		headers.setLocation(ucBuilder.path("/member/{name}").buildAndExpand(savedMember.getName()).toUri());
		
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
	}
	
	
}
