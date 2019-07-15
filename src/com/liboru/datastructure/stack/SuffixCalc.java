package com.liboru.datastructure.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

public class SuffixCalc {
	
	/**
     * 匹配 + - * / ( ) 运算符
     */
    static final String SYMBOL = "\\+|-|\\*|/|\\(|\\)";

    static final String LEFT = "(";
    static final String RIGHT = ")";
    static final String ADD = "+";
    static final String MINUS= "-";
    static final String TIMES = "*";
    static final String DIVISION = "/";
    
    /**
     * 加減 + -
     */
    static final int LEVEL_01 = 1;
    /**
     * 乘除 * /
     */
    static final int LEVEL_02 = 2;

    /**
     * 括号
     */
    static final int LEVEL_HIGH = Integer.MAX_VALUE;
    
	public static Double doTheMath(String s1,String s2,String symbol){
        Double result ;
        switch (symbol){
            case ADD : result = Double.valueOf(s1) + Double.valueOf(s2); break;
            case MINUS : result = Double.valueOf(s1) - Double.valueOf(s2); break;
            case TIMES : result = Double.valueOf(s1) * Double.valueOf(s2); break;
            case DIVISION : result = Double.valueOf(s1) / Double.valueOf(s2); break;
            default : result = null;
        }
        return result;

    }
	
	/**
     * 判断是不是运算符
     */
    public static boolean isSymbol(String s){
        return s.matches(SYMBOL);
    }
    
    /**
     * 判断是不是数字 int double long float
     */
    public static boolean isNumber(String s){
        Pattern pattern = Pattern.compile("^[0-9]+(.[0-9]+)?$");
        return pattern.matcher(s).matches();
    }
    
    /**
     * 去除所有空白符
     */
    public static String replaceAllBlank(String s ){
        // \\s+ 匹配任何空白字符，包括空格、制表符、换页符等等, 等价于[ \f\n\r\t\v]
        return s.replaceAll("\\s+","");
    }
    
    /**
     * 将中缀表达式转成List
     */
    public static List<String> toInfixExpressionList(String infixExpression){
    	
    	List<String> list = new ArrayList<>();
    	
    	int i = 0; // 用于遍历中缀表达式
    	String str = ""; // 用于对多位数的拼接
    	
    	while(true){
    		
    		if(i==infixExpression.length()){
    			break;
    		}
    		
    		String s = infixExpression.substring(i,i+1);
    		
    		if(isSymbol(s)){
    			list.add(s);
    		}else if(isNumber(s)||".".equals(s)){
    			str += s;
    			if(i+1==infixExpression.length()){
    				list.add(str);
    				str = "";
    			}else{
    				if(isSymbol(infixExpression.substring(i+1,i+2))){
        				list.add(str);
        				str = "";
        			}
    			}
    		}
    		
    		i++;
    		
    	}
    	
    	return list;
    }
    
    /**
     * 匹配运算等级
     */
    public static int calcLevel(String s){
        if("+".equals(s) || "-".equals(s)){
            return LEVEL_01;
        } else if("*".equals(s) || "/".equals(s)){
            return LEVEL_02;
        }
        return LEVEL_HIGH;
    }
    
    public static List<String> doMatch (String s){
    	
    	s = replaceAllBlank(s);
    	List<String> infixList = toInfixExpressionList(s);
    	List<String> suffixList = parseSuffixExpressionList(infixList);
    	return suffixList;
    }
    
    /**
     * 中缀List转后缀List
     */
    public static List<String> parseSuffixExpressionList(List<String> infixExpressionList){
    	
    	Stack<String> s1 = new Stack<>(); // 符号栈
    	List<String> s2 = new ArrayList<>(); // 储存中间结果的List(由于这个栈没有pop操作，且最后要倒叙输出，所以用List替代了Stack)
    	
    	for(String item:infixExpressionList){
    		if(isNumber(item)){
    			//如果是一个数，则加入s2
    			s2.add(item);
    		}else if(LEFT.equals(item)){
    			s1.push(item);
    		}else if(RIGHT.equals(item)){
    			// 如果是右括号“)”，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
    			while(!LEFT.equals(s1.peek())){
    				s2.add(s1.pop());
    			}
    			s1.pop();
    		}else {
    			//当item小于等于栈顶的运算符或s1栈顶元素是(
    			while(!s1.isEmpty() && !LEFT.equals(s1.peek()) && calcLevel(item) <= calcLevel(s1.peek())){
    				s2.add(s1.pop());
    			}
    			s1.push(item);
    		}
    	}
    	
    	while(!s1.isEmpty()){
    		s2.add(s1.pop());
    	}
    	
    	return s2;
    }
	
	public static Double doCalc(List<String> list){
		Double result = 0d;
        if(list == null || list.isEmpty()){
            return null;
        }
        if (list.size() == 1){
            System.out.println(list);
            result = Double.valueOf(list.get(0));
            return result;
        }
        
        Stack<String> stackCal = new Stack<>();
        
        for(String item : list){
        	/**
        	 * 如果是数字，直接入栈
        	 * 如果是符号，就从栈中pop出两个数做运算，再将结果压入栈中
        	 */
        	if(isSymbol(item)){
        		String numStr2 = stackCal.pop();
        		String numStr1 = stackCal.pop();
        		stackCal.push(""+doTheMath(numStr1, numStr2, item));
        	}else{
        		stackCal.push(item);
        	}
        }
        
		return Double.valueOf(stackCal.pop());
	}
	
	public static void main(String[] args) {
		String math = "12.8 + (2 - 3.55)*4+10/5.0";
		List<String> list = doMatch(math);
		System.out.println(list);
		System.out.println(doCalc(list));
		
		
	}

}
