package org.sjac.model.cart;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CartReportDAOImpl implements CartReportDAO{
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<CartReportVO> showCountCart() {
		return sqlSessionTemplate.selectList("report.showCountCart");
	}
	
	 public void insertCartReport(String gleaderId)  {
	      sqlSessionTemplate.insert("report.insertCartReport", gleaderId);
	   }

	   
	   public int updateCartReport(String gleaderId) {
	      return sqlSessionTemplate.update("report.updateCartReport",gleaderId);
	   }

}
