package gui;

import java.awt.*;
import javax.swing.*;
import com.mycompany.GUI.Calculator;

public class GUI extends JFrame {

    JTextField display;
    Calculator calc;
    number num;

    double currentValue = 0;
    String currentOperation = "";
    boolean startNewNumber = true;

    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;
    JButton b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,b21,b22,b23,b24;
    JButton a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13;

    public GUI(){
        calc = new Calculator();
        num = new number();

        this.setTitle("Gui Calculator");
        this.setSize(800,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(30,30,30));

        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial",Font.BOLD, 60));
        display.setBorder(BorderFactory.createLineBorder(new Color(40,40,40),2));
        display.setBackground(new Color(40,40,40));
        display.setForeground(Color.ORANGE);
        display.setHorizontalAlignment(JTextField.RIGHT);

        //---------------- Panels ----------------
        JPanel function = new JPanel(new GridLayout(5,4,5,5));
        function.setBackground(new Color(40,40,40));
        JButton toggleFunction = new JButton("Show Functions");
        toggleFunction.setFont(new Font("Arial",Font.BOLD,20));
        toggleFunction.setBackground(new Color(100,100,100));
        toggleFunction.setForeground(Color.ORANGE);
        toggleFunction.addActionListener(e -> {
            boolean isVisible = function.isVisible();
            function.setVisible(!isVisible);
            toggleFunction.setText(isVisible ? "Show Functions" : "Hide Functions");
            this.revalidate();
            this.repaint();
        });
        function.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        function.setVisible(false);

        JPanel numberPanel = new JPanel(new GridLayout(4,3,10,10));
        numberPanel.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        numberPanel.setBackground(new Color(40,40,40));

        JPanel operator = new JPanel(new GridLayout(7,2,10,10));
        operator.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        operator.setBackground(new Color(40,40,40));

        //---------------- Buttons ----------------
        b1 = new JButton("9"); b2 = new JButton("8"); b3 = new JButton("7");
        b4 = new JButton("6"); b5 = new JButton("5"); b6 = new JButton("4");
        b7 = new JButton("3"); b8 = new JButton("2"); b9 = new JButton("1");
        b10 = new JButton("0");

        b11 = new JButton("cos"); b12 = new JButton("sin"); b13 = new JButton("tan");
        b14 = new JButton("log"); b15 = new JButton("factorial"); b16 = new JButton("prime");
        b17 = new JButton("palindrom"); b18 = new JButton("min"); b19 = new JButton("max");
        b20 = new JButton("sum"); b21 = new JButton("avg"); b22 = new JButton("even");
        b23 = new JButton("odd"); b24 = new JButton("perfect");

        a1 = new JButton("."); a2 = new JButton("="); a3 = new JButton("\u00D7");
        a4 = new JButton("\u00F7"); a5 = new JButton("-"); a6 = new JButton("+");
        a7 = new JButton("^"); a8 = new JButton("("); a9 = new JButton(")");
        a10 = new JButton("C"); a11 = new JButton("%"); a12 = new JButton("\u03C0");
        a13 = new JButton("\u221A");

        //--------- Set button styles ----------
        JButton[] allButtons = {b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,
                                b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,b21,b22,b23,b24};
        for(JButton btn : allButtons){
            btn.setFont(new Font("Arial",Font.BOLD,25));
            btn.setBackground(new Color(100,100,100));
            btn.setForeground(Color.ORANGE);
        }
        JButton[] ops = {a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13};
        for(JButton btn : ops){
            btn.setFont(new Font("Arial",Font.BOLD,20));
            btn.setBackground(new Color(255,165,0));
            btn.setForeground(Color.BLACK);
        }

        //----------- Add buttons to panels -----------
        numberPanel.add(b1); numberPanel.add(b2); numberPanel.add(b3);
        numberPanel.add(b4); numberPanel.add(b5); numberPanel.add(b6);
        numberPanel.add(b7); numberPanel.add(b8); numberPanel.add(b9);
        numberPanel.add(b10);

        function.add(b11); function.add(b12); function.add(b13); function.add(b14);
        function.add(b15); function.add(b16); function.add(b17); function.add(b18);
        function.add(b19); function.add(b20); function.add(b21); function.add(b22);
        function.add(b23); function.add(b24);

        operator.add(a11); operator.add(a10); operator.add(a8); operator.add(a9);
        operator.add(a13); operator.add(a12); operator.add(a7); operator.add(a4);
        operator.add(a3); operator.add(a5); operator.add(a6); operator.add(a1);
        operator.add(a2);

        //---------------- Actions Numbers ----------------
        JButton[] nums = {b1,b2,b3,b4,b5,b6,b7,b8,b9,b10};
        String[] numValues = {"9","8","7","6","5","4","3","2","1","0"};
        for(int i=0;i<nums.length;i++){
            int idx = i;
            nums[i].addActionListener(e -> {
                if(startNewNumber) display.setText("");
                display.setText(display.getText() + numValues[idx]);
                startNewNumber = false;
            });
        }

        //---------------- Actions Operators ----------------
        a1.addActionListener(e -> display.setText(display.getText() + "."));
        a3.addActionListener(e -> setOperation("*"));
        a4.addActionListener(e -> setOperation("/"));
        a5.addActionListener(e -> setOperation("-"));
        a6.addActionListener(e -> setOperation("+"));
        a7.addActionListener(e -> setOperation("^"));
        a11.addActionListener(e -> setOperation("%"));
        a10.addActionListener(e -> clearDisplay());
        a2.addActionListener(e -> calculate());
        a8.addActionListener(e ->{if (startNewNumber)display.setText("");
        display.setText(display.getText()+"(");
        startNewNumber=false;
            });
        a9.addActionListener(e ->{if (startNewNumber)display.setText("");
        display.setText(display.getText()+")");
        startNewNumber=false;
            });
        // عند الضغط على زر π
a12.addActionListener(e -> {
    display.setText(display.getText() + Math.PI);
    startNewNumber = false;
});

// عند الضغط على زر √
a13.addActionListener(e -> {
    try {
        double val = Double.parseDouble(display.getText());
        display.setText(String.valueOf(Math.sqrt(val)));
        startNewNumber = true;
    } catch(Exception ex){
        display.setText("Error");
    }
});

        

        //---------------- Functions ----------------
        b11.addActionListener(e -> applyFunction("cos"));
        b12.addActionListener(e -> applyFunction("sin"));
        b13.addActionListener(e -> applyFunction("tan"));
        b14.addActionListener(e -> applyFunction("log"));
        b15.addActionListener(e -> applyFunction("factorial"));
        b16.addActionListener(e -> applyFunction("prime"));
        b17.addActionListener(e -> applyFunction("palindrom"));
        b18.addActionListener(e -> applyFunction("min"));
        b19.addActionListener(e -> applyFunction("max"));
        b20.addActionListener(e -> applyFunction("sum"));
        b21.addActionListener(e -> applyFunction("avg"));
        b22.addActionListener(e -> applyFunction("even"));
        b23.addActionListener(e -> applyFunction("odd"));
        b24.addActionListener(e -> applyFunction("perfect"));

        //---------------- Layout ----------------
        JPanel top = new JPanel(new BorderLayout(10,10));
        top.setBackground(new Color(40,40,40));
        top.add(display, BorderLayout.NORTH);
        top.add(toggleFunction,BorderLayout.SOUTH);
        top.add(function, BorderLayout.CENTER);

        JPanel center = new JPanel(new BorderLayout(2,2));
        center.setBackground(new Color(40,40,40));
        center.add(numberPanel, BorderLayout.CENTER);
        center.add(operator, BorderLayout.EAST);

        this.setLayout(new BorderLayout(10,10));
        this.add(top , BorderLayout.NORTH);
        this.add(center , BorderLayout.CENTER);

        this.setVisible(true);
    }

