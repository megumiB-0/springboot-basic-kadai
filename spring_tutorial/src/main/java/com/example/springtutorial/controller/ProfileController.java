package com.example.springtutorial.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {
	//メッセージの入れ物を作る
	public final MessagePrinter messagePrinter;
	
	public ProfileController(MessagePrinter messagePrinter) {
		//プロファイルに応じたMessagePrinterを格納
		this.messagePrinter = messagePrinter;
	}
	
	//URLアクセス時にメッセージを出力
	@GetMapping("/profile")
	public String profile() {
		//格納されたmessage.printerを出力
		return messagePrinter.printMessage();
	}
}

//クラスを切り替えるための共通のインターフェイス
interface MessagePrinter{
	String printMessage(); //メッセージを出力
}

//開発環境向けの設定クラス
@Component //そのクラスがDIコンテナに登録され、必要な時に参照できるようになる
@Profile("dev") // 指定したプロファイルが有効な時のみそのクラスやメソッドが定義される
class DevPrinter implements MessagePrinter{
	public String printMessage() {
		return "これは開発環境で実行されました。";
	}
}

//本番環境向けの設定クラス
@Component
@Profile("prod")
class ProdPrinter implements MessagePrinter{
	public String printMessage() {
		return "これは本番環境で実行されました。";
		
	}
}