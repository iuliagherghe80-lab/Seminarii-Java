package org.example;
import java.lang.reflect.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            Class<?> studentClass = Student.class;

            System.out.println("Nume complet clasă: " + studentClass.getName());
            System.out.println("Nume simplu clasă: " + studentClass.getSimpleName());
            System.out.println("Pachet: " + studentClass.getPackageName());
            System.out.println("Superclasă: " + studentClass.getSuperclass().getName());

            System.out.print("Interfețe implementate: ");
            Class<?>[] interfaces = studentClass.getInterfaces();
            for (Class<?> i : interfaces) {
                System.out.print(i.getName() + " ");
            }
            System.out.println("\n");

            Field[] fields = studentClass.getDeclaredFields();
            for (Field field : fields) {
                String modifiers = Modifier.toString(field.getModifiers());
                System.out.println(modifiers + " " + field.getType().getSimpleName() + " " + field.getName());
            }
            System.out.println();

            Method[] methods = studentClass.getDeclaredMethods();
            for (Method method : methods) {
                String modifiers = Modifier.toString(method.getModifiers());
                String returnType = method.getReturnType().getSimpleName();
                System.out.print(modifiers + " " + returnType + " " + method.getName() + "(");

                Parameter[] parameters = method.getParameters();
                for (int i = 0; i < parameters.length; i++) {
                    System.out.print(parameters[i].getType().getSimpleName() + " " + parameters[i].getName());
                    if (i < parameters.length - 1) System.out.print(", ");
                }
                System.out.println(")");
            }
            System.out.println();


            Constructor<?> noArgConstructor = studentClass.getDeclaredConstructor();
            Object studentIncomplet = noArgConstructor.newInstance();
            System.out.println("Obiect generat: " + studentIncomplet);
            System.out.println();

            Method sayHelloMethod = studentClass.getMethod("sayHello");
            sayHelloMethod.invoke(studentIncomplet);
            System.out.println();

            System.out.println("=== 6. Accesare și Modificare Câmp Privat ('name') ===");
            Field nameField = studentClass.getDeclaredField("name");
            nameField.setAccessible(true);

            System.out.println("Valoare inițială: " + nameField.get(studentIncomplet));
            nameField.set(studentIncomplet, "Iulia");
            System.out.println("Valoare nouă după modificare: " + nameField.get(studentIncomplet));
            System.out.println();

            Method privateMethod = studentClass.getDeclaredMethod("secretMethod");
            privateMethod.setAccessible(true); // Permitem accesul
            privateMethod.invoke(studentIncomplet);
            System.out.println();

            Constructor<?> constr1 = studentClass.getDeclaredConstructor(String.class);
            Object s1 = constr1.newInstance("Ana");

            Constructor<?> constr2 = studentClass.getDeclaredConstructor(String.class, int.class);
            Object s2 = constr2.newInstance("Barbu", 21);

            ((Student) s1).sayHello();
            ((Student) s2).sayHello();
            System.out.println();

            inspect(s2);
            System.out.println();

            String jsonOutput = toJson(s2);
            System.out.println(jsonOutput);
            System.out.println();

            String csvRow = "publicId,name,age\nID-99,Elena,22";
            Student studentDinCSV = mapCsvToTarget(csvRow, Student.class);
            System.out.println("Student creat din CSV successfully!");
            studentDinCSV.sayHello();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void inspect(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        System.out.println("Inspectăm obiect de tip: " + clazz.getSimpleName());
        for (Field f : clazz.getDeclaredFields()) {
            f.setAccessible(true);
            System.out.println("  Câmp: " + f.getName() + " = " + f.get(obj));
        }
    }

    public static String toJson(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        StringJoiner sj = new StringJoiner(",", "{", "}");

        for (Field f : fields) {
            f.setAccessible(true);
            String name = f.getName();
            Object value = f.get(obj);

            if (value instanceof String) {
                sj.add("\"" + name + "\":\"" + value + "\"");
            } else {
                sj.add("\"" + name + "\":" + value);
            }
        }
        return sj.toString();
    }

    public static <T> T mapCsvToTarget(String csvData, Class<T> clazz) throws Exception {
        String[] lines = csvData.split("\n");
        String[] headers = lines[0].split(",");
        String[] values = lines[1].split(",");

        T instance = clazz.getDeclaredConstructor().newInstance();

        for (int i = 0; i < headers.length; i++) {
            try {
                Field field = clazz.getDeclaredField(headers[i].trim());
                field.setAccessible(true);

                String rawValue = values[i].trim();

                if (field.getType() == int.class || field.getType() == Integer.class) {
                    field.set(instance, Integer.parseInt(rawValue));
                } else if (field.getType() == double.class || field.getType() == Double.class) {
                    field.set(instance, Double.parseDouble(rawValue));
                } else {
                    field.set(instance, rawValue);
                }
            } catch (NoSuchFieldException e) {
                System.out.println("Atenție: Câmpul " + headers[i] + " nu există în clasă.");
            }
        }
        return instance;
    }
}
