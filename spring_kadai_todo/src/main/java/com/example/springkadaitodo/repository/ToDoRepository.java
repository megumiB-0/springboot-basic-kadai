package com.example.springkadaitodo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springkadaitodo.entity.ToDo;

public interface ToDoRepository extends JpaRepository<ToDo, Integer>{
	//タイトルで部分一致検索
	List<ToDo> findByTitleLike(String title);

}
