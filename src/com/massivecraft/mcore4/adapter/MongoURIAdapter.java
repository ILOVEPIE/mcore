package com.massivecraft.mcore4.adapter;

import java.lang.reflect.Type;

import com.massivecraft.mcore4.xlib.gson.JsonDeserializationContext;
import com.massivecraft.mcore4.xlib.gson.JsonDeserializer;
import com.massivecraft.mcore4.xlib.gson.JsonElement;
import com.massivecraft.mcore4.xlib.gson.JsonParseException;
import com.massivecraft.mcore4.xlib.gson.JsonPrimitive;
import com.massivecraft.mcore4.xlib.gson.JsonSerializationContext;
import com.massivecraft.mcore4.xlib.gson.JsonSerializer;
import com.massivecraft.mcore4.xlib.mongodb.MongoURI;

public class MongoURIAdapter implements JsonDeserializer<MongoURI>, JsonSerializer<MongoURI>
{
	// -------------------------------------------- //
	// IMPLEMENTATION
	// -------------------------------------------- //
	
	@Override
	public JsonElement serialize(MongoURI mongoURI, Type typeOfSrc, JsonSerializationContext context)
	{
		return serialize(mongoURI);
	}
	
	@Override
	public MongoURI deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
	{
		return deserialize(json);
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
	
	protected static MongoURIAdapter instance = new MongoURIAdapter();
	public static MongoURIAdapter get()
	{
		return instance;
	}
}
