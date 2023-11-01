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

class MaximumBinaryTreeSolution{
    public TreeNode solve(int[] nums,int low,int high){
        if(low>high){
            return null;
        }
        int j=-1;
        int max=Integer.MIN_VALUE;

        for(int i=low;i<=high;i++){
            if(max<nums[i]){
                j=i;
                max=nums[i];
            }
        }

        TreeNode root=new TreeNode(max);
        root.left=solve(nums,low,j-1);
        root.right=solve(nums,j+1,high);
        
        return root;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int low=0;
        int high=nums.length-1;
        return solve(nums,low,high);
    }
}
