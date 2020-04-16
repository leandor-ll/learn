package com.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;

public class DbUtil {

	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/demo";
	private static final String USER = "root";
	private static final String PASSWORD = "123456";

	private static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	private static void closeSqlResource(ResultSet resultSet, PreparedStatement preparedStatement,Connection connection) {
		try {

			if (resultSet != null) {
				resultSet.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ResultSet doQuery(String sql, Object...params) {
		// 声明连接对象
		Connection conn = null;
		// 声明预编译语句对象 
		PreparedStatement pStat = null;
		// 声明结果集对象
		ResultSet resultSet = null;
		// 声明缓存结果集对象
		CachedRowSet  rowset = null;
		
		try {
			//1.获取连接对象
		    conn = getConnection();
		  //2.创建预编译语句对象
			pStat = conn.prepareStatement(sql);
			//3.对占位符赋值
			for (int i = 0; i < params.length; i++) {
				pStat.setObject(i + 1, params[i]);
			}
			//4.执行查询动作
			resultSet = pStat.executeQuery();
			
			//5 创建缓存结果集对象
			rowset = new  CachedRowSetImpl();
			//6 将结果集中的数据 存放到 缓存结果集中
			rowset.populate(resultSet);
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//5.关闭数据库
			closeSqlResource(resultSet, pStat, conn);
		}
	    
		return rowset;//返回的是缓存结果集,CachedRowSet是继承于ResultSet。
	}
	/**
	 * 更新： 添加、删除、修改
	 * @param sql
	 * @param params
	 * @return int 影响行数
	 */
	public static int doUpdate(String sql, Object...params) {
		// 声明连接对象
		Connection conn = null;
		// 声明预编译语句对象
		PreparedStatement pStat = null;
		// 影响行数
		int n = 0;
		try {
			//1.获取连接对象
		    conn = getConnection();
			//2.创建预编译语句对象
			pStat = conn.prepareStatement(sql);
			//3.对占位符赋值
			for (int i = 0; i < params.length; i++) {
				pStat.setObject(i + 1, params[i]);
			}
			//4.执行更新动作
			n = pStat.executeUpdate();	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//5.关闭数据库
			closeSqlResource(null, pStat, conn);
		}
		return n;//返回的是影响行数
	}

}
