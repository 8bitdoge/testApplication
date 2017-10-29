package com.dudin.console;


import com.dudin.Dao.JDBCDAO;
import com.dudin.service.TestEngine;

public class Main {

    public static void main(String[] args) {
        JDBCDAO tmpTest = new JDBCDAO();
        TestEngine test1 = new TestEngine();
        test1.runTest(tmpTest.getTestEntity("1"));
    }

}



