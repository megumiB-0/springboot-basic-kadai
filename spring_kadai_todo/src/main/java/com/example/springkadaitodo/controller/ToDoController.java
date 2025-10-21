package com.example.springkadaitodo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.springkadaitodo.entity.ToDo;
import com.example.springkadaitodo.service.ToDoService;



@Controller
public class ToDoController {
	private final ToDoService toDoService;
	
	public ToDoController(ToDoService toDoService) {
		this.toDoService = toDoService;
	}
	
	@GetMapping("/todo")
		//モデルインターフェース（リポジトリ）に引数を指定する
	public String toDo(Model model) {
		//最新TODOリストを取得 (エンティティのリストを取得)
		List<ToDo> toDos = toDoService.getAllToDos();
		//ビューTODOリストを渡す (コントローラのデータを保存)	
		model.addAttribute("toDos",toDos);
		
		return "todoView";
	}

	
}
