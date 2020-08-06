package com.proj.pro.controller.info;

/**
 * @author 이한철
 * @since  2020.07.01
 * 
 * 	이 클래스는 info 요청에 대한 컨트롤러이다.
 */

import java.util.*;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.proj.pro.dao.*;
import com.proj.pro.service.*;
import com.proj.pro.vo.*;


@Controller
@RequestMapping("/info")
public class InfoController {
	
	@Autowired
	InfoDAO iDAO;
	
	@Inject
	private InfoService service;
	
	
	// 위치정보(오토캠핑) 뷰 처리
	@RequestMapping("/infoAC.pro")
	public ModelAndView getViewAC(ModelAndView mv) throws Exception {
		String view = "info/infoAC";
		ArrayList<InfoVO> list = (ArrayList<InfoVO>)service.getAC_List();
		mv.addObject("AC_NAME_LIST", list);
		mv.setViewName(view);
		return mv;
	}
		
	// 위치정보(오토캠핑) 상세보기 ajax 처리
	@RequestMapping(value="/infoAC_Detail", method=RequestMethod.POST , params= {"ifno", "memid"})
	@ResponseBody
	public InfoVO infoDetail(InfoVO iVO) throws Exception {
	  	iVO = service.getAC_Detail(iVO);
		return iVO;
	}
	
	// 위치정보(오토캠핑) 리뷰 List ajax 처리
	@RequestMapping(value="/infoAC_ReviewList", method=RequestMethod.POST, params={"ifno"})
	@ResponseBody
	public ArrayList<InfoVO> AC_ReviewList(int ifno) throws Exception{
		ArrayList<InfoVO> list =(ArrayList<InfoVO>) service.getAC_Review_List(ifno);
		return list;
	}
	
	// 위치정보(오토캠핑) 리뷰작성 ajax 처리
	@RequestMapping(value="/infoAC_ReviewWrite", method=RequestMethod.POST, params={"ifno", "ifrst", "ifrtt", "ifrbd", "memid"})
	@ResponseBody
	public InfoVO AC_ReviewWrite(InfoVO iVO) throws Exception {
		int cnt = service.addAC_Review_Write(iVO);
		return iVO;
	}
	
	// 위치정보(오토캠핑) 리뷰수정 ajax 처리
	@RequestMapping(value="/infoAC_ReviewMod", method=RequestMethod.POST, params= {"ifrno", "ifrtt", "ifrbd"})
	@ResponseBody
	public Integer AC_ReviewMod(InfoVO iVO) throws Exception {
		int cnt = service.modAC_Review(iVO);
		return cnt;
	}
	
	// 위치정보(오토캠핑) 리뷰삭제 ajax 처리
	@RequestMapping(value="/infoAC_ReviewDel", method=RequestMethod.POST, params= {"ifrno"})
	@ResponseBody
	public Integer AC_ReviewDel(int ifrno) throws Exception {
		int cnt = service.delAC_Review(ifrno);
		return cnt;
	}
	
	
	// 위치정보(오토캠핑) ajax 주소 테스트
	@RequestMapping("/infoAC_Addr")
	@ResponseBody
	public ArrayList<InfoVO> AC_Addr(InfoVO iVO) throws Exception{
		ArrayList<InfoVO> list = (ArrayList<InfoVO>) service.getAC_Addr(iVO);
		return list;
	}
		
		
	// 위치정보(자동차극장) 뷰 처리
	@RequestMapping("/infoCT.pro")
	public ModelAndView getViewCT(ModelAndView mv) throws Exception {
		String view = "info/infoCT";
		ArrayList<InfoVO> list = (ArrayList<InfoVO>)service.getCT_List();
		mv.addObject("CT_NAME_LIST", list);
		mv.setViewName(view);
		return mv;
	}
	
	// 위치정보(자동차극장) 상세보기 ajax 처리
	@RequestMapping(value="/infoCT_Detail", method=RequestMethod.POST , params= {"ifno", "memid"})
	@ResponseBody
	public InfoVO infoCTDetail(InfoVO iVO) throws Exception {
	  	iVO = service.getCT_Detail(iVO);
		return iVO;
	}
		
	// 위치정보(자동차극장) 리뷰 List ajax 처리
	@RequestMapping(value="/infoCT_ReviewList", method=RequestMethod.POST, params={"ifno"})
	@ResponseBody
	public ArrayList<InfoVO> CT_ReviewList(int ifno) throws Exception{
			ArrayList<InfoVO> list =(ArrayList<InfoVO>) service.getCT_Review_List(ifno);
			return list;
	}
	
	// 위치정보(자동차극장) 리뷰작성 ajax 처리
	@RequestMapping(value="/infoCT_ReviewWrite", method=RequestMethod.POST, params={"ifno", "ifrst", "ifrtt", "ifrbd", "memid"})
	@ResponseBody
	public InfoVO CT_ReviewWrite(InfoVO iVO) throws Exception {
		int cnt = service.addCT_Review_Write(iVO);
		return iVO;
	}
	
