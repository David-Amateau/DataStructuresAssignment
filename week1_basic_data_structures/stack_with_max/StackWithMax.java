import java.util.*;
import java.io.*;

public class StackWithMax {

    private Stack<Integer> myStack;
    private Stack<Integer> maxOnStack;

    public StackWithMax() {
        myStack = new Stack<>();
        maxOnStack = new Stack<>();
    }

    public void push(int number) {
        myStack.push(number);
        if (maxOnStack.isEmpty() || number >= max()) {
            maxOnStack.push(number);
        }
    }
    public int pop(){
        if (myStack.peek() == max()) {
            maxOnStack.pop();
        }
        return myStack.pop();
    }

    public int max() { return maxOnStack.peek(); }


    static public void main(String[] args) throws IOException {
        new StackWithMax().solve();
    }

    public void solve() throws IOException {
        FastScanner scanner = new FastScanner();
        int queries = scanner.nextInt();
        StackWithMax stack = new StackWithMax();

        for (int qi = 0; qi < queries; ++qi) {
            String operation = scanner.next();
            if ("push".equals(operation)) {
                int value = scanner.nextInt();
                stack.push(value);
            } else if ("pop".equals(operation)) {
                stack.pop();
            } else if ("max".equals(operation)) {
                System.out.println(stack.max());
            }
        }
    }


    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }
        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}

