
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

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, -1, 0, 1};

    void solve() throws Throwable {
        startTime = System.currentTimeMillis();

        int N = readBufInt();
        int M = readBufInt();
        int K = readBufInt();
        
        int[][] map = new int [N + 1][M + 1];
        
        for (int i = 1; i <= K; i++) {
            if (i== K) {
                int res = N * M - 2 * (K - 1);
                pw.print(res + " ");
                int y = i;
                int x = 1;
                int j = 0;
                boolean isDown = true;
                for (; j < res && x <= M; ) {
                    for (; x <=M ; x++) {
                        while(y >= 1 && y <= N) {

                            if (map[y][x] == 0) {
                                if (j + 1== res) {
                                    pw.println(y + " " + x);
                                } else {
                                    pw.print(y + " " + x + " ");
                                }
                                map[y][x] = 1;
                                j++;
                            }
                            if (isDown) {
                                if (y >= N || map[y + 1][x] != 0) {
                                    if (y >= N) {
                                        isDown = false;
                                    }
                                    break;
                                }
                                y++;
                            } else {
                                if (y <= 1|| map[y - 1][x] != 0) {
                                    if (y <= 1) {
                                        isDown = true;
                                    }
                                    break;
                                }
                                y--;
                            }
                        }
                    }
                }
                pw.println();
                pw.println(j);
            } else {
                pw.println("2 " + i + " 1 " + i + " 2");
                map[i][1] = 1;
                map[i][2] = 1;
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
   

}
