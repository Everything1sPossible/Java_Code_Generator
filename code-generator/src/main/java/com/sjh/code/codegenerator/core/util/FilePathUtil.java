package com.sjh.code.codegenerator.core.util;

/**
 * @author sjh
 * @Description: 文件路径处理工具类
 * @date 2018/12/15 16:36
 */
public class FilePathUtil {

    private static final String SUFFIX_CLASS = ".class";
    private static final String SUFFIX_JAVA = ".java";
    private static final String PACKAGE_WITH_SUFFix_IMPL = "/impl";
    private static final String SIMPLE_JAVA_PROJECT_PREFIX = "/src/";
    private static final String MAVEN_JAVA_PROJECT_PREFIX = "/src/main/java/";

    /**
     * @Description: 截取生成文件路径中的包路径
     */
    public static String cutPathToPackage(String filePath) {
        if (filePath == null) {
            return null;
        } else if (!filePath.contains(SIMPLE_JAVA_PROJECT_PREFIX)
                && !filePath.contains(MAVEN_JAVA_PROJECT_PREFIX)) {
            return null;
        } else {
            int prefixLength = MAVEN_JAVA_PROJECT_PREFIX.length();
            int indexOf = filePath.indexOf(MAVEN_JAVA_PROJECT_PREFIX);
            if (indexOf == -1) {
                indexOf = filePath.indexOf(SIMPLE_JAVA_PROJECT_PREFIX);
                prefixLength = SIMPLE_JAVA_PROJECT_PREFIX.length();
            }
            String result = filePath.substring(indexOf + prefixLength);
            result = result.replace("/", ".");
            return result;
        }
    }

    /**
     * @Description: 将路径中的.java后缀截取掉
     */
    public static String cutJavaSuffix(String fileName) {
        if (fileName.contains(SUFFIX_JAVA)) {
            fileName = fileName.substring(0, fileName.indexOf(SUFFIX_JAVA));
            return fileName;
        }
        return fileName;
    }

    /**
     * @Description: 路径上拼接后缀.java
     */
    public static String pathWithJavaSuffix(String path) {
        return path + SUFFIX_JAVA;
    }

    /**
     * @Description: 路径上拼接后缀.class
     */
    public static String pathWithClassSuffix(String path) {
        return path + SUFFIX_CLASS;
    }
}
