public class TestAnimales  {
    public static void main(String[] args) {

        Perro perro = new Perro("Firulais", 2, "Labrador");
        System.out.println(perro);

        Animal a = new Perro("Max", 3, "Caniche");
        Mamifero m = new Perro("Rocky", 5, "Bulldog");
        Perro p = new Perro("Toby", 1, "Beagle");

        System.out.println(a.hacerSonido());
        System.out.println(m.hacerSonido());
        System.out.println(p.hacerSonido());

        Mamifero mamifero = new Mamifero("Michi", 4);
        Animal animal = new Animal("AnimalGen");

        System.out.println(mamifero);
        System.out.println(animal);
    }
}