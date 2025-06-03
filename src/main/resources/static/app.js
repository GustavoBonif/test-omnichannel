const apiUrl = "/messages";

function carregarMensagens() {
    $.get(apiUrl, function (data) {
        $('#messagesList').empty();
        data.forEach(msg => {
            $('#messagesList').append(`<li><strong>[${msg.channel}]</strong> ${msg.content}</li>`);
        });
    });
}

$('#messageForm').on('submit', function (e) {
    e.preventDefault();
    const content = $('#content').val();
    const channel = $('#channel').val();

    $.ajax({
        url: apiUrl,
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({ content, channel }),
        success: function () {
            $('#content').val('');
            $('#channel').val('');
            carregarMensagens();
        }
    });
});

$(document).ready(function () {
    carregarMensagens();
});
