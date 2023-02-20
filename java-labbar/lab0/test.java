public class test {

    public static boolean isValidLength(String SSN, int validSSNLength) {
        return SSN.length() == validSSNLength ? true : false;
    }

    public static boolean isValidPNR(String SSN) {

        if(!isValidLength(SSN, 10)) {
            System.out.println("Felaktig längd på personnummer!");
            System.exit(0);
        }

        int sum = 0;
        for(int i = 0; i < SSN.length(); i++) {
            if (i % 2 == 0) { 
                if (Character.getNumericValue(SSN.charAt(i)) * 2 >= 10) {
                    String twoDigitNum = Integer.toString(Character.getNumericValue(SSN.charAt(i)) * 2);
                    sum += Character.getNumericValue(twoDigitNum.charAt(0)) + Character.getNumericValue(twoDigitNum.charAt(1));
                } else {
                    sum += Character.getNumericValue(SSN.charAt(i)) * 2;
                }
            } else {
                sum += Character.getNumericValue(SSN.charAt(i));
            }
        }

        return sum % 10 == 0 ? true : false;
    }
    
    public static void main(String[] args) {
        String personNumber = "11111111";

        if (isValidPNR(personNumber)) {
            System.out.println("Giltigt nummer.");
        } else {
            System.out.println("Ej ett giltigt nummer.");
        }
    }

}