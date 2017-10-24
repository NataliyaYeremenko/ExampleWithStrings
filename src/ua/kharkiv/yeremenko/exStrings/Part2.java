package ua.kharkiv.yeremenko.exStrings;

public class Part2 {
    private static final String INPUT_STRING = Util.readFile("part2.txt");
    private final static String[] SYMBOLS = {",", "'", "\\r?\\n", "-"};
    public static String convert(String input) {
        String inputLine = input;
        int indexMin = 0;
        int indexMax = 0;
        StringBuilder outputPart1 = new StringBuilder("Min: ");
        StringBuilder outputPart2 = new StringBuilder("Max: ");
        for (String str: SYMBOLS) {
            inputLine = inputLine.replaceAll(str, " ");
        }
        String[] words = inputLine.split(" ");
        String[] minWords = new String[words.length];
        String[] maxWords = new String[words.length];
        int minLength = words[0].length();
        int maxLength = words[0].length();
        for (String str: words) {
            if (str.equals("")) {
            	continue;
            }
            else {
                if (str.length() < minLength) {
                	minLength = str.length();
                }
                if (str.length() > maxLength) {
                	maxLength = str.length();
                }
            }
        }
        for (int i = 0; i < words.length; i++ ){
            int checkMin = 0;
            for (int j = 0; j < minWords.length; j++) {
                if (words[i].equals(minWords[j])) {
                	checkMin++;
                }
            }
            if ((words[i].length() == minLength)&&(checkMin == 0)) {
                minWords[indexMin] = words[i];
                indexMin++;
                outputPart1.append(words[i]).append(", ");
            }
            int checkMax = 0;
            for (int j = 0; j < maxWords.length; j++) {
                if (words[i].equals(maxWords[j])) {
                	checkMax++;
                }
            }
            if ((words[i].length() == maxLength) && (checkMax == 0)) {
                maxWords[indexMax] = words[i];
                indexMax++;
                outputPart2.append(words[i]).append(", ");
            }
        }
        String out1 = outputPart1.substring(0, outputPart1.length()-2);
        String out2 = outputPart2.substring(0, outputPart2.length()-2);
        return out1 + System.lineSeparator()+ out2;
    }
    public static void main (String[] args){
        System.out.println(convert(INPUT_STRING));
    }
}
