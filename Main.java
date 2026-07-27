import java.io.*;
import java.util.*;

/**
 * Competitive Programming Template
 * Toggle DEBUG to enable/disable verbose logging via DBG.
 * Set DEBUG = false before final submission (debug I/O costs time).
 */
public class Main {

    public static final boolean DEBUG = true;

    // ================= IO : Fast input/output =================
    static class IO {
        private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private static StringTokenizer st;

        static String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        static int i() { return Integer.parseInt(next()); }
        static long l() { return Long.parseLong(next()); }
        static double d() { return Double.parseDouble(next()); }

        static String line() {
            try { return br.readLine(); } catch (IOException e) { throw new RuntimeException(e); }
        }

        static int[] iArr(int n) { int[] a = new int[n]; for (int k = 0; k < n; k++) a[k] = i(); return a; }
        static long[] lArr(int n) { long[] a = new long[n]; for (int k = 0; k < n; k++) a[k] = l(); return a; }
        static String[] sArr(int n) { String[] a = new String[n]; for (int k = 0; k < n; k++) a[k] = next(); return a; }
    }

    // ================= DBG : Debug utilities =================
    static class DBG {
        static void log(String label, Object val) {
            if (!DEBUG) return;
            String s;
            if (val instanceof int[]) s = Arrays.toString((int[]) val);
            else if (val instanceof long[]) s = Arrays.toString((long[]) val);
            else if (val instanceof Object[]) s = Arrays.deepToString((Object[]) val);
            else s = String.valueOf(val);
            System.err.println("[DEBUG] " + label + " = " + s);
        }

        static void grid(String label, char[][] g) {
            if (!DEBUG) return;
            System.err.println("[DEBUG GRID] " + label + ":");
            for (char[] row : g) System.err.println("  " + new String(row));
        }

        static void msg(String text) {
            if (DEBUG) System.err.println("[DEBUG] " + text);
        }
    }

    // ================= Mod : Modular arithmetic =================
    static class Mod {
        static final long MOD = 1_000_000_007L;

        static long add(long a, long b) { return ((a % MOD) + (b % MOD) + MOD) % MOD; }
        static long sub(long a, long b) { return ((a % MOD) - (b % MOD) + MOD) % MOD; }
        static long mul(long a, long b) { return ((a % MOD) * (b % MOD)) % MOD; }
        static long inv(long a) { return Mth.power(a, MOD - 2, MOD); }
        static long div(long a, long b) { return mul(a, inv(b)); }
    }

    // ================= Mth : Math utilities =================
    static class Mth {
        static long gcd(long a, long b) { return b == 0 ? a : gcd(b, a % b); }
        static long lcm(long a, long b) { return (a / gcd(a, b)) * b; }

        static long power(long base, long exp, long mod) {
            long result = 1;
            base %= mod;
            while (exp > 0) {
                if ((exp & 1) == 1) result = (result * base) % mod;
                base = (base * base) % mod;
                exp >>= 1;
            }
            return result;
        }

        static boolean isPrime(long n) {
            if (n <= 1) return false;
            if (n <= 3) return true;
            if (n % 2 == 0 || n % 3 == 0) return false;
            for (long k = 5; k * k <= n; k += 6)
                if (n % k == 0 || n % (k + 2) == 0) return false;
            return true;
        }

        // Sieve of Eratosthenes, isComposite[i] == true means i is NOT prime
        static boolean[] sieve(int n) {
            boolean[] composite = new boolean[n + 1];
            for (int p = 2; (long) p * p <= n; p++)
                if (!composite[p])
                    for (int k = p * p; k <= n; k += p) composite[k] = true;
            return composite;
        }
    }

    // ================= Arr : Array / prefix-suffix utilities =================
    static class Arr {
        // first index where a[idx] >= x
        static int lowerBound(int[] a, int x) {
            int lo = 0, hi = a.length;
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (a[mid] >= x) hi = mid; else lo = mid + 1;
            }
            return lo;
        }

