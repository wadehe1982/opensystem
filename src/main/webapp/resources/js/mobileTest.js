/**
 *
 */
    var myScroll;
    var scroll = $('#scroll');
    var scroll_wrapper = $('#scroll_wrapper');
    // $(document).ready(function(){
        // loaded();
    // });
   function pullUpAction() {
        console.log("pullUpAction");
        setTimeout(function() {
            for ( i = 0; i < 3; i++) {
                scroll.append("xxx: " + i);
            }
        }, 1000);
        myScroll.refresh();
    }
    
    function scrollStart(){
        console.log("scrollStart");
    }

    function loaded() {
        console.log("loaded");
        myScroll = new IScroll('#scroll_wrapper', {
            // probeType : 1,
            // mouseWheel : true,
            // scrollbars : true
            scrollbars: true,
    mouseWheel: true,
    interactiveScrollbars: true,
    shrinkScrollbars: 'scale',
    fadeScrollbars: false,
    checkDOMChanges: true
        });
        myScroll.on('scrollStart',function(){console.log("start");});
        myScroll.on('scrollEnd',function(){console.log("end");});
        
    }
document.addEventListener('touchmove', function(e) {e.preventDefault();}, false);

  
