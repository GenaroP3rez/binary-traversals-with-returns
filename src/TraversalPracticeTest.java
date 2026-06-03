import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TraversalPracticeTest {

     /**
     * Splits the captured output into lines, handling different newline conventions.
     */
    private List<String> getLines(String output) {
        String trimmed = output.trim();
        if (trimmed.isEmpty()) {
            return Collections.emptyList();
        }
        return Arrays.asList(trimmed.split("\\R"));
    }

    // Tests for printLargeNodesPostOrder

    @Test
    public void testPrintLargeNodesPostOrder_ComplexTree() {
        TreeNode node = new TreeNode(-3,
            new TreeNode(4,
                new TreeNode(1001),
                new TreeNode(9999,
                    new TreeNode(8888, null, new TreeNode(-2)),
                    new TreeNode(7777)
                )
            ),
            new TreeNode(5000,
                new TreeNode(-9, new TreeNode(-5), null),
                new TreeNode(-3000)
            )
        );
        String output = captureOutput(() -> TraversalPractice.printLargeNodesPostOrder(node));
        List<String> lines = getLines(output);
        List<String> expected = Arrays.asList("1001", "8888", "7777", "9999", "5000");
        assertEquals(expected, lines);
    }

    @Test
    public void testPrintLargeNodesPostOrder_SingleNodeMatch() {
        TreeNode node = new TreeNode(2000);
        String output = captureOutput(() -> TraversalPractice.printLargeNodesPostOrder(node));
        List<String> lines = getLines(output);
        assertEquals(Collections.singletonList("2000"), lines);
    }

    @Test
    public void testPrintLargeNodesPostOrder_SingleNodeNoMatch() {
        TreeNode node = new TreeNode(1000);
        String output = captureOutput(() -> TraversalPractice.printLargeNodesPostOrder(node));
        List<String> lines = getLines(output);
        assertTrue(lines.isEmpty());
    }

    @Test
    public void testPrintLargeNodesPostOrder_NullNode() {
        String output = captureOutput(() -> TraversalPractice.printLargeNodesPostOrder(null));
        List<String> lines = getLines(output);
        assertTrue(lines.isEmpty());
    }

    @Test
    public void testPrintLargeNodesPostOrder_BalancedTree() {
        TreeNode node = new TreeNode(2000,
            new TreeNode(1500),
            new TreeNode(2500)
        );
        String output = captureOutput(() -> TraversalPractice.printLargeNodesPostOrder(node));
        List<String> lines = getLines(output);
        List<String> expected = Arrays.asList("1500", "2500", "2000");
        assertEquals(expected, lines);
    }

    // Tests for printNegativeNodesInOrder

    @Test
    public void testPrintNegativeNodesInOrder_ComplexTree() {
        TreeNode node = new TreeNode(-3,
            new TreeNode(4,
                new TreeNode(1001),
                new TreeNode(9999,
                    new TreeNode(8888, null, new TreeNode(-2)),
                    new TreeNode(7777)
                )
            ),
            new TreeNode(5000,
                new TreeNode(-9, new TreeNode(-5), null),
                new TreeNode(-3000)
            )
        );
        String output = captureOutput(() -> TraversalPractice.printNegativeNodesInOrder(node));
        List<String> lines = getLines(output);
        List<String> expected = Arrays.asList("-2", "-3", "-5", "-9", "-3000");
        assertEquals(expected, lines);
    }

    @Test
    public void testPrintNegativeNodesInOrder_SingleNodeMatch() {
        TreeNode node = new TreeNode(-5);
        String output = captureOutput(() -> TraversalPractice.printNegativeNodesInOrder(node));
        List<String> lines = getLines(output);
        assertEquals(Collections.singletonList("-5"), lines);
    }

    @Test
    public void testPrintNegativeNodesInOrder_SingleNodeNoMatch() {
        TreeNode node = new TreeNode(0);
        String output = captureOutput(() -> TraversalPractice.printNegativeNodesInOrder(node));
        List<String> lines = getLines(output);
        assertTrue(lines.isEmpty());
    }

    @Test
    public void testPrintNegativeNodesInOrder_NullNode() {
        String output = captureOutput(() -> TraversalPractice.printNegativeNodesInOrder(null));
        List<String> lines = getLines(output);
        assertTrue(lines.isEmpty());
    }

    @Test
    public void testPrintNegativeNodesInOrder_BalancedTree() {
        TreeNode node = new TreeNode(-1,
            new TreeNode(-3),
            new TreeNode(-2)
        );
        String output = captureOutput(() -> TraversalPractice.printNegativeNodesInOrder(node));
        List<String> lines = getLines(output);
        List<String> expected = Arrays.asList("-3", "-1", "-2");
        assertEquals(expected, lines);
    }

    // Tests for printOddNodesPreOrder

    @Test
    public void testPrintOddNodesPreOrder_ComplexTree() {
        TreeNode node = new TreeNode(-3,
            new TreeNode(4,
                new TreeNode(1001),
                new TreeNode(9999,
                    new TreeNode(8888, null, new TreeNode(-2)),
                    new TreeNode(7777)
                )
            ),
            new TreeNode(5000,
                new TreeNode(-9, new TreeNode(-5), null),
                new TreeNode(-3000)
            )
        );
        String output = captureOutput(() -> TraversalPractice.printOddNodesPreOrder(node));
        List<String> lines = getLines(output);
        List<String> expected = Arrays.asList("-3", "1001", "9999", "7777", "-9", "-5");
        assertEquals(expected, lines);
    }

    @Test
    public void testPrintOddNodesPreOrder_SingleNodeMatch() {
        TreeNode node = new TreeNode(3);
        String output = captureOutput(() -> TraversalPractice.printOddNodesPreOrder(node));
        List<String> lines = getLines(output);
        assertEquals(Collections.singletonList("3"), lines);
    }

    @Test
    public void testPrintOddNodesPreOrder_SingleNodeNoMatch() {
        TreeNode node = new TreeNode(2);
        String output = captureOutput(() -> TraversalPractice.printOddNodesPreOrder(node));
        List<String> lines = getLines(output);
        assertTrue(lines.isEmpty());
    }

    @Test
    public void testPrintOddNodesPreOrder_NullNode() {
        String output = captureOutput(() -> TraversalPractice.printOddNodesPreOrder(null));
        List<String> lines = getLines(output);
        assertTrue(lines.isEmpty());
    }

    @Test
    public void testPrintOddNodesPreOrder_BalancedTree() {
        TreeNode node = new TreeNode(2,
            new TreeNode(3),
            new TreeNode(4)
        );
        String output = captureOutput(() -> TraversalPractice.printOddNodesPreOrder(node));
        List<String> lines = getLines(output);
        assertEquals(Collections.singletonList("3"), lines);
    }

    /**
     * Tree:
     *          9
     *         / \
     *        2   5
     *       / \   \
     *      7   1   3
     *     /       / \
     *    4       8  33
     *     \      /  \
     *      6    0    77
     */
    @Test
    public void testSampleTree_sumLeafNodes() {
        TreeNode root = new TreeNode(9,
            new TreeNode(2,
                new TreeNode(7,
                    new TreeNode(4, null, new TreeNode(6)),
                    null
                ),
                new TreeNode(1)
            ),
            new TreeNode(5,
                null,
                new TreeNode(3,
                    new TreeNode(8),
                    new TreeNode(33, new TreeNode(0), new TreeNode(77))
                )
            )
        );
        assertEquals(92, TraversalPractice.sumLeafNodes(root));
    }

    /**
     * Tree:
     *     42
     */
    @Test
    public void testSingleNode_sumLeafNodes() {
        TreeNode root = new TreeNode(42);
        assertEquals(42, TraversalPractice.sumLeafNodes(root));
    }

    /**
     * Tree:
     *     1
     *    /
     *   2
     */
    @Test
    public void testLeftOnlyChild_sumLeafNodes() {
        TreeNode root = new TreeNode(1, new TreeNode(2), null);
        assertEquals(2, TraversalPractice.sumLeafNodes(root));
    }

    /**
     * Tree:
     *   1
     *    \
     *     3
     */
    @Test
    public void testRightOnlyChild_sumLeafNodes() {
        TreeNode root = new TreeNode(1, null, new TreeNode(3));
        assertEquals(3, TraversalPractice.sumLeafNodes(root));
    }

    /**
     * Tree: null (empty tree)
     */
    @Test
    public void testNullInput_sumLeafNodes() {
        assertEquals(0, TraversalPractice.sumLeafNodes(null));
    }

    /**
     * Tree:
     *   1
     *    \
     *     2
     *      \
     *       3
     */
    @Test
    public void testRightChain_sumLeafNodes() {
        TreeNode root = new TreeNode(1, null,
            new TreeNode(2, null,
                new TreeNode(3)
            )
        );
        assertEquals(3, TraversalPractice.sumLeafNodes(root));
    }

    /**
     * Tree:
     *       10
     *      /  \
     *     5    15
     *         /  \
     *        12   20
     */
    @Test
    public void testMultipleLeavesMixed_sumLeafNodes() {
        TreeNode root = new TreeNode(10,
            new TreeNode(5),
            new TreeNode(15,
                new TreeNode(12),
                new TreeNode(20)
            )
        );
        assertEquals(5 + 12 + 20, TraversalPractice.sumLeafNodes(root));
    }

    /**
     * Tree:
     *          9
     *         / \
     *        2   5
     *       / \   \
     *      7   1   3
     *     /       / \
     *    4       8  33
     *     \      /  \
     *      6    0    77
     */
    @Test
    public void testSampleTree_size() {
        TreeNode root = new TreeNode(9,
            new TreeNode(2,
                new TreeNode(7,
                    new TreeNode(4, null, new TreeNode(6)),
                    null
                ),
                new TreeNode(1)
            ),
            new TreeNode(5,
                null,
                new TreeNode(3,
                    new TreeNode(8),
                    new TreeNode(33, new TreeNode(0), new TreeNode(77))
                )
            )
        );
        assertEquals(12, TraversalPractice.size(root));
    }

    /**
     * Tree:
     *     42
     */
    @Test
    public void testSingleNode_size() {
        TreeNode root = new TreeNode(42);
        assertEquals(1, TraversalPractice.size(root));
    }

    /**
     * Tree:
     *     1
     *    /
     *   2
     */
    @Test
    public void testLeftOnlyChild_size() {
        TreeNode root = new TreeNode(1, new TreeNode(2), null);
        assertEquals(2, TraversalPractice.size(root));
    }

    /**
     * Tree:
     *   1
     *    \
     *     3
     */
    @Test
    public void testRightOnlyChild_size() {
        TreeNode root = new TreeNode(1, null, new TreeNode(3));
        assertEquals(2, TraversalPractice.size(root));
    }

    /**
     * Tree: null (empty tree)
     */
    @Test
    public void testNullInput_size() {
        assertEquals(0, TraversalPractice.size(null));
    }

    /**
     * Tree:
     *   1
     *    \
     *     2
     *      \
     *       3
     */
    @Test
    public void testRightChain_size() {
        TreeNode root = new TreeNode(1, null,
            new TreeNode(2, null,
                new TreeNode(3)
            )
        );
        assertEquals(3, TraversalPractice.size(root));
    }

    /**
     * Tree:
     *       10
     *      /  \
     *     5    15
     *         /  \
     *        12   20
     */
    @Test
    public void testMultipleLeavesMixed_size() {
        TreeNode root = new TreeNode(10,
            new TreeNode(5),
            new TreeNode(15,
                new TreeNode(12),
                new TreeNode(20)
            )
        );
        assertEquals(5, TraversalPractice.size(root));
    }

    /**
     * Tree:
     *          9
     *         / \
     *        2   5
     *       / \   \
     *      7   1   3
     *     /       / \
     *    4       8  33
     *     \      /  \
     *      6    0    77
     */
    @Test
    public void testSampleTree_branchCount() {
        TreeNode root = new TreeNode(9,
            new TreeNode(2,
                new TreeNode(7,
                    new TreeNode(4, null, new TreeNode(6)),
                    null
                ),
                new TreeNode(1)
            ),
            new TreeNode(5,
                null,
                new TreeNode(3,
                    new TreeNode(8),
                    new TreeNode(33, new TreeNode(0), new TreeNode(77))
                )
            )
        );
        assertEquals(7, TraversalPractice.branchCount(root));
    }

    /**
     * Tree:
     *     42
     */
    @Test
    public void testSingleNode_branchCount() {
        TreeNode root = new TreeNode(42);
        assertEquals(0, TraversalPractice.branchCount(root));
    }

    /**
     * Tree:
     *     1
     *    /
     *   2
     */
    @Test
    public void testLeftOnlyChild_branchCount() {
        TreeNode root = new TreeNode(1, new TreeNode(2), null);
        assertEquals(1, TraversalPractice.branchCount(root));
    }

    /**
     * Tree:
     *   1
     *    \
     *     3
     */
    @Test
    public void testRightOnlyChild_branchCount() {
        TreeNode root = new TreeNode(1, null, new TreeNode(3));
        assertEquals(1, TraversalPractice.branchCount(root));
    }

    /**
     * Tree: null (empty tree)
     */
    @Test
    public void testNullInput_branchCount() {
        assertEquals(0, TraversalPractice.branchCount(null));
    }

    /**
     * Tree:
     *   1
     *    \
     *     2
     *      \
     *       3
     */
    @Test
    public void testRightChain_branchCount() {
        TreeNode root = new TreeNode(1, null,
            new TreeNode(2, null,
                new TreeNode(3)
            )
        );
        assertEquals(2, TraversalPractice.branchCount(root));
    }

    /**
     * Tree:
     *       10
     *      /  \
     *     5    15
     *         /  \
     *        12   20
     */
    @Test
    public void testMultipleLeavesMixed_branchCount() {
        TreeNode root = new TreeNode(10,
            new TreeNode(5),
            new TreeNode(15,
                new TreeNode(12),
                new TreeNode(20)
            )
        );
        assertEquals(2, TraversalPractice.branchCount(root));
    }

    /**
     * Tree:
     *          9
     *         / \
     *        2   5
     *       / \   \
     *      7   1   3
     *     /       / \
     *    4       8  33
     *     \      /  \
     *      6    0    77
     */
    @Test
    public void testSampleTree_max() {
        TreeNode root = new TreeNode(9,
            new TreeNode(2,
                new TreeNode(7,
                    new TreeNode(4, null, new TreeNode(6)),
                    null
                ),
                new TreeNode(1)
            ),
            new TreeNode(5,
                null,
                new TreeNode(3,
                    new TreeNode(8),
                    new TreeNode(33, new TreeNode(0), new TreeNode(77))
                )
            )
        );
        assertEquals(77, TraversalPractice.max(root));
    }

    /**
     * Tree:
     *     42
     */
    @Test
    public void testSingleNode_max() {
        TreeNode root = new TreeNode(42);
        assertEquals(42, TraversalPractice.max(root));
    }

    /**
     * Tree:
     *     1
     *    /
     *   2
     */
    @Test
    public void testLeftOnlyChild_max() {
        TreeNode root = new TreeNode(1, new TreeNode(2), null);
        assertEquals(2, TraversalPractice.max(root));
    }

    /**
     * Tree:
     *   1
     *    \
     *     3
     */
    @Test
    public void testRightOnlyChild_max() {
        TreeNode root = new TreeNode(1, null, new TreeNode(3));
        assertEquals(3, TraversalPractice.max(root));
    }

    /**
     * Tree: null (empty tree)
     */
    @Test
    public void testNullInput_max() {
        assertEquals(Integer.MIN_VALUE, TraversalPractice.max(null));
    }

    /**
     * Tree:
     *   1
     *    \
     *     2
     *      \
     *       3
     */
    @Test
    public void testRightChain_max() {
        TreeNode root = new TreeNode(1, null,
            new TreeNode(2, null,
                new TreeNode(3)
            )
        );
        assertEquals(3, TraversalPractice.max(root));
    }

    /**
     * Tree:
     *       10
     *      /  \
     *     5    15
     *         /  \
     *        12   20
     */
    @Test
    public void testMultipleLeavesMixed_max() {
        TreeNode root = new TreeNode(10,
            new TreeNode(5),
            new TreeNode(15,
                new TreeNode(12),
                new TreeNode(20)
            )
        );
        assertEquals(20, TraversalPractice.max(root));
    }


    /**
     * Tree:
     *       -19
     *       /  \
     *     -51  -15
     *         /  \
     *       -3   -20
     *         \
     *         -8
     */
    @Test
    public void testNegative_max() {
        TreeNode root = new TreeNode(-19,
            new TreeNode(-51),
            new TreeNode(-15,
                new TreeNode(-3, null, new TreeNode(-8)),
                new TreeNode(-20)
            )
        );
        assertEquals(-3, TraversalPractice.max(root));
    }

        /** The below are utility classes that help with testing. You do not need to modify them, but you can look with interest! */
    /**
     * Simple PrintStream that writes output to both the console and an internal buffer.
     */
    private static class TeePrintStream extends PrintStream {
        private final PrintStream second;

        public TeePrintStream(PrintStream main, PrintStream second) {
            super(main);
            this.second = second;
        }

        @Override
        public void write(byte[] buf, int off, int len) {
            super.write(buf, off, len);
            second.write(buf, off, len);
        }

        @Override
        public void write(int b) {
            super.write(b);
            second.write(b);
        }
    }

    /**
     * Captures the output of a Runnable while still printing to the console.
     * @param runnable the code that prints to System.out
     * @return the captured output as a String
     */
    private String captureOutput(Runnable runnable) {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream second = new PrintStream(baos, true);
        TeePrintStream tee = new TeePrintStream(originalOut, second);
        System.setOut(tee);
        try {
            runnable.run();
        } finally {
            System.out.flush();
            System.setOut(originalOut);
        }
        return baos.toString();
    }
}
