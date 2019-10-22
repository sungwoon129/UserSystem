package kr.co.otree.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.otree.dao.MemberDao;
import kr.co.otree.model.Member;
import kr.co.otree.util.Pager;

@Service
public class MemberServiceImpl implements MemberService {
	private final MemberDao dao;
	
	@Inject
	public MemberServiceImpl(MemberDao dao) {
		this.dao = dao;
	}
	


	@Override
	public Member registMemeber(Member member) {
		return dao.registMember(member);
	}

	@Transactional
	@Override
	public List<Member> getList(Pager pager) {
		int total = dao.getTotal(pager);
		pager.setTotal(total);
		return dao.getList(pager);
	}



	@Override
	public int isExist(String inputType,String inputValue) {
		return dao.isExist(inputType,inputValue);
	}

}
