function add() {
    openWin("/web/school/addPage","新增页面")
}
function search() {
    schoolName = $(".school-name").val();
    sendRequest(0,schoolName,pageSize);
}

function sendRequest(index,schoolName,pageSize) {
    var data={
        "index":index ,
        "schoolName":  schoolName,
        "pageSize" : pageSize
    }
    openLoading = openLoad();
    commonAjax("/web/school/list",null,null,data,'schoolListReponse')
}