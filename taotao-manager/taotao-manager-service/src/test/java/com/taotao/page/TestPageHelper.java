package com.taotao.page;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;

public class TestPageHelper {  
    
	   @Test  
	   public void testPageHelper() throws Exception{  
	     
	       ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:spring/applicationContext-*.xml");  
	       TbItemMapper tbItemMapper = applicationContext.getBean(TbItemMapper.class);  
	       PageHelper.startPage(1, 30);  
	       TbItemExample tbItemExample = new TbItemExample();  
	       //如果要使用条件查询，则先创建Criteria，然后使用它来拼接查询条件，这里我们不按条件查询，我们查询全部。  
//	     Criteria criteria = tbItemExample.createCriteria();  
//	     criteria.andIdEqualTo(1L);  
	       //pagehelper的Page类是继承ArrayList的，Page里面有分页结果  
	       List<TbItem> list = tbItemMapper.selectByExample(tbItemExample);  
	       //4.取分页信息，使用PageInfo对象获取，我们使用PageInfo的目的便是把List强转成Page对象，从而得到分页结果  
	       PageInfo<TbItem> pageInfo = new PageInfo<>(list);  
	       System.out.println("总记录数："+pageInfo.getTotal());  
	       System.out.println("总页数："+pageInfo.getPages());  
	       System.out.println("返回的记录数："+pageInfo.getSize());  
	   }  
	}  