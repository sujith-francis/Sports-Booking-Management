package com.bmg.factory;

import com.bmg.service.BMGServiceImpl;
import com.bmg.service.IBMGService;

public class BMGServiceFactory {
	private static IBMGService bmgService = null;

	private BMGServiceFactory() {

	}

	public static IBMGService getBMGService() {
		if (bmgService == null)
			bmgService = new BMGServiceImpl();
		return bmgService;
	}
}
