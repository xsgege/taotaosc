package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.pojo.TbItem;

@Controller
public class testcon {
     @RequestMapping("/ajax")
	@ResponseBody
	 public TbItem fun(@RequestBody TbItem tbItem){
		 
		 
		 return tbItem;
	 }
	
}
