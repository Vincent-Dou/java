package search2;


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
}