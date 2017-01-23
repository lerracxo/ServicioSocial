package com.nielsen.buzz.outputchecks.visualizer.server.transform;

import com.google.gson.Gson;

import spark.ResponseTransformer;

public class JsonTransformer implements ResponseTransformer {

	private static Gson gson= new Gson();
	
	@Override
	public String render(Object obj) {
		return gson.toJson(obj);
	}
}
