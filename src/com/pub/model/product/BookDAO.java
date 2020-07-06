package com.pub.model.product;

import java.util.List;

//Book 테이블과 CRUD를 수행할 모든 DAO의 최상위 객체 정의!!
public interface BookDAO {
	public List selectAll();
	public int insert(Book book);
}
