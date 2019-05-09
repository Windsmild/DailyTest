package algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Stephen Cai
 * @date 2019-03-13 22:39
 */
public class 有效的括号_20 {
    public boolean isValid(String s) {
        Map<Character,Character> map = new HashMap<>();
        map.put(new Character("]".charAt(0)),new Character("[".charAt(0)));
        map.put(new Character("}".charAt(0)),new Character("{".charAt(0)));
        map.put(new Character(")".charAt(0)),new Character("(".charAt(0)));
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.size() == 0) {
                stack.push(s.charAt(i));
            } else if (stack.peek().equals(map.get(s.charAt(i)))) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.size() == 0;
    }

    public static void main(String[] args) {
        new 有效的括号_20().isValid("([)]");
    }
}
