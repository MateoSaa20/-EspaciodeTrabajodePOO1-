public class TestEmpleados {
    public static void main(String[] args) {
        // 1. Crear un arreglo de la superclase con tipos mixtos (Polimorfismo)
        Empleado[] empleados = new Empleado[4];
        empleados[0] = new Empleado("Ana Gómez", "11111111A", 1200.0);
        empleados[1] = new EmpleadoTiempoCompleto("Carlos Pérez", "22222222B", 1500.0, 6000.0);
        empleados[2] = new EmpleadoPorHora("Lucía Fernández", "33333333C", 500.0, 40, 20.0);
        empleados[3] = new EmpleadoTiempoCompleto("Marcos López", "44444444D", 1800.0, 3600.0);

        // 2. Recorrer el arreglo e imprimir usando toString() y calcularSalario()
        System.out.println("=== LISTADO DE EMPLEADOS ===");
        for (Empleado emp : empleados) {
            System.out.println(emp.toString());
            System.out.println("Salario Real Calculado: $" + emp.calcularSalario());
            System.out.println("------------------------------------------------");
        }

        // 3. Verificar equals() con mismo DNI y mismo tipo (debe dar true)
        System.out.println("\n=== PRUBA DE EQUALS: MISMO DNI, MISMO TIPO ===");
        Empleado empA = new Empleado("Juan Original", "99999999Z", 1000.0);
        Empleado empB = new Empleado("Juan Clon", "99999999Z", 2500.0); // Diferente sueldo y nombre
        
        System.out.println("Empleado A: " + empA);
        System.out.println("Empleado B: " + empB);
        System.out.println("¿Son iguales por DNI?: " + empA.equals(empB)); // true

        // 4. Verificar equals() con mismo DNI pero distinto tipo (debe dar false gracias a getClass())
        System.out.println("\n=== PRUEBA DE EQUALS: MISMO DNI, DISTINTO TIPO ===");
        Empleado empTC = new EmpleadoTiempoCompleto("Roberto", "88888888X", 1000.0, 1200.0);
        Empleado empPH = new EmpleadoPorHora("Roberto", "88888888X", 1000.0, 10, 50.0);

        System.out.println("Empleado TC: " + empTC);
        System.out.println("Empleado PH: " + empPH);
        System.out.println("¿Son iguales?: " + empTC.equals(empPH)); // false
    }
}
