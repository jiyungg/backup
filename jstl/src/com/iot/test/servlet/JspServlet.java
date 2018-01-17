package com.iot.test.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iot.test.service.MenuService;
import com.iot.test.service.UserService;
import com.iot.test.service.impl.CustomerService;
import com.iot.test.service.impl.CustomerServiceImpl;
import com.iot.test.service.impl.MenuServiceImpl;
import com.iot.test.service.impl.UserServiceImpl;

public class JspServlet extends HttpServlet {
	private MenuService ms = new MenuServiceImpl();

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req,res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req,res);
	}
	private void doProcess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		String uri = req.getRequestURI();
		String root = req.getContextPath();
		uri = uri.replace(root, "");
		ms.setMenuList(req);
		if(uri.indexOf("user/list")!=-1) {
			//indexOf("user/list") = '유저 리스트를 가져와라.'
			//("user/list")!=-1 = 유저 리스트가 1이 아닐 때. = 즉 리스트가 있을 때. (라는 뜻이 됨(!))
			UserService us = new UserServiceImpl();
			us.getUserList(req);
		}else if(uri.indexOf("customer/list")!=-1) {
			CustomerService cs = new CustomerServiceImpl();
			cs.setCustomerList(req);
		}
		uri = "/WEB-INF" + uri + ".jsp";
		System.out.println("최종 uri : " + uri);
		RequestDispatcher rd = req.getRequestDispatcher(uri);
		rd.forward(req, res);

	}
}
