package testInBit;

/**
 * Auther:vincent-Dou
 * Date: 2019/4/11
 * Time: 18:49
 * description：枚举
 */
public class TestColor2 {

    public static void main(String[] agrs){
        Color2 blue = Color2.BLUE;
//        Color2[] Color2s = Color2.values();
//        for(Color2 cl : Color2s){
//            System.out.println(cl);
//        }
        System.out.println(Color2.class.getClass());
    }
}

/**
 * 枚举：
 * 1. 枚举时特殊的类，使用enum关键字修饰
 * 2. 枚举中定义常量，类型是枚举类型，枚举常量，通过枚举类.常量名 访问；
 * 3. 枚举类不能通过new实例化对象，
 * 4.枚举提供了有参数的构造常方法，枚举常量定义时需要制定参数值
 * 5. 任何地方使用同名的枚举常量时，他们是同一个对象；
 * 6. 通过枚举类的values()方法获取所有的枚举常量；
 * 7. 枚举常量（对象）
 *      name() 获取常量名
 *      ordinal() 获取的时常量定义的顺序下标（0）开始，开发中不需要依赖该值，
 * 8. 通过枚举类的valueOf()静态方法，参数传入枚举常量的名称，获取枚举常量（对象） 如果不存在，抛出异常
 * 9.枚举类继承自java.lang.Enum抽象类，因此不能再继承其他类
 * 10. 枚举类可以实现接口。
 * 11. switch 支持枚举类型。
 */

enum Color2{
    RED("红色"), GREEN("绿色"), BLUE("蓝色");
    private String title;
    Color2(String title){
        this.title = title;
    }

    @Override
    public String toString() {
        return "Color2{" +
                "title='" + title + '\'' +
                '}';
    }
}
