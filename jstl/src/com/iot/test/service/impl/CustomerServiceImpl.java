package com.iot.test.service.impl;

import javax.servlet.http.HttpServletRequest;

import com.iot.test.dao.CustomerDAO;
import com.iot.test.dao.CustomerDAOImpl;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDAO cdao = new CustomerDAOImpl();
	
	@Override
	public void setCustomerList(HttpServletRequest req) {		
		System.out.println(req.getParameter("order"));
		req.setAttribute("customerList",cdao.selectCustomerList(req.getParameter("order")));		
		//setAttribute = 등떠밀기. (=> 등떠밀어서, jsp로 request한 값들을 보내주는것!!! (+_+))
		//("customerList",cdao.selectCustomerList())
		//     key 값,         밸류 값(!!!!!!!!)
		//customerList라는 이름으로 key 값을 Attribute해주는 것(!!!!!!우왕)
		
		
		//오름차순(asc), 내림차순(dsc)은 이 클래스에서 했던 것 같다. (선생님이)
	}
}
