package com.tedu.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import sun.jvm.hotspot.oops.java_lang_Class;

@Controller
public class ParamController {
	/* * * * * * * * * * * * * * *
	 * 测试：接收基本类型的参数 	 *
	 * * * * * * * * * * * * * * */
	@RequestMapping("/param1")
	public String param1(String name, Integer age) {
		System.out.println("name: " + name);
		System.out.println("age: " + age);
		return "home";
	}
	
	/* * * * * * * * * * * * * * *
	 * 测试：接收包裝类型的参数	 *
	 * * * * * * * * * * * * * * */
	@RequestMapping("/param2")
	public String param2(User user) {
		System.out.println(user);
		return "home";
	}
	
	/* * * * * * * * * * * * * * * * * * * * * * * * *
	 * 测试：接收日期类型的参数	                     *
	 * 如果日期参数是 yyyy-MM-dd 格式就会出现400错误	 *
	 * 解決方法：使用@InitBinder	                     *
	 * * * * * * * * * * * * * * * * * * * * * * * * */
	@RequestMapping("/param3")
	public String param3(Date date) {
		System.out.println("日期： " + date.toLocaleString());
		return "home";
	}
	@InitBinder //自定義
	public void InitBinder(ServletRequestDataBinder binder) {
		binder.registerCustomEditor(java.util.Date.class,
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
}