        // first index where a[idx] > x
        static int upperBound(int[] a, int x) {
            int lo = 0, hi = a.length;
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (a[mid] > x) hi = mid; else lo = mid + 1;
            }
            return lo;
        }

        static long[] prefixSum(int[] a) {
            long[] p = new long[a.length + 1];
            for (int k = 0; k < a.length; k++) p[k + 1] = p[k] + a[k];
            return p;
        }

        static long[] suffixSum(int[] a) {
            long[] s = new long[a.length + 1];
            for (int k = a.length - 1; k >= 0; k--) s[k] = s[k + 1] + a[k];
            return s;
        }

        static int[] prefixMin(int[] a) {
            int[] p = a.clone();
            for (int k = 1; k < a.length; k++) p[k] = Math.min(p[k - 1], p[k]);
            return p;
        }

        static int[] suffixMin(int[] a) {
            int[] s = a.clone();
            for (int k = a.length - 2; k >= 0; k--) s[k] = Math.min(s[k], s[k + 1]);
            return s;
        }

        static int[] prefixMax(int[] a) {
            int[] p = a.clone();
            for (int k = 1; k < a.length; k++) p[k] = Math.max(p[k - 1], p[k]);
            return p;
        }

        static int[] suffixMax(int[] a) {
            int[] s = a.clone();
            for (int k = a.length - 2; k >= 0; k--) s[k] = Math.max(s[k], s[k + 1]);
            return s;
        }
    }

    // ================= Stk : Monotonic stack (Next Greater Element) =================
    static class Stk {
        static int[] nextGreater(int[] a) {
            int n = a.length;
            int[] res = new int[n];
            Arrays.fill(res, -1);
            Deque<Integer> stack = new ArrayDeque<>(); // stores values
            for (int k = n - 1; k >= 0; k--) {
                while (!stack.isEmpty() && stack.peek() <= a[k]) stack.pop();
                if (!stack.isEmpty()) res[k] = stack.peek();
                stack.push(a[k]);
            }
            return res;
        }

        static int[] nextGreaterIndex(int[] a) {
            int n = a.length;
            int[] res = new int[n];
            Arrays.fill(res, -1);
            Deque<Integer> stack = new ArrayDeque<>(); // stores indices
            for (int k = n - 1; k >= 0; k--) {
                while (!stack.isEmpty() && a[stack.peek()] <= a[k]) stack.pop();
                if (!stack.isEmpty()) res[k] = stack.peek();
                stack.push(k);
            }
            return res;
        }
    }

    // ================= Bit : Bit manipulation utilities =================
