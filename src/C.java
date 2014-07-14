


import static java.util.Arrays.deepToString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
 
public class C {
    private static final boolean isDebug = false;

    void solve() throws Throwable {
        startTime = System.currentTimeMillis();
        int N = readBufInt();
        int[] arr = readIntArray();
        
        if (N < 3) {
            pw.println(N);
            return;
        }
        shakutori(N, arr);
    }    

    static void shakutori (int N, int[] arr) {
        int[] subsequence = new int[arr.length + 1];
        System.arraycopy(arr, 0, subsequence, 0, arr.length);
        subsequence[arr.length] = -1;
        
        int to = 0;
        int before = 0;
        int[] dp = new int[N + 1];
        int length = 0;
        for (; to <= N; to++) {
            int now = subsequence[to];
            
            if(before < now) {
                length++;
            } else {
                for (int i = 0; i <= length; i++) {
                    dp[to - i] = length;
                }
                length = 1;
            }

            dp[to] = length;
            before = now;
        }
        dp[N] = 0;
//        for (int i = 0; i < N; i++) {
//            System.out.println(dp[i]);
//        }
        
        int max = 0;
        for (int i = 1; i < N - 1; i++) {
            int x = 0;
            if(dp[i + 1] == 1 && subsequence[i] + 1< subsequence[i + 2]) {
                x = dp[i] + dp[i + 2] + 1;
            }
            if (subsequence[i] > subsequence[i - 1] && subsequence[i] >= subsequence[i+1] ) {
                if(subsequence[i] + 1 < subsequence[i + 2]) {
                    x = Math.max(x, dp[i] + dp[i + 1]);
                }
                if (subsequence[i - 1] + 1 < subsequence[i + 1]) {
                    x = Math.max(x, dp[i] + dp[i + 1]);
                }
            }
            x = Math.max(x, dp[i] + 1);
            
            max = Math.max(max, x);
        }
        
        pw.println(Math.min(N, max));
    }
    
    private static long gcd(long n1, long n2) {
        return (n2 == 0)?n1:gcd(n2, n1%n2);
    }

    private static int gcd(int n1, int n2) {
        return (n2 == 0)?n1:gcd(n2, n1%n2);
    }
    private int brPos = 0;
    private int[] brBuf = null;
    
    private final int readBufInt() throws IOException {
        if (brBuf == null || brBuf.length == brPos) {
            brBuf = readIntArray();
            brPos = 0;
            return readBufInt();
        }
        return brBuf[brPos++];
    }

    private final int readInt() throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private final long readLong() throws IOException {
        return Long.parseLong(br.readLine());
    }

    private final int[] readIntArray() throws IOException {
        String[] s = readStrArray();
        int cnt = s.length;
        int[] out = new int[cnt];
        for (int i = 0; i < cnt; i++) out[i] = Integer.parseInt(s[i]);
        return out;
    }

    private final char[] readCharArray() throws IOException {
        String[] s = readStrArray();
        int cnt = s.length;
        char[] out = new char[cnt];
        for (int i = 0; i < cnt; i++) out[i] = s[i].charAt(0);
        return out;
    }

    private final long[] readLongArray() throws IOException {
        String[] s = readStrArray();
        int cnt = s.length;
        long[] out = new long[cnt];
        for (int i = 0; i < cnt; i++) out[i] = Long.parseLong(s[i]);
        return out;
    }

    private final String[] readStrArray() throws IOException {
//      String[] s = br.readLine().split(" ");
      List<String> res = new ArrayList<String>();
      StringTokenizer st = new StringTokenizer(br.readLine(), ", ");
      while (st.hasMoreTokens()) {
          res.add(st.nextToken());
      }
      
      return res.toArray(new String[0]);
  }
    static long startTime;
    public static void main(String[] args) {
        C app = new C();
        try {
            app.br = new BufferedReader(new InputStreamReader(System.in));
            app.solve();
        } catch(Throwable e) {
            e.printStackTrace();
        } finally {
            try { app.br.close();} catch (Exception igunore) {}
        }
        d(System.currentTimeMillis() - startTime + " ms");
        pw.flush();
        pw.close();
    }

   static final void d(Object ... o) {
       if (isDebug) pw.println(deepToString(o));
   }

   static final void d(boolean[][] oA) {
       for (boolean[] o : oA) {
           d(o);
       }
   }

   BufferedReader br = null;
   static PrintWriter pw = new PrintWriter(System.out);
   

}
