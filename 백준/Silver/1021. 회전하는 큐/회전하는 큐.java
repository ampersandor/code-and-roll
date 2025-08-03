import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        LinkedList<Integer> que = new LinkedList<>();
        for (int i = 1; i < n + 1; i++) que.add(i);
        int res = 0;
        int rotated;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            rotated = 0;
            while (!que.isEmpty() && que.peek() != num) {
                que.add(que.pollFirst());
                rotated += 1;
            }
            res += Math.min(que.size() - rotated, rotated);
            que.pollFirst();
        }
        System.out.println(res);
    }
}
