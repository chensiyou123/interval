
var loadLayer;
/**
 * 普通提示框
 * @param msg 提示消息
 */
function openAlert(msg) {
    return layer.msg(msg);
}

/**
 * ajax请求
 * @param url 请求后台地址
 * @param type 请求类型{post，put，delete，get}
 * @param dataType：请求数据类型{json}
 * @param data 参数
 * @param callBack 回调函数
 */
function commonAjax(url, type, dataType, data, callBack) {
    if (!type) {
        type = 'POST';
    }
    if (!dataType) {
        dataType = 'json';
    }
    $.ajax({
        url: url,
        type: type,
        dataType: dataType,
        data: data,
        /*headers: {
           "Content-Type":"application/json"
        },*/
        success: function (data) {
            if (callBack) {
                var func = eval(callBack);
                func.call(func, data);
                layer.close(loadLayer);
            }
        },
        error: function () {
            layer.close(loadLayer);
            openAlert("网络错误，请稍后重试");
        }
    });
}
