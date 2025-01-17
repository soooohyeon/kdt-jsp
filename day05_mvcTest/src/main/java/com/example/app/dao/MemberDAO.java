package com.example.app.dao;

import org.apache.ibatis.session.SqlSession;

import com.example.app.dto.MemberDTO;
import com.mybatis.config.MyBatisConfig;

public class MemberDAO {
	public SqlSession sqlSession;

	public MemberDAO() {
		this.sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	public void join (MemberDTO memberDTO) {
		sqlSession.insert("member.join", memberDTO);
	}
	
	public MemberDTO login (String memberId, String memberPassword) {
		MemberDTO memberDTO = new MemberDTO();
		
		memberDTO.setMemberId(memberId);
		memberDTO.setMemberPw(memberPassword);
//		memberDTO = memberDTO.login(memberId, memberPassword);
		
		return sqlSession.selectOne("member.login", memberDTO);	
	}
	
}
