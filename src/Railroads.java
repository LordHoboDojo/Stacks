import java.util.*;

public class Railroads {
    ArrayDeque<Integer> orderedNumbers;
    public  Railroads(int n)
    {
        this.orderedNumbers = createArrayDeque(n);
    }
    public static void main (String[] args)
    {
        Railroads r = new Railroads(6);
        String perm = "5 4 1 2 3";
        int[] arr =  Arrays.stream(perm.split(" ")).mapToInt(Integer::parseInt).toArray();
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println(r.isValid(stack));
    }

    public boolean isValid(Stack<Integer> permutation)
    {
        if (permutation.size() ==0) return true;
        if (Objects.equals(permutation.peek(), orderedNumbers.getFirst()))
        {
            permutation.pop();
            orderedNumbers.removeFirst();
            return isValid(permutation);
        }
        if (Objects.equals(permutation.peek(), orderedNumbers.getLast()))
        {

            while ( (!permutation.isEmpty() && !orderedNumbers.isEmpty()) &&permutation.peek() == orderedNumbers.getLast())
            {
                permutation.pop();
                orderedNumbers.removeLast();
            }
            return permutation.isEmpty();
        }
        return false;
    }
    public ArrayDeque<Integer> createArrayDeque(int n)
    {
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>() {
        };
        for (int i = 1; i <= n; i++) {
            stack.add(i);
        }
        return stack;
    }
}
