  $(function(){
      var data = $('#test').data("menu");
      if(data == 'home'){
          $('#home-tab-li').siblings("li").removeClass("active");
          $('#home-tab-li').addClass("active");
      }else if(data == 'profile'){
          $('#profile-tab-li').siblings("li").removeClass("active");
          $('#profile-tab-li').addClass("active");
      }else{
          $('#home-tab-li').siblings("li").removeClass("active");
          $('#home-tab-li').addClass("active");
      }
        $('#home-tab').click(function(){
             $('#myTabs').data("menu","home-tab-li");
             // $('#home-tab-li').siblings("li").removeClass("active");
             // $('#home-tab-li').addClass("active");
             location.href="test-home";
        });
        $('#profile-tab').click(function(){
            $('#myTabs').data("menu","profile-tab-li");
            // $('#profile-tab-li').siblings("li").removeClass("active");
            // $('#profile-tab-li').addClass("active");
            location.href="test-profile";
        });
  });
