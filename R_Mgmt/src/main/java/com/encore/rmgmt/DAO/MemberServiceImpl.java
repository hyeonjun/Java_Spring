package com.encore.rmgmt.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encore.rmgmt.Service.MemberService;
import com.encore.rmgmt.Service.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDAO memberDAO;
	
	public MemberServiceImpl() {
		System.out.println("===> MemberServiceImpl() °´Ã¼ »ý¼º");
	}

	@Override
	public MemberVO getUserOne(MemberVO vo) {
		return this.memberDAO.getUserOne(vo);
	}

	@Override
	public boolean userJoin(MemberVO vo) {
		boolean result = this.memberDAO.userJoin(vo);
		MemberVO mem = this.memberDAO.getUserOne(vo);
		this.memberDAO.insertIntroduce(mem);
		return result;
	}

	@Override
	public MemberVO getUserOne(int seq) {
		// TODO Auto-generated method stub
		return this.memberDAO.getUserOne(seq);
	}

}
