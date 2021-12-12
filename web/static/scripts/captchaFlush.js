$(function () {
    $("#img_check").click(function () {
        // 每次给请求加上时间戳，防止浏览器因为缓存而不能进行刷新验证码
        this.src = "captcha.jpg?a" + new Date();
    })
})