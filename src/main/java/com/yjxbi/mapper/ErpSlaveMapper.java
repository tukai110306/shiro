package com.yjxbi.mapper;

import java.util.List;

import com.yjxbi.commons.result.PubConstants;
import com.yjxbi.commons.utils.PageInfo;
import com.yjxbi.model.SingleSource;
import com.yjxbi.model.SingleTotal;
import com.yjxbi.model.SingleTotalSum;

public interface ErpSlaveMapper {

	List<PubConstants> queryOperationList();

	List<PubConstants> queryStateListByName(String stateName);

	List<SingleSource> querySingleList(PageInfo pageInfo);

	int querySingleCount(PageInfo pageInfo);

	List<SingleTotal> querySingleSum(PageInfo pageInfo);

	List<SingleTotalSum> querySingleSumTotal(PageInfo pageInfo);

	List<SingleSource> querySingleCustomerCost(PageInfo pageInfo);

	List<PubConstants> queryJsCustomerList();
	
}
