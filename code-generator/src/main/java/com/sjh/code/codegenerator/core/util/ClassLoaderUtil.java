package com.sjh.code.codegenerator.core.util;

/**
 * @author sjh
 * @Description: 类加载器工具类
 * @date 2018/12/15 15:23
 */
public class ClassLoaderUtil {

    private final ClassLoader classLoader;

    private static ClassLoaderUtil classLoaderUtil = new ClassLoaderUtil();

    private ClassLoaderUtil() {
        this.classLoader = new FileClassLoader();
    }

    public static ClassLoaderUtil instance() {
        return classLoaderUtil;
    }

    public Class<?> loadClass(String classPath) {
        try {
            return classLoader.loadClass(classPath);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
