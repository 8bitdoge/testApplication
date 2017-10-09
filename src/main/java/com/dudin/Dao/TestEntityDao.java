package com.dudin.Dao;

import com.dudin.model.Answer;
import com.dudin.model.Question;
import com.dudin.model.TestEntity;

import java.util.ArrayList;
import java.util.List;

public class TestEntityDao {

    public TestEntity getTestEntity() {
        List<Question> questions1 = new ArrayList<Question>();

        List<Answer> answers1 = new ArrayList<Answer>();
        List<Answer> answers2 = new ArrayList<Answer>();
        List<Answer> answers3 = new ArrayList<Answer>();


        Answer option1 = new Answer(1, "1");
        Answer option2 = new Answer(2, "2");
        Answer option3 = new Answer(3, "3");
        Answer option4 = new Answer(4, "4");

        Answer option11 = new Answer(1, "Moscow");
        Answer option22 = new Answer(2, "Tokyo");
        Answer option33 = new Answer(3, "London");
        Answer option44 = new Answer(4, "New York");

        Answer option111 = new Answer(1, "red");
        Answer option222 = new Answer(2, "green");
        Answer option333 = new Answer(3, "blue");
        Answer option444 = new Answer(4, "white");

        answers1.add(option1);
        answers1.add(option2);
        answers1.add(option3);
        answers1.add(option4);

        answers2.add(option11);
        answers2.add(option22);
        answers2.add(option33);
        answers2.add(option44);

        answers3.add(option111);
        answers3.add(option222);
        answers3.add(option333);
        answers3.add(option444);


        Question question1 = new Question(1, "2*2 = ?", answers1, option4);
        Question question2 = new Question(2, "Capital of Russia?", answers2, option11);
        Question question3 = new Question(3, "What color is absent on flag of US?", answers3, option222);


        questions1.add(question1);
        questions1.add(question2);
        questions1.add(question3);


        TestEntity testEntity = new TestEntity(1, "<<<-- TEST -->>>", questions1);


        return testEntity;
    }
}
