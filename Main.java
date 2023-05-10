import java.util.Scanner;
 
/**
 *The entry point of the program.
 */
public class Main {
    /**
     * Standard input scanner.
     */
    private final Scanner scanner = new Scanner(System.in);
 
    /**
     * main method of the program.
     * @param args Array with parameters of the program.
     */
    public static void main(String[] args) {
        Main instMain = new Main();
 
        Calculator calculator;
 
        CalculatorType calculatorType = instMain.readCalculator();
 
        switch (calculatorType) {
            case INTEGER:
                calculator = new IntegerCalculator();
                break;
            case DOUBLE:
                calculator = new DoubleCalculator();
                break;
            case STRING:
                calculator = new StringCalculator();
                break;
            default:
                instMain.reportFatalError("Wrong calculator type");
                return;
        }
 
        int n;
        n = instMain.readCommandsNumber();
        if (n == -1) {
            instMain.reportFatalError("Amount of commands is Not a Number");
            return;
        }
 
        for (int command = 0; command < n; command++) {
            String stringOperation = instMain.scanner.next();
            OperationType operationType = instMain.parseOperation(stringOperation);
 
            String a = instMain.scanner.next();
            String b = instMain.scanner.next();
 
            String res;
 
            switch (operationType) {
                case ADDITION:
                    res = calculator.add(a, b);
                    break;
                case SUBTRACTION:
                    res = calculator.subtract(a, b);
                    break;
                case MULTIPLICATION:
                    res = calculator.multiply(a, b);
                    break;
                case DIVISION:
                    res = calculator.divide(a, b);
                    break;
                default:
                    res = "Wrong operation type";
            }
 
            System.out.print(res + "\n");
        }
    }
 
    /**
     * This method parses a string into a calculator type.
     * @return The calculator type.
    */
    private CalculatorType readCalculator() {
        String stringCalculator = scanner.next();
        switch (stringCalculator) {
            case "INTEGER":
                return CalculatorType.INTEGER;
            case "DOUBLE":
                return CalculatorType.DOUBLE;
            case "STRING":
                return CalculatorType.STRING;
            default:
                break;
        }
 
        return CalculatorType.INCORRECT;
    }
 
    /**
     * This method reads, checks, and returns the number of commands.
     * @return The number of commands
     */
    private int readCommandsNumber() {
        String stringN = scanner.next();
 
        int n;
        try {
            n = Integer.parseInt(stringN);
        } catch (NumberFormatException e) {
            n = -1;
        }
 
        return n;
    }
 
    /**
     * This method prints the fatal error to the standard output.
     * @param err The error message to be shown
     */
    private void reportFatalError(String err) {
        System.out.print(err + "\n");
    }
 
    /**
     * This method parses a string into an operation type.
     * @param operation The operation string
     * @return The operation type
     */
    private OperationType parseOperation(String operation) {
        OperationType enumOperation;
 
        switch (operation) {
            case "+":
                enumOperation = OperationType.ADDITION;
                break;
            case "-":
                enumOperation = OperationType.SUBTRACTION;
                break;
            case "*":
                enumOperation = OperationType.MULTIPLICATION;
                break;
            case "/":
                enumOperation = OperationType.DIVISION;
                break;
            default:
                enumOperation = OperationType.INCORRECT;
        }
 
        return enumOperation;
    }
}
 
enum CalculatorType {
    /**
     * Possible calculator types.
     */
    INTEGER, DOUBLE, STRING, INCORRECT
}
 
enum OperationType {
    /**
     * Possible operation types.
     */
    ADDITION, SUBTRACTION, MULTIPLICATION, DIVISION, INCORRECT
}
 
/**
 * This abstract class performs arithmetic operations.
 * It can be inherited by IntegerCalculator, DoubleCalculator, and StringCalculator classes.
 */
abstract class Calculator {
    /**
     * This method adds two integers, doubles, or strings.
     * @param a The first operation argument
     * @param b The second operation argument
     * @return The result of the addition
     */
    public abstract String add(String a, String b);
 
