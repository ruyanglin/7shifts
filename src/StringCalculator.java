import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {
    private List<String> delimiters = new ArrayList<>();
    private List<Integer> negatives  = new ArrayList<>();
    private final int LOWER_BOUND = 0;
    private final int UPPER_BOUND = 1000;
    private final String DELIMITER = ",";


    public int add(String str) throws Exception {
        List<Integer> numbers = parseInput(str);

        if (!negatives.isEmpty()) {
            throw new Exception("Negatives not allowed: " + negatives);
        }

        return numbers.stream().reduce(0, Integer::sum);
    }

    private List<Integer> parseInput(String input) {
        String[] tokens;
        List<Integer> numbers = new ArrayList<>();

        if (input.length() == 0) {
            return numbers;
        }

        if (input.charAt(0) == input.charAt(1) && input.charAt(0) == '/') {
            input = normalizeInput(input);
        }
        tokens = input.split(DELIMITER);

        // Clean and filter the numbers
        for (String s: tokens) {
            String cleaned = clean(s);
            
            int number = cleaned.equals("") ? 0 : Integer.parseInt(cleaned);
            if (isAcceptable(number))  {
                numbers.add(number);
            }
        }

        return numbers;
    }

    private String normalizeInput(String input) {
        String[] formatedString = input.substring(2).split("\\n", 2);
        input = formatedString[1];
        delimiters = extractDelimiters(formatedString[0]);

        for (String delim: delimiters) {
            // Replace doesn't take delimiter as a regex
            input = input.replace(delim, DELIMITER);
        }
        return input;
    }

    private List<String> extractDelimiters(String delims) {
        return Arrays.asList(delims.split(DELIMITER));
    }

    private String clean(String str) {
        return str.replace("\n", "");
    }

    private boolean isAcceptable(int number) {
        if (number < 0) {
            negatives.add(number);
        }

        return number >= LOWER_BOUND && number <= UPPER_BOUND;
    }

}
