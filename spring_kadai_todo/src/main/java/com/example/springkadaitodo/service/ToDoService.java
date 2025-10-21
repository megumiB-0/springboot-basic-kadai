package com.example.springkadaitodo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springkadaitodo.entity.ToDo;
import com.example.springkadaitodo.repository.ToDoRepository;

@Service
public class ToDoService {
	private final ToDoRepository toDoRepository;
	
	//DIを行う（コンストラクタインジェクション）
	public ToDoService(ToDoRepository toDoRepository) {
		this.toDoRepository =toDoRepository;
	}
	/*
	//新規TODO登録メソッド
	public void createToDo(String title, String priority, String status) {
		//TODOの未入力チェック（完全一致はNG）
		if(title == null || title.isEmpty()) {
			throw new IllegalArgumentException("ToDoを入力してください。");
		}
		//TODO登録用のエンティティを作成
		ToDo todo = new ToDo();
		todo.setTitle(title);
		todo.setPriority(priority);
		todo.setStatus(status);
		
		//TODOの登録
		toDoRepository.save(todo);

	}
	*/
	//TODOの一括取得メソッド
	public List<ToDo> getAllToDos(){
		return toDoRepository.findAll();
	}

	
}
