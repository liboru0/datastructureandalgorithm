package com.liboru.datastructure.stack;

public class Calculator {
	
	public static void main(String[] args) {
		System.out.println(Calculator.infixCal("7*2*20-5+5+4-4"));
	}
	
	/**
	 * 中缀表达式计算器
	 */
	public static int infixCal(String expression) {
		ArrayStack<Integer> numStack = new ArrayStack<>();
		ArrayStack<Integer> operStack = new ArrayStack<>();
		int index = 0; // 用于扫描表达式
		char ch; // 用于存储扫描到的字符串的没过字符
		String keepNumStr = ""; // 用于拼接多位数
		int num1 = 0;
		int num2 = 0;
		int oper = 0;
		int res = 0;
		
		while(true){
			ch = expression.charAt(index);
			
			if(CalculatorAssistUtils.isOper(ch)){ // 如果是符号
				if(!operStack.isEmpty()){
					if(CalculatorAssistUtils.priority(ch)<=CalculatorAssistUtils.priority(operStack.peek())){
						/**
						 * 如果符号栈有操作符，就进行比较，如果当前的操作符的优先级小于或等于栈中的操作符，
						 * 就需要从数栈中pop出两个数，从符号栈pop出一个符号，
						 * 进行运算，将得到结果，入数栈，然后将当前的操作符入符号栈
						 */
						num1 = numStack.pop();
						num2 = numStack.pop();
						oper = operStack.pop();
						res = CalculatorAssistUtils.cal(num2, num1, oper);
						numStack.push(res);
						operStack.push((int)ch);
					}else{
						// 如果当前的操作符的优先级大于栈中的操作符，就直接入符号栈
						operStack.push((int)ch);
					}
				}else{
					// 如果为空，直接入栈
					operStack.push((int)ch);
				}
			}else{
				keepNumStr += ch;
				
				// 如果已经是最后一位，则直接入数栈，清空keepNumStr
				if(index==expression.length()-1){
					numStack.push(Integer.parseInt(keepNumStr));
					keepNumStr = "";
				}else{
				
					// 判断下一个字符是否是运算符
					if(CalculatorAssistUtils.isOper(expression.charAt(index+1))){
						//如果下一位是运算符，则直接入数栈，清空keepNumStr
						numStack.push(Integer.parseInt(keepNumStr));
						keepNumStr = "";
					}
					
				}
				// 否则扫描下一个
			}
			
			index++;
			if(index>=expression.length()){
				break;
			}
			
		}
		
		// 当表达式扫描完毕，就顺序的从数栈和符号栈中pop出相应的数和符号，并运行
		while(true){
			//如果符号栈为空，则计算到最后的结果，数栈中只有一个数字【结果】
			if(operStack.isEmpty()){
				break;
			}
			num1 = numStack.pop();
			num2 = numStack.pop();
			oper = operStack.pop();
			res = CalculatorAssistUtils.cal(num2, num1, oper);
			numStack.push(res);
		}
		
		return numStack.pop();
		
	}
	

}
