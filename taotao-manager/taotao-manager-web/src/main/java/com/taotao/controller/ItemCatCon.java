package com.taotao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.service.ItemCatList;
import com.taotoa.common.pojo.ItemCat;

@Controller
public class ItemCatCon {
	@Autowired
	private ItemCatList itemCatList;
	 @RequestMapping("item/cat/list")
     @ResponseBody
     public List<ItemCat> getItemcatList(@RequestParam(value="id",defaultValue="0") Long id ){
		 List<ItemCat> li= itemCatList.getItemcatList(id);
		 
		 
		return li;
		 
		 
	 }
}
