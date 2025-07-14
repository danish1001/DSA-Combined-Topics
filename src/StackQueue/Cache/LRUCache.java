package StackQueue.Cache;

public class LRUCache {
    // Least Recently Used Cache
    // capacity is the maximum size of cache which can be stored in LRU Cache
    // implement the following Operations in O(1) Time Complexity:
    //      1. Get: gets value of cache by key if exist otherwise return -1.
    //          1. if key exist, every time gets function is called update Least Recently Used Order.
    //      2. Put: update the value of key otherwise, adds key value pair in cache.
    //          1. if key exist update the value and LRU Order
    //          2. if capacity is reached and key doesn't exist in cache delete Least Recently Used Cache and add new cache.

    // We will be using Doubly Linked List to maintain the order of Least Recently Used (LRU) Cache.
    // We will be using HashMap to add Key value(Node Address in DLL) pair.
    // All of this will cost only O(1).

}
