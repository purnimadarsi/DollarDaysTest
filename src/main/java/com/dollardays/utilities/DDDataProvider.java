package com.dollardays.utilities;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)  
@Target(ElementType.METHOD)  
public @interface DDDataProvider {

	 String datafile();
	 String sheetName();
	 String testcaseID();
	 String runmode();
} 
 