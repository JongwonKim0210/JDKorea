$(document).ready(function () {
    setIndexOpacity();
});

// index page, banner div opacity option
function setIndexOpacity() {
    $(document).on("mouseover", "div#index_banner_area div", function () {
        $(this).animate({opacity:"0.8"}, 200);
    });
    $(document).on("mouseout", "div#index_banner_area div", function () {
        $(this).animate({opacity:"1"}, 200);
    });
}

