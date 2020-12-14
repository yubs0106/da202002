import java.util.Random;
import java.util.Scanner;

public class Main {
	// ��
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
	// �ּ�
	static int min_init(int[] v, int[] tree, int node, int r_first, int r_last) {
		if(r_first == r_last) {
			return tree[node] = v[r_first];
		}
		int mid = (r_first + r_last)/2;
		return tree[node] = Math.min(min_init(v,tree,node*2,r_first,mid), min_init(v,tree,node*2+1,mid+1,r_last));
	}
	
	static int min(int[] tree, int node, int r_first, int r_last, int q_start, int q_end) {
		if(r_last < q_start || q_end < r_first) {
			return Integer.MAX_VALUE; // int���� ���� ū �� ��ȯ�ؼ� �ּڰ� ���� �� ������ ��ġ�� ���ϵ��� ��
		}
		if(q_start <= r_first && r_last <= q_end) {
			return tree[node];
		}
		int mid = (r_first+r_last)/2;
		return Math.min(min(tree,node*2,r_first,mid,q_start,q_end), min(tree,node*2+1,mid+1,r_last,q_start,q_end));
	}
	//�ִ�
	static int max_init(int[] v, int[] tree, int node, int r_first, int r_last) {
		if(r_first == r_last) {
			return tree[node] = v[r_first];
		}
		int mid = (r_first + r_last)/2;
		return tree[node] = Math.max(max_init(v,tree,node*2,r_first,mid), max_init(v,tree,node*2+1,mid+1,r_last));
	}
	
	static int max(int[] tree, int node, int r_first, int r_last, int q_start, int q_end) {
		if(r_last < q_start || q_end < r_first) {
			return Integer.MIN_VALUE; // int���� ���� ���� �� ��ȯ�ؼ� �ִ� ���� �� ������ ��ġ�� ���ϵ��� ��
		}
		if(q_start <= r_first && r_last <= q_end) {
			return tree[node];
		}
		int mid = (r_first+r_last)/2;
		return Math.max(max(tree,node*2,r_first,mid,q_start,q_end), max(tree,node*2+1,mid+1,r_last,q_start,q_end));
	}
	

	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		
		System.out.print("�������� ���� (N) : ");
		int N = sc.nextInt();

		System.out.print("������ ������ ���� (k) : ");
		int k = sc.nextInt();			
		
		int[] array = new int[N]; 
		Random ran = new Random(1000);
		for(int i=0; i<N; i++) {
			array[i] = ran.nextInt();
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
		
		long[] sum_array = new long[k];
		int[] min_array = new int[k];
		int[] max_array = new int[k];
		
		long[] sumtree = new long[N*4]; // sum tree ����	
		int[] mintree = new int[N*4];	// min tree ����
		int[] maxtree = new int[N*4];   // max tree ����
		
		long start_time = System.currentTimeMillis(); 
		
		sum_init(array, sumtree, 1, 0, N-1);  // sum tree ����	
		min_init(array, mintree, 1, 0, N-1);  // min tree ����
		max_init(array, maxtree, 1, 0, N-1);  // max tree ����
		
		for(int i=0; i<k; i++) {
			sum_array[i] = sum(sumtree,1, 0, N-1, start[i], end[i]);  // ���� �� ���
			min_array[i] = min(mintree,1, 0, N-1, start[i], end[i]);  // ���� �ּڰ� ���
			max_array[i] = max(maxtree,1, 0, N-1, start[i], end[i]);  // ���� �ִ� ���
		}
		
		long end_time = System.currentTimeMillis(); 
		

		for(int i=0; i<k; i++) {
			System.out.println((i+1)+"��° ������ �ּڰ� :"+min_array[i]+", �ִ� : "+max_array[i]+", �հ� : "+sum_array[i]);
		}
		
		System.out.println("Elapsed time is "+(end_time-start_time)+"ms.");

	}

}
