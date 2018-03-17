package CodingInterviewsBook;

import java.util.Stack;

/**
 * Created by manishharpalani on 06/04/17.
 */
public class MinMaxStack {

    Stack<Integer> values;
    Stack<Integer> min;
    Stack<Integer> max;

    public MinMaxStack() {
        values = new Stack<>();
        min = new Stack<>();
        max = new Stack<>();
    }

    public void push(Integer value) {
        values.push(value);

        if (min.empty() || value < min.peek())
            min.push(value);

        if (max.empty() || value > max.peek())
            max.push(value);
    }

    public Integer pop() {
        if (values.empty())
            throw new RuntimeException("Empty Stack");

        int value = values.pop();

        if (value == min.peek() && value != values.peek())
            min.pop();

        if (value == max.peek() && value != values.peek())
            max.pop();

        return value;
    }

    public Integer getMin() {
        if (min.empty())
            throw new RuntimeException("Empty Stack - no Min");

        return min.peek();
    }

    public Integer getMax() {
        if (max.empty())
            throw new RuntimeException("Empty Stack - no Max");

        return max.peek();
    }
}
