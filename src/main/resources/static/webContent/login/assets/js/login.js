/**
 * Created by Polotin on 2017/5/14.
 */
jQuery(function($){
    $.supersized({

        // Functionality
        slideshow               :   1,			// Slideshow on/off
        autoplay				:	1,			// Slideshow starts playing automatically
        start_slide             :   1,			// Start slide (0 is random)
        stop_loop				:	0,			// Pauses slideshow on last slide
        random					: 	0,			// Randomize slide order (Ignores start slide)
        slide_interval          :   3000,		// Length between transitions
        transition              :   1, 			// 0-None, 1-Fade, 2-Slide Top, 3-Slide Right, 4-Slide Bottom, 5-Slide Left, 6-Carousel Right, 7-Carousel Left
        transition_speed		:	1000,		// Speed of transition
        new_window				:	1,			// Image links open in new window/tab
        pause_hover             :   0,			// Pause slideshow on hover
        keyboard_nav            :   1,			// Keyboard navigation on/off
        performance				:	1,			// 0-Normal, 1-Hybrid speed/quality, 2-Optimizes image quality, 3-Optimizes transition speed // (Only works for Firefox/IE, not Webkit)
        image_protect			:	1,			// Disables image dragging and right click with Javascript

        // Size & Position
        min_width		        :   0,			// Min width allowed (in pixels)
        min_height		        :   0,			// Min height allowed (in pixels)
        vertical_center         :   1,			// Vertically center background
        horizontal_center       :   1,			// Horizontally center background
        fit_always				:	0,			// Image will never exceed browser width or height (Ignores min. dimensions)
        fit_portrait         	:   1,			// Portrait images will not exceed browser height
        fit_landscape			:   0,			// Landscape images will not exceed browser width

        // Components
        slide_links				:	'blank',	// Individual links for each slide (Options: false, 'num', 'name', 'blank')
        thumb_links				:	1,			// Individual thumb links for each slide
        thumbnail_navigation    :   0,			// Thumbnail navigation
        slides 					:  	[			// Slideshow Images
            {image : 'webContent/login/assets/img/1.jpg'},
            {image : 'webContent/login/assets/img/2.jpg'},
            {image : 'webContent/login/assets/img/3.jpg'},
            {image : 'webContent/login/assets/img/4.jpg'},
            {image : 'webContent/login/assets/img/5.jpg'}
        ],

        // Theme Options
        progress_bar			:	3,			// Timer for each slide
        mouse_scrub				:	0

    });
});

function Onload() {
    console.log(getCookie("err"));
    if(getCookie("err") != null && getCookie("err") != ""){
        document.getElementById("login_err1").innerText = "账号或密码错误";
        document.cookie="err="+"";
    }
    if(getCookie("reg_err") != null && getCookie("reg_err") != ""){
        document.getElementById("reg_err1").innerText = "注册失败";
        document.cookie="reg_err="+"";
        $('#register_area').click();
    }
}

function choose_reg(){
    document.getElementById('page-container').style.display="none";
    document.getElementById('page-container1').style.display="inline-block";

    document.getElementById('register_area').style.background="#FAFAFA";
    document.getElementById('register_area').firstElementChild.style.color="#595959";
    document.getElementById('register_area').style.opacity="100";

    document.getElementById('login_area').style.background="#3B3B3B";
    document.getElementById('login_area').firstElementChild.style.color="#B3B3B3";
    document.getElementById('login_area').style.opacity=0.3;
}

function choose_log() {
    document.getElementById('page-container1').style.display="none";
    document.getElementById('page-container').style.display="inline-block";


    document.getElementById('login_area').style.background="#FAFAFA";
    document.getElementById('login_area').firstElementChild.style.color="#595959";
    document.getElementById('login_area').style.opacity="100";

    document.getElementById('register_area').style.background="#3B3B3B";
    document.getElementById('register_area').firstElementChild.style.color="#B3B3B3";
    document.getElementById('register_area').style.opacity=0.3;
}

function getCookie(c_name)
{
    if (document.cookie.length>0)
    {
        c_start=document.cookie.indexOf(c_name + "=")
        if (c_start!=-1)
        {
            c_start=c_start + c_name.length+1
            c_end=document.cookie.indexOf(";",c_start)
            if (c_end==-1) c_end=document.cookie.length
            return unescape(document.cookie.substring(c_start,c_end))
        }
    }
    return ""
}

function check_login() {
    var email = document.getElementById("login_email").value;
    var pwd = document.getElementById("login_pwd").value;
    if(email == null || email == ""){
        var err = document.getElementById("login_err");
        err.innerText="请输入邮箱";
        return false;
    }else if(pwd == null || pwd == ""){
        var err = document.getElementById("login_err1");
        err.innerText="请输入密码";
        return false;
    }
    // else{
    //     var params={};
    //     params.id=$("#login_email").val();
    //     params.password=$("#login_pwd").val();
    //     $.ajax(
    //         {
    //             type:"post",
    //             url:"account/login",
    //             data:params,
    //             datatype:"json",
    //             success:function (data) {
    //                 var obj = JSON.parse(data);
    //                 if(obj.result == 0){
    //                     return true;
    //                 }else if(obj.result == 1){
    //                     var err = document.getElementById("login_err1");
    //                     err.innerText="账号或密码错误";
    //                     return false;
    //                 }
    //             },
    //             error:function () {
    //                 return false;
    //             }
    //         }
    //     )
        return true;
}

function validateEmail(email) {
    var atpos = email.indexOf("@");
    var dotpos = email.indexOf(".");
    if(atpos < 1 || dotpos < atpos + 2 || dotpos + 2 >= email.length){
        return false;
    }
    return true;
}

function check_reg() {
    var email = document.getElementById("reg_email").value;
    var pwd1 = document.getElementById("reg_password1").value;
    var pwd2 = document.getElementById("reg_password2").value;
    if(email == null || email == ""){
        var err = document.getElementById("reg_err");
        err.innerText="请输入邮箱";
        return false;
    }else if(!validateEmail(document.getElementById("reg_email").value)){
        var err = document.getElementById("reg_err");
        err.innerText="请输入正确的邮箱";
        return false;
    }else {
        var err = document.getElementById("reg_err");
        err.innerText="";
    }

    if(pwd1 == null || pwd1 == ""){
        var err = document.getElementById("reg_err1");
        err.innerText="请输入密码";
        return false;
    }else if(pwd1 != pwd2){
        var err = document.getElementById("reg_err1");
        err.innerText="两次输入的密码不一致";
        return false;
    }else {
        var err = document.getElementById("reg_err1");
        err.innerText="";
    }

    return true;
}

function login1(){
    var params={};
    params.id=$("#login_email").val();
    params.password=$("#login_pwd").val();
    $.ajax(
        {
            type:"post",
            url:"account/login1",
            data:params,
            datatype:"json",
            success:function (data) {
                var obj = JSON.parse(data);
                // alert(obj.result);
                if(obj.result == 0){
                    alert("login success");
                    return true;
                }else if(obj.result == 1){
                    alert("fail");
                    return false;
                }
            },
            error:function () {
                return false;
            }
        }
    )
}