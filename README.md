# Java Competitive Programming Template

A single-file Java template packed with commonly used algorithms, data structures, and helper utilities — built to save setup time and reduce boilerplate during contests.

Includes fast I/O, modular arithmetic, number theory, array/prefix utilities, DSU, grid traversal, a random test-case generator, and a built-in debug logger you can toggle on/off.

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


## Bit — Bit Manipulation Utilities

A collection of static helper methods for common bitwise operations on `long` values.

### Usage

\`\`\`java
long n = 42L;
Bit.get(n, 3);              // read bit at index 3
Bit.set(n, 0);               // set bit 0
Bit.clear(n, 1);             // clear bit 1
Bit.toggle(n, 2);            // flip bit 2
Bit.isSet(n, 3);             // true/false
\`\`\`

### API Reference

| Method      | Description |
| `get(n, i)` | Returns the value (0 or 1) of bit `i` in `n`. |
| `set(n, i)` | Returns `n` with bit `i` set to 1. |
| `clear(n, i)` | Returns `n` with bit `i` cleared to 0. |
| `toggle(n, i)` | Returns `n` with bit `i` flipped. |
| `isSet(n, i)` | Returns `true` if bit `i` is set. |
| `countSetBits(n)` | Returns the number of set bits (popcount) in `n`. |
| `isPowerOfTwo(n)` | Returns `true` if `n` is a positive power of two. |
| `clearLowestSetBit(n)` | Returns `n` with its lowest set bit cleared. |
| `lowestSetBit(n)` | Returns a value with only the lowest set bit of `n` retained. |
| `lowestSetBitIndex(n)` | Returns the index of the lowest set bit, or `-1` if `n == 0`. |
| `highestSetBitIndex(n)` | Returns the index of the highest set bit, or `-1` if `n == 0`. |
| `bitLength(n)` | Returns the number of bits needed to represent `n` (position of highest set bit + 1). |
| `subsets(mask)` | Returns all bitmask subsets of `mask`, including `0` and `mask` itself, using the classic submask enumeration trick.|
| `xorSwap(a, b)` | Swaps two ints without a temporary variable using XOR, returned as `{a, b}`.|

### Notes

- All bit indices are 0-based, counting from the least significant bit.
- `subsets(mask)` runs in `O(3^popcount(mask))` total across all masks combined — the standard complexity for submask enumeration — making it efficient for subset DP problems.

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
```
