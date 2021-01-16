import java.util.Stack;

public class StackProblems {

    public static boolean isPalindrome(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            s.push(str.charAt(i));
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            char top = s.pop();

            if (ch != top) return false;
        }

        return true;
    }

    // ({})
    // [({})]
    public static boolean balancedParenthesis(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '{' || ch == '[' || ch == '(') s.push(ch);
            else {
                if (s.isEmpty()) return false;
                char top = s.pop();
                if (ch == '}' && top != '{') return false;
                if (ch == ')' && top != '(') return false;
                if (ch == ']' && top != '[') return false;
            }
        }

        return s.isEmpty();
    }

    public static int evaluatePrefixExpr(String str) {
        Stack<Integer> s = new Stack<>();

        for (int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                int elem1 = s.pop();
                int elem2 = s.pop();

                switch (ch) {
                    case '+':
                        s.push(elem1 + elem2);
                        break;
                    case '-':
                        s.push(elem1 - elem2);
                        break;
                    case '*':
                        s.push(elem1 * elem2);
                        break;
                    case '/':
                        s.push(elem1 / elem2);
                        break;
                }
            } else {
                s.push(Character.getNumericValue(ch));
            }
        }
        return s.pop();
    }
}
