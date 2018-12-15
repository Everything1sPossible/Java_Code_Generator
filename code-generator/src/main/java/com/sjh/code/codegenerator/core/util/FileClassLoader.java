package com.sjh.code.codegenerator.core.util;

import java.io.*;

/**
 * @Description: 自定义Class文件加载器
 * @author sjh
 * @date 2018/12/15 16:18
 */
public class FileClassLoader extends ClassLoader {

    /**
     * 编写findClass方法的逻辑
     * @param name:Class文件名称,绝对路径
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        // 获取类的class文件字节数组
        byte[] classData = getClassData(name);
        if (classData == null) {
            throw new ClassNotFoundException();
        } else {
            //直接生成class对象
            return defineClass(null, classData, 0, classData.length);
        }
    }
    /**
     * 编写获取class文件并转换为字节码流的逻辑
     * @param className
     * @return
     */
    private byte[] getClassData(String className) {
        // 读取类文件的字节
        try {
            InputStream ins = new FileInputStream(className);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int bufferSize = 4096;
            byte[] buffer = new byte[bufferSize];
            int bytesNumRead = 0;
            // 读取类文件的字节码
            while ((bytesNumRead = ins.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesNumRead);
            }
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
