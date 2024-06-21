import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

public class App {

    private static class BloomFilter {
        private BitSet bitSet;
        private int size;
        private int[] hashSeeds;

        public BloomFilter(int size, int[] hashSeeds) {
            this.size = size;
            this.bitSet = new BitSet(size);
            this.hashSeeds = hashSeeds;
        }

        private int hash(String data, int seed) {
            int hash = 0;
            for (int i = 0; i < data.length(); i++) {
                hash = seed * hash + data.charAt(i);
            }
            return (hash & 0x7fffffff) % size;
        }

        public void add(String data) {
            for (int seed : hashSeeds) {
                int hash = hash(data, seed);
                bitSet.set(hash);
            }
        }

        public boolean contains(String data) {
            for (int seed : hashSeeds) {
                int hash = hash(data, seed);
                if (!bitSet.get(hash)) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) throws IOException {
        String filePath = "resources/ip_addresses.txt";
        BloomFilter bloomFilter = new BloomFilter(1000000, new int[]{3, 5, 7});
        Set<String> uniqueIPs = new HashSet<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!bloomFilter.contains(line)) {
                    bloomFilter.add(line);
                    uniqueIPs.add(line);
                }
            }
        }

        System.out.println("Number of unique IP addresses: " + uniqueIPs.size());
    }
}