package com.sjh.code.codegenerator.test;

import com.sjh.code.codegenerator.simple.entity.TestEntity;

/**
 * @author sjh
 * @Description: TODO
 * @date 2018/12/18 21:35
 */
public class Test3 {
    public static void main(String[] args) {
        TestEntity testEntity = new TestEntity();
        testEntity.setname("name");
        System.out.println(testEntity.getname());
    }
}
