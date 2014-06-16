package R246_D2;

import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;

import java.math.*;
import java.io.*;
import java.text.*;
import java.util.*;
 
public class B {
//    private static final String INPUT_PATH = "C:\\atcoder\\b_008_004.txt";
    private static final String INPUT_PATH = null;

    public void solve() { 
        try {
            br = new BufferedReader(new InputStreamReader(
                    INPUT_PATH == null ? System.in : new FileInputStream(new File(INPUT_PATH))));

            int N = readInt();

            int[][] teams = new int[N][2];
            
            for (int i = 0; i < N; i++) {
                teams[i] = readIntArray();
            }

            int[] kits = new int[100001];
            
            for (int i = 0; i < N; i++) {
                kits[teams[i][0]]++;
            }
            
            for (int i = 0; i < N; i++) {
                pw.println(N -1 + kits[teams[i][1]] + " " +( N - 1 - kits[teams[i][1]]));
            }
            

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (Exception igunore) {}
        }
    }

    
    private int readInt() throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private long readLong() throws IOException {
        return Long.parseLong(br.readLine());
    }

    private int[] readIntArray() throws IOException {
        String[] s = readStrArray();
        int cnt = s.length;
        int[] out = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            out[i] = Integer.parseInt(s[i]);
        }
        return out;
    }

    private Integer[] convIntArray(int[] arg) {
        int len = arg.length;
        Integer[] res = new Integer[len];
        for (int i = 0; i < len; i++) {
            res[i] = arg[i];
        }
        return res;
    }
    
    private long[] readLongArray() throws IOException {
        String[] s = readStrArray();
        int cnt = s.length;
        long[] out = new long[cnt];
        for (int i = 0; i < cnt; i++) {
            out[i] = Long.parseLong(s[i]);
        }
        return out;
    }

    private String[] readStrArray() throws IOException {
        String[] s = br.readLine().split(" ");
        return s;
    }

    void permutationAll(int[] p) {
        permutation(p, 0, p.length - 1);
     }
    
    void permutationRange(int from, int to) {
        int cnt = to - from + 1;
        int[] elements = new int[cnt];
        for (int i = 0 ; i <  cnt; i++) {
            elements[i] = from++;
        }
        permutation(elements, 0, cnt - 1);
    }

    void permutationString(String element) {
        char[] elements = element.toCharArray();
        permutationString(elements, 0, elements.length - 1);
    }

    
    void permutation(int[] elements, int nowCnt, int totalCnt) {
        if (nowCnt == totalCnt) { 

            // TODO insertCode
        } else {
            
          for (int i = nowCnt; i <= totalCnt; i++) {
            int tmp = elements[nowCnt]; 
            elements[nowCnt] = elements[i]; 
            elements[i] = tmp;
            permutation(elements, nowCnt+1, totalCnt);
            tmp = elements[nowCnt]; 
            elements[nowCnt] = elements[i]; 
            elements[i] = tmp;
          }
        }
     }

    void permutationString(char[] elements, int nowCnt, int totalCnt) {
        if (nowCnt == totalCnt) { 
            
            // TODO insertCode
        } else {
            
          for (int i = nowCnt; i <= totalCnt; i++) {
            char tmp = elements[nowCnt]; 
            elements[nowCnt] = elements[i]; 
            elements[i] = tmp;
            permutationString(elements, nowCnt+1, totalCnt);
            tmp = elements[nowCnt]; 
            elements[nowCnt] = elements[i]; 
            elements[i] = tmp;
          }
        }
     }

    private static long gcd(long n1, long n2) {
        return (n2 == 0)?n1:gcd(n2, n1%n2);
    }
    private static int gcd(int n1, int n2) {
        return (n2 == 0)?n1:gcd(n2, n1%n2);
    }

    public static void main(String[] args) {
        long from = System.currentTimeMillis();
        B app = new B();
        app.solve();
        pw.flush();
        pw.println(System.currentTimeMillis() - from);
    }

    void printInt(int[] p) {
        for (int i : p) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

   void debug(Object ... o) {
       pw.write(deepToString(o));
   }
   BufferedReader br = null;
   static PrintWriter pw = new PrintWriter(System.out);

   class Type {
       int x, y;
       
       Type (int x, int y) {
           this.x = x;
           this.y = y;
       }
       
   }
}