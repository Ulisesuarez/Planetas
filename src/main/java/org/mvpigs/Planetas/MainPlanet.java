package org.mvpigs.Planetas;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MainPlanet {

    private static double peso;

    public static void main(String[] args){

        try{
        peso=Double.parseDouble(args[0]);}
        catch(ArrayIndexOutOfBoundsException IndexOutOfBounds){
            System.out.println("Debes pasar tu peso como argumento (default=0)");
        }

        DecimalFormat decimalFormat=new DecimalFormat(".##");

        for (Planeta planeta:Planeta.values()){
            BigDecimal pesoSuperficie=new BigDecimal(String.valueOf(planeta.pesoSuperficie(peso)));
            pesoSuperficie.setScale(2, RoundingMode.HALF_UP);

            System.out.println(String.format("Tu peso en " + planeta.name() + " es " + decimalFormat.format(pesoSuperficie)));
        }
        
        
        
        
        
    }
}
