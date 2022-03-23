package com.lcomputerstudy1.example.service;

import java.util.List;

import com.lcomputerstudy1.example.domain.Comment;
import com.lcomputerstudy1.example.domain.Pagination;

public interface CommentService {

	
	public int commentCount(Pagination pagination);

	public List<Comment> selectCommentList(Pagination pagination);
}