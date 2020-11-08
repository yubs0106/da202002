import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		System.out.print("�������� ���� : ");
		int N = sc.nextInt();
		int[] stack = new int[N];
		
		System.out.print("������ ���۰� : ");
		int a = sc.nextInt();
		
		System.out.print("������ ���ᰪ : ");
		int b = sc.nextInt();
		
		Random ran = new Random(1000);
		for(int i=0; i<stack.length; i++) {
			stack[i] = ran.nextInt();
		}
		
		int max = stack[a-1];
		for(int j=a-1; j<b; j++) {
			if(stack[j]>max) {
				max = stack[j];
			}
		}
		
		int min = stack[a-1];
		for(int k=a-1; k<b; k++) {
			if(stack[k]<min) {
				min = stack[k];
			}
		}
		
		int sum = 0;
		for(int l=a-1; l<b; l++) {
			sum+=stack[l];
		}
		
		System.out.println("���� �� �������� �ִ� : " + max);
		System.out.println("���� �� �������� �ּڰ� : " + min);
		System.out.println("���� �� �������� �հ� : " + sum);

	}

}
