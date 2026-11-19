package org.ejemplos.proyectojavafx2;

/**
 * Cilindro permite calcular el área y el volumen del cilindro
 */
public class Cilindro {
private double radio=0;
private double altura=0;
private double area=0;
private double volumen=0;

    /**
     * Constructor de la clase Cilindro.
     *
     * @param radio  Radio de la base del cilindro.
     * @param altura Altura del cilindro.
     */

public Cilindro(double radio, double altura) {
   this.radio=radio;
   this.altura=altura;
   area=calcularArea();
    volumen=calcularVolumen();

}

    /**
     * Establece el valor del radio.
     *
     * @param radio El nuevo radio del cilindro.
     */
public void setRadio(double radio){
    this.radio = radio;
    area=calcularArea();
    volumen=calcularVolumen();

}

    /**
     * Obtiene el valor actual del radio.
     *
     * @return El radio del cilindro.
     */


    public double getRadio() {
        return radio;
    }

    /**
     * Establece el valor del radio.
     *
     * @param altura La nueva altura del cilindro
     */

    public void setAltura(double altura) {
        this.altura = altura;
        area=calcularArea();
        volumen=calcularVolumen();
    }

    /**
     * Obtiene el valor actual de la altura.
     *
     * @return La altura del cilindro.
     */

    public double getAltura() {
        return altura;
    }

    /**
     * Calcula el are total del cilindro
     *
     * @return El área calculada del cilindro.
     */
    public double calcularArea(){
        //A=2πr(r+h)
        return 2*Math.PI*radio*(radio+altura);
    }

    /**
     * Calcula el volumen del cilindro
     * Fórmula: V = PI * h * r^2
     *
     * @return El volumen calculado del cilindro
     */

    public double calcularVolumen(){
    //v=πhr^2
        return Math.PI*altura*radio*radio;
        //return Math.PI*altura*Math.pow(radio,2);
    }

    /**
     * Obtiene el valor del area
     *
     * @return El area del cilindro
     */

    public double getArea() {
        return area;
    }

    /**
     * Obtiene el valor actual de la area
     *
     * @return El area del cilindro
     */

    public double getVolumen() {
        return volumen;
    }

    /**
     * Valor obtenido del volumen del cilindro
     */
}
