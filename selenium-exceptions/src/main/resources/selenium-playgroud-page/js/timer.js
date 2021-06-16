function updateTimerValue() {
    var parent = $( "#page-heading-timer" ).parent();
    $( "#page-heading-timer" ).remove();

    var d = new Date();
    var s = d.getSeconds();
    if (s<10) {
        s = "0"+s;
    }
    var m = d.getMinutes();
    if (m<10) {
        m = "0"+m;
    }
    var h = d.getHours();
    if (h<10) {
        h = "0"+h;
    }
    parent.prepend("<a id='page-heading-timer' class='right'>" + h + ":" + m + ":" + s + "</a>");
}

function updateLikesValue() {
    var parent = $( "#number-of-likes" ).parent();
     value = $( "#number-of-likes" ).text();
    $( "#number-of-likes" ).remove();
    value = Number(value) + 1;
    parent.prepend("<span id='number-of-likes' class='badge right'>" + value + "</span>");
};

setInterval(updateTimerValue, 1000);