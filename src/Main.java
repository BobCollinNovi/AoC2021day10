

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(args[0]));
        int syntaxErrorScore = 0;
//        String[] input = new String[] {
//                "[({(<(())[]>[[{[]{<()<>>",
//                "[(()[<>])]({[<{<<[]>>(",
//                "{([(<{}[<>[]}>{[]{[(<()>",
//                "(((({<>}<{<{<>}{[]{[]{}",
//                "[[<[([]))<([[{}[[()]]]",
//                "[{[{({}]{}}([{[{{{}}([]",
//                "{<[[]]>}<{[{[{[]{()[[[]",
//                "[<(<(<(<{}))><([]([]()",
//                "<{([([[(<>()){}]>(<<{{",
//                "<{([{{}}[<[[[<>{}]]]>[]]"};
//        String[] input = new String[] {
//            "{([(<{}[<>[]}>{[]{[(<()>",
//            "[[<[([]))<([[{}[[()]]]",
//            "[{[{({}]{}}([{[{{{}}([]",
//            "[<(<(<(<{}))><([]([]()",
//            "<{([([[(<>()){}]>(<<{{"};
        //String firstInput = "{([(<{}[<>[]}>{[]{[(<()>";

        while (scanner.hasNext()) {
            char[] inputChars = scanner.next().toCharArray();
//        for (String inputStr : input) {
//            char[] inputChars = inputStr.toCharArray();
            Stack<Character> openBrackets = new Stack<>();

            for (char ch : inputChars) {
                if (ch == '{' || ch == '[' || ch == '(' || ch == '<') {
                    openBrackets.add(ch);
                } else if (ch == '}') {
                    if (openBrackets.peek() == '{') {
                        openBrackets.pop();
                    } else {
                        syntaxErrorScore += 1197;
                        break;
                    }
                } else if (ch == ']') {
                    if (openBrackets.peek() == '[') {
                        openBrackets.pop();
                    } else {
                        syntaxErrorScore += 57;
                        break;
                    }
                } else if (ch == ')') {
                    if (openBrackets.peek() == '(') {
                        openBrackets.pop();
                    } else {
                        syntaxErrorScore += 3;
                        break;
                    }
                } else if (ch == '>') {
                    if (openBrackets.peek() == '<') {
                        openBrackets.pop();
                    } else {
                        syntaxErrorScore += 25137;
                        break;
                    }
                }
            }
            System.out.println(syntaxErrorScore);

        }

    }
}
