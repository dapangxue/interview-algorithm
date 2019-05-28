package interview.zuo.chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author WuXue
 * @date 2019/5/28 0028
 */
public class MorrisInOrder {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int value;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    /**
     * 经典的Morris序遍历二叉树
     * @param head
     */
    public static void morrisOrder(TreeNode head) {
        if (head == null) {
            return;
        }

        /*
        Morris的遍历顺序：
        （1）首先找到当前节点的左节点
        如果左节点不为空，找到左子树的最右节点mostRight
        <1>如果左子树的最右节点为空，那么mostRight.right = currentNode， currentNode = currentNode.left
        <2>如果左子树的最右节点不为空，即指向当前currentNode，那么mostRight.right = null, currentNode = currentNode.right
        (2)如果左节点为空，那么currentNode = currentNode.right
         */
        TreeNode currentNode = head;
        TreeNode mostRight = null;
        while (currentNode != null) {
            // 1、找到当前节点的左节点
            mostRight = currentNode.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != currentNode) {
                    mostRight = mostRight.right;
                }
                // 如果左子树的最右节点为空
                if (mostRight.right == null) {
                    mostRight.right = currentNode;
                    currentNode = currentNode.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }

            currentNode = currentNode.right;
        }
    }

    /**
     * morris
     * @param head
     * @return
     */
    public static List<Integer> morrisInOrder(TreeNode head) {
        List<Integer> list = new ArrayList<>();

        /*
        mirror 中序遍历的思路：
        1、其实相当于根节点的左子树的最右边的结点指向了当前的根节点，这样节省了空间（因为用了二叉树的null）
        设置一个当前节点cur1，它的左子节点为cur2，找到cur2的最右节点就是cur1左子树的最右节点，然后这个最右节点指向根节点/当前节点
         */
        if (head != null) {
            // 当前节点为头结点
            TreeNode cur1 = head;
            TreeNode cur2 = null;
            while (cur1 != null) {
                cur2 = cur1.left;
                if (cur2 != null) {
                    // 从cur2开始一直向右遍历找到最右节点，同时判断是不是指向了当前的根节点
                    while (cur2.right != null && cur2.right != cur1) {
                        cur2 = cur2.right;
                    }
                    // 如果找到了最右节点
                    if (cur2.right == null) {
                        cur2.right = cur1;
                        cur1 = cur1.left;
                        continue;
                    } else {
                        // 最右节点已经指向了当前的根节点
                        cur2.right = null;
                    }
                }
                list.add(cur1.value);
                cur1 = cur1.right;
            }
        }
        return list;
    }

    /**
     * morris遍历的先序遍历
     * @param head
     * @return
     */
    public static List<Integer> mirrorPreOrder1(TreeNode head) {
        List<Integer> list = new ArrayList<>();
        if (head == null) {
            return list;
        }

        TreeNode currentNode = head;
        TreeNode mostRight = null;
        while (currentNode != null) {
            // 1、找到当前节点的左节点
            mostRight = currentNode.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != currentNode) {
                    mostRight = mostRight.right;
                }
                // 如果左子树的最右节点为空,第一次访问到当前节点
                if (mostRight.right == null) {
                    mostRight.right = currentNode;
                    list.add(currentNode.value);
                    currentNode = currentNode.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            list.add(currentNode.value);
            currentNode = currentNode.right;
        }
        return list;
    }

    public static List<Integer> mirrorPreOrder2(TreeNode head) {
        List<Integer> result = new ArrayList<>();

        if (head != null) {
            TreeNode cur1 = head;
            TreeNode cur2 = null;
            TreeNode cur3 = null;
            while (cur1 != null) {
                result.add(cur1.value);
                cur2 = cur1.left;

                if (cur2 != null) {
                    while (cur2.right != null && cur2.right != cur1.right) {
                        cur2 = cur2.right;
                    }

                    if (cur2.right == null) {
                        cur2.right = cur1.right;
                        cur1 = cur1.left;
                    } else {
                        cur2.right = null;
                    }
                } else {
                    cur1 = cur1.right;
                }
            }
        }
        return result;
    }

    public static List<Integer> inorder(TreeNode head) {
        List<Integer> result = new ArrayList<>();
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    result.add(head.value);
                    head = head.right;
                }
            }
        }
        return result;
    }

    public static TreeNode createBinaryTree(int[] a) {
        List<TreeNode> list = new ArrayList<>(a.length);
        for (int i = 0, length = a.length; i < length; i++) {
            list.add(new TreeNode(a[i]));
        }

        int lastPartentTreeNodeIndex = a.length / 2 - 1;
        for (int i = 0; i < lastPartentTreeNodeIndex; i++) {
            list.get(i).left = list.get(2 * i + 1);
            list.get(i).right = list.get(2 * i + 2);
        }
        list.get(lastPartentTreeNodeIndex).left = list.get(2 * lastPartentTreeNodeIndex + 1);
        if ((list.size() & 1) == 1) {
            list.get(lastPartentTreeNodeIndex).right = list.get(2 * lastPartentTreeNodeIndex + 2);
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        TreeNode head = createBinaryTree(a);
        List<Integer> result = morrisInOrder(head);
        System.out.println(result);
        System.out.println(mirrorPreOrder2(head));
    }
}
