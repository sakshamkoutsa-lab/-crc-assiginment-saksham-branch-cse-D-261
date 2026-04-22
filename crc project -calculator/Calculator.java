public class Calculator {

    public double calculate(String exp) {

        exp = exp.replace(" ", "");  
        exp = solveMulDiv(exp); 
        return solveAddSub(exp);
    }

    private String solveMulDiv(String exp) {
        while (exp.contains("*") || exp.contains("/")) {
            int index = -1;  
            for (int i = 0; i < exp.length(); i++) {
                if (exp.charAt(i) == '*' || exp.charAt(i) == '/') {
                    index = i;
                    break;
                }
            }
            int left = index - 1;
            while (left >= 0 && (Character.isDigit(exp.charAt(left)) || exp.charAt(left)=='.')) {
                left--;
            }
            left++;
            int right = index + 1;
            while (right < exp.length() && (Character.isDigit(exp.charAt(right)) || exp.charAt(right)=='.')) {
                right++;
            }
            double num1 = Double.parseDouble(exp.substring(left, index));
            double num2 = Double.parseDouble(exp.substring(index + 1, right));
            double result = 0;
            if (exp.charAt(index) == '*') {
                result = num1 * num2;
            } else {
                result = num1 / num2;
            } 
            exp = exp.substring(0, left) + result + exp.substring(right);
        }
        return exp;
    }
    private double solveAddSub(String exp) {
        double result = 0;
        String num = "";
        char op = '+';
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (Character.isDigit(ch) || ch == '.') {
                num = num + ch;
            } else {
                result = apply(result, Double.parseDouble(num), op);
                op = ch;
                num = "";
            }
        }
        if (!num.equals("")) {
            result = apply(result, Double.parseDouble(num), op);
        }
        return result;
    }
    private double apply(double a, double b, char op) {

        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        }

        return a;  
    }
}