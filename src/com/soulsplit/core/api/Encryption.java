package com.soulsplit.core.api;

public class Encryption {
	/**
	*@author Jordan/PriceJordan
	**/
	
	public static String[] replace = {
		"a", "e", "i", "m", "q", "u",
		"b", "f", "j", "n", "r", "v", 
		"c", "g", "k", "o", "s", "w",
		"d", "h", "l", "p", "t", "x",
		"y", "5",
	};
	
	public static String encrypt(String text){
		String newText = "";
		
		newText = text.substring(2) + text.substring(0, 3);
		
		String replaceText = newText;
		
		for(int i = 0; i < replace.length; i++){
			if(newText.contains(replace[i])){
				if(replace[i].equals("z")){
					replaceText = newText.replace(replace[i], "a");
				} else {
					replaceText = newText.replace(replace[i], replace[i + 1]);
				}
			}
		}

		return replaceText.toLowerCase();
	}
	
	public static String decrypt(String text){
		String newText = "";
		
		newText = text.substring(text.length() - 3) +
				text.substring(1, text.length() - 3);
		
		String replaceText = newText;
		
		for(int i = 0; i < replace.length; i++){
			if(newText.contains(replace[i])){
				if(replace[i].equals("a")) {
					replaceText = newText.replace(replace[i], "z");
				} else {
					replaceText = newText.replace(replace[i], replace[i - 1]);
				}
			}
		}
		
		return replaceText.toLowerCase();
	}
}
