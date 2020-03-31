package aula12.ex2;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class PluginManager {
    public static IPlugin load(String name) throws Exception {
        Class<?> c = Class.forName(name);
       // System.out.println(c.getSimpleName());
        return (IPlugin) c.newInstance();
    }
}
