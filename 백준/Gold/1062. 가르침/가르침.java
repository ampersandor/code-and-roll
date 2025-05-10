import java.io.*;
import java.util.*;

public class Main {
    public static int k;
    public static int n;
    public static String[] words;
    public static boolean[] alphas = new boolean[26];
    public static int res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        if (k > 4) {
            k -= 5;
            alphas['a' - 'a'] = true;
            alphas['n' - 'a'] = true;
            alphas['t' - 'a'] = true;
            alphas['i' - 'a'] = true;
            alphas['c' - 'a'] = true;
            words = new String[n];
            for (int i = 0; i < n; i++) {
                words[i] = br.readLine();
            }
            backtracking(0, 0);
        }
        bf.write(String.valueOf(res));
        bf.flush();

    }

    public static void judge(){
        int count = n;
        for (String word: words){
            for (char alpha: word.toCharArray()){
                if (!alphas[alpha - 'a']){
                    count--;
                    break;
                }
            }
        }
        res = Math.max(res, count);
    }

    public static void backtracking(int cur, int len){
        if (len == k) {
            judge();
        }
        for (int i = cur; i < 26; i++){
            if (!alphas[i]) {
                alphas[i] = true;
                backtracking(i + 1, len + 1);
                alphas[i] = false;
            }
        }
    }
}
