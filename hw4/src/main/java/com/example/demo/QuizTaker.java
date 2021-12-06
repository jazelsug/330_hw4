package com.example.demo;

public class QuizTaker{
	String name;
	String result;

	double cyrus = 0.0;
	double lnx1 = 0.0;
	double shaking = 0.0;
	double thankyou = 0.0;
	double wazowski = 0.0;


	public void setName(String n){
		name = n;
	}

	public String getName(){
		return name;
	}

	public void setResult(String r){
		result = r;
	}

	public String getResult(){
		return result;
	}

	public void addToCyrus(double value){
		cyrus = cyrus + value;
	}

	public void addToLnx1(double value){
		lnx1 = lnx1 + value;
	}

	public void addToShaking(double value){
		shaking = shaking + value;
	}

	public void addToThankYou(double value){
		thankyou = thankyou + value;
	}

	public void addToWazowski(double value){
		wazowski = wazowski + value;
	}

	public void calculateResult(){
		double maxVal = 0.0;

		if (maxVal <= cyrus){
			maxVal = cyrus;
			result = "cyrus";
		}
		if (maxVal <= lnx1){
			maxVal = lnx1;
			result = "lnx1";
		}
		if (maxVal <= shaking){
			maxVal = shaking;
			result = "shaking";
		}
		if (maxVal <= thankyou){
			maxVal = thankyou;
			result = "thankyou";
		}
		if (maxVal <= wazowski){
			maxVal = wazowski;
			result = "wazowski";
		}
	}
}