/**
 * Created by yzc on 2017/5/19.
 */

function test1(event) {
    var dropText = document.getElementById("type").innerHTML;
    var topicType = "";
    if (dropText == "交流")
        topicType = "1";
    else if (dropText == "招人")
        topicType = "2";
    else if (dropText == "求组")
        topicType = "3";
    else {
        alert("请选择一个帖子类型！");
        return;
    }

    var cnt = 0;
    var tagList = "";
    var strFlag = "true";
    for (var i = 1; i <= 15; i++) {
        var temp = document.getElementById(i);
        if (temp.className == "tag-label-select") {
            cnt++;
            if (strFlag == "true") {
                tagList += temp.text;
                strFlag = "false";
            }
            else
                tagList += ("," + temp.text);
        }
    }
    if (cnt > 5) {
        alert("技术方向不能多于5个！");
        return;
    }
    if (cnt == 0) {
        alert("技术方向至少选择1个！");
        return;
    }

    var titleText = $('#title').val();
    titleText = titleText.replace(/ /g, "");
    if (titleText.length < 3) {
        alert("标题内容不能少于3个字！");
        return;
    }

    // 取得HTML内容
    var contentText = editor.html();
    contentText = contentText.replace(/&nbsp;/g, " ");
    if (contentText.length < 10) {
        alert("帖子内容不能少于10个字！");
        return;
    }

    console.log("type : " + topicType);
    console.log("tag : " + tagList);
    console.log("title : " + titleText);
    console.log("content : " + contentText);

    $.ajax({
        type: "POST",
        url: "localhost:8080/postTopic",
        data: {
            type : topicType,
            tag : tagList,
            title : titleText,
            content : contentText
        },
        dataType: "json",
        success: function(data){
            var resData=$.parseJSON(data);
            /*$.each(data.name, function(i, item){
                var id=item.id;

            });*/
            var result = resData.result;
            if (result == "true") {
                alert("发布帖子成功！即将返回论坛页面！");
                window.location.href = "blog.html";
            }
            else {
                alert("发布帖子失败！请检查网络或稍后重试！");
            }
        },
        error: function(e) {
            alert("发布帖子失败！请检查网络或稍后重试！");
        }
    });
}

function test(event) {
    if (event.className == "tag-label") {
        event.className ="tag-label-select";
    }
    else
        event.className ="tag-label";
}

function customdropdown(ele){

    this.dropdown=ele;
    this.placeholder=this.dropdown.find(".placeholder");
    this.options=this.dropdown.find("ul.dropdown-menu > li");
    this.val='';
    this.index=-1;//默认为-1;
    this.initevents();
}
customdropdown.prototype={
    initevents:function(){
        var obj=this;


        //点击下拉列表的选项
        obj.options.on("click",function(){
            var opt=$(this);
            obj.text=opt.find("a").text();
            obj.val=opt.attr("value");
            obj.index=opt.index();
            obj.placeholder.text(obj.text);
        });
    },
    gettext:function(){
        return this.text;
    },
    getvalue:function(){
        return this.val;
    },
    getindex:function(){
        return this.index;
    }
}
$(document).ready(function(){
    var mydropdown=new customdropdown($("#dropdown1"));
});
