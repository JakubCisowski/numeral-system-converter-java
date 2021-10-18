package pl.polsl.models;

import pl.polsl.controllers.Converter;

public class Number
{
	private String value;
	private int numeralSystem;
	private double valueInDecimalSystem;

	public Number(String value, int numeralSystem)
	{
		this.value = value;
		this.numeralSystem = numeralSystem;

		valueInDecimalSystem = Converter.convertToDecimalValue(this);
	}

	public String getValue()
	{
		return value;
	}

	public int getNumeralSystem()
	{
		return numeralSystem;
	}

	public double getValueInDecimalSystem()
	{
		return valueInDecimalSystem;
	}

}
