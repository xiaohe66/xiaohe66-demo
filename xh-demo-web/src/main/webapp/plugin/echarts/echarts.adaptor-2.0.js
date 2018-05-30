/**
 * 图表控件
 *
 * @author xh
 * @date 18-01-25 025
 *
 * @version 2.0  18-03-12
 */
(function($){

    var un = undefined;

    var getEchartsObj = function($this){
        var obj = $($this);
        $this.echartsObj.remove();
        obj.after($this.echartsObjHtml);
        var echartsObj = $this.echartsObj = obj.next();
        echartsObj.attr("id","");
        return echarts.init(echartsObj[0]);
    };

    var jsonObj = function (data) {
        return typeof data === "string" ? JSON.parse(data) : data;
    };

    var getObj = function (map,key) {
        return map[key] === un ? map[key] = {} : map[key];
    };

    var setIfNull = function (map,key,val) {
        if(map[key] === un)map[key] = val;
    };

    var copyObj = function (source,target){
        if(source === un) return target === un ? {} : target;
        var result = target === un ? {} : target;
        for(var field in source){
            result[field] = source[field];
        }
        return result;
    };

    var getSeries = function (param) {
        var series = getObj(param,param.type+"Series");
        return copyObj(getObj(param,"seriesAdaptor"),series);
    };

    var getOption = function (param) {
        var option = getObj(param,param.type+"Option");
        return copyObj(getObj(param,"optionAdaptor"),option);
    };

    var setDefault = function ($this,seriesData) {
        var param = $this.echartParam;
        var option = getOption(param);

        var series = getSeries(param);

        var seriesArr = option.series = [];

        series.type = param.type;
        setIfNull(series,"radius",[0, 200]);

        var item = jsonObj(param.item);

        var s = 100/seriesData.length;
        $.each(seriesData,function (i,data) {
            var obj = copyObj(series);
            seriesArr.push(obj);
            if(param.type !== "radar"){
                obj.name = item[i];
                obj.center = [s*i+s*0.5+"%","50%"];
            }
            obj.data = data;
        });

        var title = getObj(option,"title");
        title.text = param.title;
        title.subtext = param.subtitle;
        setIfNull(title,"x","center");

        getEchartsObj($this).setOption(option);
    };

    var create = {
        pie : function ($this) {
            var param = $this.echartParam;

            var valuesArr = jsonObj(param.valuesArr);
            var x = jsonObj(param.xAxis);
            var item = jsonObj(param.item);

            var option = getOption(param);

            var seriesData = [];
            $.each(valuesArr,function(i,values){
                var data = [];
                seriesData.push(data);
                $.each(values,function (j,value) {
                    data.push({
                        name:x[j],
                        value:value
                    });
                });
            });

            var tooltip = getObj(option,"tooltip");
            setIfNull(tooltip,"trigger","item");

            var label = getObj(getObj(param,"pieSeries"),"label");
            setIfNull(label,"formatter","{b}{d}%");

            option.xAxis = un;
            option.yAxis = un;

            var legend = getObj(option,"legend");

            setIfNull(legend,"data",x);
            setIfNull(legend,"y","bottom");
            setIfNull(legend,"x","center");
            setIfNull(legend,"type","scroll");
            setIfNull(legend,"orient","horizontal");

            setDefault($this,seriesData);
        },
        bar : function ($this) {
            var param = $this.echartParam;

            var option = getOption(param);

            var xAxis = getObj(option,"xAxis");
            xAxis.data = jsonObj(param.xAxis);

            getObj(option,"yAxis");

            var tooltip = getObj(option,"tooltip");
            setIfNull(tooltip,"trigger","axis");
            setIfNull(getObj(tooltip,"axisPointer"),"type","shadow");

            var label = getObj(getObj(param,"barSeries"),"label");
            setIfNull(label,"formatter","{c}");
            setIfNull(label,"show",true);
            setIfNull(label,"position","top");

            var legend = getObj(option,"legend");

            setIfNull(legend,"data",jsonObj(param.item));
            setIfNull(legend,"y","center");
            setIfNull(legend,"type","scroll");
            setIfNull(legend,"orient","vertical");
            setIfNull(legend,"right",10);
            setIfNull(legend,"top",20);
            setIfNull(legend,"bottom",20);

            setDefault($this,jsonObj(param.valuesArr));
        },
        line : function ($this) {
            this.bar($this);
        },
        radar : function ($this) {
            var param = $this.echartParam;
            var option = getOption(param);

            var x = jsonObj(param.xAxis);
            var item = jsonObj(param.item);

            getObj(option,"tooltip");

            var max = param.radarMax;
            if(max === un){
                max = [];
                $.each(jsonObj(param.valuesArr),function (i, data) {
                    $.each(data,function (j,item) {
                        if(max[j] === un || max[j] < item){
                            max[j] = item*1.1;
                        }
                    });
                });
            }

            var indicator = [];
            $.each(x,function (i,value) {
                indicator.push({
                    name:value,
                    max:max[i]
                });
            });
            var radar = getObj(option,"radar");
            setIfNull(radar,"indicator",indicator);

            var dataItem = [];
            var valuesArr = jsonObj(param.valuesArr);
            $.each(valuesArr,function(i,values){
                dataItem.push({
                    name:item[i],
                    value:values
                });
            });

            var data = [];
            data.push(dataItem);

            var radarSeries = getObj(param,"radarSeries");
            // getObj(getObj(radarSeries,"areaStyle"),"normal");
            setIfNull(radarSeries,"radius",[]);

            var legend = getObj(option,"legend");
            setIfNull(legend,"data",jsonObj(param.item));
            setIfNull(getObj(option,"title"),"x","left");

            setDefault($this,data);
        }
    };

    $.fn.echarts = function(param){
        var $this = this[0];
        $this.echartsObjHtml = $this.outerHTML;
        $($this).hide();
        $this.echartsObj = $("<div style='display:none'></div>");
        $this.echartParam = param;
        create[param.type]($this);
    };

    $.fn.echartsType = function(type){
        var $this = this[0];
        var param = $this.echartParam;
        if(param === un){
            alert("控件未初始化，请先初始化");
            return;
        }
        param.type = type;
        create[type]($this);
    };
})(jQuery);