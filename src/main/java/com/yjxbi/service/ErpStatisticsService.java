package com.yjxbi.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.yjxbi.commons.result.Tree;
import com.yjxbi.commons.utils.PageInfo;

public interface ErpStatisticsService {

	void querySingleList(PageInfo pageInfo);

	List<Tree> queryOperationList();

	List<Tree> queryStateListByName(String stateName);

	void querySingleSum(PageInfo pageInfo);

	BigDecimal queryFeewithouttax(PageInfo pageInfo);

	List<Tree> queryJsCustomerList();
	
	Map<String,String> getPubConstants(String pubName);
	
}