static class Bit {
    static int get(long n, int i) { return (int) ((n >> i) & 1); }
    static long set(long n, int i) { return n | (1L << i); }
    static long clear(long n, int i) { return n & ~(1L << i); }
    static long toggle(long n, int i) { return n ^ (1L << i); }
    static boolean isSet(long n, int i) { return get(n, i) == 1; }
    static int countSetBits(long n) { return Long.bitCount(n); }
    static boolean isPowerOfTwo(long n) { return n > 0 && (n & (n - 1)) == 0; }
    static long clearLowestSetBit(long n) { return n & (n - 1); }
    static long lowestSetBit(long n) { return n & (-n); }
    static int lowestSetBitIndex(long n) { return n == 0 ? -1 : Long.numberOfTrailingZeros(n); }
    static int highestSetBitIndex(long n) { return n == 0 ? -1 : 63 - Long.numberOfLeadingZeros(n); }
    static int bitLength(long n) { return 64 - Long.numberOfLeadingZeros(n); }
    static List<Long> subsets(long mask) {
        List<Long> res = new ArrayList<>();
        long sub = mask;
        while (true) {
            res.add(sub);
            if (sub == 0) break;
            sub = (sub - 1) & mask;
        }
        return res;
    }
    static int[] xorSwap(int a, int b) { a ^= b; b ^= a; a ^= b; return new int[]{a, b}; }
}

    // ================= Grd : Grid traversal =================
    static class Grd {
        static final int[] DR = {-1, 1, 0, 0};
        static final int[] DC = {0, 0, -1, 1};

        static boolean inBounds(int r, int c, int rows, int cols) {
            return r >= 0 && r < rows && c >= 0 && c < cols;
        }

        static void dfs(int r, int c, char[][] grid, boolean[][] visited, char wall) {
            visited[r][c] = true;
            for (int k = 0; k < 4; k++) {
                int nr = r + DR[k], nc = c + DC[k];
                if (inBounds(nr, nc, grid.length, grid[0].length) && !visited[nr][nc] && grid[nr][nc] != wall)
                    dfs(nr, nc, grid, visited, wall);
            }
        }

        static void bfs(int sr, int sc, char[][] grid, boolean[][] visited, char wall) {
            Queue<int[]> q = new ArrayDeque<>();
            q.add(new int[]{sr, sc});
            visited[sr][sc] = true;
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                for (int k = 0; k < 4; k++) {
                    int nr = cur[0] + DR[k], nc = cur[1] + DC[k];
                    if (inBounds(nr, nc, grid.length, grid[0].length) && !visited[nr][nc] && grid[nr][nc] != wall) {
                        visited[nr][nc] = true;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
        }
    }

    // ================= DSU : Disjoint Set Union =================
    static class DSU {
        final int[] parent, size;

        DSU(int n) {
            parent = new int[n];
            size = new int[n];
            for (int k = 0; k < n; k++) { parent[k] = k; size[k] = 1; }
        }

        int find(int x) {
            return parent[x] == x ? x : (parent[x] = find(parent[x]));
        }

        boolean union(int a, int b) {
            int ra = find(a), rb = find(b);
            if (ra == rb) return false;
            if (size[ra] < size[rb]) { int t = ra; ra = rb; rb = t; }
            parent[rb] = ra;
            size[ra] += size[rb];
            return true;
        }

        boolean connected(int a, int b) { return find(a) == find(b); }
    }
    // ================= Pair : generic pair =================
    static class Pair<A, B> {
        A first;
        B second;
        Pair(A a, B b) { first = a; second = b; }
        public String toString() { return "(" + first + ", " + second + ")"; }
    }

    // ================= Gen : random / edge-case test data generator =================
    static class Gen {
        static final Random rnd = new Random();

        static int i(int min, int max) { return min + rnd.nextInt(max - min + 1); }
        static long l(long min, long max) { return min + (long) (rnd.nextDouble() * (max - min + 1)); }

        static int[] iArr(int size, int min, int max) {
            int[] a = new int[size];
            for (int k = 0; k < size; k++) a[k] = i(min, max);
            return a;
        }

        static int[] edgeArr(int size) {
            int[] pool = {0, 1, -1, Integer.MAX_VALUE, Integer.MIN_VALUE};
            int[] a = new int[size];
            for (int k = 0; k < size; k++) a[k] = pool[rnd.nextInt(pool.length)];
            return a;
        }

        static String str(int len) {
            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < len; k++) sb.append((char) ('a' + rnd.nextInt(26)));
            return sb.toString();
        }
    }

    // ================= main =================
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        // ---- Quick usage reference ----
        // int n = IO.i();                     long v = IO.l();
        // int[] a = IO.iArr(n);                long[] b = IO.lArr(n);
        // long g = Mth.gcd(x, y);              long p = Mth.power(base, exp, Mod.MOD);
        // int idx = Arr.lowerBound(sortedArr, x);
        // DSU dsu = new DSU(n);                dsu.union(u, v);
        // ST seg = new ST(values);             long sum = seg.query(l, r);
        // Graph g2 = new Graph(n);             g2.addEdge(u, v, w, false);
        // long[] dist = g2.dijkstra(src);
        // DBG.log("n", n);

        out.flush();
    }
}
