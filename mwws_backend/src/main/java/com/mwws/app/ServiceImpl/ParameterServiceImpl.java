package com.mwws.app.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mwws.app.DAO.ParameterDAO;
import com.mwws.app.Service.ParameterService;
import com.mwws.app.entity.Parameter;

@Service
public class ParameterServiceImpl implements ParameterService{

	@Autowired
	ParameterDAO parameterDAO;
	
	@Override
	public List<Parameter> getParameter() {
		return parameterDAO.getParameter();
	}

}
