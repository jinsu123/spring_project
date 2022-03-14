package com.lcomputerstudy1.example.service;

import java.util.List;
import com.lcomputerstudy1.example.domain.Board;
import com.lcomputerstudy1.example.domain.Pagination;

public interface BoardService {
	public List<Board> selectBoardList(Pagination pagination);

	public int boardCount();
	
	public Board boardDetail(Board board);
	
}
