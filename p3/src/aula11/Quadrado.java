package aula11;

public class Quadrado extends Retangulo{
    public Quadrado(Ponto centro, double lado) {
        super(centro,lado,lado);
    }
    public Quadrado(double lado) {
        super(new Ponto(0,0),lado,lado);
    }
    public Quadrado(double x, double y,double lado) {
        super(new Ponto(x,y),lado,lado);
    }
    public Quadrado(Quadrado q) {
        this(q.centro(),q.a());
    }

    @Override public String toString() {
        return String.format("Quadrado de %s e de lado %1.1f", super.toString(),this.a());
    }
}