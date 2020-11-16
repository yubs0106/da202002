import java.util.Random;
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
	
	public void add(E v) {
		data[rear] = v;
		rear = (rear+1)%size;
	}
	
	public void remove() {  
		data[front] = null;
		front = (front+1)%size;
	}
	
	public E peek() { 
		return(data[front]);
	}
	
	public boolean empty() { 
		return front == rear; 
	}
}

class Stack<E>{
	E[] data2;
	int top;
	Stack() {
		data2 = (E[]) new Object[1000];
		top = -1;
	}
	
	public void push(E v) {  
		data2[++top] = v;

	}
	
	public void pop() {
		data2[top--] = null;	
	}
	
	public E top() {
		return data2[top];
	}
	
	public int size() {
		return top+1;  
	}

}
public class Main_1 {

	public static void main(String[] args) {
		Queue<Integer> q = new Queue();
		Stack<Integer> s = new Stack();
		
		System.out.print("데이터의 개수 : ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Random ran = new Random(1000);
		for(int i=0; i<n; i++) {
			q.add(ran.nextInt(10000));
		}
		
		while(q.empty()==false) {
			if(s.top == -1) {
				s.push(q.peek());
				q.remove();
			}
			
			else if(s.top()>=q.peek()) {
				s.push(q.peek());
				q.remove();
			}
			
			else if(s.top()<q.peek()) {
				q.add(s.top());
				s.pop();
			}
		}
		
		for(int j=0; j<n; j++) {  
			System.out.println(+s.top());
			s.pop();
		}
	}

}
