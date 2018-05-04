package com.taotao.service;

import java.util.List;

import com.taotoa.common.pojo.ItemCat;

public interface ItemCatList {
       List<ItemCat> getItemcatList(Long parentid);
}
