public class Confused {
   static ArrayStack<String> stack = new ArrayStack<>();
    public static void main(String[] args) throws Exception {

        String str = "[([([]())])]";
        System.out.println(isValid(str));

    }
    public static boolean isValid(String s) throws Exception {
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
