# Java Competitive Programming Template

A single-file Java template packed with commonly used algorithms, data structures, and helper utilities — built to save setup time and reduce boilerplate during contests.

Includes fast I/O, modular arithmetic, number theory, array/prefix utilities, graph algorithms, segment tree, DSU, grid traversal, a random test-case generator, and a built-in debug logger you can toggle on/off.

---

## Features

- ⚡ Fast buffered input/output
- 🧮 Modular arithmetic (add/sub/mul/inverse/divide) under `1e9+7`
- 🔢 Math utilities — gcd, lcm, fast power, primality test, sieve
- 📊 Array utilities — binary search bounds, prefix/suffix sum/min/max
- 🥞 Monotonic stack — next greater element (values & indices)
- 🗺️ Grid traversal — bounds check, DFS, BFS
- 🔗 Disjoint Set Union (Union-Find) with path compression
- 🌲 Segment Tree — range sum query, point update
- 🕸️ Graph — adjacency list + Dijkstra's shortest path
- 👯 Generic `Pair<A, B>` class
- 🎲 Random & edge-case test data generator
- 🐞 Debug logger, silenced by a single `DEBUG` flag

---

## Classes

### `IO` — Fast Input Utilities

**Purpose:** Read input efficiently with minimal boilerplate.

| Function  | Purpose                             |
| --------- | ------------------------------------ |
| `next()`  | Read the next space-separated token  |
| `i()`     | Read an integer                      |
| `l()`     | Read a long                          |
| `d()`     | Read a double                        |
| `line()`  | Read an entire line                  |
| `iArr(n)` | Read an integer array of size `n`    |
| `lArr(n)` | Read a long array of size `n`        |
| `sArr(n)` | Read a string array of size `n`      |

---

### `Mod` — Modular Arithmetic

**Purpose:** Perform arithmetic operations under modulo `1e9+7`.

| Function   | Purpose                             |
| ---------- | ------------------------------------ |
| `add(a,b)` | Compute `(a + b) % MOD`              |
| `sub(a,b)` | Compute `(a - b) % MOD`              |
| `mul(a,b)` | Compute `(a × b) % MOD`              |
| `inv(a)`   | Modular multiplicative inverse       |
| `div(a,b)` | Compute `(a / b) % MOD`              |

---

### `Mth` — Math Utilities

**Purpose:** Frequently used mathematical algorithms.

| Function        | Purpose                                          |
| --------------- | ------------------------------------------------- |
| `gcd(a,b)`      | Greatest Common Divisor                            |
| `lcm(a,b)`      | Least Common Multiple                              |
| `power(b,e,m)`  | Fast modular exponentiation                        |
| `isPrime(n)`    | Check if a number is prime                         |
| `sieve(n)`      | Generate a composite table via Sieve of Eratosthenes |

---

### `Arr` — Array Utilities

**Purpose:** Binary search and prefix/suffix preprocessing.

| Function          | Purpose                        |
| ----------------- | -------------------------------- |
| `lowerBound(a,x)` | First index where value ≥ `x`  |
| `upperBound(a,x)` | First index where value > `x`  |
| `prefixSum(a)`    | Prefix sum array                 |
| `suffixSum(a)`    | Suffix sum array                 |
| `prefixMin(a)`    | Prefix minimum array             |
| `suffixMin(a)`    | Suffix minimum array             |
| `prefixMax(a)`    | Prefix maximum array             |
| `suffixMax(a)`    | Suffix maximum array             |

---

### `Stk` — Monotonic Stack

**Purpose:** Solve Next Greater Element type problems.

| Function              | Purpose                       |
| --------------------- | ------------------------------ |
| `nextGreater(a)`      | Next Greater Element values     |
| `nextGreaterIndex(a)` | Next Greater Element indices    |

---

### `Grd` — Grid Algorithms

**Purpose:** Common utilities for grid traversal.

| Function                     | Purpose                                 |
| ----------------------------- | ------------------------------------------ |
| `inBounds(r,c,rows,cols)`     | Check whether a cell is inside the grid    |
| `dfs(r,c,grid,visited,wall)`  | Depth-first search from a cell             |
| `bfs(r,c,grid,visited,wall)`  | Breadth-first search from a cell           |

---

### `DSU` — Disjoint Set Union

**Purpose:** Maintain connected components efficiently.

| Function          | Purpose                                    |
| ------------------ | --------------------------------------------- |
| `find(x)`          | Find representative of a set                   |
| `union(a,b)`       | Merge two disjoint sets                        |
| `connected(a,b)`   | Check if two nodes belong to the same set      |

---

### `ST` — Segment Tree

**Purpose:** Efficient range query and point update operations.

| Function       | Purpose                        |
| -------------- | --------------------------------- |
| `update(idx,val)` | Update value at an index        |
| `query(l,r)`      | Query range sum over `[l, r]`    |

---

### `Graph` — Adjacency List & Dijkstra

**Purpose:** Weighted graph representation and shortest paths.

| Function                    | Purpose                                    |
| ---------------------------- | --------------------------------------------- |
| `addEdge(u,v,w,directed)`   | Add a weighted edge (directed or undirected)  |
| `dijkstra(src)`             | Shortest distances from `src` to all nodes    |

---

### `Pair<A, B>` — Generic Pair

**Purpose:** Bundle two values together, useful for sorting and priority queues.

| Field / Method | Purpose                  |
| --------------- | --------------------------- |
| `first`         | First element               |
| `second`        | Second element              |

---

### `Gen` — Test Case Generator

**Purpose:** Generate random and edge-case test data.

| Function              | Purpose                          |
| ---------------------- | ----------------------------------- |
| `i(min,max)`           | Generate random integer             |
| `l(min,max)`           | Generate random long                 |
| `iArr(size,min,max)`   | Generate random integer array        |
| `edgeArr(size)`        | Generate edge-case integer array     |
| `str(len)`             | Generate random lowercase string     |

---

### `DBG` — Debug Utilities

**Purpose:** Print debugging information during development.

| Function          | Purpose                         |
| ------------------ | ------------------------------------ |
| `log(label,val)`   | Print a variable with its label       |
| `grid(label,grid)` | Print a 2D character grid             |
| `msg(text)`        | Print a custom debug message           |

---

## Debug Mode

```java
public static final boolean DEBUG = true;
```

Set `DEBUG = false` before submitting your solution — debug output isn't free, and judges won't thank you for the extra I/O.

---

## Quick Example

```java
int n = IO.i();
int[] a = IO.iArr(n);

long g = Mth.gcd(a[0], a[1]);
int pos = Arr.lowerBound(a, 5);

DSU dsu = new DSU(n);
dsu.union(0, 1);

ST seg = new ST(Arrays.stream(a).asLongStream().toArray());
long sum = seg.query(0, n - 1);

Graph graph = new Graph(n);
graph.addEdge(0, 1, 4, false);
long[] dist = graph.dijkstra(0);

long ans = Mod.mul(a[0], a[1]);
```

---

## Usage

1. Copy `Main.java` into your solution folder.
2. Write your logic inside `main()`, using the utility classes above.
3. Set `DEBUG = false` before final submission.

## Contributing

Suggestions and pull requests for additional utilities (Trie, Fenwick Tree, LCA, KMP, combinatorics, etc.) are welcome.

## License

MIT
