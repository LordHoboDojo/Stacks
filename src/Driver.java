public class Driver {

    public static void main(String[] args) throws Exception {
//        ArrayStack stack = new ArrayStack();
//        stack.push(69);
//        stack.push(12);
//        stack.push(66);
//        stack.push(82);
//        stack.push(68);
//        stack.push(15);
//        stack.push(62);
//        stack.push(68);
//        stack.push(15);
//        stack.push(62);
//        System.out.println(stack.getTop());
//        System.out.println(stack.toString());
//        System.out.println(stack.isFull());
//        System.out.println(stack.peek());
//        System.out.println(stack.pop());
//        System.out.println(stack.isEmpty());
        RPNCalculator test = new RPNCalculator("expressions.txt");
        test.fileRead();

    }
}
