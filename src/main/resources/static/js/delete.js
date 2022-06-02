/**
 *Function for delete pop up screen
 */
$('document').ready(function () {
    $('.table #deleteButton').on('click', function (event) {
        event.preventDefault();
        const href = $(this).attr('data-deleteQueId');
        $('#deleteModal #delRef').attr('href', 'delete/'+ href);
        $('#deleteModal').modal();
    });
});