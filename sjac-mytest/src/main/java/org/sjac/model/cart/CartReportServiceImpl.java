package org.sjac.model.cart;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class CartReportServiceImpl implements CartReportService{
	@Resource
	private CartReportDAO cartReportDAO;

	@Override
	public List<CartReportVO> showCountCart() {
		return cartReportDAO.showCountCart();
	}

	   public void saveCartReport(String gleaderId)  {   
	         int result=cartReportDAO.updateCartReport(gleaderId);
	         if(result==0)
	        	 cartReportDAO.insertCartReport(gleaderId);         
	   }   

}
