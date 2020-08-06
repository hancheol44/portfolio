package com.proj.pro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.pro.dao.InfoDAO;
import com.proj.pro.vo.*;

@Service
public class InfoService {
	
	@Autowired
	InfoDAO iDAO;
	// 자동차 캠핑
	
	// InfoAC List
	public List<InfoVO> getAC_List() throws Exception {
		return iDAO.getACList();
	}
	
	// InfoAC Detail
	public InfoVO getAC_Detail(InfoVO iVO) throws Exception {
		return iDAO.getAC_Detail(iVO);
	}
	
	// infoAC Review List
	public List<InfoVO> getAC_Review_List(int ifno) throws Exception {
		return iDAO.getAC_Review_List(ifno);
	}
	
	// InfoAC Review Write
	public int addAC_Review_Write(InfoVO iVO) throws Exception {
		return iDAO.addAC_Review(iVO);
	}
	
	// InfoAC Review Del
	public int delAC_Review(int ifrno) throws Exception {
		return iDAO.delAC_Review(ifrno);
	}
	
	// InfoAC Review Modi
	public int modAC_Review(InfoVO iVO) throws Exception{
		return iDAO.modAC_Review(iVO);
	}
	
	public List<InfoVO> getAC_Addr(InfoVO iVO) throws Exception{
		return iDAO.getACAddr(iVO);
	}
	
	// 자동차 극장
	// InfoCT List
		public List<InfoVO> getCT_List() throws Exception {
			return iDAO.getCTList();
		}
		
		// InfoCT Detail
		public InfoVO getCT_Detail(InfoVO iVO) throws Exception {
			return iDAO.getCT_Detail(iVO);
		}
		
		// infoCT Review List
		public List<InfoVO> getCT_Review_List(int ifno) throws Exception {
			return iDAO.getCT_Review_List(ifno);
		}
		
		// InfoCT Review Write
		public int addCT_Review_Write(InfoVO iVO) throws Exception {
			return iDAO.addCT_Review(iVO);
		}
		
		// InfoCT Review Del
		public int delCT_Review(int ifrno) throws Exception {
			return iDAO.delCT_Review(ifrno);
		}
		
		// InfoCT Review Modi
		public int modCT_Review(InfoVO iVO) throws Exception{
			return iDAO.modCT_Review(iVO);
		}
		
		// InfoCT All Addr
		public List<InfoVO> getCT_Addr(InfoVO iVO) throws Exception{
			return iDAO.getCTAddr(iVO);
		}
		
		public List<SalesVO> getMain_Addr(SalesVO sVO) throws Exception{
			return iDAO.getMainAddr(sVO);
		}
		
		
		
		
		// 승차 검진소
		// InfoDT List
			public List<InfoVO> getDT_List() throws Exception {
				return iDAO.getDTList();
			}
			
			// InfoDT Detail
			public InfoVO getDT_Detail(InfoVO iVO) throws Exception {
				return iDAO.getDT_Detail(iVO);
			}
			
			// infoDT Review List
			public List<InfoVO> getDT_Review_List(int ifno) throws Exception {
				return iDAO.getDT_Review_List(ifno);
			}
			
			// InfoDT Review Write
			public int addDT_Review_Write(InfoVO iVO) throws Exception {
				return iDAO.addDT_Review(iVO);
			}
			
			// InfoDT Review Del
			public int delDT_Review(int ifrno) throws Exception {
				return iDAO.delDT_Review(ifrno);
			}
			
			// InfoDT Review Modi
			public int modDT_Review(InfoVO iVO) throws Exception{
				return iDAO.modDT_Review(iVO);
			}
			

			public List<InfoVO> getDT_Addr(InfoVO iVO) throws Exception{
				return iDAO.getDTAddr(iVO);
			}
			// Main Cnt 
			public InfoVO getCnt_Main() throws Exception{
				return iDAO.getCnt();
			}
			
			
			
			
			// Info Like 처리 서비스
			public InfoVO likeproc(InfoVO iVO) throws Exception {
				// Info 카테고리별 VO 데이터 채우기
				if(iVO.getIfct().equals("ctt")) {
					iVO = iDAO.getCT_Detail(iVO);
				} else if(iVO.getIfct().equals("acp")) {
					iVO = iDAO.getAC_Detail(iVO);
				} else if(iVO.getIfct().equals("dtc")) {
					iVO = iDAO.getDT_Detail(iVO);
				}
				
				if(iVO.getClike() == 0) {
					// 좋아요 등록
					int addlike = iDAO.addlike(iVO);
					int likeplus = iDAO.pluslike(iVO);
				} else {
					// 좋아요 취소
					int likeminus = iDAO.minuslike(iVO);
					int dellike = iDAO.dellike(iVO);
				}

				
				if(iVO.getIfct().equals("ctt")) {
					iVO = iDAO.getCT_Detail(iVO);
				} else if(iVO.getIfct().equals("acp")) {
					iVO = iDAO.getAC_Detail(iVO);
				} else if(iVO.getIfct().equals("dtc")) {
					iVO = iDAO.getDT_Detail(iVO);
				}
				
				return iVO;
			}
			
		
			// right promotion 좋아요 처리
			public List<SalesVO> getLike() throws Exception {
				return iDAO.getLike(); // promotion 좋아요 가져오기
			}
			
			public List<InfoVO> getiLike() throws Exception {
				return iDAO.getiLike();
			}
			
			
			
			
}
