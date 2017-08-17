package hs.admin.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.mapper.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hs.admin.dao.AdminDAO;
import hs.member.dto.MemberDTO;

@Service
public class AdminSearchMemberService {

	@Inject
	private AdminDAO adminDAO;

	public Model execute(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String hp = request.getParameter("hp");
		System.out.println("AdminSearchMemberService.id:" + id + ",name:" + name + ",email:" + email + ",hp:" + hp);

		MemberDTO memberDTO = new MemberDTO();
		List<?> memberList = new ArrayList<Object>();
		
		if ("".equals(id) == true) {
			id = null;
		}
		if ("".equals(name) == true) {
			name = null;
		}
		if ("".equals(email) == true) {
			email = null;
		}
		if ("".equals(hp) == true) {
			hp = null;
		}
		System.out.println("AdminSearchMemberService.id:" + id + ",name:" + name + ",email:" + email + ",hp:" + hp);
		memberDTO.setId(id);
		memberDTO.setName(name);
		memberDTO.setEmail(email);
		memberDTO.setHp(hp);

		System.out.println("AdminSearchMemberService.memberDTO:" + memberDTO);
		memberList = adminDAO.adminSearchMember(memberDTO);
		System.out.println("AdminSearchMemberService.memberList:" + memberList);
		if (memberList == null) {
			System.out.println("관리자 : 회원 정보 불러오기 실패 ");
			return null;
		}
	
		System.out.println("관리자 : 회원 정보 불러오기 성공 ");

		request.setAttribute("memberList", memberList);
		System.out.println("AdminSearchMemberService : " + memberList);
		return model;
	}

}
