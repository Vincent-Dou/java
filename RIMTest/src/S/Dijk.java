package S;
/**
 * 求数学计算字符串表达式的数学表达式结果；
 * 用DijkStra的双栈算数表达式求值算法p80
 */
import java.util.Stack;

public class Dijk {
    public static void main(String[] args) {
        System.out.println(DijkStra("(-6)+1"));
//        (1+((2+3)*(4*5)))
//        (-6)+1
    }

    public static double DijkStra (String str) {

        //创建操作符栈
        Stack<Character> ops = new Stack<>();
        //创建操作数栈
        Stack<Double> nums = new Stack<>();
        for (int i = 0 ; i < str.length(); i++) {
            char s = str.charAt(i);
            switch (s) {
                //无视左括号
                case '(':
                    break;
                // + 、 - 、 * 、／、sqrt 这些操作符都压入栈
                case '+':
                    ops.push(s);
                    break;
                case '-':
                    ops.push(s);
                    break;
                case '*':
                    ops.push(s);
                    break;
                case '/':
                    ops.push(s);
                    break;
                case ')':
                    //遇到右括号时，根据从操作符栈中取出操作符，并从操作数栈中取出相应都操作数进行计算，并将计算结果压入操作数栈
                    char op = ops.pop();
                    Double num = nums.pop();
                    switch (op) {
                        case '+':
                            num = num + nums.pop();
                            break;
                        case '-':
                            num = num - nums.pop();
                            break;
                        case '*':
                            num = num * nums.pop();
                            break;
                        case '/':
                            num = num / nums.pop();
                            break;
                    }
                    nums.push(num);
                    break;
                default:
                    nums.push(Double.parseDouble(Character.toString(s)));//将数字压入操作数栈；
                    break;
            }
        }
        return nums.pop();
    }
}
