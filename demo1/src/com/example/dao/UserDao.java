package com.example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.util.DbUtil;

public class UserDao {
	
	public int insertText(String id) {
		return DbUtil.doUpdate("insert into text values(2,?)", id);
	}

	public String queryText(int id) {
		ResultSet resultSet = DbUtil.doQuery("select * from text where id = ? ", id);
		try {
			while (resultSet.next()) {
				String name = resultSet.getString(2);
				return name;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
