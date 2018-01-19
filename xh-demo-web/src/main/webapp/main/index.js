/**
 * Created by xh on 18-1-11 011.
 */
var data = [
    {name:"name",urls:[
        {name:"百度",url:"www.baidu.com"}
        ,{name:"百度",url:"www.baidu.com"}
        ,{name:"百度",url:"www.baidu.com"}
        ,{name:"百度",url:"www.baidu.com"}
        ,{name:"百度",url:"www.baidu.com"}
        ,{name:"百度",url:"www.baidu.com"}
        ,{name:"百度",url:"www.baidu.com"}
        ,{name:"百度",url:"www.baidu.com"}
        ,{name:"百度",url:"www.baidu.com"}
    ]}
    ,{name:"外国",urls:[
        {name:"谷歌",url:"www.baidu.com"}
        ,{name:"谷歌",url:"www.baidu.com"}
        ,{name:"谷歌",url:"www.baidu.com"}
        ,{name:"谷歌",url:"www.baidu.com"}
        ,{name:"谷歌",url:"www.baidu.com"}
        ,{name:"谷歌",url:"www.baidu.com"}
        ,{name:"谷歌",url:"www.baidu.com"}
        ,{name:"谷歌",url:"www.baidu.com"}
        ,{name:"谷歌",url:"www.baidu.com"}
    ]}
];
var itemHtml;
var tdHtml;
var rootObj;
$(function () {
    init();
    showData();
});
function init() {
    rootObj = $(".root");
    var tbody = rootObj.find("tbody");
    tdHtml = tbody.find("tr").html();
    tbody.html("");
    itemHtml = rootObj.html();
    rootObj.html("");
}
function showData() {
    var item,tr,td,tbody,count;
    $.each(data,function(index,i){
        rootObj.append(itemHtml);
        item = rootObj.find(".item:last");
        item.find(".title").text(i.name);
        tbody = item.find("tbody");
        count = 5;
        $.each(i.urls,function (index,j) {
            if(count++ === 5){
               tbody.append("<tr class='line'></tr>");
               count = 1;
               tr = tbody.find("tr:last");
            }
            tr.append(tdHtml);
            td = tr.find("td:last");
            // td.find("img").attr("src","https://gss0.bdstatic.com/5eR1dDebRNRTm2_p8IuM_a/res/img/baiduzhongban-4.gif?1515808540");
            var a = td.find("a");
            a.attr("href",j.url);
            a.text(j.name);
            // td.find("span").text(j.name);
        });
    });
}

var isEdit = false;
function edit(menu) {
    if(isEdit = !isEdit){
        $(menu).attr("src","ok.png");
        $(".mask").show();
        $(menu).parents(".item").css("z-index",10);
    }else{
        $(menu).attr("src","rack.png");
        $(".mask").hide();
        $(menu).parents(".item").css("z-index",0);
    }

}