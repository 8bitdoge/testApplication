package com.dudin.console;


import com.dudin.Dao.JDBCDAO;
import com.dudin.Gson.GsonTest;
import com.dudin.service.TestEngine;

public class Main {

    public static void main(String[] args) {
        JDBCDAO tmpTest = new JDBCDAO();
        TestEngine test1 = new TestEngine();
        GsonTest gsonTest = new GsonTest();
        System.out.println(gsonTest.getGsonTest("1"));

    }

}



