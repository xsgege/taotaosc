package com.taotao.service;

import com.taotao.pojo.TbItem;
import com.taotoa.common.pojo.EasyUIDataGridResult;
import com.taotoa.common.pojo.taotaores;

public interface items {
	TbItem getbyid(Long id);
	EasyUIDataGridResult getItemList(int page,int rows);
	taotaores createItem(TbItem tbitem,String desc,String itemParams);
	EasyUIDataGridResult getItemparamList(int page,int rows);
}
