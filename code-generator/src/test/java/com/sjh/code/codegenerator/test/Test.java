package com.sjh.code.codegenerator.test;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.IOException;

/**
 * @author sjh
 * @Description: TODO
 * @date 2018/12/15 15:03
 */
public class Test {
    public static void main(String[] args) {

        String fileName = "D:\\IdeaProjects\\demo\\src\\com\\sjh\\demo\\CompileTest.java";

        /**
         * ToolProvider类：该类是为查找工具提供者提供方法，例如，编译器的提供者。）
         * getSystemJavaCompiler：获取此平台提供的 Java™ 编程语言编译器。
         */
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        /**
         * getStandardFileManager： 为此工具获取一个标准文件管理器实现的新实例。
         * 参数：
         *    diagnosticListener - 用于非致命诊断信息的诊断侦听器；如果为 null，则使用编译器的默认方法来报告诊断信息
         *    locale - 格式化诊断信息时要应用的语言环境；如果为 null，则使用默认语言环境。
         *    charset - 用于解码字节的字符集；如果为 null，则使用平台默认的字符集
         * 返回：
         *    标准文件管理器
         *
         */
        StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null,null,null);
        /**
         * getJavaFileObjects：获取表示给定文件的文件对象。
         * 参数：
         *    files - 文件数组
         * 返回：
         *    文件对象列表
         */
        Iterable units = fileMgr.getJavaFileObjects(fileName);
        /**
         * getTask：使用给定组件和参数创建编译任务的 future
         * 参数：
         *    out - 用于来自编译器的其他输出的 Writer；如果为 null，则使用 System.err
         *    fileManager - 文件管理器；如果为 null，则使用编译器的标准文件管理器
         *    diagnosticListener - 诊断侦听器；如果为 null，则使用编译器的默认方法报告诊断信息
         *    options - 编译器选项；null 表示没有选项
         *    classes - 类名称（用于注释处理），null 表示没有类名称
         *    compilationUnits - 要编译的编译单元；null 表示没有编译单元
         * 返回：
         *    表示编译的对象
         */
        JavaCompiler.CompilationTask t = compiler.getTask(null,null,null,null,null,units);//编译任务
        //  开始编译
        boolean result = t.call();
        System.out.println(result);
        //  关闭“java编译器”
        try {
            fileMgr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
