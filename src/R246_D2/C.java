package R246_D2;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;

import java.math.*;
import java.io.*;
import java.text.*;
import java.util.*;
 
public class C {
//    private static final String INPUT_PATH = "C:\\atcoder\\b_008_004.txt";
    private static final String INPUT_PATH = null;

    String getKey(int[] i) {
        StringBuilder sb = new StringBuilder();
        for (int s : i) {
            sb.append(" " + s);
        }
        return sb.toString();
    }
    
    public void newSolve() {
        try {
            br = new BufferedReader(new InputStreamReader(
                    INPUT_PATH == null ? System.in : new FileInputStream(new File(INPUT_PATH))));


            int[] primes = getPrimeNum();

            int N = readInt();

            // ソート後の並び順
            int[][] a = new int[N][];
            for(int i = 0;i < N;i++){
                a[i] = new int[]{readMinInt(), i};
            }
            
            Arrays.sort(a, new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return a[0] - b[0];
                }
            });

            System.out.println("--------");

            // 現在の並び順
            int[] ia = new int[N];
            for(int i = 0;i < N;i++)ia[a[i][1]] = i;
            List<String> lines = new ArrayList<String>();

            printMatrix(a);
            printArray(ia);
            System.out.println("--------");

            for(int i = 0;i < N;i++){
                
                // ソート後の並び順のi番目の現在の位置
                int x = a[i][1];
                while(x > i){
                    // xがソート後の並び順のi番目の位置より大きい場合にループ処理を続ける。
                    
                    // ソート後の並び順の現在位置と、現在確定するべき場所の位置の差をとり、
                    // 素数豹の何番目の位置に入れるべきかを考える
                    int ind = Arrays.binarySearch(primes, x-i+1);

                    System.out.print(" x = " + x);
                    System.out.println(" ind = " + ind);
                    if(ind < 0)ind = -ind-2;
                    lines.add((x-primes[ind]+1+1) + " " + (x+1));
                    int nex = x-primes[ind]+1;
                    int num = ia[nex];
                    {
                        int d = a[i][1];
                        a[i][1] = a[num][1]; 
                        a[num][1] = d;
                    }
                    {
                        int d = ia[x];
                        ia[x] = ia[nex];
                        ia[nex] = d;
                    }
                    x = nex;
                    
                    printMatrix(a);
                    printArray(ia);
                    System.out.println("--------");
                }
            }
            pw.println(lines.size());
            for(String line : lines){
                pw.println(line);
            }

            
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (Exception igunore) {}
        }
        
    }


    void printMatrix(int[][] p) {
        for (int[] i : p) printArray(i);
    }
    
    void printArray(int[] p) {
        for (int i : p) System.out.print(i + " ");
        System.out.println();
    }
    
    public void solve() { 
        try {
            br = new BufferedReader(new InputStreamReader(
                    INPUT_PATH == null ? System.in : new FileInputStream(new File(INPUT_PATH))));

            int N = readInt();

            int[] first = readIntArray();
            
            int[] goal = Arrays.copyOf(first, N);
            Arrays.sort(goal);

            int[] check = copyOf(first, N);

            List<String> set = new ArrayList<String>();
            
            int sortCnt = 0;
            int[] primes = getPrimeNum();
            for (int i = 0; i < N; i++) {
                int num = check[i];
                while (num > i + 1) {                    
                    int shift = Arrays.binarySearch(primes, num - i - 1);
                    
                    if ( shift < 0) shift = -shift;
                    int move = check[shift];
                    
                    set.add(num + " " + move);
                    
                    check[shift] = num;
                    check[i] = move;
                    num = move;
                    sortCnt++;
                }
                
            }
            
            pw.println(sortCnt);

            for (String s : set) {
                pw.println(s);
            }

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (Exception igunore) {}
        }
    }

    boolean[] dp = new boolean[100001];
    {
        Arrays.fill(dp, true);
        dp[0] = false;
        dp[1] = false;
        for (int i = 2; i <= 1000; i++) {
            if (dp[i]) {
                for (int j = i + i; j < 100001; j+=i ) {
                    dp[j] = false;
                }
            }
        }
    }
    boolean checkPrimeNum(int num) {
        return dp[num];
    }
    
    int[] getPrimeNum() {
        
        int cnt = 0;
        for (int i = 2; i < 100000; i++) {
            if (dp[i]) {
                cnt++;
            }
        }

        int[] res = new int[cnt];
        int index = 0;
        for (int i = 2; i < 100000; i++) {
            if (dp[i]) {
                res[index++] = i;
            }
        }
        return res;
    }
    
    boolean deepEquals(int[] i1, int[] i2) {
        if (i1.length != i2.length) return false;
        for (int i = 0 ; i < i1.length; i++) {
            if (i1[i] != i2[i]) return false;
        }
        return true;
    }

    private int brPos = 0;
    private int[] brBuf = null;
    
    private int readMinInt() throws IOException {
        if (brBuf == null || brBuf.length == brPos) {
            brBuf = readIntArray();
            brPos = 0;
        }
        return brBuf[brPos++];
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
        C app = new C();
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