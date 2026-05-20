

public  class Mamifero extends Animal {
    private int mesesGestacion;

    public Mamifero(String nombre, int mesesGestacion) {
        super(nombre);
        this.mesesGestacion = mesesGestacion;
    }
     @Override
    public String hacerSonido(){
        return super.hacerSonido() + "Es un mamifero";
    }
     @Override
    public String toString(){
        return super.toString() + ", mesesGestacion=" + mesesGestacion;
    }

}
