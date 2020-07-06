package com.pub.model.product;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.pub.mybatis.MybatisConfigManager;

public class BookDAOOracle implements BookDAO{
	MybatisConfigManager manager = MybatisConfigManager.getInstance();
	
	public List selectAll() {
		List list = null;
		SqlSession sqlSession = manager.getSqlSession();
		list = sqlSession.selectList("Book.selectAll");
		manager.closeSession(sqlSession);
		return list;
	}
	
	public int insert(Book book) {
		int result = 0;
		SqlSession sqlSession = manager.getSqlSession();
		result = sqlSession.insert("Book.insert",book);
		sqlSession.commit();
		manager.closeSession(sqlSession);
		return result;
	}
}
