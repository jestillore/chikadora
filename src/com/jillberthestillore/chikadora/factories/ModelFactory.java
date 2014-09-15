package com.jillberthestillore.chikadora.factories;

import java.util.HashMap;

import com.jillberthestillore.chikadora.models.Model;

public class ModelFactory {

	private static HashMap<String, Class<? extends Model>> map = new HashMap<String, Class<? extends Model>>();
	
	private ModelFactory() {
		
	}
	
	public static void register(String modelId, Class<? extends Model> modelClass) {
		map.put(modelId, modelClass);
	}
	
	public static Model create(String modelId) {
		try {
			return map.get(modelId).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
