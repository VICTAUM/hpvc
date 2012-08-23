    $(document).ready(function(){
        var y_fixo = $(".menu-principal").offset().top;
        $(window).scroll(function () {
            var fixoOffset = y_fixo+$(document).scrollTop()+"px";
            $(".menu-principal").animate({
                top: fixoOffset},{duration:250,queue:false}
            );
        });
    });
