package com.encore.rmgmt.Service;

public interface MemberService {
	
	MemberVO getUserOne(MemberVO vo);
	
	MemberVO getUserOne(int seq);
	
	boolean userJoin(MemberVO vo);
	
}