	// 위치정보(자동차극장) 리뷰수정 ajax 처리
	@RequestMapping(value="/infoCT_ReviewMod", method=RequestMethod.POST, params= {"ifrno", "ifrtt", "ifrbd"})
	@ResponseBody
	public Integer CT_ReviewMod(InfoVO iVO) throws Exception {
		int cnt = service.modCT_Review(iVO);
		return cnt;
	}
	
	// 위치정보(자동차극장) 리뷰삭제 ajax 처리
	@RequestMapping(value="/infoCT_ReviewDel", method=RequestMethod.POST, params= {"ifrno"})
	@ResponseBody
	public Integer CT_ReviewDel(int ifrno) throws Exception {
		int cnt = service.delCT_Review(ifrno);
		return cnt;
	}
	
	
	//위치정보(자동차극장) ajax 주소 테스트
	@RequestMapping("/infoCT_Addr")
	@ResponseBody
	public ArrayList<InfoVO> CT_Addr(InfoVO iVO) throws Exception{
			ArrayList<InfoVO> list = (ArrayList<InfoVO>) service.getCT_Addr(iVO);
			return list;
	}
	
	
	
	// 위치정보(승차검진소) 뷰 처리
	@RequestMapping("/infoDT.pro")
	public ModelAndView getViewDT(ModelAndView mv) throws Exception {
		String view = "info/infoDT";
		ArrayList<InfoVO> list = (ArrayList<InfoVO>)service.getDT_List();
		mv.addObject("DT_NAME_LIST", list);
		mv.setViewName(view);
		return mv;
	}
	
	// 위치정보(승차검진소) 상세보기 ajax 처리
	@RequestMapping(value="/infoDT_Detail", method=RequestMethod.POST , params= {"ifno", "memid"})
	@ResponseBody
	public InfoVO infoDTDetail(InfoVO iVO) throws Exception {
	  	iVO = service.getDT_Detail(iVO);
		return iVO;
	}
		
	// 위치정보(승차검진소) 리뷰 List ajax 처리
	@RequestMapping(value="/infoDT_ReviewList", method=RequestMethod.POST, params={"ifno"})
	@ResponseBody
	public ArrayList<InfoVO> DT_ReviewList(int ifno) throws Exception{
			ArrayList<InfoVO> list =(ArrayList<InfoVO>) service.getDT_Review_List(ifno);
			return list;
	}
	
	// 위치정보(승차검진소) 리뷰작성 ajax 처리
	@RequestMapping(value="/infoDT_ReviewWrite", method=RequestMethod.POST, params={"ifno", "ifrst", "ifrtt", "ifrbd", "memid"})
	@ResponseBody
	public InfoVO DT_ReviewWrite(InfoVO iVO) throws Exception {
	  int cnt = service.addDT_Review_Write(iVO);
		return iVO;
	}
	
	// 위치정보(승차검진소) 리뷰수정 ajax 처리
	@RequestMapping(value="/infoDT_ReviewMod", method=RequestMethod.POST, params= {"ifrno", "ifrtt", "ifrbd"})
	@ResponseBody
	public Integer DT_ReviewMod(InfoVO iVO) throws Exception {
		int cnt = service.modDT_Review(iVO);
		return cnt;
	}
	
	// 위치정보(승차검진소) 리뷰삭제 ajax 처리
	@RequestMapping(value="/infoDT_ReviewDel", method=RequestMethod.POST, params= {"ifrno"})
	@ResponseBody
	public Integer DT_ReviewDel(int ifrno) throws Exception {
		int cnt = service.delDT_Review(ifrno);
		return cnt;
	}
	
	// 위치정보(승차검진소) 주소 테스트
	@RequestMapping("/infoDT_Addr")
	@ResponseBody
	public ArrayList<InfoVO> DT_Addr(InfoVO iVO) throws Exception{
			ArrayList<InfoVO> list = (ArrayList<InfoVO>) service.getDT_Addr(iVO);
			return list;
	}
	
	
	// 위치정보 좋아요 기능 ajax 처리
	@RequestMapping("/infoLike")
	@ResponseBody
	public InfoVO infolike(InfoVO iVO) throws Exception {
		iVO = service.likeproc(iVO);
		return iVO;
	}
	
	
	// 메인페이지 팝니당 위치정보 ajax 처리
	@RequestMapping("/main_Addr")
	@ResponseBody
	public ArrayList<SalesVO> main_Addr(SalesVO sVO) throws Exception{
		ArrayList<SalesVO> list = (ArrayList<SalesVO>) service.getMain_Addr(sVO);
		return list;
	}

}
