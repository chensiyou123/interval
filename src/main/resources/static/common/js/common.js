
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


/**
 * 通用iframe异步加载弹出框
 * @param url
 * @param iWidth
 * @param iHeight
 */
function openWin(url, title, iWidth, iHeight) {
    //通过这种方式弹出的层，每当它被选择，就会置顶。
    if (!iWidth)iWidth = window.screen.availWidth * 0.5;//浏览器窗口70%的宽度
    if (!iHeight)iHeight = window.screen.availHeight * 0.6;//浏览器窗口80%的高度
    if (!title)title = "信息";
    var offset = window.screen.availHeight / 2 - iHeight / 2;
    return layer.open({
        title: title,
        offset: offset + 'px',
        type: 2,//0（信息框，默认）1（页面层）2（iframe层）3（加载层）4（tips层）
        shade: [0.3, '#393D49'],
        area: [iWidth + 'px', iHeight + 'px'],
        maxmin: true,
        content: url,
        success: function (layero, index) {
            $(layero).attr("title", "ESC快捷键可以退出当前窗口");
        }
    })
}
