package com.eshimoniak.aestheticspacing;

/**
 * Created by Evan Shimoniak on 11/19/16.
**/
public class SpaceModifier {
	/**
	 * Add spaces in between characters and replace single spaces with multiple spaces
	 * @param inputStr Original string
	 * @param kerning Number of spaces to add in between letters
	 * @param spaceWidth Number of spaces ot use in place of any spaces in the original text
	 * @param nbsp Whether to use non-breaking spaces in the middle of words
	 * @return Modified copy of the original string
	**/
	public static String addSpaces(String inputStr, int kerning, int spaceWidth, boolean nbsp) {
		String kern = "";
		String largeSpace = "";
		String finalStr = "";

		//Define string of spaces to be placed in between letters
		//(Set kerning string)
		for (int i = 0; i < kerning; i++) {
			if (nbsp) {
				kern += '\u00a0';
			} else {
				kern += ' ';
			}
		}
		//Define string of spaces to replace single spaces
		//(Set spacing string)
		for (int i = 0; i < spaceWidth; i++) {
			largeSpace += ' ';
		}

		//Create modified string
		for (int i = 0; i < inputStr.length(); i++) {
			if (inputStr.charAt(i) == ' ' || inputStr.charAt(i) == '\u00a0') {
				finalStr += largeSpace;
			} else {
				if (i == inputStr.length() - 1) {
					finalStr += inputStr.charAt(i);
				} else {
					finalStr += inputStr.charAt(i) + kern;
				}
			}
		}


		return finalStr;
	}
}
