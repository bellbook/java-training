package ch16.ex16_09;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public class Descriptor {

    public static void main(String[] args) {

        String[] classes = {"java.util.HashMap", "ch16.ex16_09.AnnotationSample"};

        for (String name : classes) {
            try {
                Class<?> startClass = Class.forName(name);
                Descriptor.print(startClass);
                System.out.println();
                System.out.println();
            } catch (ClassNotFoundException e) {
                System.out.println(e);
            }
        }
    }

    public static void print(Class<?> clazz) {

        printType(clazz, 0, basic);

        System.out.println();

        String className = clazz.getName();
        printMembers(clazz.getDeclaredFields(), className);
        printMembers(clazz.getDeclaredConstructors(), className);
        printMembers(clazz.getDeclaredMethods(), className);

    }

    private static String[] basic   = { "class",   "interface",
                                        "enum",    "annotation" },
                            supercl = { "extends", "implements" },
                            iFace   = { null,      "extends" };

    private static void printType(Type type, int depth, String[] labels) {
        if (type == null)
            return;

        Class<?> cls = null;
        if (type instanceof Class<?>)
            cls = (Class<?>) type;
        else if (type instanceof ParameterizedType)
            cls = (Class<?>) ((ParameterizedType) type).getRawType();
        else
            throw new Error("Unexpected non-class type");


        Annotation[] annotations = cls.getAnnotations();
        for (Annotation annotation : annotations)
            System.out.println(annotation);


        for (int i = 0; i < depth; i++) {
            System.out.print(" ");
        }
        int kind = cls.isAnnotation() ? 3 :
            cls.isEnum() ? 2 :
            cls.isInterface() ? 1 : 0;
        System.out.print(labels[kind] + " ");
        System.out.print(cls.getCanonicalName());

        TypeVariable<?>[] params = cls.getTypeParameters();
        if (params.length > 0) {
            System.out.print('<');
            for (int i = 0; i < params.length; i++) {
                TypeVariable<?> param = params[i];
                System.out.print(param.getName());
                if (i != params.length - 1)
                    System.out.print(", ");
            }
            System.out.println(">");
        } else
            System.out.println();

        Type[] interfaces = cls.getGenericInterfaces();
        for (Type iface : interfaces) {
            printType(iface, depth + 1, cls.isInterface() ? iFace : supercl);
        }

        Type superclass = cls.getGenericSuperclass();
        if (superclass != Object.class)
            printType(superclass, depth + 1, supercl);
    }

    private static void printMembers(Member[] mems, String className) {

        for (Member m : mems) {
            String decl = m.toString();

            // annotation
            Annotation[] annotations = ((AnnotatedElement) m).getDeclaredAnnotations();
            for (Annotation annotation : annotations)
                System.out.println(" " + annotation);

            // member
            System.out.println(" " + strip(decl, className + "."));
        }
    }

    private static String strip(String decl, String str) {
        return decl.replace(str, "");
    }

}
