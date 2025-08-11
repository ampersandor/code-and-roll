import java.io.*;

public class Main {
    static int n;
    static String[] scene;

    public static String compress(int x1, int y1, int x2, int y2) {
        if (x2 - x1 == 1) {
            char a = scene[x1].charAt(y1);
            char b = scene[x2-1].charAt(y2);
            char c = scene[x1+1].charAt(y1);
            char d = scene[x2].charAt(y2);
            if (a == b && b == c && c == d) return "" + a;
            return String.format("(%c%c%c%c)", a, b, c, d);
        }
        String ul = compress(x1, y1, x1 + (x2 - x1) / 2, y1 + (y2 - y1) / 2);
        String ur = compress(x1, y1 + (y2 - y1 + 1) / 2, x1 + (x2 - x1) / 2, y2);
        String dl = compress(x1 + (x2 - x1 + 1) / 2, y1, x2, y1 + (y2 - y1) / 2);
        String dr = compress(x1 + (x2 - x1 + 1) / 2, y1 + (y2 - y1 + 1) / 2, x2, y2);
        if (ul.length() == 1 && ul.equals(ur) && ur.equals(dl) && dl.equals(dr)) return ul;
        return String.format("(%s%s%s%s)", ul, ur, dl, dr);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        if (n == 1) {
            System.out.println(br.readLine());
            return;
        }
        scene = new String[n];
        for (int i = 0; i < n; i++) scene[i] = br.readLine();

        System.out.println(compress(0, 0, n - 1, n - 1));
    }
}

/**
 * 4
 * 1111
 * 1111
 *
 */