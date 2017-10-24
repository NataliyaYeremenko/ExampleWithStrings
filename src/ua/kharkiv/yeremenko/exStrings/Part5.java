package ua.kharkiv.yeremenko.exStrings;

public class Part5 {
	private static boolean check;
    public static String decimal2Roman(int x) {
        StringBuffer a = new StringBuffer("");
        int m1 = x / 1000;
        a.append(checkM(m1));
        int m2 = x % 1000;
        int d1 = m2 / 500;
        a.append(checkD(d1));
        int d2 = m2 % 500;
        int c1 = d2 / 100;
        a.append(checkC(c1));
        int c2 = d2 % 100;
        int l1 = c2 / 50;
        int l2 = c2 % 50;
        a.append(checkL(l1, l2/10));
        int x1 = l2 / 10;
        a.append(checkX(x1));
        int x2 = l2 % 10;
        a.append(basic(x2));
        return a.toString();
    }

    private static String checkM(int in) {
        StringBuffer a = new StringBuffer("");
        int i = 0;
        while (i < in) {
            a.append("M");
            i++;
        }
        return a.toString();
    }

    private static String checkC(int in) {
        if ((in == 4)&(!check)) {
            check =true;
            return "CD";
        }
        else {
        	if ((in != 0) && (in < 4)) {
        		check = false;
        		StringBuffer a = new StringBuffer("");
        		int i = 0;
        		while (i < in) {
        			a.append("C");
        			i++;
        		}
        		return a.toString();
        	}
        	else {
        		return "";
        	}
        }
    }

    private static String checkX(int in) {
        if ((in == 4)&(!check)) {
            check = true;
            return "XL";
        }
        if ((in != 0) && (in < 4)) {
            check = false;
            StringBuffer a = new StringBuffer("");
            int i = 0;
            while (i < in) {
                a.append("X");
                i++;
            }
            return a.toString();
        }
        else {
        	return "";
        }
    }

    private static String checkD(int in) {
        if ((in == 1)&(!check)) {
            check = true;
            return "CM";
        }
        if ((in != 0) && (in < 4)) {
            check = false;
            StringBuffer a = new StringBuffer("");
            int i = 0;
            while (i < in) {
                a.append("D");
                i++;
            }
            return a.toString();
        }
        else {
        	return "";
        }
    }


    private static String checkL(int in, int nextNum) {
        if ((in == 1)&(!check)&(nextNum > 3)){
            check = true;
            return "XC";
        }
        else {
        	if (in != 0) {
        		check = false;
        		StringBuffer a = new StringBuffer("");
        		int i = 0;
        		while (i < in) {
        			a.append("L");
        			i++;
        		}
        		return a.toString();
        	}
        	else {
        		return "";
        	}
        }

    }

    private static String basic(int in) {
        String[] a = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        check = false;
        return a[in];
    }

    public static int roman2Decimal(String s) {
        int[] numbers = new int[100];
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.substring(i, i+1).equals("I")) {
            	numbers[i] = 1;
            }
            if (s.substring(i, i+1).equals("V")) {
            	numbers[i] = 5;
            }
            if (s.substring(i, i+1).equals("X")) {
            	numbers[i] = 10;
            }
            if (s.substring(i, i+1).equals("L")) {
            	numbers[i] = 50;
            }
            if (s.substring(i, i+1).equals("C")) {
            	numbers[i] = 100;
            }
            if (s.substring(i, i+1).equals("D")) {
            	numbers[i] = 500;
            }
            if (s.substring(i, i+1).equals("M")) {
            	numbers[i] = 1000;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (numbers[i] < numbers[i+1]) {
            	result -= numbers[i];
            }
            else {
            	result += numbers[i];
            }
        }
        return result;
    }
    
    public static void dataOutput(int arabicInput){
    	String romain = decimal2Roman(arabicInput);
        int arabic = roman2Decimal(romain);
        String narrow = " ===> ";
        System.out.println(arabicInput + narrow + romain + narrow + arabic);
    }

    public static void main(String[] args) {
        for (int i = 1; i <=5; i++){
            dataOutput(i);
        }
        for (int i = 94; i <=100; i++){
        	dataOutput(i);
        }
    }
}
