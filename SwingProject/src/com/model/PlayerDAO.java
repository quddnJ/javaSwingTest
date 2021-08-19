package com.model;

import java.util.ArrayList;

public interface PlayerDAO {
	
	
	//추가
	public void insert(Player p);
	
	//전체보기
	public ArrayList<Player>selectAll();
	
	//수정
	public void update(Player p);
	
	//삭제
	public void delete(int num);
	
	//검색
	public ArrayList<Player> search(String field,String word);
	
	//상세보기
	public Player view(int num);
}