    //---------------- Helper Methods ----------------
    private void setOperation(String op){
    // إذا الشاشة فاضية، ما تعمل شيء
    if(display.getText().isEmpty()) return;

    // خزّن الرقم الأول
    try {
        currentValue = Double.parseDouble(display.getText());
    } catch(Exception e){
        currentValue =0;
    }

    // خزّن العملية
    currentOperation = op;

    // أظهر العملية على الشاشة جنب الرقم
    display.setText(display.getText() + op);

    // خلي الإدخال الجديد للرقم الثاني
    startNewNumber = false;
}
    private void calculate() {
    try {
        String text = display.getText();

        // 1- استبدال الباي في النص كامل
        text = text.replace("π", String.valueOf(Math.PI));
        text = text.replace("×", "*");
        text = text.replace("÷", "/");

        double result = 0;

        // 2- الجذر التربيعي
        if(text.startsWith("√")) {
            String num = text.substring(1); // كل شيء بعد √
            // لو الجذر داخل أقواس
            if(num.startsWith("(") && num.endsWith(")")) {
                num = num.substring(1, num.length()-1);
            }
            result = Math.sqrt(Double.parseDouble(num));

        // 3- الأس
        } else if(text.contains("^")) {
            String[] parts = text.split("\\^");
            result = Math.pow(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]));

        // 4- الأقواس البسيطة
        } else if(text.contains("(") && text.contains(")")) {
            int start = text.indexOf("(");
            int end = text.indexOf(")");
            double valInside = Double.parseDouble(text.substring(start+1, end));

            String left = text.substring(0, start);
            if(left.endsWith("+")) result = Double.parseDouble(left.substring(0,left.length()-1)) + valInside;
            else if(left.endsWith("-")) result = Double.parseDouble(left.substring(0,left.length()-1)) - valInside;
            else if(left.endsWith("*")) result = Double.parseDouble(left.substring(0,left.length()-1)) * valInside;
            else if(left.endsWith("/")) result = Double.parseDouble(left.substring(0,left.length()-1)) / valInside;
            else if(left.endsWith("%")) result = Double.parseDouble(left.substring(0,left.length()-1)) % valInside;

        } else {
            // 5- العمليات البسيطة بدون أقواس
            if(text.contains("+")) {
                String[] parts = text.split("\\+");
                result = Double.parseDouble(parts[0]) + Double.parseDouble(parts[1]);
            } else if(text.contains("-")) {
                String[] parts = text.split("-");
                result = Double.parseDouble(parts[0]) - Double.parseDouble(parts[1]);
            } else if(text.contains("*")) {
                String[] parts = text.split("\\*");
                result = Double.parseDouble(parts[0]) * Double.parseDouble(parts[1]);
            } else if(text.contains("/")) {
                String[] parts = text.split("/");
                result = Double.parseDouble(parts[0]) / Double.parseDouble(parts[1]);
            } else if(text.contains("%")) {
                String[] parts = text.split("%");
                result = Double.parseDouble(parts[0]) % Double.parseDouble(parts[1]);
            } else {
                // مجرد رقم
                result = Double.parseDouble(text);
            }
        }

