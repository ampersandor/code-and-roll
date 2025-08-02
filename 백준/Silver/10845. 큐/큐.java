import java.io.*;
import java.util.StringTokenizer;


public class Main {
    public static class Node {
        private int value;
        private Node next;
        public Node(int value){
            this.value = value;
        }
        public int getValue(){
            return this.value;
        }
        public Node getNext(){
            return this.next;
        }
        public void setNext(Node node){
            this.next = node;
        }
    }
    public static class Queue {
        private Node front, back;
        private int size;
        public Queue() {
        }
        public boolean isEmpty() {
            return this.front == null && this.back ==null;
        }

        public int empty() {
            return isEmpty() ? 1 : 0;
        }

        public int size() {
            return this.size;
        }
        public int front() {
            return isEmpty() ? -1 : front.getValue();
        }
        public int back() {
            return isEmpty() ? -1 : back.getValue();
        }

        public void push(int x){
            Node node = new Node(x);
            if (isEmpty()){
                front = back = node;
            }
            else{
                back.setNext(node);
                back = node;
            }
            size++;
        }
        public int pop(){
            if (isEmpty()) {
                return -1;
            } else if (size() == 1) {
                Node popped = front;
                front = back = null;
                size = 0;
                return popped.getValue();
            } else {
                Node popped = front;
                front = front.getNext();
                size--;
                return popped.getValue();
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Queue que = new Queue();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push":
                    que.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(que.pop()).append("\n");
                    break;
                case "size":
                    sb.append(que.size()).append("\n");
                    break;
                case "empty":
                    sb.append(que.empty()).append("\n");
                    break;
                case "front":
                    sb.append(que.front()).append("\n");
                    break;
                case "back":
                    sb.append(que.back()).append("\n");
                    break;
                default:
                    break;
            }
        }
        bw.write(sb.toString());
        bw.flush();

    }
}
