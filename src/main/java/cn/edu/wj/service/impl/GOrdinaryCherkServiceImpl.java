package cn.edu.wj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.wj.mapper.GOrdinaryCherkMapper;
import cn.edu.wj.model.GOrdinaryCherk;
import cn.edu.wj.service.GOrdinaryCherkService;


@Service
public class GOrdinaryCherkServiceImpl implements GOrdinaryCherkService {

	@Autowired
	private GOrdinaryCherkMapper gocMapper;
	
	@Override
	public int insert(GOrdinaryCherk goc){
		// TODO Auto-generated method stub
				int result2 =gocMapper.insert(goc);
				return 0;
	}
	
}