        display.setText(String.valueOf(result));
        startNewNumber = true;

    } catch(Exception e) {
        display.setText("Error");
    }
}

   

    

  

   
    private double simpleEval(String expr) {
    while (expr.contains("(")) {
        int open = expr.lastIndexOf("(");
        int close = expr.indexOf(")", open);
        String inside = expr.substring(open + 1, close);
        double val = simpleEval(inside);
        expr = expr.substring(0, open) + val + expr.substring(close + 1);
    }

    return evalNoParentheses(expr);
}

private double evalNoParentheses(String expr) {
    expr = expr.replace(" ", ""); // إزالة الفراغات

    // دعم العمليات حسب الأولوية: ^ ثم * / % ثم + -
    // 1. الأس (^)
    while (expr.contains("^")) {
        int index = expr.indexOf("^");
        double left = getLeftNumber(expr, index);
        double right = getRightNumber(expr, index);
        double res = Math.pow(left, right);
        expr = replaceExpression(expr, index, left, right, res);
    }

    // 2. الضرب والقسمة والنسبة (%)
    while (expr.contains("*") || expr.contains("/") || expr.contains("%")) {
        int indexMul = expr.indexOf("*") != -1 ? expr.indexOf("*") : Integer.MAX_VALUE;
        int indexDiv = expr.indexOf("/") != -1 ? expr.indexOf("/") : Integer.MAX_VALUE;
        int indexMod = expr.indexOf("%") != -1 ? expr.indexOf("%") : Integer.MAX_VALUE;

        int index = Math.min(indexMul, Math.min(indexDiv, indexMod));
        char op = expr.charAt(index);

        double left = getLeftNumber(expr, index);
        double right = getRightNumber(expr, index);
        double res = 0;

        switch (op) {
            case '*': res = left * right; break;
            case '/': res = left / right; break;
            case '%': res = left % right; break;
        }

        expr = replaceExpression(expr, index, left, right, res);
    }

    // 3. الجمع والطرح
    while (expr.contains("+") || (expr.lastIndexOf("-") > 0)) { // تجنب السالب في البداية
        int indexPlus = expr.indexOf("+") != -1 ? expr.indexOf("+") : Integer.MAX_VALUE;
        int indexMinus = expr.indexOf("-", 1) != -1 ? expr.indexOf("-", 1) : Integer.MAX_VALUE;

        if (indexPlus == Integer.MAX_VALUE && indexMinus == Integer.MAX_VALUE) break;

        int index = Math.min(indexPlus, indexMinus);
        char op = expr.charAt(index);

        double left = getLeftNumber(expr, index);
        double right = getRightNumber(expr, index);
        double res = (op == '+') ? left + right : left - right;

        expr = replaceExpression(expr, index, left, right, res);
    }

    return Double.parseDouble(expr);
}

