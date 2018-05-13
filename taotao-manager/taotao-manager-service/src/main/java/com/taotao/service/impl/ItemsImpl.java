package com.taotao.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.mapper.TbItemParamItemMapper;
import com.taotao.mapper.TbItemParamMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemExample;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamExample;
import com.taotao.pojo.TbItemParamItem;
import com.taotao.service.items;
import com.taotao.util.IdUtils;
import com.taotoa.common.pojo.EasyUIDataGridResult;
import com.taotoa.common.pojo.taotaores;
@Service
public class ItemsImpl implements items {
    @Autowired
    private TbItemMapper tbItemMapper;
    @Autowired
    private TbItemParamItemMapper tbItemParamItemMapper;
    @Autowired
    private TbItemDescMapper tbItemDescMapper;
    @Autowired
    private TbItemParamMapper tbItemParamMapper;
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
	@Override
	public taotaores createItem(TbItem tbitem, String desc,String itemParams) {
		long id=IdUtils.GetItemId();
		Date date=new Date();
		tbitem.setId(id);
		tbitem.setStatus((byte)1);
		tbitem.setCreated(date);
		tbitem.setUpdated(date);
		tbItemMapper.insert(tbitem);
		TbItemDesc tbItemDesc=new TbItemDesc();
		tbItemDesc.setItemId(id);
		tbItemDesc.setItemDesc(desc);
		tbItemDesc.setCreated(date);
		tbItemDesc.setUpdated(date);
		tbItemDescMapper.insert(tbItemDesc);
		TbItemParamItem tbItemParamItem=new TbItemParamItem();
		tbItemParamItem.setItemId(id);
		tbItemParamItem.setParamData(itemParams);
		tbItemParamItem.setCreated(date);
		tbItemParamItem.setUpdated(date);
		tbItemParamItemMapper.insert(tbItemParamItem);
		return taotaores.ok();
	}
	@Override
	public EasyUIDataGridResult getItemparamList(int page, int rows) {
		PageHelper.startPage(page, rows);
		TbItemParamExample example=new TbItemParamExample();
		List<TbItemParam> lst= tbItemParamMapper.selectByExampleWithBLOBs(example);
		PageInfo<TbItemParam> pageInfo=new PageInfo<>(lst);
		EasyUIDataGridResult ed=new EasyUIDataGridResult();
		ed.setTotal(pageInfo.getTotal());
		ed.setRows(lst);
		return ed;
	}

}
