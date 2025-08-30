import java.io.*;
import java.util.*;

public class Main {
    static PriorityQueue<Integer> heap;
    public static void main(String[] args) throws IOException {
        heap = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int num1, num2;
        for (int i = 0; i < n; i++) heap.add(Integer.parseInt(br.readLine()));
        int res = 0;
        while (heap.size() > 1) {
            num1 = heap.poll();
            num2 = heap.poll();
            res += num1 + num2;
            heap.add(num1 + num2);
        }
        System.out.println(res);

    }

}
