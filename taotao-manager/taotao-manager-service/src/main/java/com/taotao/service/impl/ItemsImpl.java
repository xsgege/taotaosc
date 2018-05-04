package com.taotao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.items;
import com.taotoa.common.pojo.EasyUIDataGridResult;
@Service
public class ItemsImpl implements items {
    @Autowired
    private TbItemMapper tbItemMapper;
	@Override
	public TbItem getbyid(Long id) {
		TbItem tb=	tbItemMapper.selectByPrimaryKey(id);
		return tb;
	}
	@Override
	public EasyUIDataGridResult getItemList(int page, int rows) {
		
		PageHelper.startPage(page, rows);
		TbItemExample example=new TbItemExample();
		List<TbItem> lst= tbItemMapper.selectByExample(example);
		PageInfo<TbItem> pageInfo=new PageInfo<>(lst);
		EasyUIDataGridResult ed=new EasyUIDataGridResult();
		ed.setTotal(pageInfo.getTotal());
		ed.setRows(lst);
		return ed;
	}

}
