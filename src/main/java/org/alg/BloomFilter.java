package org.alg;

import java.nio.charset.StandardCharsets;
import java.util.BitSet;
import java.util.Random;


public class BloomFilter {
    private final BitSet bitSet;
    private final int bitSetSize;
    private final int numHashFunctions;
    private final int[] hashSeeds;

    public BloomFilter(int size, int numHashFunctions) {
        this.bitSetSize = size;
        this.numHashFunctions = numHashFunctions;
        this.bitSet = new BitSet(size);
        this.hashSeeds = new int[numHashFunctions];
        Random rand = new Random();
        for (int i = 0; i < numHashFunctions; i++) {
            hashSeeds[i] = rand.nextInt();
        }
    }

    /**
     * Multiply hash by 31: This helps spread out the bits,
     * ensuring that small changes in input result in
     * different hash values. The number 31 is often chosen
     * because it's a prime number, which helps minimize collisions.
     *
     * XOR (^) with b: The bitwise XOR operation combines
     * the existing hash value with b, introducing new bits
     * into the hash. This ensures that different values of b
     * produce different results.
     * @param data
     * @param seed
     * @return
     */

    private int hash(String data, int seed) {
        int hash = seed;
        for (byte b : data.getBytes(StandardCharsets.UTF_8)) {
            hash = (hash * 31) ^ b;
        }
        return Math.abs(hash % bitSetSize);
    }

    public void add(String data) {
        for (int seed : hashSeeds) {
            bitSet.set(hash(data, seed));
        }
    }

    public boolean mightContain(String data) {
        for (int seed : hashSeeds) {
            if (!bitSet.get(hash(data, seed))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        BloomFilter bloomFilter = new BloomFilter(1000, 3);

        bloomFilter.add("hello");
        bloomFilter.add("world");

        System.out.println("Contains 'hello': " + bloomFilter.mightContain("hello"));
        System.out.println("Contains 'world': " + bloomFilter.mightContain("world"));
        System.out.println("Contains 'java': " + bloomFilter.mightContain("java"));
    }
