public class ModifBinaryTreeArray28 {
        int[] data;
        int idxLast;
        int capacity;
    
        public ModifBinaryTreeArray28(int capacity) {
            this.capacity = capacity;
            data = new int[capacity];
            idxLast = -1;
        }
    
        public void add(int data) {
            if (idxLast < capacity - 1) {
                idxLast++;
                this.data[idxLast] = data;
            } else {
                System.out.println("Tree is full, cannot add more elements.");
            }
        }
    
        public void traversePreOrder(int idxStart) {
            if (idxStart <= idxLast) {
                System.out.print(data[idxStart] + " ");
                traversePreOrder(2 * idxStart + 1);
                traversePreOrder(2 * idxStart + 2);
            }
        }
    
        public void traversePostOrder(int idxStart) {
            if (idxStart <= idxLast) {
                traversePostOrder(2 * idxStart + 1);
                traversePostOrder(2 * idxStart + 2);
                System.out.print(data[idxStart] + " ");
            }
        }
    
        public void traverseInOrder(int idxStart) {
            if (idxStart <= idxLast) {
                traverseInOrder(2 * idxStart + 1);
                System.out.print(data[idxStart] + " ");
                traverseInOrder(2 * idxStart + 2);
            }
        }
    }
    
