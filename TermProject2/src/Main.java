import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		
		System.out.print("�������� ���� (N) : ");
		int N = sc.nextInt();

		System.out.print("������ ������ ���� (k) : ");
		int k = sc.nextInt();			
		
		long start_time = System.currentTimeMillis(); 
		
		int[] stack = new int[N];
		Random ran = new Random(1000);
		for(int i=0; i<stack.length; i++) {
			stack[i] = ran.nextInt();
		}
		
		int[] start = new int[k];  // ������ ���۰��� �ִ� �迭
		int[] end = new int[k];    // ������ ���ᰪ�� �ִ� �迭
		Random ran2 = new Random(1000);
		for(int i=0; i<k; i++) {
			int a = ran2.nextInt(N);
			int b = ran2.nextInt(N);
			if(a<=b) {
				start[i] = a;
				end[i] = b;
			}
			else {
				start[i] = b;
				end[i] = a;
			}
		}
		
		for(int i=0; i<k; i++) {
			int max = stack[start[i]];
			for(int j=start[i]; j<=end[i]; j++) {
				if(stack[j]>max) {
					max = stack[j];
				}
			}
			
			int min = stack[start[i]];
			for(int j=start[i]; j<=end[i]; j++) {
				if(stack[j]<min) {
					min = stack[j];
				}
			}
			
			long sum = 0;
			for(int j=start[i]; j<=end[i]; j++) {
				sum+=stack[j];
			}
			
			System.out.println((i+1)+"��° ������ �ּڰ� :"+min+", �ִ� : "+max+", �հ� : "+sum);
		}

		long end_time = System.currentTimeMillis(); 
		
		System.out.println("Elapsed time is "+(end_time-start_time)+"ms.");


	
	}

}
