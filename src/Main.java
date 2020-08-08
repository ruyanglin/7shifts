public class Main {

    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.out.println("Not enough arguments. Expecting input in the format: //[delimiter]\\n[delimiter separated numbers]");
            System.exit(1);
        }
        StringCalculator stringCalculator = new StringCalculator();
        // When input is from the command line need to escape \n
        String input = args[0].replace("\\n", "\n");
        System.out.println(stringCalculator.add(input));

    }
}
