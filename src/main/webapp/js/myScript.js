var testObj, answersObj={};

function ajaxGet() {
    var data = {"numberOfTest": $('#id1').val()};
    $.ajax({
        dataType: 'json',
        type: 'GET',
        url: '/test',
        contentType: 'application/json',
        data: data
    }).done(function (data1) {
        // alert(JSON.stringify(data1));
        testObj = data1;
        $("#testDiv").html("<p>" + "The name of this test is - " + testObj.testName + "</p>");
    });
}

// function getQuestions() {
//
//     $("#showQuestionsBtn").click(function() {
//         $("#showQuestionsBtn").hide("slow");
//         for (var i = 0; i < testObj.questions.length; i++){
//             $("#Questions").append("<p>" + testObj.questions[i].question + "</p>");
//         }
//     });
// }

function getQuestions() {
    // var tmpClassID = testObj.questions[question]["id"];
    $("#questionsDiv").hide("slow", function () {
        var qID=0;
        for (var question in testObj.questions) {
            var tmpQuestionID = testObj.questions[question]["id"];
            var thatQuestion = testObj.questions[question]["question"];
            if (testObj.questions.hasOwnProperty(question)) {
                $('#Questions').append("<p id='"+tmpQuestionID+"'>" + thatQuestion + "</p>");
            }

            for (var answer in testObj.questions[question]["answerList"]) {
                var option = testObj.questions[question]["answerList"][answer]["answer"];
                if (testObj.questions[question]["id"] == testObj.questions[question]["answerList"][answer]["question_id"]) {
                    $('#Questions').append("<span>" + option + "</span>").append("<span><input type='radio' id='"+option+"' name='"+tmpQuestionID+"' value='"+option+"'></input></span>");
                }

            }
            qID++;
        }
    });
}

function checkAnswers() {
    var names = {};
    var arrChoises=[], arrQuestionsNums=[];
    $('input:radio').each(function() { // find unique names
        names[$(this).attr('name')] = true;
    });
    var count = 0;
    $.each(names, function() { // then count them
        count++;
    });
    if($('input:radio:checked').length == count) {
        // alert("все кнопки отмечены");
        for (var question in testObj.questions) {
            arrChoises.push($('input[name='+testObj.questions[question]["id"]+']:checked').val());//было +testObj.questions[question]["id"]+
            arrQuestionsNums = $.map($("#Questions p[id]"), function(n, i) {
                return n.id;
            });
        }
        // alert(JSON.stringify(arrChoises));
        // alert(JSON.stringify(arrQuestionsNums));
        if (arrChoises.length == arrChoises.length) {
            for (var i=0; i<arrQuestionsNums.length; i++) {
                answersObj[arrQuestionsNums[i]] = arrChoises[i];
            }
            $.ajax({
                data: JSON.stringify(answersObj),
                url: '/test',
                type: 'POST',
                dataType: 'json',
                contentType: 'application/json'
            }).done(function (d) {
                alert("вы набрали " + Math.round(d) + "% ответов");
             });
        } else {
            alert("Число ответов не равно числу вопросов!");
        }
        // alert(JSON.stringify(answersObj));

    } else {
        alert("не все кнопки отмечены");
    }
}
