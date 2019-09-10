import java.io.File;
import java.util.Scanner;

public class Confused {
   private static ArrayStack<String> stack = new ArrayStack<>();
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(new File("Confused.dat"));
        int numberOfCases = sc.nextInt();
        for (int i=0; i< numberOfCases; i++)
        {
            System.out.println(isValid(sc.nextLine()));
        }

    }
    private static boolean isValid(String s) throws Exception {
        String[] strCharArray = s.split("");
        for (String str: strCharArray) {
            if (str.equals("(") || str.equals("[")) stack.push(str);
            if (stack.isEmpty()) return false;
            if ((str.equals("]") && stack.peek().equals("["))|| (str.equals(")") && stack.peek().equals("("))) {
                stack.pop();
            }
            else if (!(str.equals("(") || str.equals("[")))
            {
                return false;
            }
        }
        return stack.isEmpty();
    }

}
