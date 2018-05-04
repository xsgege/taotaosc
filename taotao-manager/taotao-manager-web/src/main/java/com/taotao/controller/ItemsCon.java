package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.pojo.TbItem;
import com.taotao.service.items;
import com.taotoa.common.pojo.EasyUIDataGridResult;

@Controller
public class ItemsCon {
       @Autowired
       private items i;
       @RequestMapping("/items/{id}")
       @ResponseBody
       public TbItem getItemById(@PathVariable Long id){
    	   TbItem tb=  i.getbyid(id);
    	   return tb;
       }
       @RequestMapping("/")
       public String index(){
    	   return "index";
       }
       @RequestMapping("/{page}")
       public String index(@PathVariable String page){
    	   return page;
       }
       @RequestMapping("/item/list")
       @ResponseBody
       public EasyUIDataGridResult getItemList(Integer page,Integer rows){
    	   
    	   EasyUIDataGridResult easy= i.getItemList(page, rows);    	   
    	   return easy;
       }
}
