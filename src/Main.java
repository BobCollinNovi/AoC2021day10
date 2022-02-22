

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        int totalSyntaxErrorScore = 0;
        ArrayList<Long> completionScores = new ArrayList<Long>();

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
        //String firstInput = "{([(<{}[<>[]}>{[]{[(<()>";

        Scanner scanner = new Scanner(new File(args[0]));
        while (scanner.hasNext()) {
            char[] inputChars = scanner.next().toCharArray();
//        for (String inputStr : input) {
//            char[] inputChars = inputStr.toCharArray();
            Stack<Character> openBrackets = new Stack<>();
            int syntaxErrorScore = 0;
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
            totalSyntaxErrorScore += syntaxErrorScore;
            System.out.println("SyntaxErrorScore:" + totalSyntaxErrorScore);

            if (syntaxErrorScore > 0) { continue;}

            Stack<Character> closeBrackets = new Stack<>();

            long curCompletionScore = 0;
            while (!openBrackets.empty())
            {
                curCompletionScore *= 5;
                char curCh = openBrackets.pop();
                if (curCh == '{') { closeBrackets.add('}'); curCompletionScore += 3;}
                if (curCh == '[') { closeBrackets.add(']'); curCompletionScore += 2;}
                if (curCh == '(') { closeBrackets.add(')'); curCompletionScore += 1;}
                if (curCh == '<') { closeBrackets.add('>'); curCompletionScore += 4;}
            }
            completionScores.add(curCompletionScore);
            Collections.sort(completionScores);
            System.out.println("size:" + completionScores.size());
            int middle = completionScores.size() / 2;
            long median = completionScores.get(middle);
            System.out.println("MedianCompletionScore:" + median);

        }



    }
}
