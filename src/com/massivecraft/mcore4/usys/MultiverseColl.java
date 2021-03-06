package com.massivecraft.mcore4.usys;

import com.massivecraft.mcore4.MCore;
import com.massivecraft.mcore4.store.Coll;

public class MultiverseColl extends Coll<Multiverse, String>
{
	// -------------------------------------------- //
	// META
	// -------------------------------------------- //
	public static MultiverseColl i = new MultiverseColl();
	
	private MultiverseColl()
	{
		super(MCore.p, "ai", "usys_multiverse", Multiverse.class, String.class, false);
	}
	
	@Override
	public void init()
	{
		super.init();
		
		// Ensure the default multiverse exits
		this.get(MCore.DEFAULT, true);
	}
	
}
