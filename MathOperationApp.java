package javapractice;

@FunctionalInterface
interface IMathFunction {
    int calculate(int a, int b);
    static void PrintResult(int a, int b, String function, IMathFunction fobj) {
        System.out.println("Result of" +" "+function+" "+ "is" +" "+fobj.calculate(a, b));
    }
}
public class MathOperationApp {

    public static void main(String[] args) {
        IMathFunction add = Integer :: sum;
        IMathFunction subtract = (a , b) -> a - b;
        IMathFunction multiply = (a , b) -> a * b;
        IMathFunction divide = (a , b) -> a / b;

        System.out.println("Addition is: " + add.calculate(6, 3));
        System.out.println("Subtraction is: " + subtract.calculate(6,3));
        System.out.println("Multiplication is: " + multiply.calculate(6,3));
        System.out.println("Division is: " + divide.calculate(6,3));

        IMathFunction.PrintResult(6, 3, "Addition", add);
        IMathFunction.PrintResult(6,3,"Subtraction", subtract);
        IMathFunction.PrintResult(6, 3, "Multiplication", multiply);
        IMathFunction.PrintResult(6,3,"Division", divide);
        }
}
