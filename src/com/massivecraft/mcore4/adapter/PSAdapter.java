package com.massivecraft.mcore4.adapter;

import java.lang.reflect.Type;

import com.massivecraft.mcore4.PS;
import com.massivecraft.mcore4.xlib.gson.Gson;
import com.massivecraft.mcore4.xlib.gson.JsonDeserializationContext;
import com.massivecraft.mcore4.xlib.gson.JsonDeserializer;
import com.massivecraft.mcore4.xlib.gson.JsonElement;
import com.massivecraft.mcore4.xlib.gson.JsonParseException;
import com.massivecraft.mcore4.xlib.gson.JsonPrimitive;
import com.massivecraft.mcore4.xlib.mongodb.MongoURI;

public class PSAdapter implements JsonDeserializer<PS>
{
	// -------------------------------------------- //
	// IMPLEMENTATION
	// -------------------------------------------- //
	
	@Override
	public PS deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
	{
		if (json.isJsonPrimitive())
		{
			return new PS(json.getAsString());
		}
		return new Gson().fromJson(json, typeOfT);
	}
	
	// -------------------------------------------- //
	// STATIC LOGIC
	// -------------------------------------------- //
	
	public static JsonElement serialize(MongoURI mongoURI)
	{
		return new JsonPrimitive(mongoURI.toString());
	}
	
	public static MongoURI deserialize(JsonElement json)
	{
		return new MongoURI(json.getAsString());
	}
	
	// -------------------------------------------- //
	// INSTANCE
	// -------------------------------------------- //
	
	protected static PSAdapter instance = new PSAdapter();
	public static PSAdapter get()
	{
		return instance;
	}
}
