package R255;



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
 
public class D {
    private static final boolean isDebug = false;

    void solve() throws Throwable {
        startTime = System.currentTimeMillis();
        
        int N = readBufInt();
        int M = readBufInt();
        int K = readBufInt();
        int P = readBufInt();
        
        int[][] array = new int[N][];
        for (int i = 0; i < N; i++) {
            array[i] = readIntArray();
        }
        
        int[] line = new int[N];
        int[] colum = new int[M];
        for (int i = 0; i < N; i++) {
            int s = 0;  
            for (int j = 0; j < M; j++) {
                s += array[i][j];
            }
            line[i] = s;
        }
        
        for (int i = 0; i < M; i++) {
            int s = 0;
            for (int j = 0; j < N; j++) {
                s += array[j][i];
            }
            colum[i] = s;
        }
        
        Arrays.sort(line);
        Arrays.sort(colum);
        
        int lineM = line[N - 1];
        int columM = colum[M - 1];
        int sum = 0;
        
        int mCnt = 0;
        int cCnt = 0;
                
        for (int i = 0; i < K; i++) {
            int nLine = lineM - cCnt * P;
            int nColum = columM - mCnt * P;

            int t = 0;
            if (nLine > nColum) {
                t = nLine;
                lineM -= P * M;
                int index = binarySearch(lineM, N, line);
                
                for (int j = N - 1; j > index; j--) {
                    line[j] = line[j-1];
                }
                line[index] = lineM;
                mCnt++;
                lineM = line[N - 1];
            } else {
                t = nColum;
                columM -= P * N;
                int index = binarySearch(columM, M, colum);
                
                for (int j = M - 1; j > index; j--) {
                    colum[j] = colum[j-1];
                }
                colum[index] = columM;
                cCnt++;
                columM = colum[M - 1];
            }
            
            sum+=t;
        }

        pw.println(sum);
        
    }    

    public static int binarySearch(int num, int N, int[] list) {
        int max = N;
        int min = 0;
        while(min + 1 < max) {
            int now = (max + min) / 2;
            if (list[now] > num) {
                max = now;
            } else {
                min = now;
            }
        }
        
        return min;
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
