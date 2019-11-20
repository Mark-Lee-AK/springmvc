package com.tedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 这个注解表示当前类是属于控制层
public class HelloController {
	// 期望访问路径：http://localhost/项目名称/hello
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * 这个注解用于：映射请求的资源路径（/hello）和当前方法（hello）的对应关系  *
	 * 当浏览器请求/hello路径时，就会访问（执行）则个方法	                     *
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	@RequestMapping("/home")
	public String hello() {
		System.out.println("HelloController.hello()");
		return "home";
	}
}
