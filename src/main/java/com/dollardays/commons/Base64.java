package com.dollardays.commons;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

import com.google.common.io.BaseEncoding;

public class Base64 {

	public static void encrypt(String encryptValue) throws GeneralSecurityException, UnsupportedEncodingException {

		BaseEncoding.base64().encode(encryptValue.getBytes("UTF-8"));

	}

	public static String decrypt(String decryptValue) throws GeneralSecurityException, UnsupportedEncodingException {

		byte[] contentInBytes = BaseEncoding.base64().decode(decryptValue);
		return new String(contentInBytes, "UTF-8");
	}	
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		//username="srikanthtesting100@gmail.com";
		//PWD: password123
		//qwerr@gmail.com
		//password12345
		String inputContent = "password12345";
		String base64String = BaseEncoding.base64().encode(inputContent.getBytes("UTF-8"));
		//decode
		System.out.println("Base64:" + base64String);
		byte[] contentInBytes = BaseEncoding.base64().decode(base64String);
		System.out.println("Source content: " + new String(contentInBytes, "UTF-8"));
	}

}
