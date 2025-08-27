public class Main {
    // --------- MAX HEAP IMPLEMENTATION ----------
    static class MaxHeap {
        private int[] heap;
        private int size;
        private int capacity;

        public MaxHeap(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            heap = new int[capacity];
        }

        private int parent(int i) { return (i - 1) / 2; }
        private int left(int i) { return 2 * i + 1; }
        private int right(int i) { return 2 * i + 2; }

        private void swap(int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }

        // Insert value into heap
        public void insert(int val) {
            if (size == capacity) {
                System.out.println("Heap is full!");
                return;
            }
            heap[size] = val;
            int current = size;
            size++;

            // Bubble up
            while (current > 0 && heap[current] > heap[parent(current)]) {
                swap(current, parent(current));
                current = parent(current);
            }
        }

        // Extract the maximum value (root)
        public int extractMax() {
            if (size <= 0) throw new RuntimeException("Heap is empty");
            if (size == 1) return heap[--size];

            int root = heap[0];
            heap[0] = heap[--size];
            heapify(0);
            return root;
        }

        // Heapify (fix heap from index i downward)
        private void heapify(int i) {
            int l = left(i), r = right(i);
            int largest = i;

            if (l < size && heap[l] > heap[largest]) largest = l;
            if (r < size && heap[r] > heap[largest]) largest = r;

            if (largest != i) {
                swap(i, largest);
                heapify(largest);
            }
        }

        // Peek maximum
        public int getMax() {
            if (size == 0) throw new RuntimeException("Heap is empty");
            return heap[0];
        }

        // Print heap array
        public void printHeap() {
            for (int i = 0; i < size; i++) {
                System.out.print(heap[i] + " ");
            }
            System.out.println();
        }
    }

    // Driver code
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(15);

        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);

        System.out.println("Heap array: ");
        maxHeap.printHeap();

        System.out.println("Max value: " + maxHeap.getMax());

        System.out.println("Extracted Max: " + maxHeap.extractMax());
        System.out.println("Heap after extract: ");
        maxHeap.printHeap();
    }
}
