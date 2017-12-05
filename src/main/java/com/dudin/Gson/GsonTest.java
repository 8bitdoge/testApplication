package com.dudin.Gson;

import com.dudin.Dao.JDBCDAO;
import com.dudin.model.TestEntity;
import com.dudin.service.TestEngine;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by 8bitdoge on 16.11.2017.
 */
public class GsonTest {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public TestEntity getGsonTest(String testNumber) {
        JDBCDAO tmpTest = new JDBCDAO();

        return tmpTest.getTestEntity(testNumber);
    }
}
