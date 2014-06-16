
import static java.util.Arrays.*;
import static java.lang.Math.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
 
public class D {
    private static final boolean isDebug = false;

    int rnd = 1;
    void solve() throws Throwable {
        startTime = System.currentTimeMillis();

        int x = readBufInt();
        int k = readBufInt();
        int p = readBufInt();

        long sum = 0;
        int cnt = 100;
        for (int i = 0; i < cnt; i++) {
            sum+=calc(x,k,p);
        }
        BigDecimal s = new BigDecimal(sum).divide(new BigDecimal(cnt), 15,RoundingMode.HALF_EVEN);
        
        pw.println(s);
    }    

    int calc (int x, int k, int p) {
        //input: integers x, k, p
        double a = x;
        int s = 0;

        for(int step = 1; step <= k; step = step + 1){
            
            rnd++;
            if (rnd == 101) {
                rnd = 1;
            }

            if(rnd <= p)
                a = a * 2;
            else
                a = a + 1;
        }


        while (a % 2 == 0){
            a = a / 2;
            s = s + 1;
        }

        return s;
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
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      while (st.hasMoreTokens()) {
          res.add(st.nextToken());
      }
      
      return res.toArray(new String[0]);
  }
    static long startTime;
    public static void main(String[] args) {
        D app = new D();
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
