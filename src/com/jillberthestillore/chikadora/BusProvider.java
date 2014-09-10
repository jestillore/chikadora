package com.jillberthestillore.chikadora;

import com.squareup.otto.Bus;

public class BusProvider {
	
	private BusProvider() {
		
	}
	
	private static final Bus BUS = new Bus();
	
	public static Bus getInstance() {
		return BUS;
	}

}
