package com.proj.pro.dao;

/**
 * @author 이한철
 * @since  2020.07.01
 * 
 */
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.proj.pro.vo.*;

public class InfoDAO {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	public InfoDAO() {}
	// 자동차 캠핑
	// infoAC 리스트 sql 가져오기
	public List<InfoVO> getACList() {
		return sqlSession.selectList("iSQL.sel_ac");
	}
	
	// infoAC 디테일 sql 가져오기
	public InfoVO getAC_Detail(InfoVO iVO) {
		return sqlSession.selectOne("iSQL.Detail_ac", iVO);
	}
	
	// infoAC_review sql 가져오기
	public List<InfoVO> getAC_Review_List(int ifno) {
		return sqlSession.selectList("iSQL.review_ac", ifno);
	}
	
	// infoAC_review_Write sql 가져오기
	public int addAC_Review(InfoVO iVO) {
		return sqlSession.insert("iSQL.review_ac_add", iVO);
	}
	
	// infoAC_review Del sql 가져오기
	public int delAC_Review(int ifrno) {
		return sqlSession.update("iSQL.review_ac_del", ifrno);
	}
	
	// infoAC_review Modi sql 가져오기
	public int modAC_Review(InfoVO iVO) {
		return sqlSession.update("iSQL.review_ac_mod", iVO);
	}
	
	public List<InfoVO> getACAddr(InfoVO iVO){
		return sqlSession.selectList("iSQL.Addr_ac", iVO);
	}
	
	
	// 자동차 극장
		// infoCT 리스트 sql 가져오기
		public List<InfoVO> getCTList() {
			return sqlSession.selectList("iSQL.sel_ct");
		}
		
		// infoCT 디테일 sql 가져오기
		public InfoVO getCT_Detail(InfoVO iVO) {
			return sqlSession.selectOne("iSQL.Detail_ct", iVO);
		}
		
		// infoCT_review sql 가져오기
		public List<InfoVO> getCT_Review_List(int ifno) {
			return sqlSession.selectList("iSQL.review_ct", ifno);
		}
		
		// infoCT_review_Write sql 가져오기
		public int addCT_Review(InfoVO iVO) {
			return sqlSession.insert("iSQL.review_ct_add", iVO);
		}
		
		// infoCT_review Del sql 가져오기
		public int delCT_Review(int ifrno) {
			return sqlSession.update("iSQL.review_ct_del", ifrno);
		}
		
		// infoCT_review Modi sql 가져오기
		public int modCT_Review(InfoVO iVO) {
			return sqlSession.update("iSQL.review_ct_mod", iVO);
		}
		
		// infoCT_ 주소값 sql 가져오기
		public List<InfoVO> getCTAddr(InfoVO iVO){
			return sqlSession.selectList("iSQL.Addr_ct", iVO);
		}
		
// 승차 검진소
		// infoDT 리스트 sql 가져오기
		public List<InfoVO> getDTList() {
			return sqlSession.selectList("iSQL.sel_dt");
		}
		
		// infoDT 디테일 sql 가져오기
		public InfoVO getDT_Detail(InfoVO iVO) {
			return sqlSession.selectOne("iSQL.Detail_dt", iVO);
		}
		
		// infoDT_review sql 가져오기
		public List<InfoVO> getDT_Review_List(int ifno) {
			return sqlSession.selectList("iSQL.review_dt", ifno);
		}
		
		// infoDT_review_Write sql 가져오기
		public int addDT_Review(InfoVO iVO) {
			return sqlSession.insert("iSQL.review_dt_add", iVO);
		}
		
		// infoDT_review Del sql 가져오기
		public int delDT_Review(int ifrno) {
			return sqlSession.update("iSQL.review_dt_del", ifrno);
		}
		
		// infoDT_review Modi sql 가져오기
		public int modDT_Review(InfoVO iVO) {
			return sqlSession.update("iSQL.review_dt_mod", iVO);
		}
		
		
		public List<InfoVO> getDTAddr(InfoVO iVO){
			return sqlSession.selectList("iSQL.Addr_dt", iVO);
		}
		
		// info 좋아요 plike insert
		public int addlike(InfoVO iVO) {
			return sqlSession.insert("iSQL.addlike", iVO);
		}
		
		// info 좋아요 plus 처리
		public int pluslike(InfoVO iVO) {
			return sqlSession.update("iSQL.pluslike", iVO);
		}
		
		// info 좋아요 취소(del) 처리
		public int dellike(InfoVO iVO) {
			return sqlSession.delete("iSQL.dellike", iVO);
		}
		
		// info 좋아요 minus 처리
		public int minuslike(InfoVO iVO) {
			return sqlSession.update("iSQL.minuslike", iVO);
		}
		
		// 메인 맵_ 판매점 마커 찍기
		public List<SalesVO> getMainAddr(SalesVO sVO){
			return sqlSession.selectList("iSQL.mainAddr", sVO);
		}
		
		// 메인 회원수 / 등록매장수 뽑기
		public InfoVO getCnt () {
			return sqlSession.selectOne("iSQL.mainCnt");
		}
		
		// 우측 promotion 좋아요 
		public List<SalesVO> getLike() {
			return sqlSession.selectList("iSQL.pro_like_top5");
		}
		
		// 우측 promotion 좋아요 
		public List<InfoVO> getiLike() {
			return sqlSession.selectList("iSQL.info_like_top5");
		}
	
}
