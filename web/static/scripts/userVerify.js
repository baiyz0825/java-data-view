$(function () {//加载完页面加载脚本
    $("#submitBtn").click(function () {//添加单击事件
        let username = $("#username").val();
        let password = $("#password").val();
        let passwordRepeat = $("#passwordRepeat").val();
        let number = $("#number").val();
        let verifyCode = $("#verifyCode").val();
        let regExpUserName = /^\w{4,15}$/;//正则表达式匹-配位密码（字母开头 A-Z 0~9 a-z允许符号）
        let regExpPhoneNumber = /(13|14|15|18)[0-9]{9}/;//匹配中国手机号，手机号以13 14 15 18 开头11位
        let regExpPassword = /^[a-zA-Z]\w{5,17}$/;//匹配账户是否合法字母开头，长度在6~18之间，只能包含字母、数字和下划线
        //校验用户名
        if (!regExpUserName.test(username)) {
            $("#errorMsg").text("用户名非法！")
            return false;
        }
        //校验密码空值
        else if (password == null || password === "") {
            $("#errorMsg").text("请输入密码！")
            return false;
        }
        //校验密码
        else if (!regExpPassword.test(password)) {
            $("#errorMsg").text("密码强度太弱！")
            return false;
        }
        //校验密码第二次
        else if (password !== passwordRepeat) {
            $("#errorMsg").text("密码不一致！")
            return false;
        }
        //校验电话号码与验证码
        else if ((number !== "") && !regExpPhoneNumber.test(number)) {
            $("#errorMsg").text("电话号码错误！")
            return false;
        }
        //校验验证码
        else if (verifyCode === "") {
            $("#errorMsg").text("验证码错误！")
            return false;
        }
        //跳转
        else {
            // alert("跳转！");
        }
    })
})

