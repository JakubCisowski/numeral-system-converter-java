package pl.polsl.controllers;

import java.nio.ByteBuffer;

public class Parser
{
	public static int parseStringToInt(String originalValue)
	{
		int targetValue;

//		try
//		{
		targetValue = Integer.parseInt(originalValue);
//		}
//		catch (NumberFormatException ex)
//		{
//			ex.printStackTrace();
//		}

		return targetValue;
	}

	public static double parseStringToDouble(String originalValue)
	{
		return Double.parseDouble(originalValue);
	}

	public static double parseIntToDouble(int originalValue)
	{
		return Double.valueOf(originalValue);
	}

	public static int parseDoubleToInt(double originalValue)
	{
		return (int)Math.round(originalValue);
	}

	public static String parseIntToString(int originalValue)
	{
		return String.valueOf(originalValue);
	}

	public static String parseCharToString(char originalValue)
	{
		return String.valueOf(originalValue);
	}

	public static char parseIntToChar(int originalValue)
	{
		return (char)originalValue;
	}
}
