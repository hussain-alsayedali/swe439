

import java.util.ArrayList; 
public class CalcApp{
public class BasicCalculator {
    protected double result;

  
    private int J;

    public BasicCalculator() {
        this.result = 0;
        this.J = 100; // Unused assignment
    }

    public void add(double value) {
        result += value;
    }

    public void subtract(double value) {
        result -= value;
    }


    private void nothing() {
        System.out.println("hmmm");
    }

    public double getResult() {
        return result;
    }

    
    public void clrZ123() {
        result = 0; 
    }
}


class AdvancedCalculator extends BasicCalculator {

    public void multiply(double value) {
        result *= value;
    }

    // Exception handling issue: Not specific enough or inefficient (code smell)
    public void divide(double value) {
        try {
            result /= value;
        } catch (Exception e) { // Catching generic Exception (bad practice)
            System.out.println("Error");
        }
    }

    // Overly complex method (increased Cyclomatic Complexity)
    public double complexOperation(double a, double b) {
        if (a > 0) {
            if (b > 0) {
                return a * b;
            } else {
                return a / (b == 0 ? 1 : b); // Ternary operator adds complexity
            }
        } else if (a < 0) {
            return -a * b;
        } else {
            return a + b;
        }
    }
}


class OperationLogger {

    public void logOperation(String operation, double result) {
        try {
            System.out.println("Operation: " + operation + ", Result: " + result);
        } catch (Exception e) {
            System.out.println("Logging failed!"); 
        }
    }
}

// Main class with cloned code, high coupling, and unused imports


public class MainCalculatorApp {
    public static void main(String[] args) {
        AdvancedCalculator advCalc = new AdvancedCalculator();
        OperationLogger logger = new OperationLogger();

        // Cloned code (this block is repeated unnecessarily)
        advCalc.add(10);
        logger.logOperation("Add 10", advCalc.getResult());

        advCalc.subtract(5);
        logger.logOperation("Subtract 5", advCalc.getResult());

        advCalc.multiply(3);
        logger.logOperation("Multiply by 3", advCalc.getResult());

        advCalc.divide(2);
        logger.logOperation("Divide by 2", advCalc.getResult());

        // Reset (code smell: unclear method name)
        advCalc.clrZ123();

        // Inefficient code example: adding all these operations manually (cloned code)
        advCalc.add(20);
        logger.logOperation("Add 20 after reset", advCalc.getResult());

        advCalc.subtract(10);
        logger.logOperation("Subtract 10", advCalc.getResult());

        advCalc.multiply(2);
        logger.logOperation("Multiply by 2", advCalc.getResult());

        advCalc.divide(5);
        logger.logOperation("Divide by 5", advCalc.getResult());
    }
}
}