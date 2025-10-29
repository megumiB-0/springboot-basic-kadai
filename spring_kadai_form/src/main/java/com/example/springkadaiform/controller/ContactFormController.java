package com.example.springkadaiform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springkadaiform.form.ContactForm;



@Controller
public class ContactFormController {
	//フォーム入力画面表示
	@GetMapping("/form")
	public String showForm(Model model) {
		// モデルにからのフォームをセット
		model.addAttribute("contactForm",new ContactForm());
		return "contactFormView";
	}
	
	//フォーム送信（POST）
	@PostMapping("/confirm")
	public String submitForm(
			@Validated ContactForm form, //入力を受け取る
			BindingResult result,		 //チェック結果を受け取る
			Model model) {				 //画面にデータを渡す
		if(result.hasErrors()) {
			//formを再表示
			return "contactFormView";
		}
		//入力OK→確認画面へ
		model.addAttribute("contactForm",form);
		
		// リダイレクトしてconfirmにリストを表示
		return "confirmView";
	}

}
