package kr.co.otree.service;

import java.util.List;

import kr.co.otree.model.Member;
import kr.co.otree.util.Pager;

public interface MemberService {

	Member registMemeber(Member member);

	List<Member> getList(Pager pager);

	int isExist(String inputType, String inputValue);

}
