	1.	Time Complexity:
	•	Adding an element to the Bloom filter: O(k), where k is the number of hash functions.
	•	Checking an element in the Bloom filter: O(k), where k is the number of hash functions.
	•	Reading and processing the file: O(n * k), where n is the number of lines (IP addresses) in the file.
	2.	Space Complexity:
	•	Bloom filter: O(m), where m is the size of the bit array.
	•	HashSet for unique IP addresses: O(u), where u is the number of unique IP addresses.

Why was this algorithm chosen?

The naive algorithm using a HashSet requires a lot of memory to store all unique IP addresses, which is inefficient for large data sets. The Bloom filter uses a fixed amount of memory and quickly checks the uniqueness of IP addresses. This reduces memory consumption and speeds up data processing, making it preferable for this task.