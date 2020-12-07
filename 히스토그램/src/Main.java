import java.util.Scanner;

// 히스토그램에서 가장 큰 직사각형 넓이 구하기
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

	static int histo(int[]v, int a, int b) { // 분할정복을 위한 histo 함수
		if(a==b) {
			return v[a];
		}
		int c = (a+b)/2;
		
		int w = max(histo(v,a,c),histo(v,c+1,b));
		
		int i = c;
		int j = c+1;
		
		int h = min(v[i], v[j]);  // h = 직사각형의 높이
		
		w = max(w, h*2);   // w = 직사각형의 넓이
		
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
		int n = sc.nextInt();      // 샘플의 수
		int[] v = new int[n];	   // 도수 저장할 배열
		for(int i=0; i<n; i++) {   // n개의 도수를 입력받아 배열 v에 저장
			v[i] = sc.nextInt();
		}
		
		int r = histo(v,n);        // 가장 큰 직사각형의 넓이 계산
		System.out.println(r);

	}

}
