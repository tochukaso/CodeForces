

import static java.util.Arrays.*;
import static java.lang.Math.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
 
public class C {
    private static final boolean isDebug = false;
    
    int N = 0;

    int min = Integer.MAX_VALUE;
    String[] s = null;

    void solve() throws Throwable {
        startTime = System.currentTimeMillis();

        N = readBufInt();
        s = readStrArray();
        
        boolean[] colors = new boolean[5];
        boolean[] numbers = new boolean[5];
        
        boolean[] cards = new boolean[26];
        for(String card : s) {
            char color = card.charAt(0);
            int num = Character.getNumericValue(card.charAt(1));
            
            if (color == 'G') {
                num += 5;
            } else if (color == 'R') {
                num += 10;
            } else if (color == 'B') {
                num += 15;
            } else if (color == 'W') {
                num += 20;
            } 
            cards[num] = true;
        }
        
        while(true) {
            int maxMatch = 0;
            for (int i = 1; i < 26; i++) {
                
            }
            
        }
        
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
   
   void permutationAll(int[] p) {
       permutation(p, 0, p.length - 1);
    }
   
   void permutationRange(int from, int to) {
       int cnt = to - from + 1;
       int[] elements = new int[cnt];
       for (int i = 0 ; i <  cnt; i++) elements[i] = from++;
       permutation(elements, 0, cnt - 1);
   }

   void permutationString(String element) {
       char[] elements = element.toCharArray();
       permutationString(elements, 0, elements.length - 1);
   }

   
   void permutation(int[] elements, int nowCnt, int totalCnt) {
       if (nowCnt == totalCnt) { 
           int sum = 0;
           boolean[] colors = new boolean[5];
           boolean[] numbers = new boolean[5];
           
           boolean[] checked = new boolean[N];
           
           for (int i = 0; i < elements.length; i++) {
               if (i <= 5) {
                   numbers[i - 1] = true;
               } else {
                   colors[i - 6] = true;
               }
               
               for (int j = 0; j < N; j++) {
                   
               }
           }
           
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

}
