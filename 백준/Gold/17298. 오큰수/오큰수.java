import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int c, n;
    static int read() throws Exception {
        n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = read();
        int[] stack = new int[n];
        int ptr = 0;
        int[] nums = new int[n];
        int[] res = new int[n];

        for (int i = 0; i < n; i++){
            nums[i] = read();
            while (ptr > 0 && nums[stack[ptr-1]] < nums[i]){
                res[stack[--ptr]] = nums[i];
            }
            stack[ptr++] = i;
        }

        for (int i = 0; i < n; i++){
            bw.write(res[i] == 0 ? "-1 " : res[i] + " ");
        }
        bw.flush();
    }
}
