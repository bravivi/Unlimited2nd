package min.point.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import min.point.dto.PointHistoryDTO;
import min.point.dto.PointSearching;
import min.point.dto.RefundRequestDTO;
import min.util.Paging;

@Repository
public class PointDAO {
	@Autowired
	SqlSessionTemplate template;
	public SqlSessionTemplate getTemplate() {
		return template;
	}
	private static String namespace = "mapper.Point.";
	
	public List<Object> getBuyHistory(Paging paging) {
		// TODO Auto-generated method stub

			return template.selectList(namespace+"getBuyHistory", paging);

	}
	
	public List<Object> getSellHistory(Paging paging) {
		// TODO Auto-generated method stub
		
			return template.selectList(namespace+"getSellHistory", paging);
	}
	
	public List<Object> getCRHistory(Paging paging) {
		// TODO Auto-generated method stub
			return template.selectList(namespace+"getCRHistory", paging);
	}

	public List<Object> getPointHistory(@RequestParam(value="id", defaultValue="kyu")String id, Paging paging) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		System.out.println(id);
		map.put("id",id);
		map.put("paging", paging);
		return template.selectList(namespace+"getMbPointHistory", map);
	}

	public List<Object> getRefundRequestList(Paging paging) {
		// TODO Auto-generated method stub
		return template.selectList(namespace+"getRefundRequestList", paging);
	}

	public int getPoint(String id) {
		// TODO Auto-generated method stub
		System.out.println(id);
		return template.selectOne(namespace+"getPoint", id);
	}

	public void pointChange(Map<String, Object>map) {
		// TODO Auto-generated method stub
		template.update(namespace+"pointChange", map);
	}

	public void updateCR(Map<String, Object> map) {
		// TODO Auto-generated method stub
		template.insert(namespace+"insertCR", map);
		
	}

	public void insertBuyHistory(PointHistoryDTO buyerPointHistoryDTO) {
		// TODO Auto-generated method stub
		template.insert(namespace+"insertBuyHistory",buyerPointHistoryDTO);
		
	}

	public void insertSellHistory(PointHistoryDTO sellerPointHistoryDTO) {
		// TODO Auto-generated method stub
		template.insert(namespace+"insertSellHistory",sellerPointHistoryDTO);
	}

	public void refundRequest(RefundRequestDTO refundRequestDTO) {
		// TODO Auto-generated method stub
		template.insert(namespace+"insertRefundRequest", refundRequestDTO);
	}

	public void refundRequestCheck(int no) {
		// TODO Auto-generated method stub
		template.insert(namespace+"refundDone", no);
		
	}

	public int getMBHistoryCount(String id) {
		// TODO Auto-generated method stub
		return template.selectOne(namespace+"getMBHistoryCount",id);
	}

	public int getRefundRequestCount() {
		// TODO Auto-generated method stub
		return template.selectOne(namespace+"getRefundRequestCount");
	}

	public int getBuyHistoryCount() {
		// TODO Auto-generated method stub
		return template.selectOne(namespace+"getBuyHistoryCount");
	}

	public int getSellHistoryCount() {
		// TODO Auto-generated method stub
		return template.selectOne(namespace+"getSellHistoryCount");
	}

	public int getCRHistoryCount() {
		// TODO Auto-generated method stub
		return template.selectOne(namespace+"getCRHistoryCount");
	}

	public int getSearchPointHistoryCount(PointSearching pointSearching) {
		// TODO Auto-generated method stub	
		return template.selectOne(namespace+"getSearchPointHistoryCount", pointSearching);
	}

	public List<PointHistoryDTO> getSearchPointHistory(Paging paging, PointSearching pointSearching) {
		// TODO Auto-generated method stub
		Map<String, Object>map = new HashMap<>();
		map.put("paging", paging);
		map.put("pointSearching", pointSearching);
		return template.selectList(namespace+"getSearchPointHistory", map);
	}

	public int getSearchBuyHistoryCount(PointSearching pointSearching) {
		// TODO Auto-generated method stub
		return template.selectOne(namespace+"getSearchBuyHistoryCount", pointSearching);
	}

	public List<PointHistoryDTO> getSearchBuyHistory(Paging paging, PointSearching pointSearching) {
		// TODO Auto-generated method stub
		Map<String, Object>map = new HashMap<>();
		map.put("paging", paging);
		map.put("pointSearching", pointSearching);
		return template.selectList(namespace+"getSearchBuyHistory", map);
	}

	public int getSearchSellHistoryCount(PointSearching pointSearching) {
		// TODO Auto-generated method stub
		return template.selectOne(namespace+"getSearchSellHistoryCount", pointSearching);
	}

	public List<PointHistoryDTO> getSearchSellHistory(Paging paging, PointSearching pointSearching) {
		// TODO Auto-generated method stub
		Map<String, Object>map = new HashMap<>();
		map.put("paging", paging);
		map.put("pointSearching", pointSearching);
		return template.selectList(namespace+"getSearchSellHistory", map);
	}

	public int getSearchCRHistoryCount(PointSearching pointSearching) {
		// TODO Auto-generated method stub
		return template.selectOne(namespace+"getSearchCRHistoryCount", pointSearching);
	}

	public List<PointHistoryDTO> getSearchCRHistory(Paging paging, PointSearching pointSearching) {
		// TODO Auto-generated method stub
		Map<String, Object>map = new HashMap<>();
		map.put("paging", paging);
		map.put("pointSearching", pointSearching);
		return template.selectList(namespace+"getSearchCRHistory", map);
	}

	public int getSearchRefundRequestCount(PointSearching pointSearching) {
		// TODO Auto-generated method stub
		return template.selectOne(namespace+"getSearchRefundRequestCount", pointSearching);
	}

	public List<PointHistoryDTO> getSearchRefundRequest(Paging paging, PointSearching pointSearching) {
		// TODO Auto-generated method stub
		Map<String, Object>map = new HashMap<>();
		map.put("paging", paging);
		map.put("pointSearching", pointSearching);
		return template.selectList(namespace+"getSearchRefundRequest", map);
	}

//	public void insertCRhistory(Map<String, Object> map) {
//		// TODO Auto-generated method stub
//		template.insert(namespace+"insertCR", map);
//		
//	}
}
