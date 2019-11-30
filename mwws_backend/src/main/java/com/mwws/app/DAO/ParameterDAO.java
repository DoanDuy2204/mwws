package com.mwws.app.DAO;

import java.util.List;

import com.mwws.app.entity.Parameter;

public interface ParameterDAO {

	/**
	 * Get list all parameter of System
	 * @return
	 */
	public List<Parameter> getParameter();
}
