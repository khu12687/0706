package com.pub.model.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.pub.mybatis.MybatisConfigManager;

public class NoticeDAO {
	
	//주이블 받으려면, 생성자나 세터메서드 둘중에 하나는 정의되어 있어야한다
	MybatisConfigManager manager = MybatisConfigManager.getInstance();
	public NoticeDAO(MybatisConfigManager manager) {
		this.manager=manager;
	}
	//CRUD
	public List selectAll() {
		List list  = null;
		SqlSession sqlSession = manager.getSqlSession();
		list = sqlSession.selectList("Notice.selectAll");
		manager.closeSession(sqlSession);
		return list;
	}
	
	public Notice select(int notice_id) {
		Notice notice = null;
		SqlSession sqlSession = manager.getSqlSession();
		notice = sqlSession.selectOne("Notice.select",notice_id);
		manager.closeSession(sqlSession);
		return notice;
	}
	
	public int insert(Notice notice) {
		int result=0;
		SqlSession sqlSession = manager.getSqlSession();
		result = sqlSession.insert("Notice.insert",notice);
		sqlSession.commit();
		manager.closeSession(sqlSession);
		return result;
	}
	public int update(Notice notice) {
		int result=0;
		SqlSession sqlSession = manager.getSqlSession();
		result = sqlSession.update("Notice.update",notice);
		sqlSession.commit();
		manager.closeSession(sqlSession);
		return result;
	}
	public int delete(int notice_id) {
		int result=0;
		SqlSession sqlSession = manager.getSqlSession();
		result = sqlSession.delete("Notice.delete",notice_id);
		sqlSession.commit();
		manager.closeSession(sqlSession);
		return result;
	}
}
