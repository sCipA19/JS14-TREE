public class Tugas4 {
    static class Node28 {
        int data;
        Node28 left, right;

        public Node28(int item) {
            data = item;
            left = right = null;
        }
    }

    static class BinaryTree28 {
        Node28 root;

        public BinaryTree28() {
            root = null;
        }

        boolean isEmpty() {
            return root == null;
        }

        void add(int data) {
            if (isEmpty()) {
                root = new Node28(data);
            } else {
                Node28 current = root;
                while (true) {
                    if (data < current.data) {
                        if (current.left != null) {
                            current.left = new Node28(data);
                            break;
                        } else {
                            current = current.left;
                        }
                    } else if (data > current.data) {
                        if (current.right == null) {
                            current.right = new Node28(data);
                            break;
                        } else {
                            current = current.right;
                        }
                    } else { // data is already exist
                        break;
                    }
                }
            }
        }

        boolean find(int data) {
            Node28 current = root;
            while (current != null) {
                if (current.data == data) {
                    return true;
                } else if (data < current.data) {
                    current = current.left;
                } else {
                    current = current.right;
                }
            }
            return false;
        }

        void traversePreOrder(Node28 node) {
            if (node != null) {
                System.out.print(" " + node.data);
                traversePreOrder(node.left);
                traversePreOrder(node.right);
            }
        }

        void traversePostOrder(Node28 node) {
            if (node != null) {
                traversePostOrder(node.left);
                traversePostOrder(node.right);
                System.out.print(" " + node.data);
            }
        }

        void traverseInOrder(Node28 node) {
            if (node != null) {
                traverseInOrder(node.left);
                System.out.print(" " + node.data);
                traverseInOrder(node.right);
            }
        }

        Node28 getSuccessor(Node28 del) {
            Node28 successorParent = del;
            Node28 successor = del;
            Node28 current = del.right;
            while (current != null) {
                successorParent = successor;
                successor = current;
                current = current.left;
            }

            if (successor != del.right) {
                successorParent.left = successor.right;
                successor.right = del.right;
            }
            return successor;
        }

        void delete(int data) {
            if (isEmpty()) {
                System.out.println("Tree is empty");
                return;
            }

            Node28 parent = root;
            Node28 current = root;
            boolean isLeftChild = false;

            while (current.data != data) {
                parent = current;
                if (data < current.data) {
                    current = current.left;
                    isLeftChild = true;
                } else {
                    current = current.right;
                    isLeftChild = false;
                }

                if (current == null) {
                    System.out.println("Couldn't find data!");
                    return;
                }
            }

            if (current.left == null && current.right == null) {
                if (current == root) {
                    root = null;
                } else if (isLeftChild) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            } else if (current.right == null) {
                if (current == root) {
                    root = current.left;
                } else if (isLeftChild) {
                    parent.left = current.left;
                } else {
                    parent.right = current.left;
                }
            } else if (current.left == null) {
                if (current == root) {
                    root = current.right;
                } else if (isLeftChild) {
                    parent.left = current.right;
                } else {
                    parent.right = current.right;
                }
            } else {
                Node28 successor = getSuccessor(current);
                if (current == root) {
                    root = successor;
                } else if (isLeftChild) {
                    parent.left = successor;
                } else {
                    parent.right = successor;
                }
                successor.left = current.left;
            }
        }

        int countLeafNodes(Node28 node) {
            if (node == null) {
                return 0;
            }
            if (node.left == null && node.right == null) {
                // Jika node adalah leaf, kembalikan nilai 1
                return 1;
            }
            // Rekursi untuk menghitung jumlah leaf nodes pada subtree kiri dan kanan
            return countLeafNodes(node.left) + countLeafNodes(node.right);
        }
    }

    public static void main(String[] args) {
        BinaryTree28 tree = new BinaryTree28();

        // Menambahkan beberapa node ke dalam tree
        tree.add(10);
        tree.add(5);
        tree.add(20);
        tree.add(3);
        tree.add(7);
        tree.add(15);
        tree.add(25);

        // Memanggil metode countLeafNodes
        int leafCount = tree.countLeafNodes(tree.root);
        System.out.println("Jumlah leaf nodes dalam tree: " + leafCount);
    }
}
