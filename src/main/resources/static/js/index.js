//推出登陆
function logout() {
    console.log("推出")
    commonAjax("/web/login/logout","GET",null,null,"logoutCallBack")
}

function logoutCallBack(data) {
    openAlert(data.msg);
    if (data.code == 0) {
        setTimeout(function () {
            window.location.href = "/web/login/toLogin";
        }, 1000)
    }
}