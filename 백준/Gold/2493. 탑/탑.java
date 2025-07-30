import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] towers = new int[n];
        int[] res = new int[n];
        int[] stack = new int[n];
        int ptr = 0;
        for (int i = 0; i < n; i++) towers[i] = Integer.parseInt(st.nextToken());
        for (int i = n-1; i >= 0; i--){
            while (ptr > 0 && towers[stack[ptr - 1]] < towers[i]){
                res[stack[--ptr]] = i+1;
            }
            stack[ptr++] = i;
        }

        for (int i = 0; i < n - 1; i ++){
            bw.write(res[i] + " ");
        }
        bw.write(res[res.length - 1] + "");
        bw.flush();


    }
}
