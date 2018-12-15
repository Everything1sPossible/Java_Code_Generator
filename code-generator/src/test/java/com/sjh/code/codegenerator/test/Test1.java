package com.sjh.code.codegenerator.test;

import com.sjh.code.codegenerator.core.util.FilePathUtil;

/**
 * @author sjh
 * @Description: TODO
 * @date 2018/12/15 21:39
 */
public class Test1 {
    public static void main(String[] args) {
        String path = "D:/IdeaProjects/code-generator/src/main/java/com/sjh/code/codegenerator/demo";
        String result = FilePathUtil.cutPathToPackage(path);
        System.out.println(result);
    }
}
