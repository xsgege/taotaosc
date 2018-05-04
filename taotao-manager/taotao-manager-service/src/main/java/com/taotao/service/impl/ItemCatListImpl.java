package com.taotao.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.pojo.TbItemCatExample.Criteria;
import com.taotao.service.ItemCatList;
import com.taotoa.common.pojo.ItemCat;
@Service
public class ItemCatListImpl implements ItemCatList {
    @Autowired
	private TbItemCatMapper tbItemCatMapper;
	@Override
	public List<ItemCat> getItemcatList(Long parentid) {
		TbItemCatExample example=new TbItemCatExample();
		Criteria cri=example.createCriteria();
		cri.andParentIdEqualTo(parentid);
		List<TbItemCat> tcat=tbItemCatMapper.selectByExample(example);
		List<ItemCat> li=new  ArrayList();
		for(TbItemCat cat:tcat){
			ItemCat c=new ItemCat();
			c.setId(cat.getId());
			c.setText(cat.getName());
			c.setState(cat.getIsParent()?"closed":"open");
			li.add(c);
		}
		return li;
	}

}
