import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

class Bracket {
    char type;
    int position;

    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }

    boolean Match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        if (this.type == '(' && c == ')')
            return true;
        return false;
    }
}

public class check_brackets {
    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();
        checkBracketsFromString(text);
        reader.close();

                // For local file testing
        // String fileName = "";
        // BufferedReader rd = new BufferedReader(new FileReader(fileName));
        // String text = rd.readLine();
        // checkBracketsFromString(text);
        // rd.close();
    }

    public static void checkBracketsFromString (String text) {
        Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();
        for (int position = 0; position < text.length(); ++position) {
            char next = text.charAt(position);
            if (next == '(' || next == '[' || next == '{') {
                opening_brackets_stack.push(new Bracket(next, position));
            }
            if (next == ')' || next == ']' || next == '}') {
                if (opening_brackets_stack.isEmpty()) {
                    System.out.println(position + 1);
                    return;
                }
                Bracket currentBracket = opening_brackets_stack.pop();
                if (!currentBracket.Match(next)) {
                    System.out.println(position + 1);
                    return;
                }
            }
        }
        if (opening_brackets_stack.isEmpty()) {
            System.out.println("Success");
        } else {
            System.out.println(opening_brackets_stack.peek().position + 1);
        }
    }
}