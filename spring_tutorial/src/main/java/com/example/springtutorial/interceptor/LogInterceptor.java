package com.example.springtutorial.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogInterceptor implements HandlerInterceptor{
	//リクエストの前処理
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler)
		throws Exception{
			log.info("preHandle():リクエスト:{}メソッド：{}",
					request.getRequestURL(),
					request.getMethod());
			//trueを返すことでコントローラを呼び出す
			return true;
		}
	
	// レスポンスの後処理（ビュー表示前）
	@Override
	public void postHandle(HttpServletRequest request,HttpServletResponse response,Object handler,
			ModelAndView modelAndView)throws Exception{
		log.info("postHandle():ステータスコード:{}",
					response.getStatus());
	}
	
	//ビュー表示後の完了処理
	@Override
	public void afterCompletion(HttpServletRequest request,HttpServletResponse response,Object handler,Exception ex)
				throws Exception{
		log.info("afterCompletion():コンテンツタイプ：{}",
				response.getContentType());
	}
}
