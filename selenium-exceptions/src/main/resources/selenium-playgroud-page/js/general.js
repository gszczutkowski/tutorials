function showAlertAfterRandomTime() {
    waitInMilliSecondsBeforeShowAlert = Math.floor(((Math.random() * 2) + 1) * 500);
    setTimeout(function () {
        $('#append-banner-after').prepend('<div id="success-alert" class="alert alert-success alert-dismissable"><a href="#" class="close" data-dismiss="alert" aria-label="close">×</a><strong>Success!</strong> This alert box could indicate a successful or positive action.</div>');
    }, waitInMilliSecondsBeforeShowAlert);
}