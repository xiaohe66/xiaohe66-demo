/**
 * 记录一些js
 *
 * @author xh
 * @date 18-03-12 012
 */


/**
 * 判断是否为数组
 * @param obj
 * @returns {boolean}
 */
function isArray(obj){
    return obj instanceof Array;
}

/**
 * 复制一个obj
 * @param source    源obj
 * @param target    目标obj
 * @returns {{}}    返回一个新的obj，该obj与原obj无关联
 */
function copyObj(source,target) {
    if(source === un) return target === undefined ? {} : target;
    var result = target === undefined ? {} : target;
    for(var field in source){
        result[field] = source[field];
    }
    return result;
}