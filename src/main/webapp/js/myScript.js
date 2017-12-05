function ajaxGet() {
    var data = {"numberOfTest": $('#id1').val()};
    // alert(data.numberOfTest);
    $.ajax({
        dataType: 'json',
        type: 'GET',
        url: '/test',
        contentType: 'application/json',
        data: data
    }).done(function (data1) {
        alert(JSON.stringify(data1));
    });
}
