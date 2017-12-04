
// disables the imsafety scrolling banner and sets it below the page as if the user already scrolled down
var active = document.getElementsByClassName("is-active");
for(var i = 0; i < active.length; ++i)
    if(active[i].classList.contains("gene-component--spotlight")){
        active[i].style="position: relative; bottom: auto;";
        active[i].classList.remove("is-active");
        $(window).unbind('scroll');
    }

// set the correct link on the right side of the imsafety banner
var seeMore = document.getElementsByClassName("spotlight-link-active");
if(seeMore.length > 0)
    seeMore[0].style="display:none;";
var backToTop = document.getElementsByClassName("spotlight-link-inactive");
if(backToTop.length > 0)
    backToTop[0].style="display:inline;";
