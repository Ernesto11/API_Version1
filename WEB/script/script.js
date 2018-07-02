var selected_menu=function(){
    $("li").click(function() {
        $('.my-list-selected').removeClass('my-list-selected');
        $('.my-list-selected').addClass('my-list-not-selected');
        $(this).addClass('my-list-selected');
        $(this).find('.my-list-not-selected').removeClass('my-list-not-selected');
    });
};