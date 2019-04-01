package InBit;

/**
 * Auther:vincent-Dou
 */
public class TestSequence {
    public static void main(String[] agrs){
        Sequence se = new Sequence();
        for(int i = 0; i < 21; i++){
            se.add(i,i);
        }
        se.display();
        System.out.println("\n======================");
        se.add(5,"hello");
        System.out.println(se.search("hello"));
        se.display();
        System.out.println(se.contains(5));
        System.out.println(se.getPos(7));
        System.out.println(se.size());

        //        se.display();
    }
}
