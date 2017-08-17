package hs.member.service;


import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import hs.member.dao.MemberDAO;
import hs.member.dto.MemberDTO;

@Service
public class IdCheckService {
	@Inject
	private MemberDAO memberDAO;

	public  MemberDTO execute(String id, HttpServletRequest request)  {
		MemberDTO memberDTO = new MemberDTO();

		id = request.getParameter("id");
		System.out.println("사용자가 입력한 아이디 : " + id);
		// loginDAO에서 가져온 id를 newId에 할당한다.
		// MemberDTO newId = memberDAO.idCheckProcess(memberDTO);
		memberDTO = memberDAO.idCheckProcess(id);
		System.out.println("idcheckService .memberDTO : " + memberDTO);

		// System.out.println("memberDAO.idCheckProcess 를 거친 newID" + newId);
		// request객체에 이름이 newId인변수에 newId값을 할당
		// request.setAttribute("newId", newId);
		 request.setAttribute("memberDTO", memberDTO);

		return memberDTO;
	}
	
	
//	public Model execute(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
//		MemberDTO memberDTO = new MemberDTO();
//		
//		String id = request.getParameter("id");
//		System.out.println("사용자가 입력한 아이디 : " + id);
//		// loginDAO에서 가져온 id를 newId에 할당한다.
//		// MemberDTO newId = memberDAO.idCheckProcess(memberDTO);
//		memberDTO = memberDAO.idCheckProcess(id);
//		System.out.println("idcheckService .memberDTO : " + memberDTO);
//		
//		// System.out.println("memberDAO.idCheckProcess 를 거친 newID" + newId);
//		// request객체에 이름이 newId인변수에 newId값을 할당
//		// request.setAttribute("newId", newId);
//		
//		return model;
//	}

}