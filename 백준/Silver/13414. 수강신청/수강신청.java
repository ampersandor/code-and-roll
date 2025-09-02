import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        String[] que = new String[m];
        for (int i = 0; i < m; i++) map.put(br.readLine(), i);
        for (Map.Entry<String, Integer> entry : map.entrySet()) que[entry.getValue()] = entry.getKey();

        for (int i = 0; i < m && n > 0; i++) {
            if (que[i] != null) {
                bw.write(que[i] + "\n");
                n--;
            }
        }
        bw.flush();

    }
}