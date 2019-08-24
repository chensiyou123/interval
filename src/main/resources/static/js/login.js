$(function () {
    $('body').attr('class','theme-white')
    saveSelectColor.Color = 'theme-white';
    // 保存选择项
    storageSave(saveSelectColor);
    if (self != top){
        top.location.href = self.location.href
    }
})

function login() {
    var account = $("#account").val();
    var password = $("#password").val();
    if (account == undefined || account.length == 0){
        openAlert("请输入用户名")
        return;
    }
    if (password == undefined || password.length == 0){
        openAlert("请输入密码")
        return;
    }
    var data={
        "account":account,
        "password":password
    }
    commonAjax("/web/login/login",null,null,data,"loginBack")
}

function loginBack(res) {
    openAlert(res.msg);
    console.log("login==>")
    if (res.code == 0){
        if (res.data == 0){
            setTimeout(function(){window.location.href="/web/main/index";},1000)
        } else if (res.data == 1){
            setTimeout(function(){window.location.href="/web/section/toUserSectionList";},1000)
        }

    }
}