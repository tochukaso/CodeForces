package R254;
import static java.util.Arrays.deepToString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
 
public class A {
    private static final boolean isDebug = false;

    
    static Deque<char[][]> bfs = new ArrayDeque<char[][]>();
    static Deque<char[][]> nBfs = new ArrayDeque<char[][]>();
    int[] dx = {-1, 0};
    int[] dy = {0, -1};
    
    char[][] map = null;
    int N = 0;
    int M = 0;
    void solve() throws Throwable {
        startTime = System.currentTimeMillis();
        
        N = readBufInt();
        M = readBufInt();
        
        map = new char[N + 1][M + 1];
        
        for(int i = 0; i <= N; i++) {
            Arrays.fill(map[i], '-');
        }
        
        boolean isFirst = false;
        for (int i = 1; i <= N; i++) {
            char[] cA = br.readLine().toCharArray();
            for (int j = 1; j <= M; j++) {
               map[i][j] = cA[j - 1];
               if (!isFirst && map[i][j] == '.') {
                   isFirst = true;
                   map[i][j] = 'B';
               }
           
            } 
        }
       

        for (int k = 1; k <= N ; k++) {
            for (int k2 = 1; k2 <= M; k2++) {
                if (map[k][k2] == '-') {
                    pw.print(map[k][k2]) ;
                } else {
                    
                    pw.print((k + k2) %2 == 0 ? 'B' : 'W');
                }
            } 
            pw.println();
        }
        
    }    
    
    boolean isComplete = false;
    void dfs( int y, int x) {
        if (isComplete)return;
        if (y == N && x == M + 1) {
            isComplete = true;
            return;
        }

        if (x == M + 1) {
            y ++;
            x = 1;
        }

         if(map[y][x] == '.') {
            if (map[y - 1][x] != 'B' && map[y][x-1] != 'B') {
                map[y][x] = 'B';
                dfs(y, x + 1);
                if(isComplete)return;
                map[y][x] = '.';
            }

            if (map[y - 1][x] != 'W' && map[y][x-1] != 'W') {
                if ((map[y][x - 1] == '-' && (x >= 2 && map[y][x -2] == 'B')) || (map[y - 1][x] == '-' && y >= 2 && map[y-2][x] == 'B')) {
                    return;
                }
                map[y][x] = 'W';
                dfs(y, x + 1);
                if(isComplete)return;
                map[y][x] = '.';
            }
         } else {
             dfs(y, x + 1);
         }
        
    }


    char[][] copyArray(char[][] original) {
        
        char[][] res = new char[original.length][];
        for (int i = 0; i < original.length; i++) {
            res[i] = Arrays.copyOf(original[i], original[i].length);
        }
        
       return res; 
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
        A app = new A();
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
