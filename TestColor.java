package testInBit;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.concurrent.BlockingDeque;

/**
 * Auther:vincent-Dou
 * Date: 2019/4/11
 * Time: 18:40
 * description：枚举的实现
 */
public class TestColor {
    public static void main(String[] agrs){
        System.out.println(Color.getColorInstance(1));
    }
}
class  Color{
    private static final  Color RED = new Color("RED");
    private static final  Color GREEN = new Color("GREEN");
    private static final  Color BLUE =  new Color("BLUE");

    private String title;
    public Color(String title){
        this.title = title;
    }

    public static Color getColorInstance(int flag){
        switch (flag){
            case 1:
                return RED;
            case 2:
                return GREEN;
            case  3:
                return BLUE;
                default:
                    return null;
        }
    }
}
