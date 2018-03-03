package org.mvpigs.Planetas;

import java.util.ArrayList;
import java.util.Arrays;


public enum Planeta {


    MERCURIO(3.303e+23, 2.4397e6,TipoPlaneta.TERRESTRE),
    VENUS(4.869e+24, 6.0518e6,TipoPlaneta.TERRESTRE),
    TIERRA(5.976e+24, 6.37814e6,TipoPlaneta.TERRESTRE),
    MARTE(6.421e+23, 3.3972e6,TipoPlaneta.TERRESTRE),
    JUPITER (1.9e+27,   7.1492e7,TipoPlaneta.GASEOSO),
    SATURNO  (5.688e+26, 6.0268e7,TipoPlaneta.GASEOSO),
    URANO  (8.686e+25, 2.5559e7,TipoPlaneta.GASEOSO),
    NEPTUNO (1.024e+26, 2.4746e7,TipoPlaneta.GASEOSO),;
    //PLUTON (1.25e+22,1.188e6){:-(};




    public enum TipoPlaneta {TERRESTRE, GASEOSO}
    private final double masa;
    private final double radio;
    public static final double G = 6.67300E-11;
    private final double gravedadSpuerficie;
    private final Enum<TipoPlaneta> tipo;




    Planeta(double masa, double radio, Enum<TipoPlaneta> tipo){

        this.masa=masa;
        this.radio=radio;
        this.tipo=tipo;
        this.gravedadSpuerficie=setgravedadSuperficie();
    }

    private double setgravedadSuperficie() {

    return G * this.masa/ Math.pow(this.radio,2);}

    public static Planeta[] getGigantesGaseosos() {

        return new ArrayList<>(Arrays.asList(Planeta.values())).stream().
                filter(Planeta -> Planeta.getTipo().equals(TipoPlaneta.GASEOSO)).toArray(Planeta[]::new);


    }

    public static Planeta[] getPlanetasTerrestres() {


        return new ArrayList<>(Arrays.asList(Planeta.values())).stream().
                filter(Planeta ->Planeta.getTipo().equals(TipoPlaneta.TERRESTRE)).toArray(Planeta[]::new);
    }


    public double getMasa() {
        return masa;
    }

    public double getRadio() {
        return radio;
    }
    public Enum<TipoPlaneta> getTipo() {
        return tipo;
    }
    public double getGravedadSpuerficie() {
        return gravedadSpuerficie;
    }
    public double pesoSuperficie(double pesoHumano){
        double masaHumano=pesoHumano/Planeta.TIERRA.getGravedadSpuerficie();

        return masaHumano*this.getGravedadSpuerficie();}
}


/*memoria, aplicad este sencilla fórmula:
Peso_en_Superficie = tu_Masa * Gravedad_en_superficie
donde
Gravedad_en_superficie = G * Masa_del_planeta / Radio_del_planeta_al_cuadrado
donde:
G = 6.67300E-11
y
tu_masa = tu_peso_en_la_Tierra / gravedad_superficial_tierra;*/














