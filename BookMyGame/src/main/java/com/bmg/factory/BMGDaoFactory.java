package com.bmg.factory;

import com.bmg.dao.BMGDaoImpl;
import com.bmg.dao.IBMGDao;

public class BMGDaoFactory {
	private static IBMGDao bmgDao = null;

	private BMGDaoFactory() {

	}

	public static IBMGDao getBMGDao() {
	 if (bmgDao == null)
		 bmgDao = new BMGDaoImpl();
		
		return bmgDao;
	}
}
