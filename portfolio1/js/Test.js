jQuery(function(){
    jQuery('.main_visual').slick({
        autoplay: true,
        autoplaySpeed: 3000,
        infinite: true,
        dots: true
    });

    jQuery('.work-image').on('click', function() {
        var modalId = jQuery(this).data('modal');
        var modal = document.getElementById(modalId);
        var modalImg = modal.querySelector('.modal-content');
        modal.style.display = "block";
        modalImg.src = this.src;

        window.onclick = function(event) {
            if (event.target == modal) {
                modal.style.display = "none";
            }
        }
    });
});