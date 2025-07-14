package Heaps;
public class MaxHeapImplementation {
    int[] heap;
    int heapSize, capacity;
    public MaxHeapImplementation() {
        this.heap = new int[1];
        this.capacity = 1;
        this.heapSize = -1;
    }
    public MaxHeapImplementation(int[] heap) {
        this.heap = heap;
        this.capacity = heap.length;
        this.heapSize = heap.length - 1;
        buildHeap();
    }
    public void buildHeap() {
        // why capacity/2 -1
        // if you look at the pattern of complete binary tree
        // child nodes will occur after capacity/2-1 i.e. no nead to call heapify at leaf nodes
        // only need to call heapify for parent nodes
        // buildHeap has O(1) T.C.
        for (int i = heapSize / 2 - 1; i >= 0; i--) {
            heapify(i);
        }
    }
    public void heapify(int index) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int largest = index;
        if (leftChild < heapSize && heap[leftChild] > heap[largest]) {
            largest = leftChild;
        }
        // V.V IMP Point: here we are using heap[largest]
        if (rightChild < heapSize && heap[rightChild] > heap[largest]) {
            largest = rightChild;
        }
        if (largest != index) {
            swap(heap, largest, index);
            heapify(largest);
        }
    }
    public int peek() {
        if (isEmpty()) return -1;
        return this.heap[0];
    }
    public int extractMax() {
        if(isEmpty()) return -1;
        int max = peek();
        swap(heap, 0, heapSize);
        heapSize--;
        heapify(0);
        return max;
    }
    public void insert(int ele) {
        if (isOverflow()) increaseCapacity();
        heapSize++;
        heap[heapSize] = ele;
        int index = heapSize;
        int parentIndex = (heapSize + 1) / 2 - 1;
        while (index > 0 && heap[index] > heap[parentIndex]) {
            swap(heap, index, parentIndex);
            index = parentIndex;
            parentIndex = (index+1)/2 - 1;
        }
    }
    public void increaseKey(int index, int newValue) {
        if(index < 0 || index > heapSize || heap[index] >= newValue) {
            System.out.println("Wrong Operation");
            return;
        }
        heap[index] = newValue;
        int parentInd = (index+2)/2 - 1;
        while (index > 0 && heap[parentInd] < heap[index]) {
            swap(heap, index, parentInd);
            index = parentInd;
            parentInd = (index+2)/2 - 1;
        }
    }
    public void decreaseKey(int index, int newValue) {
        if(index < 0 || index > heapSize || heap[index] <= newValue) {
            System.out.println("Wrong Operation");
            return;
        }
        heap[index] = newValue;
        heapify(index);
    }
    public void heapSort() {

    }
    public void increaseCapacity() {
        int newCapacity = 2 * capacity;
        int[] newHeap = new int[newCapacity];
        for (int i = 0; i < capacity; i++) {
            newHeap[i] = heap[i];
        }
        heap = newHeap;
        capacity = newCapacity;
    }
    public boolean isOverflow() {
        if (heapSize == capacity - 1) return true;
        return false;
    }
    public boolean isEmpty() {
        if (heapSize == -1) return true;
        return false;
    }
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void printHeap() {
        for(int i=0; i<=heapSize; i++) {
            System.out.print(heap[i] + ", ");
        }
        System.out.println();
    }
}