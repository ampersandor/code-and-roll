import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static List<Integer> nums;
    static Set<Integer> doubles;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        nums = new ArrayList<>();
        for (int i = 0; i < n; i++) nums.add(Integer.parseInt(br.readLine()));
        nums.sort(Comparator.naturalOrder());
        doubles = new HashSet<>();
        for (int i = 0; i < n-1; i++){
            for (int j = i; j < n; j++){
                doubles.add(nums.get(i) + nums.get(j));
            }
        }
        for (int i = n-1; i > 0; i--) {
            for (int j = 0; j < i; j++){
                if (doubles.contains(nums.get(i) - nums.get(j))) {
                    System.out.println(nums.get(i));
                    return;
                }
            }
        }


    }


}
