const indexUrl = "http://localhost:8088/JavaDataView/pages/user/logoutSuccess.html";
const errorPage = "http://localhost:8088/JavaDataView/pages/common/errprPage.html";
//
//jquery click事件相当于模拟鼠标点击，其触发的是onclick事件

function clickMouse() {
    console.log("点击");
    // $(location).attr("href", indexUrl);
    $.ajax({
        url: "user/userServlet",
        type: "GET",
        dataType: "json",
        data: {
            action: "logout"
        },
        async: false,
        success: function (data) {
            // console.log("ajax请求已发送！")
            // console.log(data.msg);
            if (data.msg === true) {
                // console.log("已跳转！")
                $(location).attr("href", indexUrl);
            } else {
                // console.log("不能跳转！")
                $(location).attr("href", errorPage);
            }
        }
    })
}