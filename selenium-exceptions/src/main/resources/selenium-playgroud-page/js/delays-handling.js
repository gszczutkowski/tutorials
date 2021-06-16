var progressBar = document.getElementById("progress-section");
var pageContent = document.getElementById("page-content");

function increaseProgressBarValue() {
    var elem = document.getElementById("progress-bar");
    var width = 0;
    var id = setInterval(frame, 100);
    function frame() {
        if (width >= 100) {
            clearInterval(id);
            showContentHideBar();
        } else {
            width=width+10;
            elem.style.width = width + '%';
            elem.innerHTML = width + '%';
        }
    }
}

function showContentHideBar(){
    progressBar.style.display = "none";
    pageContent.style.display = "block";
}

function filterDataWithDelay() {
    setTimeout(function () {
        var input, filter, table, tr, td, i;
        input = document.getElementById("search-names-input");
        filter = input.value.toUpperCase();
        table = document.getElementById("country-table");
        tr = table.getElementsByTagName("tr");
        for (i = 0; i < tr.length; i++) {
            td = tr[i].getElementsByTagName("td")[0];
            if (td) {
                if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                    tr[i].style.display = "";
                } else {
                    tr[i].style.display = "none";
                }
            }
        }
    }, 3000);
}

increaseProgressBarValue();