package com.iot.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iot.test.common.DBCon;
import com.iot.test.common.DBUtil;
import com.iot.test.vo.Customer;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public List<Customer> selectCustomerList(String orderStr) {
		List<Customer> customerList = new ArrayList<Customer>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {			
			String sql = "select * from customer ";
			con = DBCon.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(orderStr!=null) {
				sql += " order by " + orderStr;
			}
			
			while(rs.next()) {
				Customer c = new Customer();
				c.setCustomerID(rs.getInt("customerid"));
				c.setCustomerName(rs.getString("customername"));
				c.setCity(rs.getString("city"));
				c.setCountry(rs.getString("country"));
				customerList.add(c);
				//customerList.add(new Customer());
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(rs,ps,con);
		}		    
		return customerList;
	}

	}
