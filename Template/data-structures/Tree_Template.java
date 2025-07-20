import java.io.*;
import java.util.*;

class Tree_Template {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    // 이진 트리 노드 클래스
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    
    // 이진 검색 트리 클래스
    static class BinarySearchTree {
        TreeNode root;
        
        BinarySearchTree() {
            this.root = null;
        }
        
        // 삽입
        void insert(int val) {
            root = insertRec(root, val);
        }
        
        TreeNode insertRec(TreeNode node, int val) {
            if (node == null) {
                return new TreeNode(val);
            }
            
            if (val < node.val) {
                node.left = insertRec(node.left, val);
            } else if (val > node.val) {
                node.right = insertRec(node.right, val);
            }
            
            return node;
        }
        
        // 검색
        boolean search(int val) {
            return searchRec(root, val);
        }
        
        boolean searchRec(TreeNode node, int val) {
            if (node == null) {
                return false;
            }
            
            if (val == node.val) {
                return true;
            } else if (val < node.val) {
                return searchRec(node.left, val);
            } else {
                return searchRec(node.right, val);
            }
        }
        
        // 삭제
        void delete(int val) {
            root = deleteRec(root, val);
        }
        
        TreeNode deleteRec(TreeNode node, int val) {
            if (node == null) {
                return null;
            }
            
            if (val < node.val) {
                node.left = deleteRec(node.left, val);
            } else if (val > node.val) {
                node.right = deleteRec(node.right, val);
            } else {
                // 삭제할 노드 발견
                if (node.left == null) {
                    return node.right;
                } else if (node.right == null) {
                    return node.left;
                }
                
                // 두 자식이 모두 있는 경우
                node.val = minValue(node.right);
                node.right = deleteRec(node.right, node.val);
            }
            
            return node;
        }
        
        int minValue(TreeNode node) {
            int minVal = node.val;
            while (node.left != null) {
                minVal = node.left.val;
                node = node.left;
            }
            return minVal;
        }
        
        // 전위 순회 (Preorder)
        void preorderTraversal() {
            System.out.print("전위 순회: ");
            preorderRec(root);
            System.out.println();
        }
        
        void preorderRec(TreeNode node) {
            if (node != null) {
                System.out.print(node.val + " ");
                preorderRec(node.left);
                preorderRec(node.right);
            }
        }
        
        // 중위 순회 (Inorder)
        void inorderTraversal() {
            System.out.print("중위 순회: ");
            inorderRec(root);
            System.out.println();
        }
        
        void inorderRec(TreeNode node) {
            if (node != null) {
                inorderRec(node.left);
                System.out.print(node.val + " ");
                inorderRec(node.right);
            }
        }
        
        // 후위 순회 (Postorder)
        void postorderTraversal() {
            System.out.print("후위 순회: ");
            postorderRec(root);
            System.out.println();
        }
        
        void postorderRec(TreeNode node) {
            if (node != null) {
                postorderRec(node.left);
                postorderRec(node.right);
                System.out.print(node.val + " ");
            }
        }
        
        // 레벨 순회 (BFS)
        void levelOrderTraversal() {
            System.out.print("레벨 순회: ");
            if (root == null) {
                System.out.println("비어있음");
                return;
            }
            
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                System.out.print(node.val + " ");
                
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            System.out.println();
        }
        
        // 트리 높이
        int height() {
            return heightRec(root);
        }
        
        int heightRec(TreeNode node) {
            if (node == null) {
                return 0;
            }
            
            int leftHeight = heightRec(node.left);
            int rightHeight = heightRec(node.right);
            
            return Math.max(leftHeight, rightHeight) + 1;
        }
        
        // 노드 개수
        int countNodes() {
            return countNodesRec(root);
        }
        
        int countNodesRec(TreeNode node) {
            if (node == null) {
                return 0;
            }
            
            return 1 + countNodesRec(node.left) + countNodesRec(node.right);
        }
    }
    
    public static void main(String[] args) throws IOException {
        // 이진 검색 트리 예시
        BinarySearchTree bst = new BinarySearchTree();
        
        // 삽입
        int[] values = {50, 30, 70, 20, 40, 60, 80};
        System.out.println("삽입할 값들: " + Arrays.toString(values));
        
        for (int val : values) {
            bst.insert(val);
        }
        
        // 순회 방법들
        bst.preorderTraversal();
        bst.inorderTraversal();
        bst.postorderTraversal();
        bst.levelOrderTraversal();
        
        // 검색
        System.out.println("40 검색: " + bst.search(40));
        System.out.println("100 검색: " + bst.search(100));
        
        // 트리 정보
        System.out.println("트리 높이: " + bst.height());
        System.out.println("노드 개수: " + bst.countNodes());
        
        // 삭제
        System.out.println("\n30 삭제 후:");
        bst.delete(30);
        bst.inorderTraversal();
        
        // 트리 레벨별 출력 예시
        System.out.println("\n트리 레벨별 출력:");
        printTreeLevels(bst.root);
    }
    
    // 트리를 레벨별로 출력하는 함수
    static void printTreeLevels(TreeNode root) {
        if (root == null) {
            System.out.println("트리가 비어있습니다.");
            return;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            System.out.print("Level " + level + ": ");
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                System.out.print(node.val + " ");
                
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            System.out.println();
            level++;
        }
    }
}