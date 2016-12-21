package com.yjxbi.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yjxbi.commons.annotation.DataSourceChange;
import com.yjxbi.commons.result.PubConstants;
import com.yjxbi.commons.result.Tree;
import com.yjxbi.commons.utils.CoreUtils;
import com.yjxbi.commons.utils.FtcontractConstants;
import com.yjxbi.commons.utils.PageInfo;
import com.yjxbi.mapper.ErpSlaveMapper;
import com.yjxbi.model.SingleSource;
import com.yjxbi.model.SingleTotalSum;
import com.yjxbi.service.ErpStatisticsService;
@Service
public class ErpStatisticsServiceImpl implements ErpStatisticsService {
	
	@Autowired
    private ErpSlaveMapper erpSlaveMapper;

	@Override
	@DataSourceChange(slave = true)
	public void querySingleList(PageInfo pageInfo) {
		pageInfo.setRows(erpSlaveMapper.querySingleList(pageInfo));
        pageInfo.setTotal(erpSlaveMapper.querySingleCount(pageInfo));
        List<SingleSource> list = pageInfo.getRows();
        Map<String,String> contractype2Map = getPubConstants("CONTRACTTYPE2");
        Map<String,String> agentorselfMap =  getPubConstants("SELFAGENT");
        Map<String,String> iszzkfMap = getPubConstants("YN");
        //Map<String,String> developedeptMap = getPubConstants("DEPT");
        Map<String,String> mainregionMap = getPubConstants("MAINREGION");
        Map<String,String> ftccurrencyMap = getPubConstants("CUR");
        for(SingleSource single : list){
        	single.setContractype2value(contractype2Map.get(single.getContractype2()));
        	single.setAgentorself(agentorselfMap.get(single.getAgentorself()));
        	single.setIszzkf(iszzkfMap.get(single.getIszzkf()));
        	//single.setDevelopedept(developedeptMap.get(single.getDevelopedept()));
        	single.setMainregion(mainregionMap.get(single.getMainregion()));
        	single.setFtccurrency(ftccurrencyMap.get(single.getFtccurrency()));
        }
	}

	@Override
	@DataSourceChange(slave = true)
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Tree> queryOperationList() {
		 List<Tree> trees = new ArrayList<Tree>();
	     List<PubConstants> roles = erpSlaveMapper.queryOperationList();
	     for (PubConstants role : roles) {
	         Tree tree = new Tree();
	         tree.setId(role.getId());
	         tree.setText(role.getName());
	         trees.add(tree);
	     }
	     return trees;
	}

	@Override
	@DataSourceChange(slave = true)
	public List<Tree> queryStateListByName(String stateName) {
		 List<Tree> trees = new ArrayList<Tree>();
	     List<PubConstants> roles = erpSlaveMapper.queryStateListByName(stateName);
	     for (PubConstants role : roles) {
	         Tree tree = new Tree();
	         tree.setId(role.getId());
	         tree.setText(role.getName());
	         trees.add(tree);
	     }
	     return trees;
	}
	
	@Transactional
	public Map<String,String> getPubConstants(String pubName){
		if(FtcontractConstants.pubConstants.get(pubName)==null){
			Map<String,String> pubMap = new HashMap<String,String>();
			List<PubConstants> roles = erpSlaveMapper.queryStateListByName(pubName);
			for(PubConstants role : roles){
				pubMap.put(role.getId(), role.getName());
			}
			FtcontractConstants.pubConstants.put(pubName, pubMap);
		}
		return FtcontractConstants.pubConstants.get(pubName);
	}

	@Override
	@DataSourceChange(slave = true)
	public void querySingleSum(PageInfo pageInfo) {
		pageInfo.setTotalList(erpSlaveMapper.querySingleSum(pageInfo));
		pageInfo.setSingletotalsum(erpSlaveMapper.querySingleSumTotal(pageInfo)==null?new SingleTotalSum():erpSlaveMapper.querySingleSumTotal(pageInfo).get(0));
	}

	@Override
	@DataSourceChange(slave = true)
	public BigDecimal queryFeewithouttax(PageInfo pageInfo) {
		List<SingleSource> list = erpSlaveMapper.querySingleCustomerCost(pageInfo);
		BigDecimal resultonly = CoreUtils.ZERO;
		for(SingleSource source : list){
			BigDecimal mockagentfeewithouttax2 = source.getPaymentofagent();
			BigDecimal rate = CoreUtils.ONE;
			String customercode=source.getCustomerno();
			if(customercode.indexOf("A")>0)
				rate = new BigDecimal("1.06");
			else if(customercode.indexOf("B")>0)
				rate = new BigDecimal("1.17");
			else
				rate = CoreUtils.ONE;
			resultonly = resultonly.add(mockagentfeewithouttax2.divide(rate, 2, BigDecimal.ROUND_HALF_UP));
		}
		return resultonly;
	}

	@Override
	@DataSourceChange(slave = true)
	public List<Tree> queryJsCustomerList() {
		 List<Tree> trees = new ArrayList<Tree>();
	     List<PubConstants> roles = erpSlaveMapper.queryJsCustomerList();
	     for (PubConstants role : roles) {
	         Tree tree = new Tree();
	         tree.setId(role.getId());
	         tree.setText(role.getName());
	         trees.add(tree);
	     }
	     return trees;
	}
	
}
