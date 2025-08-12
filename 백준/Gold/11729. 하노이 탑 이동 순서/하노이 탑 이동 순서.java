import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<String> res;

    public static void hanoi(String from, String tmp, String to, int n) {
        if (n == 0) return;

        hanoi(from, to, tmp, n-1);
        res.add(from + " " + to);
        hanoi(tmp, from, to, n-1);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        res = new ArrayList<>();
        hanoi("1", "2", "3", n);
        bw.write(res.size() + "\n");
        for (String move : res) {
            bw.write(move + "\n");
        }
        bw.flush();
    }
}

/**
 * 4
 * 1111
 * 1111
 */