    /**
     * This method subtracts two integers or doubles.
     * @param a The first operation argument
     * @param b The second operation argument
     * @return The result of the subtraction
     */
    public abstract String subtract(String a, String b);
 
    /**
     * This method multiplies two integers, doubles, or strings.
     * @param a The first operation argument
     * @param b The second operation argument
     * @return The result of the multiplication
     */
    public abstract String multiply(String a, String b);
 
    /**
     * This method divides two integers or doubles.
     * @param a The first operation argument
     * @param b The second operation argument
     * @return The result of the division
     */
    public abstract String divide(String a, String b);
}
 
/**
 * This class performs arithmetic operations on integers.
 */
class IntegerCalculator extends Calculator {
    public String add(String a, String b) {
        try {
            Integer intA = Integer.parseInt(a);
            Integer intB = Integer.parseInt(b);
 
            Integer res = intA + intB;
 
            return res.toString();
        } catch (NumberFormatException e) {
            return "Wrong argument type";
        }
    }
 
    public String subtract(String a, String b) {
        try {
            Integer intA = Integer.parseInt(a);
            Integer intB = Integer.parseInt(b);
 
            Integer res = intA - intB;
 
            return res.toString();
        } catch (NumberFormatException e) {
            return "Wrong argument type";
        }
    }
 
    public String multiply(String a, String b) {
        try {
            Integer intA = Integer.parseInt(a);
            Integer intB = Integer.parseInt(b);
 
            Integer res = intA * intB;
 
            return res.toString();
        } catch (NumberFormatException e) {
            return "Wrong argument type";
        }
    }
 
    public String divide(String a, String b) {
        try {
            Integer intA = Integer.parseInt(a);
            Integer intB = Integer.parseInt(b);
 
            if (intB == 0) {
                return "Division by zero";
            }
 
            Integer res = intA / intB;
 
            return res.toString();
        } catch (NumberFormatException e) {
            return "Wrong argument type";
        }
    }
}
 
/**
 * This class performs arithmetic operations on doubles.
 */
class DoubleCalculator extends Calculator {
    public String add(String a, String b) {
        try {
            Double doubleA = Double.parseDouble(a);
            Double doubleB = Double.parseDouble(b);
 
            Double res = doubleA + doubleB;
 
            return res.toString();
        } catch (NumberFormatException e) {
            return "Wrong argument type";
        }
    }
 
    public String subtract(String a, String b) {
        try {
            Double doubleA = Double.parseDouble(a);
            Double doubleB = Double.parseDouble(b);
 
            Double res = doubleA - doubleB;
 
            return res.toString();
        } catch (NumberFormatException e) {
            return "Wrong argument type";
        }
    }
 
    public String multiply(String a, String b) {
        try {
            Double doubleA = Double.parseDouble(a);
            Double doubleB = Double.parseDouble(b);
 
            Double res = doubleA * doubleB;
 
            return res.toString();
        } catch (NumberFormatException e) {
            return "Wrong argument type";
        }
    }
 
    public String divide(String a, String b) {
        try {
            Double doubleA = Double.parseDouble(a);
            Double doubleB = Double.parseDouble(b);
 
            if (doubleB == 0.0) {
                return "Division by zero";
            }
 
            Double res = doubleA / doubleB;
 
            return res.toString();
        } catch (NumberFormatException e) {
            return "Wrong argument type";
        }
    }
}
 
/**
 * This class performs arithmetic operations on strings.
 */
class StringCalculator extends Calculator {
    public String add(String a, String b) {
        return (a + b);
    }
 
    public String subtract(String a, String b) {
        return "Unsupported operation for strings";
    }
 
    public String multiply(String a, String b) {
        try {
            Integer intB = Integer.parseInt(b);
            if (intB <= 0) {
                return "Wrong argument type";
            }
 
            String res = "";
            for (int i = 0; i < intB; i++) {
                res += a;
            }
 
            return res;
        } catch (NumberFormatException e) {
            return "Wrong argument type";
        }
    }
 
    public String divide(String a, String b) {
        return "Unsupported operation for strings";
    }
}
