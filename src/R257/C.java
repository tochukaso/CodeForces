package R257;

import static java.util.Arrays.deepToString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class C {
    private static final boolean isDebug = false;

    void solve() throws Throwable {
        startTime = System.currentTimeMillis();
        
        int n = readInt();
        int m = readInt();
        int k = readInt();
        
        if(k > (n + m - 2)) {
            pw.println(-1);
            return;
        }
        
        

//        long max = (long) n * m;
        long min = 1;
        
        int mMin = Math.max(0,k - (n - 1));
//        System.out.println(mMin);
        
//        long[] dp = new long[k - mMin];
//        while(min + 1 < max) {
            
//            long now = (min + max) / 2;
            
//            boolean isClear = false;
            for (int i = mMin; i <= (n / 2) && k >= i; i++) {
//            for (int i = mMin; i <= n - 1 && k >= i; i++) {
//                long t = 0;
//                if (dp[i] != 0) {
//                    t = dp[i];
//                } else {
                    int y = n;
                    int last = k - i + 1;
                    if(i > 0) {
                        if (i == n / 2) {
                            y = 1;
                            last = k - i * 2  + 1;
                        } else {
                            y = n / (i + 1);
                        }
                    }
                    if(y <= min) continue;
                    int x = m;
                    if(k - i > 0) {
                        x = m / last;
                    }
                    
//                    dp[i] = x * y;
//                    t = x * y;
//                }
                
                min = Math.max(min, x * y);

                
//                if (t >= now) {
//                    isClear = true;
//                    break;
//                }
            }
            
            
//            if(isClear) {
//                min = now;
//            } else {
//                max = now;
//            }
            
//        }

        pw.println(min);
        
        
    }    

    public static int binarySearch(int num, int[] list) {
        int max = list.length;
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

    final void printMatrix(double[][] p) {
        for (double[] i : p) printArray(i);
    }

    final void printArray(double[] p) {
        for (double i : p) System.out.print(i + " ");
        System.out.println();
    }

    private static long gcd(long n1, long n2) {
        return (n2 == 0)?n1:gcd(n2, n1%n2);
    }

    private static int gcd(int n1, int n2) {
        return (n2 == 0)?n1:gcd(n2, n1%n2);
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

    static final void d(int[][] oA) {
        for (int[] o : oA) {
            d(o);
        }
    }
    static final void d(boolean[][] oA) {
        for (boolean[] o : oA) {
            d(o);
        }
    }

    void permutationAll(int[] p) {
        permutation(p, 0, p.length - 1);
    }

    void permutationRange(int from, int to) {
        int cnt = to - from + 1;
        int[] elements = new int[cnt];
        for (int i = 0 ; i <  cnt; i++) elements[i] = from++;
        permutation(elements, 0, cnt - 1);
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

    static PrintWriter pw = new PrintWriter(System.out);

    BufferedReader br = null;
    private int brPos = 0;
    private int[] brBuf = null;

    private String delimiter = " ";
    public void close() {
        try {
            this.br.close();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public final int readInt()  {
        if (brBuf == null || brBuf.length == brPos) {
            brBuf = readIntArray();
            brPos = 0;
            return readInt();
        }
        return brBuf[brPos++];
    }

    private String readLine() {
        try {
            return br.readLine();
        } catch(IOException ioe) {
            ioe.printStackTrace();
            throw new RuntimeException(ioe);
        }
    }

    public final int readNextInt()  {
        return Integer.parseInt(readLine());
    }

    public final long readNextLong()  {
        return Long.parseLong(readLine());
    }

    public final int[] readIntArray()  {
        String[] s = readStrArray();
        int cnt = s.length;
        int[] out = new int[cnt];
        for (int i = 0; i < cnt; i++) out[i] = Integer.parseInt(s[i]);
        return out;
    }

    public final int[] readIntColumnArray(int N)  {
        int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            res[i] = readInt();
        } 
        return res;
    }

    public final int[][] readIntMatrix(int N) {
        int[][] res = new int[N][];
        for (int i = 0; i < N; i++) {
            res[i] = readIntArray();
        }

        return res;
    }

    public final char[][] readCharMatrix(int N) {
        char[][] res = new char[N][];
        for (int i = 0; i < N; i++) {
            res[i] = readCharArray();
        }

        return res;
    }

    public final char[] readCharArray()  {
        String[] s = readStrArray();
        int cnt = s.length;
        char[] out = new char[cnt];
        for (int i = 0; i < cnt; i++) out[i] = s[i].charAt(0);
        return out;
    }

    public final long[] readLongArray()  {
        String[] s = readStrArray();
        int cnt = s.length;
        long[] out = new long[cnt];
        for (int i = 0; i < cnt; i++) out[i] = Long.parseLong(s[i]);
        return out;
    }

    public final String readString() {
        return readLine();
    }

    public final String[] readStrArray()  {
        List<String> res = new ArrayList<String>();
        StringTokenizer st = new StringTokenizer(readLine(), delimiter);
        while (st.hasMoreTokens()) {
            res.add(st.nextToken());
        }
        return res.toArray(new String[0]);
    }

    public void setDelimiter(String delim) {
        this.delimiter = delim;
    }

    public String getDelimiter() {
        return this.delimiter;
    }

    public static class UnionFind {
        private int[] parentArray ;

        private int[] rankArray;
        private int nodeCount;

        public UnionFind(int totalCount) {
            this.nodeCount = totalCount;
            parentArray = new int[totalCount];
            rankArray = new int[totalCount];

            for (int i = 0; i < totalCount; i++) {
                parentArray[i] = i;
                rankArray[i] = 0;
            }
        }

        public int findParent(int nodeIndex) {
            if (parentArray[nodeIndex] == nodeIndex) {
                return nodeIndex;
            } else {
                return parentArray[nodeIndex] = findParent(parentArray[nodeIndex]);
            }
        }

        public void union(int node1, int node2) {
            node1 = findParent(node1);
            node2 = findParent(node2);
            if (node1 == node2) {
                return;
            }

            if (rankArray[node1] < rankArray[node2]) {
                parentArray[node1] = node2;
            } else if (rankArray[node1] > rankArray[node2]) {
                parentArray[node2] = node1;
            } else {
                parentArray[node2] = node1;
                rankArray[node1]++;
            }

        }

        public boolean isSameParent(int node1, int node2) {
            return findParent(node1) == findParent(node2);
        }

        public int getNodeCount() {
            return this.nodeCount;
        }
        
        public int getNodeConut(int node) {
            return rankArray[findParent(node)];
        }
    }

}