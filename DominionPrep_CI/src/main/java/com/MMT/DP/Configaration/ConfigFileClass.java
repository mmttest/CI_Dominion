package com.MMT.DP.Configaration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.MMT.DP.FrameWorkConstant.Paths;

public class ConfigFileClass {

	private static Properties propFile;
	private static FileInputStream file;
	private static final Map<String, String> CONFIGMAP = new HashMap<>();;

	public static String setProperty(String key) throws Throwable {
		return CONFIGMAP.get(key);
	}

	static {

		try {
			file = new FileInputStream(Paths.getConfigpath());
			propFile = new Properties();
			propFile.load(file);
			for(Object kay : propFile.keySet()) {
				CONFIGMAP.put(String.valueOf(kay), String.valueOf(propFile.get(kay)));	
			}
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}

