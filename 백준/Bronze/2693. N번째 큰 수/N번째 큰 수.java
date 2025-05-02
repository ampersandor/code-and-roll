import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++){
            PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<>(){
                @Override
                public int compare(Integer o1, Integer o2){
                    return - Integer.compare(o1, o2);
                }
            });

            StringTokenizer st = new StringTokenizer(br.readLine());
            int element;
            while(st.hasMoreElements()){
                element = Integer.parseInt(st.nextToken());
                heap.add(element);
            }
            int count = 0;
            while(!heap.isEmpty() && count++ < 2){
                heap.poll();
            }
            System.out.println(heap.poll());

        }
    }
}