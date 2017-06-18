/**
 * Created by Polotin on 2017/6/8.
 */
function Onload() {
    $.ajax(
        {
            type:"get",
            url:"forum/topics",
            data:{"type":1,"curNum":0,"perPage":20,"isSortByHot":0},
            dataType:"json",
            success:function (data) {
                var dataJson = data;
                String.prototype.temp = function(obj) {
                    return this.replace(/\$\w+\$/gi, function(matchs) {
                        var returns = obj[matchs.replace(/\$/g, "")];
                        return (returns + "") == "undefined"? "": returns;
                    });
                };
                var htmlList = '<thead> <tr> <th>标题</th><th>作者</th><th>评论数</th><th>最后更新时间</th></tr></thead>'
                    , htmlTemp ='<tr><td><SPAN class=smallfont><STRONG><a href="detailPage">$title$</a></STRONG></SPAN></td><td>$userName$</td><td>$commentsCount$</td><td>$time$</td></tr>';
                dataJson.forEach(function(item) {
                    var tmpString = htmlTemp.temp(item);
                    tmpString = tmpString.replace("detailPage","webContent");
                    console.log(tmpString);
                    htmlList += tmpString;
                });
                $(".liebiao").html(htmlList);
            },
            error:function () {
                alert("fail");
            }
        }
    )
}