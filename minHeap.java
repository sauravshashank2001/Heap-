public class Main {
    static class MinHeap {
        private int[] heap;
        private int size;
        private int capacity;

        public MinHeap(int capacity) {
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
            while (current > 0 && heap[current] < heap[parent(current)]) {
                swap(current, parent(current));
                current = parent(current);
            }
        }

        // Extract the minimum value (root)
        public int extractMin() {
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
            int smallest = i;

            if (l < size && heap[l] < heap[smallest]) smallest = l;
            if (r < size && heap[r] < heap[smallest]) smallest = r;

            if (smallest != i) {
                swap(i, smallest);
                heapify(smallest);
            }
        }

        // Peek minimum
        public int getMin() {
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
        MinHeap minHeap = new MinHeap(15);

        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);

        System.out.println("Heap array: ");
        minHeap.printHeap();

        System.out.println("Min value: " + minHeap.getMin());

        System.out.println("Extracted Min: " + minHeap.extractMin());
        System.out.println("Heap after extract: ");
        minHeap.printHeap();
    }
}
