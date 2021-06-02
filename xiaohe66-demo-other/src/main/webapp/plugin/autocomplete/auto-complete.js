/**
 * 输入框输入时，自动检索数据并下拉显示
 * 在点击下拉的数据时，将数据填入到输入框中
 *
 * 本插件需要jQuery的支持
 * 使用说明：
 * 1.引入css和js
 	<link rel="stylesheet" href="/plugin/auto-complete/auto-complete.css" />
 	<script type="text/javascript" src="/plugin/auto-complete/auto-complete.js"></script>
 * 2.初始化
 *  假设
 *  input输入框为<input id="title"/>
 *  后台的查询url为：/autoComplete/qa.do
 *  那么初始化的语句为：
    $("#title").autoComplete("/autoComplete/qa.do");//这条语句要在文档加载完后执行
 *
 * @author xh
 * @date 18-02-02 002.
 */
(function($){
    var showData = function($this,data){
        if(data.length === 0){
            return;
        }
        var ul = $this.completeUl;
        ul.html("");
        ul.show();
        $.each(data,function(index,item){
            if(index === 5){
                return false;
            }
            ul.append("<li>"+item+"</li>");
        });

        ul.find("li").click(function () {
            $this.val($(this).html());
            ul.hide();
        });
    };

    var getData = function($this,num){
        var val = $this.inpVal;
        if(val === undefined || val === ""){
            return;
        }
        var url = $this.url;
        url += url.indexOf("?") === -1 ? "?value="+val : "&value=" + val;

        $.ajax({
            url : url,
            success:function (data) {
                //num值可以判断这条请求是否与当前输入框的值相同
                if($this.num === num){
                    showData($this,$.parseJSON(data));
                }
            },
            error:function (e) {
                // alert("err...");
            }
        });
    };

    var init = function($this,url){
        $this.inpVal = $this.val();
        $this.url = url;
        $this.after("<ul class='auto-complete-ul'></ul>");
        var ul = $this.next();
        $this.completeUl = ul;
        ul.width($this.width());
        //父最近非static定位元素到文档的距离
        var parentLeft = $this.offsetParent().offset().left;
        //input到文档的距离，
        var iLeft=$this.offset().left;
        //iLeft-parentLeft为input相对于父定位元素的偏移距离
        ul.css("left",iLeft-parentLeft+"px");
    };

    $.fn.autoComplete = function(url){
        var $this = $(this);
        //不是input时，跳出
        if(!$this.is("input")){
            return;
        }
        //初始化
        init($this,url);
        //键盘按下
        $this.keyup(function (event) {
            var newVal = $this.val();
            if($this.inpVal !== newVal){
                //定时器作用：按下半秒后再搜索
                if($this.times !== undefined){
                    clearTimeout($this.times);
                }
                $this.times = setTimeout(function(){
                    $this.completeUl.hide();
                    $this.inpVal = newVal;
                    var num = Math.random();
                    $this.num = num;
                    getData($this,num);
                },300);
            }
        });
    }

})(jQuery);