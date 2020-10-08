package com.dollardays.utilities;

import java.io.InputStream;
import java.nio.charset.Charset;

import org.apache.commons.io.output.StringBuilderWriter;

public class IOUtils {

	public static String toString(final InputStream input, final Charset encoding) {
		StringBuilderWriter sw = new StringBuilderWriter();
		return sw.toString();
	}
	
	
	
}
