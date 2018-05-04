package com.taotao.service;

import com.taotao.pojo.TbItem;
import com.taotoa.common.pojo.EasyUIDataGridResult;

public interface items {
	TbItem getbyid(Long id);
	EasyUIDataGridResult getItemList(int page,int rows);
}
