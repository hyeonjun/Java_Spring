package com.encore.rmgmt.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.encore.rmgmt.Service.MemberService;
import com.encore.rmgmt.Service.MemberVO;

@Controller("/jquery")
@RequestMapping("jquery/*")
public class JqueryController {
	
	@Autowired
	MemberService memberService;
	
	
	@RequestMapping("jquery/logout")
	public String logout(HttpSession session){
		session.removeAttribute("user");
		return "/home/login";
	}
	
	@RequestMapping(value="jquery/login", method=RequestMethod.POST)
	@ResponseBody
	public boolean login(MemberVO vo, HttpSession session){
		boolean result=false;
		MemberVO idCheck = memberService.getUserOne(vo);
		System.out.println("Jquery : "+vo.toString());
		if(idCheck == null){
			result=false;
		} else if(vo.getUserId().equals(idCheck.getUserId()) & vo.getPassword().equals(idCheck.getPassword())){ // �α��� 
			session.setAttribute("user", idCheck);
			result=true;
		} else{ // ��й�ȣ Ʋ��
			result=false;
		}
		System.out.println("===> Result : "+result);
		return result;
	} // login end
	
	@RequestMapping(value="jquery/signUp", method=RequestMethod.POST)
	@ResponseBody
	public boolean signUp(MemberVO vo){
		boolean result = false;
		MemberVO idCheck = memberService.getUserOne(vo);
		if(idCheck==null){
			result = memberService.userJoin(vo);
		}
		return result; // ȸ������
	}
	
	@RequestMapping(value="jquery/idCheck", method=RequestMethod.POST)
	@ResponseBody
	public boolean idCheck(MemberVO vo){
		boolean result = false;
		MemberVO idCheck = memberService.getUserOne(vo);
		if(idCheck==null){
			result=true; // ����
		}
		return result;
	}
	
}
