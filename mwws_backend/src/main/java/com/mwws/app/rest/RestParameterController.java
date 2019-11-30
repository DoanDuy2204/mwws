package com.mwws.app.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mwws.app.Service.ParameterService;
import com.mwws.app.entity.Parameter;

@RestController
@RequestMapping("parameter")
@CrossOrigin
public class RestParameterController {
	
	@Autowired
	ParameterService parameterService;
	
	@RequestMapping(value="list",method = RequestMethod.GET)
	public List<Parameter> listParameter(){
		List<Parameter> parameters = parameterService.getParameter();
		return parameters;
	}
	
}
