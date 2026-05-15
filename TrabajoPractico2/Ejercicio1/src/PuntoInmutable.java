package TrabajoPractico2.Ejercicio1;

import java.io.PrintStream;


public class PuntoInmutable {
   private final double x;
   private final double y;

   public PuntoInmutable(double var1, double var3) {
      this.x = var1;
      this.y = var3;
   }

   public double getX() {
      return this.x;
   }

   public double getY() {
      return this.y;
   }

   public String toString() {
      return "PuntoInmutable(x = " + this.x + ", y = " + this.y + ")";
   }

   PuntoInmutable transladar(double var1, double var3) {
      return new PuntoInmutable(this.x + var1, this.y + var3);
   }

   PuntoInmutable escalar(double var1) {
      return new PuntoInmutable(this.x * var1, this.y * var1);
   }

   PuntoInmutable reflejarX() {
      return new PuntoInmutable(this.x, -this.y);
   }

   PuntoInmutable reflejarY() {
      return new PuntoInmutable(-this.x, this.y);
   }

   double distanciaAlOrigen() {
      return Math.sqrt(this.x * this.x + this.y * this.y);
   }

   double distanciaA(PuntoInmutable var1) {
      double var2 = this.x - var1.x;
      double var4 = this.y - var1.y;
      return Math.sqrt(var2 * var2 + var4 * var4);
   }
    public static void main(String[] var0) {
         PuntoInmutable var1 = new PuntoInmutable((double)3.0F, (double)4.0F);
         System.out.println(var1);
         PuntoInmutable var2 = var1.reflejarX().escalar((double)2.0F).transladar((double)1.0F, (double)1.0F);
         System.out.println(var2);
         System.out.println("Distancia al origen: " + var1.distanciaAlOrigen());
         PrintStream var10000 = System.out;
         double var10001 = var1.distanciaA(new PuntoInmutable((double)0.0F, (double)0.0F));
         var10000.println("Distancia a (0,0): " + var10001);
      }
}


