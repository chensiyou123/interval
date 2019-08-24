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
}