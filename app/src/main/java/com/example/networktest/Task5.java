package com.example.networktest;

/*
* MNr. 01656002 % 7 = 5 ->
* "Jede	zweite	Ziffer	der	Matrikelnummer	durch	ASCII
* Characters	ersetzen,	wobei	0	=	a,	1	=	b,	…	"
*/

import java.util.Arrays;


public class Task5 {

    public String mixDigitASCII (String MNr)  {
        int [] MNrDigits = new int[8];
        String [] numbCharMNR = new String[8];
        char sign;
        int intMNr = Integer.parseInt(MNr);
        int digit;
        int iterator = MNrDigits.length-1;
        String output;

        while (intMNr>0){
            digit = intMNr%10;
            MNrDigits[iterator]=digit;
            iterator--;
            intMNr=intMNr/10;
        }

        for(int i=0; i<MNrDigits.length; i++){
            if(i%2==0){
                numbCharMNR[i] = Integer.toString(MNrDigits[i]);
            }else{  //jede zweite Ziffer wird zu ASCII Zeichen
                sign = (char) (MNrDigits[i]+97);
                numbCharMNR[i] = Character.toString(sign);
            }
        }

        output = Arrays.toString(numbCharMNR);
        return output;
    }
}
