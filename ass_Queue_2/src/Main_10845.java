import java.util.Scanner;

class Queue<E>{
	int front;
	int rear;
	int size;
	E[] data;
	
	Queue(){
		front = rear = 0;
		size = 1000;
		data = (E[]) new Object[size];
	}
	
	public void push(E v) {
		data[rear] = v;
		rear = (rear+1)%size;
	}
	
	public void pop() {  
		data[front] = null;
		front = (front+1)%size;
	}
	
	public int size() {
		return (rear-front+size)%size;
	}
	
	public int empty() { 
		if(front == rear) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	public E front() { 
		return (data[front]);
	}
	
	public E back() {
		return (data[rear-1]);
	}
	

}

public class Main_10845 {

	public static void main(String[] args) {
		Queue<Integer> q = new Queue();
		Scanner sc = new Scanner(System.in);
		System.out.print("명령의 수 : ");
		int n = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			System.out.print("명령어 : ");
			String txt = sc.next();
			if(txt.equals("push")) {
				int num = sc.nextInt();
				q.push(num);
			}
			else if(txt.equals("pop")) {
				if(q.empty()==1) {
					System.out.println("-1");
				}
				else {
					System.out.println(q.front());
					q.pop();
				}
			}
			else if(txt.equals("size")) {
				System.out.println(q.size());
			}
			else if(txt.equals("empty")) {
				System.out.println(q.empty());
			}
			else if(txt.equals("front")) {
				if(q.empty()==1) {
					System.out.println("-1");
				}
				else {
					System.out.println(q.front());
				}
			}
			else if(txt.equals("back")) {
				if(q.empty()==1) {
					System.out.println("-1");
				}
				else {
					System.out.println(q.back());
				}
			}
		}

	}

}
