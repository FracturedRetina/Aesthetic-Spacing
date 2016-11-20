package com.eshimoniak.aestheticspacing;

/**
 * Created by Evan Shimoniak on 11/19/16.
**/
public class SpaceModifier {
	public static String addSpaces(String str, int kerning, int spaceWidth, boolean nbsp) {
		String kern = "";
		String largeSpace = "";
		String finalStr = "";

		for (int i = 0; i < kerning; i++) {
			if (nbsp) {
				kern += '\u00a0';
			} else {
				kern += ' ';
			}
		}
		for (int i = 0; i < spaceWidth; i++) {
			largeSpace += ' ';
		}

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ' || str.charAt(i) == '\u00a0') {
				finalStr += largeSpace;
			} else {
				if (i == str.length() - 1) {
					finalStr += str.charAt(i);
				} else {
					finalStr += str.charAt(i) + kern;
				}
			}
		}


		return finalStr;
	}
}
