package com.mwws.app.Service;

import java.util.List;

import com.mwws.app.entity.Parameter;

public interface ParameterService {

	/**
	 * Get list all parameter of System
	 * @return
	 */
	public List<Parameter> getParameter();
}
