$(function () {
    $("#confirm").click(function () {
        //属性值不为空
        let bookName = $("#name").val();
        let bookNumber = $("#number").val();
        let bookSort = $("#sortBook").val();
        let bookPublisher = $("#publisher").val();
        let bookAuthor = $("#author").val();
        //正则匹配格式
        let publishData = $("#publishData").val();
        let remainNumber = $("#remainNumber").val();
        let prices = $("#prices").val();
        let regExpData = /^(^\d{4})-(0?[1-9]|1[0-2])-((0?[1-9])|((1|2)[0-9])|30|31)$/; // yyyy-mm-dd
        let regExpPrices = /^(\d{0,4})(\.\d{1,3})?$/;// 0~9999 1~3位小数
        let regExpRemainNumber = /^\d{1,5}$/; //匹配0~99999
        if (bookName == "" || bookName === "期刊名称") {
            alert("请输入期刊名称！");
            return false;
        }
        if (bookNumber == "") {
            alert("请输入期刊编号！");
            return false;
        }
        if (bookSort == "") {
            alert("请输入期刊分类！未知分类填写未分类！");
            return false;
        }
        if (bookPublisher == "") {
            alert("请输入出版社！");
            return false;
        }
        if (bookAuthor == "") {
            alert("请输入作者！");
            return false;
        } else if (!regExpData.test(publishData)) {
            alert("日期输入错误，请输入 yyyy-mm-dd");
            return false;
        } else if (!regExpPrices.test(prices)) {
            alert("价格输入格式错误！");
            return false;
        } else if (!regExpRemainNumber.test(remainNumber)) {
            alert("库存输入超过限制！0~99999");
            return false;
        }
    })
})