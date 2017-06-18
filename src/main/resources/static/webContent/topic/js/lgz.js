/**
 * Created by Andy on 2017/6/6.
 */

function getQueryVariable() //查询id
{
    var query = window.location.search.substring(1);
    var vars = query.split("&");
    for (var i=0;i<vars.length;i++) {
        var pair = vars[i].split("=");
        if(pair[0] == 'id'){return pair[1];}

    }
    return(false);
}

var s=100;
var a=100;
var p=100;
function add_comments(pic_url,comments,link)  //动态添加评论
{
    var box = document.createElement("div"); //首先创建一个div
    var box_id = 'p'+p;
    box.setAttribute("id",box_id); //定义该div的id
    box.setAttribute('class', 'comment-box');
    p=p+1;
    document.getElementById("commentBox").appendChild(box);

    var img = document.createElement("input"); //创建一个img
    var img_id= 's'+s;
    img.setAttribute("id",img_id); //定义该div的id
    img.setAttribute("type","image"); //设置类型
    img.setAttribute('class', 'head-img');
    img.setAttribute("src",pic_url);
    hreflink = "window.open('"+ link + "')";
    img.setAttribute("onclick",hreflink);
    s=s+1;
    document.getElementById(box_id).appendChild(img);

    var comment = document.createElement("div"); //首先创建一个div
    var comment_id = 'a'+a;
    comment.setAttribute("id",comment_id); //定义该div的id
    comment.setAttribute('class', 'comment-div');
    a=a+1;
    document.getElementById(box_id).appendChild(comment);
    document.getElementById(comment_id).innerHTML = comments;

}
var l = 100;
function add_label(labels)  //动态添加评论
{
    var label = document.createElement("label"); //首先创建一个div
    var label_id = 'l'+l;
    label.setAttribute("id",label_id); //定义该div的id
    label.setAttribute('class', 'content-type');
    l=l+1;
    document.getElementById('typeBox').appendChild(label);
    document.getElementById(label_id).innerHTML = labels;
}

function getContent() {

    content_id = getQueryVariable()
    $.ajax({
        type: "post",
        async: false,
        url: "帖子内容url",
        data: content_id,
        dataType: JSON,
        success: function(data){
            document.getElementById('c-title').innerHTML = data.title;
            document.getElementById('c-username').innerHTML = data.userName;
            document.getElementById('c-time').innerHTML = data.time;
            document.getElementById('c-content').innerHTML = data.content;
            arr=data.tag.split(";");
            for (var i=0;i<arr.length;i++)
            {
                add_label(arr[i]);
            }
            getComments(content_id,numComments);
        },
        error: function(){
        }
    });
}
var numComments = 0;
function getComments(content_id,numComments) {
    var data = {'id':content_id,'num':numComments}
    $.ajax({
        type: "post",
        async: false,
        url: "评论内容url",
        data: data,
        dataType: JSON,
        success: function(data){
            data.forEach(function(item) {
                link = "locahost:8080/test?"+item.userid;
                add_comments(item.url,item.comments,link);
            });
        },
        error: function(){
            alert("getComments error");
        }
    });
}

function test() {
    tag = "a;b;c;d;e;f"
    arr=tag.split(";");
    for (var i=0;i<arr.length;i++)
    {
        alert(arr[i]);
    }
}

function more() {
    content_id = getQueryVariable();
    getComments(content_id,numComments);
}

window.onload = function(){
    getContent();
};