$(function() {

    $('#login-form-link').click(function(e) {
        $("#register-form").delay(100).fadeIn(100);
        $('#register-form-link').removeClass('active');
        $(this).addClass('active');
        e.preventDefault();
    });
    $('#register-form-link').click(function(e) {
        $("#register-form").delay(100).fadeIn(100);
        $('#register-form').removeClass('active');
        $(this).addClass('active');
        e.preventDefault();
    });

});