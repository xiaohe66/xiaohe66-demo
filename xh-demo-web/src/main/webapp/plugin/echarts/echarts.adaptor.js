/**
 * 图表控件
 *
 * @author xh
 * @date 18-01-25 025
 */
(function($){

    var getEchartsObj = function($this){
        if($this.echartObj === undefined){
            $this.echartObj = echarts.init($this);
        }
        return $this.echartObj;
    };

    //柱状图
    var bar = function ($this) {
        var options = $this.echartOptions;
        var adaptor = options.adaptors;

        var dataObj = JSON.parse(adaptor.data);
        var values = [];
        var names = [];
        $.each(dataObj,function(dataI,data){
            values.push(data[adaptor.value]);
            names.push(data[adaptor.name]);
        });

        var param = options.other;
        if(param === undefined){
            param = {};
        }
        param.title = {text:options.title,subtext:options.subtitle};
        param.tooltip= {};
        param.legend= {data:[adaptor.legend]};
        param.xAxis= {data:names};
        param.yAxis= {};
        param.series= {
            name:adaptor.legend,
            type:options.type,
            data:values
        };
        getEchartsObj($this).setOption(param);
    };

    //饼图
    var pie = function ($this) {
        var options = $this.echartOptions;
        console.log(options);
        var adaptor = options.adaptors;

        var dataObj = JSON.parse(adaptor.data);
        var names = [];
        var seriesData = [];
        $.each(dataObj,function(dataI,data){
            var value = data[adaptor.value];
            var name = data[adaptor.name];
            names.push(name);
            seriesData.push({
                name:name,
                value:value
            });
        });

        var param = options.other;
        if(param === undefined){
            param = {};
        }
        param.title = {text:options.title,subtext:options.subtitle,x:'center'};
        param.tooltip = {trigger: 'item'};
        param.legend= {type: 'scroll',orient: 'vertical',right: 10,top: 20,bottom: 20,data:names};
        param.series= {name:adaptor.legend,type:options.type,data:seriesData};
        getEchartsObj($this).setOption(param);
    };

    //折线图
    var line  = function ($this) {
         bar($this);
    };

    /**
     * 使用switch判断对不同图表的方法调用并不好
     * 因为在类型越来越多时，代码会变得冗余
     * todo:需要修改根据type判断调用不同方法的实现逻辑
     * @param $this
     */
    var dispatch = function($this){
        switch($this.echartOptions.type){
            case "bar":
                bar($this);
                break;
            case "pie":
                pie($this);
                break;
            case "line":
                line($this);
                break;
            default :
                alert("未定义该类型");
        }
    };

    $.fn.echarts = function(options){
        this[0].echartOptions = options;
        dispatch(this[0]);
    };

    $.fn.echartsType = function(type){
        var $this = this[0];
        var param = $this.echartOptions;
        if(param === undefined){
            alert("控件未初始化，请先初始化");
            return;
        }
        param.type = type;
        dispatch($this);
    };
})(jQuery);