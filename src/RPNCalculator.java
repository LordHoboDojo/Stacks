import java.io.File;
import java.util.Scanner;

public class RPNCalculator {
    String fileName;
    File file;
    ArrayStack stack;

    public RPNCalculator(String fileName) {
        this.stack = new ArrayStack<Double>();
        this.fileName = fileName;
        this.file = new File(fileName);
    }
    public void fileRead() throws Exception {
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            System.out.println(doOperation(sc.nextLine()));
        }
    }
    private String doOperation(String expression) throws Exception {
        String[] expressionArray = expression.split(" ");
      // System.out.println(Arrays.toString(expressionArray));
        for (int i=0; i< expressionArray.length;i++)
        {
            if(isNumeric(expressionArray[i]))
            {
                stack.push(Double.parseDouble(expressionArray[i]));
            }
            else
            {
                operate(expressionArray[i]);
            }
        }
        String returnValue=  stack.size()==1 ? stack.pop() + "" : "Invalid";
        stack.clear();
        return returnValue;

    }
    @SuppressWarnings("uncehcked")
    private void operate(String operator) throws Exception {
//        System.out.println(operator);
        Double one  = (Double) stack.pop();
        Double two  = (Double) stack.pop();


        switch (operator) {
            case "+":
                stack.push(one + two);
              // System.out.println("Plus: " +stack.peek());
                break;
            case "-":
                stack.push(two - one);
                //System.out.println( "Minus: " +stack.peek());
                break;
            case "/":
                stack.push(two / one);
             // System.out.println( "divide: " +stack.peek());
                break;
            case "*":
                stack.push((one * two));
               // System.out.println( "Multiply: " +stack.peek());
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + operator);
        }



    }

    public  boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}

