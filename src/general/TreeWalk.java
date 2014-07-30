/**
 * @author HariBabu.T
 *
 *
 */
package general;


public class TreeWalk {

	static class Tree{
		public final Tree left;
		public final Tree right;
		public final int value;
		
		public Tree(Tree left, int value, Tree right){
			this.left = left;
			this.right = right;
			this.value = value;
		}
		
		public final String toString(){
			String leftStr = left == null ? "^" : left.toString();
			String rightStr = right == null ? "^" : right.toString();
			
			return "(" + leftStr + "-" + value + "-" + rightStr + ")";
		}
	}
	
	public static void main(String[] args){
		Tree root = new Tree(new Tree(new Tree(null, 3, null), 2, new Tree(
				new Tree(null, 5, null), 4, null)), 1, new Tree(new Tree(null,
				7, null), 6, new Tree(null, 8, null)));
		System.out.println("Tree Walk: "+ root.toString());
	}
}