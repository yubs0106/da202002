import java.util.Scanner;

public class Main_9012 {
	
	public static boolean isValid(String str) {
		char[] stack = new char[1024];
		int top = -1;
		
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			if(ch == '(' ) {
				top++;
				stack[top] = ch;
			}
			else if(ch == ')') {
				if(top == -1 || stack[top] != '(') {
					return false;
				}
				top--;
			}
		}
		return top == -1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		char result [] = new char[n];
		
		for(int i=0; i<n; i++) {
			String abc = sc.next();
			if(isValid(abc)) {
				result[i] = 'y';
			}
			else {
				result[i] = 'n';
			}
		}
		
		for(int j=0; j<result.length; j++) {
			if(result[j] == 'y') {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}

	}

}
