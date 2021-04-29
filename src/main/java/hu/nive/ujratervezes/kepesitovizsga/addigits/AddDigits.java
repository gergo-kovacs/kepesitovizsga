package hu.nive.ujratervezes.kepesitovizsga.addigits;

public class AddDigits {


    public int addDigits(String input){

        if(input == null || input.equals("")){
            return -1;
        }

        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            if(Character.isDigit(input.charAt(i))){
              sum +=  Integer.parseInt(String.valueOf(input.charAt(i)));
                System.out.println(sum);
            }
        }

        return sum;
    }

}
