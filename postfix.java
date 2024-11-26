package practice;

import java.util.Stack;
import java.util.Scanner;

public class postfix {

	public static String infix_to_postfix(String infix) {
		
		StringBuilder postfix=new StringBuilder();
		Stack<Character> s=new Stack<>();
		
		for(char c:infix.toCharArray()) {
			if(Character.isLetterOrDigit(c)) {
				postfix.append(c);
			}
			else if(c=='(') {
				s.push(c);
			}
			else if(c==')') {
				while(!s.isEmpty() && s.peek()!='(') {
					postfix.append(s.pop());
				}
				s.pop();
			}
			else {
				while(!s.isEmpty() && precedence(s.peek())>=precedence(c)) {
					postfix.append(s.pop());
				}
				s.push(c);
			}
		}
		while(!s.isEmpty()) {
			postfix.append(s.pop());
		}
		return postfix.toString();
	}
	
	public static int precedence(char c) {
		switch(c) {
		case '+':
		case '-':
			return 1;
			
		case '*':
		case '/':
			return 2;
		
		case '^':
			return 3;
		
		default:
			return 0;
		}
	}
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Infix Expression:");
		String infix=sc.nextLine();
		String postfix=infix_to_postfix(infix);
		System.out.println("Postfix Expression: "+postfix);
	}
}
