package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.pojo.TbItem;
import com.taotao.service.TbItemParamService;
import com.taotao.service.items;
import com.taotoa.common.pojo.EasyUIDataGridResult;
import com.taotoa.common.pojo.taotaores;

@Controller
public class ItemsCon {
       @Autowired
       private items i;
       @Autowired
       private TbItemParamService tbItemParamService;
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
       @RequestMapping(value="/item/save",method=RequestMethod.POST)
       @ResponseBody
       public taotaores addItem(TbItem tbitem, String desc,String itemParams){
    	   
    	   taotaores res= i.createItem(tbitem, desc,itemParams);   	   
    	   return res;
       }
       @RequestMapping("/item/param/list")
       @ResponseBody
       public EasyUIDataGridResult getItemparamList (@RequestParam(defaultValue="1") Integer page,@RequestParam(defaultValue="30")Integer rows){
    	   
    	   EasyUIDataGridResult easy= i.getItemparamList(page, rows);   
    	   return easy;
       }
       @RequestMapping("/item/param/query/itemcatid/{cid}")
       @ResponseBody
       public taotaores Itemparam(@PathVariable Long cid){
    	   taotaores res =   tbItemParamService.getTbItemParam(cid);
    	      	   
    	   return res;
       }
       @RequestMapping("/item/param/save/{cid}")
       @ResponseBody
       public taotaores saveItemparam(@PathVariable Long cid,String paramData){
    	   taotaores res=tbItemParamService.saveItemparam(cid, paramData);
    	      	   
    	   return res;
       }
       @RequestMapping("/item/param/delete")
       @ResponseBody
       public taotaores deleteItemparam(Long ids){
    	  
    	   taotaores res= tbItemParamService.deleteItemparam(ids)  ;
    	   return res;
       }
}
