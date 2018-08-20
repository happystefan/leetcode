package archive.misc;

import java.util.*;

public class Q005_Interactive_Sort {
    /*
    public static void main(String[] args) {
        Scanner sin = new Scanner(System.in);
        int N = sin.nextInt();
        int Q = sin.nextInt();
        if (N == 0) {
            System.out.printf("! %s\n", "");
            System.out.flush();
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : merge_sort(sin, N)) {
            sb.append(c);
        }
        System.out.printf("! %s\n", sb.toString());
        System.out.flush();
    }
    */

    private static ArrayList<Character> bsearch(Scanner sin, int N) {
        ArrayList<Character> result = new ArrayList(N);
        result.add('A');
        for (char c = 'B'; c < 'A'+N; c++) {
            int l = 0, r = result.size()-1;
            while (l <= r) {
                int m = l + (r-l)/2;
                if (isLarger(sin, c, result.get(m))) {
                    l = m+1;
                } else {
                    r = m-1;
                }
            }
            result.add(l, c);
        }
        return result;
    }

    private static ArrayList<Character> merge_sort(Scanner sin, int N) {
        ArrayList<Character> result = new ArrayList(N);
        for (char c = 'A'; c < 'A'+N; c++) {
            result.add(c);
        }
        sort(result, sin, 0, N-1);
        return result;
    }

    private static void sort(ArrayList<Character> result, Scanner sin, int l, int r) {
        if (l == r) {
            return;
        }
        if (l + 1 == r) {
            if (isLarger(sin, result.get(l), result.get(r))) {
                swap(result, l, r);
            }
            return;
        }
        int m = l + (r-l)/2;
        sort(result, sin, l, m-1);
        sort(result, sin, m, r);

        ArrayList<Character> tmp = new ArrayList<>();
        int i = l, j = m;
        while (i <= m-1 && j <= r) {
            if (isLarger(sin, result.get(i), result.get(j))) {
                tmp.add(result.get(j));
                j++;
            } else {
                tmp.add(result.get(i));
                i++;
            }
        }
        while (i <= m-1) {
            tmp.add(result.get(i));
            i++;
        }
        while (j <= r) {
            tmp.add(result.get(j));
            j++;
        }
        for (i = l; i <= r; i++) {
            result.set(i, tmp.get(i-l));
        }
        return;
    }

    private static void swap(ArrayList<Character> result, int i, int j) {
        char tmp = result.get(i);
        result.set(i, result.get(j));
        result.set(j, tmp);
    }

    private static boolean isLarger(Scanner sin, char a, char b) {
        System.out.printf("? %c %c\n", a, b);
        System.out.flush();
        String result = sin.next();
        return result.charAt(0) == '>';
    }

}
