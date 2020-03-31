package aula12.ex1;
import aula11.Circulo;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Ex1 {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Object> objectos = new ArrayList<>();
    public static void main(String[] args) {
        Circulo q1 = new Circulo(4);
        while (true){
            menu(q1);
        }
        // (a)
        //show_class(q1);

        // (b)

    }
    public static void menu(Object q1){
        System.out.println("----------------MENU-----------------");
        System.out.println("| 1 - show class                    |");
        System.out.println("| 2 - create object                 |");
        System.out.println("| 3 - show objects created          |");
        System.out.println("| 4 - invoque method in obj created |");
        System.out.println("-------------------------------------");

        System.out.printf("|Opçao|-> ");
        int op = Integer.parseInt(sc.nextLine());
        switch (op){
            case 1 :
                show_class(q1);
                break;
            case 2:
                Object o = create_obj(q1);
                System.out.println("| Objecto criado | : "+o);
                objectos.add(o);
                System.out.println();
                break;
            case 3:
                show_created();
                break;
            case 4:
                choose_obj();
                break;
            default:
                System.exit(1);
                break;
        }
    }

    private static void show_created() {
        System.out.println("---Objectos criados---");
        int cnt = 0;
        for (Object ob:objectos) {
            System.out.println("    "+cnt+" - "+ob);
            cnt++;
        }
        System.out.println();
    }
    private static void choose_obj(){
        Object choosen = objectos.get(0);
        LinkedList<String> metodos =  new LinkedList<>();
        Method tmp_m[] = choosen.getClass().getDeclaredMethods();
        for (Method m :tmp_m
        ) {
            String a = "public "+m.getAnnotatedReturnType().getType().getTypeName()+" "+m.getName()+"(";
            Class cl[] = m.getParameterTypes();
            int cont = 0;
            for ( Class c: cl ) {
                cont++;
                a += c.getName()+" param"+cont+" ";
            }
            a += "){...}";
            metodos.add(a);
        }
        System.out.println("---Choose method---");
        int c = 0;
        for (String m : metodos) {
            System.out.println(c+" - "+m);
            c++;
        }
        System.out.printf(" |choosen method| :");
        int o = Integer.parseInt(sc.nextLine());
        try {
            int ct = 0;
            Method me = tmp_m[o];
            for (Object oj : objectos) {
                System.out.println("\t"+ct+"--|"+me.getName().toUpperCase()+" => "+me.invoke(oj));
                ct++;
            }
            Class cl[] = me.getParameterTypes();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private static Object create_obj(Object q2){ return create_obj(q2.getClass()); }
    private static Object create_obj(Class q){
        Constructor tmp[] = q.getConstructors();
        ArrayList<String> con = new ArrayList<>();
        for (Constructor c:tmp
        ) {
            String n = c.getName();
            n = n.replace(q.getPackageName()+".","");
            String t ="\t"+con.size()+" - public "+n+"(";
            Class cl[] = c.getParameterTypes();
            int cnt = 0;
            for (Class tmpc: cl
            ) {
                cnt++;
                if (cl.length == cnt){
                    t += tmpc.getName().replace(q.getPackageName()+".","")+" param"+cnt;
                    break;
                }
                t += tmpc.getName().replace(q.getPackageName()+".","")+" param"+cnt+" ,";
            }
            t += "){...}\n";
            con.add(t);
        }
        System.out.println("-----Choose constructor-----");
        for (String s: con
             ) {
            System.out.printf(s);
        }
        Constructor<?> choosen = null;
        while (true) {
            try {
                System.out.printf("|Opçao| ->");
                int op = Integer.parseInt(sc.nextLine());
                choosen = tmp[op];
                break;
            } catch (Exception e) {
                System.out.println("Opçao invalida");
            }
        }
        Class<?>[] param = choosen.getParameterTypes();
        if (param.length==0){
            return null;
        }
        ArrayList<Object> param_f = new ArrayList<>();
        System.out.println("---| Definindo parametros : |---");
        for (Class<?> p: param) {
            String pa ="";
            Object t = null;
            if (p.isPrimitive()){
                String type = p.getCanonicalName();
                System.out.printf("|-> "+type+" :");
                pa = sc.nextLine();
                switch (type){
                    case "double":
                        t = Double.parseDouble(pa);
                        break;
                    case "integer":
                        t = Integer.parseInt(pa);
                        break;
                    case "String":
                        t = pa;
                        break;
                    default:
                        t = null;
                        break;
                }
                param_f.add(t);
            }else{
                String sp = p.getCanonicalName();
                sp = sp.replace(p.getPackageName()+".","");
                System.out.println("| "+sp+" | ");
                param_f.add(create_obj(p));
            }
        }
        Object ob = null;
        Object[] objects = param_f.toArray(new Object[param_f.size()]);
        try {
            ob = choosen.newInstance(objects);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("|---->|"+q.getSimpleName()+"| = "+ob);
        return ob;
    }
    private static void show_class(Object q1) {
        show_class(q1.getClass());
    }
    private static void show_class(Class q) {
// (interfaces, superclasses, construtores, métodos, atributos.
        String p = q.getPackageName();
        String nome = q.getSimpleName();
        Constructor tmp[] = q.getConstructors();
        LinkedList<String> metodos =  new LinkedList<>();
        Method tmp_m[] = q.getDeclaredMethods();
        for (Method m :tmp_m
             ) {
            String a = "public "+m.getAnnotatedReturnType().getType().getTypeName()+" "+m.getName()+"(";
            Class cl[] = m.getParameterTypes();
            int cont = 0;
            for ( Class c: cl ) {
                cont++;
                a += c.getName()+" param"+cont+" ";
            }
            a += "){...}";
            metodos.add(a);
        }

        LinkedList<String> construtores= new LinkedList<>();

        String pck = "package "+q.getPackageName()+";";
        String t = "";
        for (Constructor c:tmp
        ) {
            String n = c.getName();
            n = n.replace(q.getPackageName()+".","");
            t +="\tpublic "+n+"(";
            Class cl[] = c.getParameterTypes();
            int cnt = 0;
            for (Class tmpc: cl
            ) {
                cnt++;
                if (cl.length == cnt){
                    t += tmpc.getName().replace(q.getPackageName()+".","")+" param"+cnt+"){...}\n";
                    break;
                }
                t += tmpc.getName().replace(q.getPackageName()+".","")+" param"+cnt+" ,";
            }


        }
        System.out.println();
        System.out.println(pck);
        System.out.println("public class "+nome+"{");
        System.out.println(t);
        for (String s :metodos
             ) {
            System.out.println("\t"+s);
        }
        System.out.println("}");
        System.out.println();
    }

}
