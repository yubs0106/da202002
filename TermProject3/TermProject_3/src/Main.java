import java.util.Random;
import java.util.Scanner;

public class Main {
	// 합
	static long sum_init(int[] v, long[] tree, int node, int r_first, int r_last) {
		if(r_first == r_last) {
			return tree[node] = v[r_first];
		}
		int mid = (r_first + r_last)/2;
		return tree[node] = sum_init(v,tree,node*2,r_first,mid) + sum_init(v,tree,node*2+1,mid+1,r_last);
	}
	
	static long sum(long[] tree, int node, int r_first, int r_last, int q_start, int q_end) {
		if(r_last < q_start || q_end < r_first){
			return 0;
		}
		if(q_start <= r_first && r_last <= q_end) {
			return tree[node];
		}
		int mid = (r_first+r_last)/2;
		return sum(tree,node*2,r_first,mid,q_start,q_end) + sum(tree,node*2+1,mid+1,r_last,q_start,q_end);
	}
	// 최소
	static int min_init(int[] v, int[] tree, int node, int r_first, int r_last) {
		if(r_first == r_last) {
			return tree[node] = v[r_first];
		}
		int mid = (r_first + r_last)/2;
		return tree[node] = Math.min(min_init(v,tree,node*2,r_first,mid), min_init(v,tree,node*2+1,mid+1,r_last));
	}
	
	static int min(int[] tree, int node, int r_first, int r_last, int q_start, int q_end) {
		if(r_last < q_start || q_end < r_first) {
			return Integer.MAX_VALUE; // int에서 가장 큰 값 반환해서 최솟값 구할 때 영향을 끼치지 못하도록 함
		}
		if(q_start <= r_first && r_last <= q_end) {
			return tree[node];
		}
		int mid = (r_first+r_last)/2;
		return Math.min(min(tree,node*2,r_first,mid,q_start,q_end), min(tree,node*2+1,mid+1,r_last,q_start,q_end));
	}
	//최대
	static int max_init(int[] v, int[] tree, int node, int r_first, int r_last) {
		if(r_first == r_last) {
			return tree[node] = v[r_first];
		}
		int mid = (r_first + r_last)/2;
		return tree[node] = Math.max(max_init(v,tree,node*2,r_first,mid), max_init(v,tree,node*2+1,mid+1,r_last));
	}
	
	static int max(int[] tree, int node, int r_first, int r_last, int q_start, int q_end) {
		if(r_last < q_start || q_end < r_first) {
			return Integer.MIN_VALUE; // int에서 가장 작은 값 반환해서 최댓값 구할 때 영향을 끼치지 못하도록 함
		}
		if(q_start <= r_first && r_last <= q_end) {
			return tree[node];
		}
		int mid = (r_first+r_last)/2;
		return Math.max(max(tree,node*2,r_first,mid,q_start,q_end), max(tree,node*2+1,mid+1,r_last,q_start,q_end));
	}
	

	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		
		System.out.print("데이터의 개수 (N) : ");
		int N = sc.nextInt();

		System.out.print("생성할 구간의 개수 (k) : ");
		int k = sc.nextInt();			
		
		int[] array = new int[N]; 
		Random ran = new Random(1000);
		for(int i=0; i<N; i++) {
			array[i] = ran.nextInt();
		}

		
		int[] start = new int[k];  // 구간의 시작값들 넣는 배열
		int[] end = new int[k];    // 구간의 종료값을 넣는 배열
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
		
		long[] sum_array = new long[k];
		int[] min_array = new int[k];
		int[] max_array = new int[k];
		
		long[] sumtree = new long[N*4]; // sum tree 형성	
		int[] mintree = new int[N*4];	// min tree 형성
		int[] maxtree = new int[N*4];   // max tree 형성
		
		long start_time = System.currentTimeMillis(); 
		
		sum_init(array, sumtree, 1, 0, N-1);  // sum tree 형성	
		min_init(array, mintree, 1, 0, N-1);  // min tree 형성
		max_init(array, maxtree, 1, 0, N-1);  // max tree 형성
		
		for(int i=0; i<k; i++) {
			sum_array[i] = sum(sumtree,1, 0, N-1, start[i], end[i]);  // 구간 합 결과
			min_array[i] = min(mintree,1, 0, N-1, start[i], end[i]);  // 구간 최솟값 결과
			max_array[i] = max(maxtree,1, 0, N-1, start[i], end[i]);  // 구간 최댓값 결과
		}
		
		long end_time = System.currentTimeMillis(); 
		

		for(int i=0; i<k; i++) {
			System.out.println((i+1)+"번째 구간의 최솟값 :"+min_array[i]+", 최댓값 : "+max_array[i]+", 합계 : "+sum_array[i]);
		}
		
		System.out.println("Elapsed time is "+(end_time-start_time)+"ms.");

	}

}
