import java.util.ArrayList;
import java.util.Random;

public class offerSeaTree {

    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val = 0;

        public TreeNode(int val){
            this.val = val;
        }
    }

    static int index = 0;

    public static void main(String[] args){
        ArrayList<Integer> e = new ArrayList<>();
        int[] pre = {15,11,6,5,7,20,18,16,19};
        int[] in = {5,6,7,11,15,16,18,19,20};
        int nums = 7;
        int k = 4;
        TreeNode root = reConstructBinaryTree(pre,in);
        System.out.println(f1(root,k).val);
    }

    public static TreeNode f1(TreeNode root, int k){
        if(root!=null){
            TreeNode node = f1(root.left,k);
            if(node != null)
                return node;
            index++;
            if(index == k)
                return root;
            node = f1(root.right,k);
            if(node != null)
                return node;
        }
        return null;
    }

//    public static TreeNode construct(TreeNode root,int k,int num){
//        int rdi = (int)(Math.random() * (num + 1));
//        if(k!=0) {
//            root = new TreeNode(rdi);
//            root.left = construct(root.left,k-2,rdi);
//            root.right = construct(root.right,k-2,rdi+2);
//        }
//        return root;
//    }

    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root=reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }
    //前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
    private static TreeNode reConstructBinaryTree(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn) {

        if(startPre>endPre||startIn>endIn)
            return null;
        TreeNode root=new TreeNode(pre[startPre]);

        for(int i=startIn;i<=endIn;i++)
            if(in[i]==pre[startPre]){
                root.left=reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                root.right=reConstructBinaryTree(pre,i-startIn+startPre+1,endPre,in,i+1,endIn);
                break;
            }

        return root;
    }
}
