package kr.co.otree.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.otree.model.Member;
import kr.co.otree.util.Pager;

@Repository
public class MemberDaoImpl implements MemberDao {
	private final SqlSession sql;
	
	@Inject
	public MemberDaoImpl(SqlSession sql) {
		this.sql = sql;
	}
	
	@Override
	public Member registMember(Member member) {
		sql.insert("member.registMember", member);
		return member;

	}

	@Override
	public List<Member> getList(Pager pager) {
		return sql.selectList("member.getList",pager);
	}

	@Override
	public int getTotal(Pager pager) {
		return sql.selectOne("member.total",pager);
	}

	@Override
	public int isExist(String inputType,String inputValue) {
	
		Map<String,Object> map = new HashMap<>();
		map.put("inputType",inputType);
		map.put("inputValue",inputValue);
		
		return sql.selectOne("member.isExist",map);

	}

}
