/**
 * Created by Polotin on 2017/6/8.
 */
function Onload() {
    $.ajax(
        {
            type:"get",
            url:"forum/topics",
            data:{"type":1,"curNum":0,"perPage":6,"isSortByHot":0},
            datatype:"json",
            success:function (data) {
                // var obj = JSON.parse(data);
                // if(obj.result == 0){
                //     return true;
                // }else if(obj.result == 1){
                //     var err = document.getElementById("login_err1");
                //     err.innerText="账号或密码错误";
                //     return false;
                // }
                alert(data);
            },
            error:function () {
                alert("fail");
            }
        }
    )
}