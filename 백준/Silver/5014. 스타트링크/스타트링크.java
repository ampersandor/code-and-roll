import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken()) -1;
        int g = Integer.parseInt(st.nextToken()) -1;
        int u = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int[] cur;
        int floor, cost;
        int[] visited = new int[f];
        Arrays.fill(visited, Integer.MAX_VALUE);
        Deque<int[]> que = new ArrayDeque<>();

        que.offer(new int[]{s, 0});
        while (!que.isEmpty()) {
            cur = que.poll();
            floor = cur[0];
            cost = cur[1];
            if (floor == g){
                System.out.println(cost);
                return;
            }
            if (floor + u < f && cost + 1 < visited[floor+u]) {
                que.offer(new int[]{floor + u, cost + 1});
                visited[floor+u] = cost + 1;
            }
            if (floor - d >= 0 && cost + 1 < visited[floor-d]) {
                que.offer(new int[]{floor - d, cost + 1});
                visited[floor-d] = cost + 1;
            }
        }
        System.out.println("use the stairs");
    }
}
