package aula12.ex3;

import java.lang.reflect.Constructor;

abstract class PluginManager {
    public static AgendaPlugin load(String name) throws Exception {
        Class<?> c = Class.forName(name);
        return (AgendaPlugin) c.newInstance();
    }
}
