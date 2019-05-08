package search2;
/**
 * 
 * @author 豆光耀
 *
 * @param <Key>
 * @param <Value>
 */

public class BST1<Key extends Comparable<Key>,Value> {
	private Node root;
	private class Node{
		//键
		private Key key;
		//值
		private Value val;
		//指向子树的链接
		private Node left, right;
		//以该结点为根的子树的节点总数
		private int N;
		public Node(Key key, Value val, int N) {
			this.key = key;
			this.val = val;
			this.N = N ;
		}
	}
		//私有方法返回以该节点为子树的节点总数
		private int size(Node x) {
			if(x == null) {
				return 0;
			}else {
				return x.N;
			}
		}
		public int size() {
			return size(root);
		}
		//在以x为根节点的子树中查找并返回key所对应的值
		//找不到返回空
		private Value get(Node x, Key key) {
			if(x == null ) {
				return null;
			}
			int cmp = key.compareTo(x.key);
			if(cmp < 0) {
				return get(x.left, key);
			}else if(cmp > 0) {
				return get(x.right, key);
			}else {
				return x.val;
			}
		}
		public Value get(Key key) {
			return get(root, key);
		}
		//如果key存在与以x为结点的子树中则更新它的值
		//否则将以key和val为键值对的新节点插入到该子树中；
		private Node put(Node x, Key key, Value val) {
			if( x == null) {
				return new Node(key, val, 1);
			}
			int cmp = key.compareTo(x.key);
			if(cmp < 0) {
				x.left = put(x.left, key, val);
			}else if(cmp > 0) {
				x.right = put(x.right, key,val);
			}else {
				x.val = val;
			}
			x.N = size(x.left) + size(x.right) + 1;
			return x;
		}
		//查找key，找到后就更新它的值，否则为它创建一个新的结点
		public void put(Key key, Value val) {
			root = put(root, key, val);
		}
		//二叉查找树中max()、 min()、floor()、ceiling()方法的实现
		private Node min(Node x) {
			if(x.left == null) {
				return x;
			}
			return min(x.left);
		}
		public Key min() {
			return min(root).key;
		}
		private Node floor(Node x, Key key) {
			if(x == null) {
				return null;
			}
			int cmp = key.compareTo(x.key);
			if(cmp == 0) {
				return x;
			}
			if(cmp < 0) {
				return floor(x.left,key);
			}
			Node t = floor(x.right,key);
			if(t != null) {
				return t;
			}else {
				return x;
			}
		}
		public Key floor(Key key) {
			Node x = floor(root, key);
			if(x == null) {
				return null;
			}
			return x.key;
		}
		//二叉查找树中select()和rank()方法的实现
		
		//返回排名为k的节点
		private Node select(Node x, int k) {
			if(x == null) {
				return null;
			}
			int t = size(x.left);
			if(t > k) {
				return select(x.left, k);
			}else if(t < k) {
				return select(x.right, k-t-1);
			}else {
				return x;
			}
		}
		public Key select(int k) {
			return select(root,k).key;
		}
		//返回以x为根节点的子树中小于x.key的键的数量
		private int rank(Key key, Node x) {
			if(x == null) {
				return 0;
			}
			int cmp = key.compareTo(x.key);
			if(cmp < 0) {
				return rank(key, x.left);
			}else if(cmp > 0) {
				return 1 + size(x.left) + rank(key, x.right);
			}else {
				return size(x.left);
			}
		}
		
		
		//二叉查找树中delete()方法的实现
		
		private Node deleteMin(Node x) {
			if(x.left == null) {
				return x.right;
			}
			x.left = deleteMin(x.left);
			x.N = size(x.left) + size(x.right) + 1;
			return x;
		}
		public void deleteMin() {
			root = deleteMin(root);
		}
		
		private Node delete(Node x, Key key) {
			if(x == null) {
				return null;
			}
			int cmp = key.compareTo(x.key);
			if(cmp < 0) {
				x.left = delete(x.left, key);
			}else if(cmp > 0) {
				x.right = delete(x.right, key);
			}else {
				if(x.right == null) {
					return x.left;
				}
				if(x.left == null) {
					return x.right;
				}
				Node t = x;
				x = min(t.right);
				x.right = deleteMin(t.right);
				x.left = t.left;
			}
			x.N = size(x.left) + size(x.right) + 1;
			return x;
		}
		
}
