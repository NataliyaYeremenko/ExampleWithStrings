package ua.kharkiv.yeremenko.exStrings;

public class Part1 {
    private static final String INPUT_STRING = Util.readFile("part1.txt");
    public static String convert1(String input) {
        String[] lines = input.split("\\r?\\n");
        StringBuilder output = new StringBuilder();
        for (String str: lines) {
            String [] currentLine = str.split(";");
            if (currentLine[0].equals("Login")) {
            	continue;
            }
            output.append(currentLine[0]).append(" ==> ").append(currentLine[2]).append(System.lineSeparator()); 
        }
        return output.substring(0,output.length()-1);
    }
    public static String convert2(String input) {
        String[] lines = input.split("\\r?\\n");
        StringBuilder output = new StringBuilder();
        for (String str: lines) {
            String [] currentLine = str.split(";");
            if (currentLine[0].equals("Login")) {
            	continue;
            }
            output.append(currentLine[1]).append(" (email: ").append(currentLine[2]).append(")").append(System.lineSeparator());
        }
        return output.substring(0,output.length()-1);
    }
    public static String convert3(String input) {
    	String[] lines = input.split("\\r?\\n");
        StringBuilder output = new StringBuilder();
        String[] domein = new String[lines.length-1];
        String[] login = new String[lines.length-1];
        String[] out = new String[lines.length-1];
        int index = 0;
        for (String str: lines) {
            String [] currentLine = str.split(";");
            login [index] = currentLine[0];
            if (currentLine[0].equals("Login")) {
            	continue;
            }
            else {
                String[] subline = currentLine[2].split("@");
                domein[index] = subline[1];
                index++;
            }
        }
        index = 0;
        for (int i = 0; i < domein.length; i++) {
            String str = domein[i];
            if (str.equals("")) {
            	continue;
            }
            StringBuilder logins = new StringBuilder(login[i]);
            for (int j = i + 1; j < domein.length; j++) {
                if (str.equals(domein[j])) {
                    domein[j] = "";
                    logins.append(", ").append(login[j]);
                }
            }
            out[index] = str + " ==> " + logins;
            index++;
        }
        for (int i = 0; i < index-1; i++) {
        	output.append(out[i]).append(System.lineSeparator());
        }
        output.append(out[index-1]);
        return output.toString();
    }

    public static String convert4(String input) {
        String[] lines = input.split("\\r?\\n");
        StringBuilder output = new StringBuilder();
        int lineIndex = 0;
        class Randomizer {
            int random(int minNumber, int maxNumber) {
                maxNumber -= minNumber;
                return (int) (Math.random() * ++maxNumber) + minNumber;
            }
        }
        Randomizer randomizer = new Randomizer();
        for (String str: lines) {
            if (lineIndex == 0) {
                output.append(str).append(";Password").append(System.lineSeparator());
                lineIndex++;
            }
            else{
                output.append(str).append(";").append(String.valueOf(randomizer.random(1000, 9999))).append(System.lineSeparator());
            }
        }
        return output.toString();
    }

    public static void main (String[] args){
        System.out.println("~~~convert1()~~~");
        System.out.println(convert1(INPUT_STRING));
        System.out.println("~~~convert2()~~~");
        System.out.println(convert2(INPUT_STRING));
        System.out.println("~~~convert3()~~~");
        System.out.println(convert3(INPUT_STRING));
        System.out.println("~~~convert4()~~~");
        System.out.println(convert4(INPUT_STRING));
    }

}
