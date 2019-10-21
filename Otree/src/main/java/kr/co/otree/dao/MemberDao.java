package kr.co.otree.dao;

import java.util.List;

import kr.co.otree.model.Member;
import kr.co.otree.util.Pager;

public interface MemberDao {

	Member registMember(Member member);

	List<Member> getList(Pager pager);

	int getTotal(Pager pager);

	int isExist(String inputType, String inputValue);

}
