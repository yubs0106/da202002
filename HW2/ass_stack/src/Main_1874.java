import java.util.Scanner;

class Stack<E> {
   E[] data;
   int top;
   
   Stack() {
      data = (E[]) new Object[1024];
      top = -1;
   }
   public void push(E v) {
      top++;
      data[top] = v;
   }
   public void pop() {
      data[top] = null;
      top --;
   } 
   public E top() {
      return data[top];
   }
}

public class Main_1874 {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n =sc.nextInt();
      
      Stack<Integer> st = new Stack();
      int ip [] = new int[n];           // 내가 입력한 숫자들을 저장하는 배열 공간
      char result []= new char[1024];   // push, pop 연산이 이루어질 때마다 기록하는 배열 공간
      
      int max = 0;
      int tem = 0;
      boolean fn = true;
      
      for(int i=0; i<n; i++) {
         int num = sc.nextInt();
         ip[i] = num;
         
         if(st.top == -1 ) {   
            for(int j=1; j<=num; j++) {
               st.push(j);
               result[tem]='+';
               tem++;
            }
            st.pop();
            result[tem]='-';
            tem++;
         }
         else if(st.top() == num) {
            st.pop();
            result[tem]='-';
            tem++;
         }
         else if(st.top() < num) {
            if(num > max) {
               for(int j = max+1; j<=num; j++) {
                  st.push(j);
                  result[tem]='+';
                  tem++;
               }
            }
            st.pop();
            result[tem]='-';
            tem++;
         }
         else {
        	 fn = false;
         }
         for(int j=0; j<ip.length; j++) {
            if(ip[j] > max) {
               max = ip[j];
            }
         }
      }
      if(fn == true) {
    	  for(int k=0; k<tem; k++) {
    	         System.out.println(result[k]);
    	      }
      }
      else {
    	  System.out.println("NO");
      }
   }

}