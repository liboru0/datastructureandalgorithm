package com.spider.datastructure.stack;

public class CalculatorAssistUtils {
	
	// 返回运算符优先级
	public static int priority(int oper){
		if('*'==oper||'/'==oper){
			return 1;
		}else if('+'==oper||'-'==oper){
			return 0;
		}else{
			return -1;
		}
	}
	
	// 判断是否是运算符
	public static boolean isOper(char val){
		return val=='+' || val == '-'|| val == '*'|| val == '/';
	}
	
	// 计算方法
	public static int cal(int num1,int num2,int oper){
		int result = 0;
		switch (oper) {
		case '+':
			result = num1+num2;
			break;
		case '-':
			result = num1-num2;
			break;
		case '*':
			result = num1*num2;
			break;
		case '/':
			result = num1/num2;
			break;
		default:
			break;
		}
		return result;
	}

}
