package com.massivecraft.mcore4.cmd.arg;

import java.util.Collection;

public class ARStringMatchStartCI extends ARAbstractStringMatch
{
	// -------------------------------------------- //
	// IMPLEMENTATION
	// -------------------------------------------- //
	
	@Override
	public Integer matches(String arg, String alt)
	{
		arg = arg.toLowerCase();
		alt = alt.toLowerCase();
		if (alt.startsWith(arg))
		{
			return alt.length() - arg.length();
		}
		else
		{
			return null;
		}
	}

	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //
	
	public ARStringMatchStartCI(String typename, Collection<Collection<String>> altColls)
	{
		super(typename, altColls);
	}
}
