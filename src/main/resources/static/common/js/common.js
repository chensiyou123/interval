var SUCCESS_CODE = "000000";//成功返回码
var loadLayer;
//注册键盘事件
document.onkeydown = function (e) {
    //捕捉回车事件
    var ev = (typeof event != 'undefined') ? window.event : e;
    if (ev.keyCode == 13 && document.activeElement.className.indexOf("am-btn") >= 0) {
        return false;//禁用amazui按钮回车事件
    } else if (ev.keyCode == 27 && parent.layer) {//可以通过ESC键退出当前弹出窗口
        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
        parent.layer.close(index); //再执行关闭
    }
}

function checkAll(obj) {
    $("input[type=checkbox]").each(function () {
        $(this).prop("checked", obj.checked);
    });
}

function isEmpty(obj) {
    if (typeof(obj) == "undefined") {
        return true;
    }
    if (obj == null) {
        return true;
    }
    if (obj == '') {
        return true;
    }
    return false;
}

/**
 * 通用ajax方法调用
 * @param url 请求路径
 * @param type 默认'POST'
 * @param dataType 默认 'json'
 * @param data 参数
 * @param callBack 回调函数名 ep：toModCallBack(data)
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

function getBrowserInfo() {
    var browserInfo = {};
    var ua = navigator.userAgent.toLowerCase();
    var s;
    (s = ua.match(/msie ([\d.]+)/)) ? browserInfo.ie = s[1]
        : (s = ua.match(/firefox\/([\d.]+)/)) ? browserInfo.firefox = s[1]
        : (s = ua.match(/chrome\/([\d.]+)/)) ? browserInfo.chrome = s[1]
        : (s = ua.match(/opera.([\d.]+)/)) ? browserInfo.opera = s[1]
        : (s = ua.match(/version\/([\d.]+).*safari/)) ? browserInfo.safari = s[1] : 0;
    return browserInfo;
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
    });
}

/**
 * 打开加载框
 * @param ts 毫秒数
 * @param type
 */
function openLoad() {
    return layer.load(0, {shade: false});
}

/**
 * 普通提示框
 * @param msg 提示消息
 */
function openAlert(msg) {
    return layer.msg(msg);
}

/**
 * 询问框
 * @param msg
 * @param callBack
 */
function openConfirm(msg, callBack) {

    layer.open({
        content: msg
        , btn: ['确定', '取消']
        , yes: function (index) {
            if (callBack) {
                var func = eval(callBack);
                func.call(func, index);
            }
            layer.close(index);
        }
    });
}

/**
 * 在弹出的iframe页面关闭自身
 * @returns
 */
function closeIfreamLayer(){
    var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
    parent.layer.close(index); //再执行关闭
}

function logout() {
    commonAjax("/web/login/logout","GET",null,null,"logoutCallBack")
}
function logoutCallBack(data) {
    openAlert(data.msg);
    if (data.code == 0){
        setTimeout(function(){window.location.href="/web/login/toLogin";},1000)
    }
}
