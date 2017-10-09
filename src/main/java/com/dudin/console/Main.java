package com.dudin.console;


import com.dudin.Dao.TestEntityDao;
import com.dudin.service.TestEngine;

public class Main {

    public static void main(String[] args) {
        TestEntityDao tmpTest = new TestEntityDao();
        TestEngine test1 = new TestEngine();
        test1.runTest(tmpTest.getTestEntity());
    }

}



