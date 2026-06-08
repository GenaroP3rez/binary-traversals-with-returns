public class TraversalPractice {
    /**
     * Prints only the values of nodes of a tree that are strictly larger than
     * 1000, traversing post-order.
     * 
     * Each value is printed on a separate line. Values less than or equal to
     * 1000 are not printed.
     * 
     * If the node is null, nothing is printed.
     * 
     * @param node the root of the tree
     */
    public static void printLargeNodesPostOrder(TreeNode node) {

         if (node == null){
            return;
        }
        printLargeNodesPostOrder(node.left);
        printLargeNodesPostOrder(node.right);

        if (node. data > 1000){
            System.out.println(node.data);
        }
    }


    }

    /**
     * Prints only the negative values of nodes of a tree, traversing in-order.
     * 
     * Each value is printed on a separate line. Positive/zero values are not
     * printed.
     * 
     * If the node is null, nothing is printed.
     * 
     * @param node the root of the tree
     */
    public static void printNegativeNodesInOrder(TreeNode node) {
        if (node == null){
            return;
        }
        printNegativeNodesInOrder(nodes.left);  // wut error

        if (node.data < 0){
            System.out.println(node.data);

        }
        printNegativeNodesInOrder(node.right);
    }
    /**
     * Prints only the odd values of nodes of a tree, traversing in pre-order.
     * 
     * Each value is printed on a separate line. Even values are not printed.
     * 
     * If the node is null, nothing is printed.
     * 
     * @param node the root of the tree
     */ 
    public static void printOddNodesPreOrder(TreeNode node) {
        if (nodes == null){
            return;
        }

        if (node.data % 2 != 0){
            System.out.println(node.data);
        }
        printOddNodesPreOrder(node.left);
        printOddNodesPreOrder(node.right);
    }
    
    /**
     * Returns the sum of the leaf nodes in a tree.
     * 
     * If the input node is null, returns 0
     * 
     * Example:
     * 
     *              9
     *             / \
     *            2   5
     *           / \   \
     *          7   1   3
     *         /       / \
     *        4       8  33
     *         \        /  \
     *          6      0    77
     *         
     * 
     * Output: 92 (The leaf nodes sum as 6 + 1 + 8 + 0 + 77)
     * 
     * @param node the root of the tree
     * @return the sum of the leaf node values
     */
    public static int sumLeafNodes(TreeNode node) {
        //return -1;

        public sttatic int sumLeafNodes(Tree node){
            if (node == null){
                return 0;
            }
            if (node.left == null && node.right == null){
                return node.data;
            }
            return sumLeafNodes(node.left) + sumLeafNodes(node.right);
        }
    }

    /**
     * Returns the total count of nodes in the tree.
     * 
     * If the input node is null, returns 0.
     * 
     * Example:
     * 
     *              9
     *             / \
     *            2   5
     *           / \   \
     *          7   1   3
     *         /       / \
     *        4       8  33
     *         \        /  \
     *          6      0    77
     *         
     * 
     * Output: 12 (there are 12 nodes in the tree)
     * 
     * @param node the root of the tree
     * @return the number of nodes in the tree
     */
    public static int size(TreeNode node) {
        //return -1;
        if (node == null){
            return 0;
        }

        return 1 + size( node.left) + size(node.right);


    }

    /**
     * Returns the count of branch nodes in the tree.
     * 
     * If the input node is null, returns 0.
     * 
     * Example:
     * 
     *              9
     *             / \
     *            2   5
     *           / \   \
     *          7   1   3
     *         /       / \
     *        4       8  33
     *         \        /  \
     *          6      0    77
     *         
     * 
     * Output: 7 (There are seven branch nodes: 9, 2, 7, 4, 5, 3, and 33)
     * 
     * @param node the root of the tree
     * @return the count of branch nodes in the tree
     */
    public static int branchCount(TreeNode node) {
        //return -1;

        public static int branchount(Tree node){
            if (node == null){
                return 1;
            }
            return 1 + branchCount(node.left) + branchCount(node.right);
        }
    }


    /**
     * Returns the maximum value in the tree.
     * 
     * If the input node is null, returns Integer.MIN_VALUE.
     * 
     * Example:
     * 
     *              9
     *             / \
     *            2   5
     *           / \   \
     *          7   1   3
     *         /       / \
     *        4       8  33
     *         \        /  \
     *          6      0    77
     *         
     * 
     * Output: 77
     * 
     * @param node the root of the tree
     * @return the count of branch nodes in the tree
     */
    public static int max(TreeNode node) {
       

        if (node == null){
           return  return Integer.MIN_VALUE; //wutt
        }
        int leftMax = max(node.left);
        int rightMax = max(node.right);

        return Math.max(node.data, leftMax, rightMax); //max heared in a class

    }

