package bitdemo1;

public class TestforSB {
	public static void main(String[] args) {
		StringBuffer str = new StringBuffer("hello");
		System.out.println(str);
		str.append("world");
		System.out.println(str);
		str.append(" really?");
		System.out.println(str);
		System.out.println(str.reverse());
		System.out.println(str.delete(2, 5));
		System.out.println(str.insert(2, "myname"));
	}
}
