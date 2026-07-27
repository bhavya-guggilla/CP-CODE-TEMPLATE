# Java Competitive Programming Template

A single-file Java template packed with commonly used algorithms, data structures, and helper utilities — built to save setup time and reduce boilerplate during contests.

Includes fast I/O, modular arithmetic, number theory, array/prefix utilities, DSU, Bit Manipulation, grid traversal, a random test-case generator, and a built-in debug logger you can toggle on/off.

---

## Features

- Fast buffered input/output
- Modular arithmetic (add/sub/mul/inverse/divide) under `1e9+7`
- Math utilities — gcd, lcm, fast power, primality test, sieve
- Array utilities — binary search bounds, prefix/suffix sum/min/max
- Monotonic stack — next greater element (values & indices)
- Grid traversal — bounds check, DFS, BFS
- Disjoint Set Union (Union-Find) with path compression
- Generic `Pair<A, B>` class
- Bit manipulation utilities — get/set/clear/toggle, popcount, subset enumeration
- Random & edge-case test data generator
- Debug logger, silenced by a single `DEBUG` flag

---

## Classes

### `IO` — Fast Input Utilities

**Purpose:** Read input efficiently with minimal boilerplate.

| Function  | Purpose                              |
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

| Function   | Purpose                              |
| ---------- | ------------------------------------ |
| `add(a,b)` | Compute `(a + b) % MOD`              |
| `sub(a,b)` | Compute `(a - b) % MOD`              |
| `mul(a,b)` | Compute `(a × b) % MOD`              |
| `inv(a)`   | Modular multiplicative inverse       |
| `div(a,b)` | Compute `(a / b) % MOD`              |

---

### `Mth` — Math Utilities

**Purpose:** Frequently used mathematical algorithms.

| Function        | Purpose                                            |
| --------------- | -------------------------------------------------  |
| `gcd(a,b)`      | Greatest Common Divisor                            |
| `lcm(a,b)`      | Least Common Multiple                              |
| `power(b,e,m)`  | Fast modular exponentiation                        |
| `isPrime(n)`    | Check if a number is prime                         |
| `sieve(n)`      | Generate a composite table via Sieve of Eratosthenes |

---

### `Arr` — Array Utilities

**Purpose:** Binary search and prefix/suffix preprocessing.

| Function          | Purpose                          |
| ----------------- | -------------------------------- |
| `lowerBound(a,x)` | First index where value ≥ `x`    |
| `upperBound(a,x)` | First index where value > `x`    |
| `prefixSum(a)`    | Prefix sum array                 |
| `suffixSum(a)`    | Suffix sum array                 |
| `prefixMin(a)`    | Prefix minimum array             |
| `suffixMin(a)`    | Suffix minimum array             |
| `prefixMax(a)`    | Prefix maximum array             |
| `suffixMax(a)`    | Suffix maximum array             |

---

### `Stk` — Monotonic Stack

**Purpose:** Solve Next Greater Element type problems.

| Function              | Purpose                         |
| --------------------- | ------------------------------  |
| `nextGreater(a)`      | Next Greater Element values     |
| `nextGreaterIndex(a)` | Next Greater Element indices    |

---

### `Grd` — Grid Algorithms

**Purpose:** Common utilities for grid traversal.

| Function                     | Purpose                                     |
| ----------------------------- | ------------------------------------------ |
| `inBounds(r,c,rows,cols)`     | Check whether a cell is inside the grid    |
| `dfs(r,c,grid,visited,wall)`  | Depth-first search from a cell             |
| `bfs(r,c,grid,visited,wall)`  | Breadth-first search from a cell           |

---

### `DSU` — Disjoint Set Union

**Purpose:** Maintain connected components efficiently.

| Function           | Purpose                                        |
| ------------------ | ---------------------------------------------  |
| `find(x)`          | Find representative of a set                   |
| `union(a,b)`       | Merge two disjoint sets                        |
| `connected(a,b)`   | Check if two nodes belong to the same set      |

---
### `Pair<A, B>` — Generic Pair

**Purpose:** Bundle two values together, useful for sorting and priority queues.

| Field / Method  | Purpose                     |
| --------------- | --------------------------- |
| `first`         | First element               |
| `second`        | Second element              |

---

### `Bit` — Bit Manipulation Utilities

**Purpose:** Common bitwise operations on `long` values.

| Function                | Purpose                                                     |
| ----------------------- | ------------------------------------------------------------ |
| `get(n,i)`              | Value (0 or 1) of bit `i` in `n`                             |
| `set(n,i)`              | Set bit `i` to 1                                              |
| `clear(n,i)`            | Clear bit `i` to 0                                            |
| `toggle(n,i)`           | Flip bit `i`                                                  |
| `isSet(n,i)`            | Check if bit `i` is set                                       |
| `countSetBits(n)`       | Popcount — number of set bits                                 |
| `isPowerOfTwo(n)`       | Check if `n` is a positive power of two                       |
| `clearLowestSetBit(n)`  | Clear the lowest set bit                                       |
| `lowestSetBit(n)`       | Isolate the lowest set bit                                     |
| `lowestSetBitIndex(n)`  | Index of the lowest set bit (`-1` if `n == 0`)                 |
| `highestSetBitIndex(n)` | Index of the highest set bit (`-1` if `n == 0`)                |
| `bitLength(n)`          | Number of bits needed to represent `n`                         |
| `subsets(mask)`         | Enumerate all submasks of `mask`, including `0` and `mask`      |
| `xorSwap(a,b)`          | Swap two ints without a temp variable using XOR                |

```java
```

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


### Debug Mode

```java
public static final boolean DEBUG = true;
```

---

### Quick Example

```java
int[] a = IO.iArr(n);
long g = b;
for (int val : a) {
    g = Mth.gcd(g, val);
}
int pos = Arr.lowerBound(sortedArray, x);
DSU dsu = new DSU(n);
dsu.union(u, v);
long ans = Mod.mul(x, y);
int popcount = Bit.countSetBits(mask);
```
