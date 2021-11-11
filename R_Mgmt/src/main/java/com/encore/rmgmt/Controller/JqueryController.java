package com.encore.rmgmt.Controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.encore.rmgmt.DAO.UploadFileUtil;
import com.encore.rmgmt.Service.IntroduceService;
import com.encore.rmgmt.Service.IntroduceVO;
import com.encore.rmgmt.Service.MemberService;
import com.encore.rmgmt.Service.MemberVO;
import com.encore.rmgmt.Service.ProjectService;
import com.encore.rmgmt.Service.ProjectVO;

@Controller("/jquery")
@RequestMapping("jquery/*")
public class JqueryController {
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	IntroduceService introService;

	@Autowired
	ProjectService projectService;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	@RequestMapping("jquery/logout")
	public String logout(HttpSession session){
		session.removeAttribute("user");
		session.removeAttribute("seq");
		return "/home/login";
	}
	
	@RequestMapping(value="jquery/login", method=RequestMethod.POST)
	@ResponseBody
	public boolean login(MemberVO vo, HttpSession session){
		boolean result=false;
		MemberVO idCheck = memberService.getUserOne(vo);
		if(idCheck == null){
			result=false;
		} else if(vo.getUserId().equals(idCheck.getUserId()) & vo.getPassword().equals(idCheck.getPassword())){ // 로그인 
			session.setAttribute("user", idCheck.getUserId());
			session.setAttribute("seq", idCheck.getSeq());
			result=true;
		} else{ // 비밀번호 틀림
			result=false;
		}
		System.out.println("Jquery : "+idCheck.toString());
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
		return result; // 회원가입
	}
	
	@RequestMapping(value="jquery/idCheck", method=RequestMethod.POST)
	@ResponseBody
	public boolean idCheck(MemberVO vo){
		boolean result = false;
		MemberVO idCheck = memberService.getUserOne(vo);
		if(idCheck==null){
			result=true; // 가능
		}
		return result;
	}
	
	@RequestMapping(value="jquery/introWrite", method=RequestMethod.POST)
	@ResponseBody
	public boolean introWrite(IntroduceVO vo, HttpSession session){
		boolean result = false;
		MemberVO mem = memberService.getUserOne((int) session.getAttribute("seq"));
		vo.setSeq(mem.getSeq());
		vo.setName(mem.getNickname());
		vo.setEmail(mem.getEmail());
		vo.setPhone(mem.getPhone());
		System.out.println("introWrite ===> "+vo.toString());
		try{
			introService.updateIntroduce(vo);
			result = true;
		} catch (Exception e) {
			System.out.println("Update "+e.getMessage());
			System.out.println("Update "+e.getStackTrace());
		}
		return result;
	}
	
	/*public boolean introWrite(IntroduceVO vo, MultipartFile file) throws IOException, Exception{
		boolean result = false;
		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtil.calcPath(imgUploadPath);
		String fileName = null;
		
		if(file != null) {
		 fileName =  UploadFileUtil.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
		} else {
		 fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
		}
		
		vo.setPicture(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		
		result = introService.updateIntroduce(vo);
		return result;
	}*/
	
	@RequestMapping(value="jquery/introGet", method=RequestMethod.GET)
	@ResponseBody
	public IntroduceVO introGet(String seq){
		return introService.getIntroduce(Integer.parseInt(seq));
	}

	// ===================================================================
	
	@RequestMapping(value="jquery/projectList", method=RequestMethod.GET)
	@ResponseBody
	public List<ProjectVO> projectList(String seq, int role){
		ProjectVO vo = new ProjectVO();
		vo.setSeq(Integer.parseInt(seq));
		vo.setRole(role);
		return projectService.getProjectList(vo);
	}
	
	@RequestMapping(value="jquery/projectGet", method=RequestMethod.GET)
	@ResponseBody
	public ProjectVO projectGet(String seq, String pSeq){
		ProjectVO vo = new ProjectVO();
		vo.setSeq(Integer.parseInt(seq));
		vo.setpSeq(Integer.parseInt(pSeq));
		return projectService.getProject(vo);
	}
	
	@RequestMapping(value="jquery/projectInsert", method=RequestMethod.POST)
	@ResponseBody
	public boolean projectInsert(ProjectVO vo){
		boolean result = false;
		result = projectService.insertProject(vo);
		return result;
	}
	
	@RequestMapping(value="jquery/projectUpdate", method=RequestMethod.POST)
	@ResponseBody
	public boolean projectUpdate(ProjectVO vo){
		boolean result = false;
		result = projectService.updateProject(vo);
		return result;
	}
	
	@RequestMapping(value="jquery/projectDelete", method=RequestMethod.GET)
	@ResponseBody
	public boolean projectDelete(String seq, String pSeq){
		boolean result = false;
		System.out.println(seq+", "+pSeq);
		ProjectVO vo = new ProjectVO();
		vo.setSeq(Integer.parseInt(seq));
		vo.setpSeq(Integer.parseInt(pSeq));
		result = projectService.deleteProject(vo);
		System.out.println(result);
		return result;
	}

	
	
	
	
	
	
}
