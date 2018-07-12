$(document).ready(function () {

    $('#accountsShowRef').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function (data) {

            $('.modal :checkbox').each(function () {
                var id = getId($(this).prop('id'), 'account_');
                if (data.includes(id)) $(this).prop('checked', 'checked');
                else
                    $(this).removeProp('checked');
            });

            // $('#number').attr('text', 'Number ' + data);
            console.log(data);
        });

        $('#accountsDialog').modal('show');
    });

    function getId(name, pattern) {
        return name.split(pattern)[1];
    }
});