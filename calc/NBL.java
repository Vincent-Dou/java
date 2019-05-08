package calc;

import java.util.Stack;

/**
 * Auther:vincent-Dou
 * Date: 2019/4/21
 * Time: 23:06
 * Description：算术表达式求值(用后缀表达式来求值)
 */
public class NBL {

    public static void main(String[] agrs) {
        String a = "652";
        String s = "(3*2+5 -1) / 2";
        System.out.println(s);
        System.out.println(suffixEvaluation(infixToSuffix(s)));
    }

    //将中中缀表达式 ====》 后缀表达式
    //遇见加号要将栈元素全部弹出或者到 （ 停止在放加号
    //遇见 ） 要将栈弹出到 遇见（
    public static String[] infixToSuffix(String s) {
        Stack<Character> sta = new Stack<>();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); ) {
            //当为数字时
            if ((String.valueOf(s.charAt(i))).matches("[0-9]")) {
                while (i < s.length() && (String.valueOf(s.charAt(i))).matches("[0-9]")) {
                    str.append(s.charAt(i));
                    i++;
                }
                str.append(',');

                //遇见 + 号时；
            } else if (s.charAt(i) == '+') {
                while (!sta.empty()) {
                    if (sta.peek() == '(') {
                        break;
                    }
                    str.append(sta.pop().toString());
                    str.append(',');
                }
                sta.push(s.charAt(i));
                i++;
            } else if (s.charAt(i) == '-') {
                sta.push(s.charAt(i));
                i++;
            } else if (s.charAt(i) == '*') {
                sta.push(s.charAt(i));
                i++;
            } else if (s.charAt(i) == '/') {
                sta.push(s.charAt(i));
                i++;
            } else if (s.charAt(i) == '(') {
                sta.push(s.charAt(i));
                i++;
            } else if (s.charAt(i) == ')') {
                while (sta.peek() != '(') {
                    str.append(sta.pop());
                    str.append(',');
                }
                sta.pop();
                i++;
            } else if (s.charAt(i) == ' ') {
                i++;
            }
        }
        while (!sta.empty()) {
            str.append(sta.pop());
            str.append(',');
        }
        String str1 = str.toString().trim();
        String[] str2 = str1.split(",");
//        for(String i : str2){
//            System.out.print(i + " ");
//        }
//        System.out.println();
        return str2;
    }

    //根据后缀表达式求值
    public static int suffixEvaluation(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                s.push(s.pop() + s.pop());
            } else if (tokens[i].equals("-")) {
                int second = Integer.valueOf(s.pop());
                int first = Integer.valueOf(s.pop());
                s.push(first - second);
            } else if (tokens[i].equals("*")) {
                s.push(s.pop() * s.pop());
            } else if (tokens[i].equals("/")) {
                int second = Integer.valueOf(s.pop());
                int first = Integer.valueOf(s.pop());
                s.push(first / second);
            } else {
                s.push(Integer.valueOf(tokens[i]));
            }
        }
        return Integer.valueOf(s.pop());
    }
}
