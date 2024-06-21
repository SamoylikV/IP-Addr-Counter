## Time Complexity

- **Adding an element to the Bloom filter**: O(k), where k is the number of hash functions.
- **Checking an element in the Bloom filter**: O(k), where k is the number of hash functions.
- **Reading and processing the file**: O(n * k), where n is the number of lines (IP addresses) in the file.

## Space Complexity

- **Bloom filter**: O(m), where m is the size of the bit array.
- **HashSet for unique IP addresses**: O(u), where u is the number of unique IP addresses.

## Why This Algorithm Was Chosen

The naive algorithm using a HashSet requires a substantial amount of memory to store all unique IP addresses, which becomes inefficient for large datasets. The Bloom filter, on the other hand, uses a fixed amount of memory and allows for quick checks of the uniqueness of IP addresses. This approach reduces memory consumption and speeds up data processing, making it a preferable solution for handling large datasets efficiently.
