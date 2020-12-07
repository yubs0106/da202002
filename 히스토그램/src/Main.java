import java.util.Scanner;

// ������׷����� ���� ū ���簢�� ���� ���ϱ�
public class Main {
	static int max(int a, int b) {
		if(a>=b) {
			return a;
		}
		else {
			return b;
		}
	}
	
	static int min(int a, int b) {
		if(a<=b) {
			return a;
		}
		else {
			return b;
		}
	}

	static int histo(int[]v, int a, int b) { // ���������� ���� histo �Լ�
		if(a==b) {
			return v[a];
		}
		int c = (a+b)/2;
		
		int w = max(histo(v,a,c),histo(v,c+1,b));
		
		int i = c;
		int j = c+1;
		
		int h = min(v[i], v[j]);  // h = ���簢���� ����
		
		w = max(w, h*2);   // w = ���簢���� ����
		
		while(i>a || j<b) {
			if( j<b && ( (i==a) || (v[i-1] < v[j+1]) ) ) { 
				++j;
				h = min(h, v[j]);
			}
			else {
				--i;
				h = min(h, v[i]);
			}
			w = max(w, h*(j-i+1));
		}
		return w;
	}

	static int histo(int[] v, int n) {
		return histo(v, 0, n-1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();      // ������ ��
		int[] v = new int[n];	   // ���� ������ �迭
		for(int i=0; i<n; i++) {   // n���� ������ �Է¹޾� �迭 v�� ����
			v[i] = sc.nextInt();
		}
		
		int r = histo(v,n);        // ���� ū ���簢���� ���� ���
		System.out.println(r);

	}

}
