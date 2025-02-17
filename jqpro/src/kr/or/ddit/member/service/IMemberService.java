package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

public interface IMemberService {
	public String getMemberById(String id);
	public List<ZipVO> selectByZipcode(String dong);
	public String insertMember(MemberVO vo);
}
