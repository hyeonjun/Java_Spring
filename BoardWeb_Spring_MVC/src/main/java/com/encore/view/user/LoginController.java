package com.encore.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.encore.biz.user.UserVO;
import com.encore.biz.user.impl.UserDAO;

public class LoginController implements Controller {

	public LoginController() {
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("==> �α��� ó�� <==");

		// 1. ����� �Է� ���� ����
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		// 2. DB ���� ó��
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);

		UserDAO dao = new UserDAO();
		UserVO user = dao.getUser(vo);

		// 3. ȭ�� �׺���̼�
		ModelAndView mav = new ModelAndView();
		if (user != null) {
			mav.setViewName("redirect:getBoardList.do");
		} else {
			mav.setViewName("redirect:login.jsp");
		}

		return mav;
	}

}
