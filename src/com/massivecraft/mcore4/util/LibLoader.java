package com.massivecraft.mcore4.util;

import java.io.File;

import com.massivecraft.mcore4.MCore;
import com.massivecraft.mcore4.MPlugin;

public class LibLoader
{	
	public static boolean require(String filename, String url, MPlugin p)
	{
		if ( ! include(filename, url))
		{
			p.log("Failed to load the required library "+filename);
			p.suicide();
			return false;
		}
		return true;
	}
	
	public static boolean include (String filename, String url)
	{
		File file = getFile(filename);
		if ( ! file.exists())
		{
			File parent = file.getParentFile();
			if (parent != null && !parent.exists()) parent.mkdirs();
			
			MCore.p.log("Downloading library "+filename);
			if ( ! DiscUtil.downloadUrl(url, file))
			{
				MCore.p.log(Txt.parse("<b>Failed to download <h>%s", filename));
				return false;
			}
		}
		return ClassLoadHack.load(file);
	}
	
	private static File getFile(String filename)
	{
		return new File("./lib/"+filename);
	}
}