// دوال مساعدة
private double getLeftNumber(String expr, int index) {
    int i = index - 1;
    while (i >= 0 && (Character.isDigit(expr.charAt(i)) || expr.charAt(i) == '.')) i--;
    return Double.parseDouble(expr.substring(i + 1, index));
}

private double getRightNumber(String expr, int index) {
    int i = index + 1;
    while (i < expr.length() && (Character.isDigit(expr.charAt(i)) || expr.charAt(i) == '.')) i++;
    return Double.parseDouble(expr.substring(index + 1, i));
}

private String replaceExpression(String expr, int opIndex, double left, double right, double result) {
    int start = opIndex - String.valueOf(left).length();
    int end = opIndex + 1 + String.valueOf(right).length();
    return expr.substring(0, start) + result + expr.substring(end);
}





 


    private void clearDisplay(){
        display.setText("");
        currentOperation = "";
        currentValue = 0;
        startNewNumber = true;
    }

    private void applyFunction(String func){
        double val = 0;
        try { val = Double.parseDouble(display.getText()); } catch(Exception e){ val=0; }
        int intVal = (int) val;

        switch(func){
            case "cos": display.setText(String.valueOf(calc.cos(val))); break;
            case "sin": display.setText(String.valueOf(calc.sin(val))); break;
            case "tan": display.setText(String.valueOf(calc.tan(val))); break;
            case "log": display.setText(String.valueOf(calc.log(val))); break;
            case "factorial": display.setText(String.valueOf(num.factorial(intVal))); break;
            case "prime": display.setText(String.valueOf(num.prime(intVal))); break;
            case "palindrom": display.setText(String.valueOf(num.palindrome(intVal))); break;
            case "min": display.setText(String.valueOf(num.minNumber(intVal))); break;
            case "max": display.setText(String.valueOf(num.maxNumber(intVal))); break;
            case "sum": display.setText(String.valueOf(num.sumOfDigits(intVal))); break;
            case "avg": display.setText(String.valueOf(num.averageOfDigits(intVal))); break;
            case "even": display.setText(String.valueOf(num.isEven(intVal))); break;
            case "odd": display.setText(String.valueOf(num.isOdd(intVal))); break;
            case "perfect": display.setText(String.valueOf(num.isPerfectNumber(intVal))); break;
        }
        startNewNumber = true;
    }

    public static void main(String[] args){
        new GUI();
    }
}
