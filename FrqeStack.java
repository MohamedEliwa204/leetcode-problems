import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

class FreqStack {
    Map<Integer, Integer> freqMap = new HashMap<>();
    Map<Integer, Stack<Integer>> groupMap = new HashMap<>();
    int maxFreq = 0;

    public FreqStack() {
    Stack stack = new Stack<>();
}


    public void push(int x) {
        int freq = freqMap.getOrDefault(x, 0) + 1;
        freqMap.put(x, freq);

        groupMap.computeIfAbsent(freq, z -> new Stack<>()).push(x);
        maxFreq = Math.max(maxFreq, freq);
    }

    public int pop() {
        Stack<Integer> stack = groupMap.get(maxFreq);
        int x = stack.pop();

        freqMap.put(x, freqMap.get(x) - 1);
        if (stack.isEmpty()) {
            maxFreq--;
        }

        return x;
    }
}
public class FrqeStack {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String[] ops = scanner.nextLine().replaceAll("[\\[\\]\"]", "").split(",");

        // Read parameters
        System.out.println("Enter parameters:");
        String rawParams = scanner.nextLine();
        List<List<Integer>> paramList = parseParams(rawParams);

        // Result array to store outputs
        List<String> results = new ArrayList<>();

        FreqStack freqStack = null;

        for (int i = 0; i < ops.length; i++) {
            String command = ops[i].trim();
            List<Integer> params = paramList.get(i);

            if (command.equals("FreqStack")) {
                freqStack = new FreqStack();
                results.add("null");
            } else if (command.equals("push")) {
                int val = params.get(0);
                freqStack.push(val);
                results.add("null");
            } else if (command.equals("pop")) {
                int result = freqStack.pop();
                results.add(String.valueOf(result));
            }
        }

        // Print the final results as an array
        System.out.println(results.toString());

        scanner.close();
    }

    private static List<List<Integer>> parseParams(String input) {
        List<List<Integer>> result = new ArrayList<>();
        input = input.replaceAll("\\s+", "");
        input = input.substring(1, input.length() - 1); // remove outer [ ]

        String[] parts = input.split("(?<=\\]),?(?=\\[)");

        for (String part : parts) {
            part = part.replaceAll("\\[|\\]", "");
            List<Integer> subList = new ArrayList<>();
            if (!part.isEmpty()) {
                for (String num : part.split(",")) {
                    if (!num.isEmpty()) {
                        subList.add(Integer.parseInt(num));
                    }
                }
            }
            result.add(subList);
        }

        return result;
    }
}
import java.util.Stack;

// public class FreqStack {
//     Stack<Integer> stack;

//     public FreqStack() {
//         Stack<Integer> stack = new Stack<>();
//     }

//     public void push(int x) {
//         int max = 0;
//         Stack<Integer> temp = new Stack<>();
//         while (!stack.empty()) {
//             if (stack.peek() > max) {
//                 max = stack.peek();
//             }
//             temp.push(stack.pop());
//             // stack.pop();
//         }
//         int[] freq = new int[max + 1];

//         while (!temp.empty()) {
//             if (temp.peek() == x) {
//                 freq[temp.peek()]++;
//             }
//             // stack.push(temp.peek());
//             freq[temp.pop()]++;

//         }
//         int cnt = 1;
//         for (int i = 0; i <= max; i++) {
//             if (freq[i] == cnt) {
//                 stack.push(i);
//             }
//             cnt++;
//         }

//     }

//     public int pop() {

//         int top = stack.pop();
//         return top;
//     }
// }



