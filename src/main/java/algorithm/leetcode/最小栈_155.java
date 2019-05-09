package algorithm.leetcode;

import java.util.Stack;

/**
 * @author Stephen Cai
 * @date 2019-03-27 22:55
 */
public class 最小栈_155 {
    private Stack<Integer> stackData = new Stack<>();
    private int min_val =  Integer.MAX_VALUE;

    public void push(Integer num) {
        if (num <= min_val) {
            stackData.push(min_val);
            min_val = num;
        }
        stackData.push(num);
    }
    public void pop(){
        //把之前的最小值压入栈中，这样现在的最小值取出后，可以把最小值设为之前的最小值。
        if (stackData.pop() == min_val) {
            min_val = stackData.pop();
        }
    }
    public int top() {
        return stackData.peek();
    }

    public Integer getMin() {
        return min_val;
    }

    public static void main(String[] args) {
        最小栈_155 minStack  = new 最小栈_155();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();

    }
}
