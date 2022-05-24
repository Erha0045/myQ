/**
 *Function for delete pop up screen
 */
$('document').ready(function () {
    $('.table #deleteButton').on('click', function (event) {
        event.preventDefault();
        const href = $(this).attr('href');
        $('#deleteModal #delRef').attr('href', href);
        $('#deleteModal').modal();
    });
});