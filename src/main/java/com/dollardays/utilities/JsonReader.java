package com.dollardays.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

public class JsonReader {

	public static Logger APPLICATION_LOGS = Logger.getLogger(JsonReader.class);

	@DataProvider(name = "dd-dataprovider")
	public static Object[][] getTestData(ITestContext context, Method metod)
			throws JsonParseException, JsonMappingException, IOException {
		DDDataProvider params = metod.getAnnotation(DDDataProvider.class);
		Object obj[][] = getData(params.datafile());
		return obj;
	}

	// Function to get Test Data form Excel File for a particular Test case
	public static Object[][] getData(String file) throws IOException {
		Gson gson = new Gson();
		final Type DATA_TYPE = new TypeToken<List<Map<String, Object>>>() {
		}.getType();
		List<Map<String, String>[]> mapData;
		JsonElement jsonData = new JsonParser().parse(new FileReader(file));
		JsonElement dataSet = jsonData.getAsJsonArray();

		if (jsonData.toString().startsWith("[")) {
			mapData = gson.fromJson(dataSet, DATA_TYPE);
		} else {
			String jsonStr = FileUtils.readFileToString(new File(file), "UTF-8");
			mapData = gson.fromJson(jsonStr, DATA_TYPE);
		}

		Object[][] returnValue = new Object[mapData.size()][1];
		for (int i = 0; i < mapData.size(); i++) {
			returnValue[i][0] = mapData.get(i);
		}

		return returnValue;

	}

}
