import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringCalculator {


    private List<String> delimiters = new ArrayList<>();
    private List<Integer> negatives  = new ArrayList<>();
    private final int LOWER_BOUND = 0;
    private final int UPPER_BOUND = 1000;
    private final String NORMALIZED_DELIMITER = ",";


    public int add(String str) throws Exception {
        List<Integer> numbers = parseString(str);

        if (!negatives.isEmpty()) {
            throw new Exception("Negatives not allowed: " + negatives);
        }

        return numbers.stream().reduce(0, Integer::sum);
    }

    public List<String> getDelimiters() {
        if (delimiters.size() == 0) {
            return Collections.singletonList(",");
        }
        return delimiters;
    }


    private List<Integer> parseString(String str) {
        String[] tokens;
        List<Integer> numbers = new ArrayList<>();

        if (str.length() == 0) {
            return numbers;
        }

        if (str.charAt(0) == str.charAt(1) && str.charAt(0) == '/') {
            String[] formatedString = str.substring(2).split("\\n", 2);
            str = formatedString[1];
            delimiters = Arrays.asList(formatedString[0].split(NORMALIZED_DELIMITER));

            for (String delim: delimiters) {
                // Replace doesn't take delimiter as a regex
                str = str.replace(delim, NORMALIZED_DELIMITER);
            }
        }
        tokens = str.split(NORMALIZED_DELIMITER);

        // Clean and filter the numbers
        for (String s: tokens) {
            String cleaned = clean(s);

            // For cased where the delimiters are * and **
            int number = cleaned.equals("") ? 0 : Integer.parseInt(cleaned);
            if (isAcceptable(number))  {
                numbers.add(number);
            }
        }

        return numbers;
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
