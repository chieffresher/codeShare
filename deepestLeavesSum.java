
import java.util.*;


class DeepestLeavesSum {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //works but slower
    public int deepestLeavesSum(TreeNode root) {
        int sum = 0;
        Stack<TreeNode> currentLevel = new Stack<TreeNode>();
        Stack<TreeNode> tempLevel;
        TreeNode node = null;
        currentLevel.push(root);
        while(!currentLevel.empty())
        {
            sum = 0;
            tempLevel = new Stack<>();
            while(!currentLevel.empty())
            {
                node = currentLevel.pop();
                if(node!=null)
                    sum+=node.val;
                if(node.left!=null)
                    tempLevel.push(node.left);
                if(node.right!=null)
                    tempLevel.push(node.right);
            }
            if(tempLevel.empty())
                return  sum;
            currentLevel = tempLevel;
        }
        return sum;
    }

    public  int findHeight(TreeNode node)
    {
        if(node==null)
            return 0;
        else
            return Math.max(findHeight(node.left),findHeight(node.right))+1;
    }

    //using dfs to find height
    public int deepestLeavesSum2(TreeNode root) {
        int sum = 0,height=0,curHeight=0;
        height = findHeight(root);
        Stack<TreeNode> currentLevel = new Stack<TreeNode>();
        Stack<TreeNode> tempLevel;
        TreeNode node = null;
        currentLevel.push(root);
        while(!currentLevel.empty())
        {
            curHeight++;
            tempLevel = new Stack<>();
            while(!currentLevel.empty())
            {
                node = currentLevel.pop();
                if(node.left!=null)
                    tempLevel.push(node.left);
                if(node.right!=null)
                    tempLevel.push(node.right);
                //perform sum
                if(height==curHeight)
                    sum+=node.val;
            }
            if(tempLevel.empty())
                return  sum;
            currentLevel = tempLevel;
        }
        return sum;
    }



    public static void main(String[] args ){

    }
}