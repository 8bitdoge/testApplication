package com.dudin.service;

import com.dudin.dao.DBCPDataSourceFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class AnswersChecking {

    public float checkAnswers(Map<String, String> answersMap) {
        float result = 0;
        HashMap<String, String> dbMap = new HashMap<>();
        DBCPDataSourceFactory dataSourceFactory = new DBCPDataSourceFactory();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = dataSourceFactory.getDataSource("mysql").getConnection();
            statement = connection.createStatement();

            String sqlCheck = "SELECT * FROM answer WHERE correct_answer=1;";

            ResultSet correctSet = statement.executeQuery(sqlCheck);

            while (correctSet.next()) {
                int question_id = correctSet.getInt("question_id");
                String questionID = question_id + "";
                String option = correctSet.getString("option");
                dbMap.put(questionID, option);
            }

            if (dbMap.equals(answersMap)) {
                result = answersMap.size() / answersMap.size() * 100;
            } else {
                for (String key1: dbMap.keySet()) {
                    for (String key2: answersMap.keySet()) {
                        if (Objects.equals(key1, key2)) {
                            if (Objects.equals(dbMap.get(key1), answersMap.get(key2))){
                                result++;
                            }
                        }
                    }
                }
                result = result / answersMap.size() * 100;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
