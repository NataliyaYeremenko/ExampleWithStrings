package ua.kharkiv.yeremenko.exStrings;

public class Part3 {
    private static final String INPUT_STRING = Util.readFile("part3.txt");
    public static String convert(String input) {
        String[] lines = input.split("\\r?\\n");
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < lines.length; i++) {
            String[] words = lines[i].split(" ");
            for (int j = 0; j < words.length; j++) {
            	if (words[j].equals("со") || words[j].equals("в")) {
            		words[j] = words[j];
            	}
            	else {
            		words[j] = words[j].toUpperCase().substring(0, 1) + words[j].substring(1, words[j].length());
            	}
                if (j == words.length-1) {
                	output.append(words[j]);
                }
                else {
                	output.append(words[j]).append(" ");
                }
            }
            if (i != lines.length-1) {
            	output.append(System.lineSeparator());
            }
        }
        return output.toString();
    }
    public static void main(String[] args) {
        System.out.println(convert(INPUT_STRING));
    }
}
