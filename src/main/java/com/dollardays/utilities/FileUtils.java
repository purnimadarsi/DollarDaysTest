package com.dollardays.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.apache.commons.io.Charsets;

public class FileUtils {

	public static String readFileToString(final File file, final String encoding) throws IOException{
		return readFileToString1(file, Charsets.toCharset(encoding));
	}
	
	public static String readFileToString1(final File file, final Charset encoding) throws IOException{
         InputStream in = null;
         try {
        	 in = new FileInputStream(file);
        	 return IOUtils.toString(in, Charsets.toCharset(encoding));
         } finally{
        	 in.close();
		}
	}
	
	
}
