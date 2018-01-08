'use strict'

$(document).ready(function () {

    let date = new Date()
    let month = date.getMonth() + 1
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    let strDate = date.getDay()
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    let date_result = date.getFullYear() + '-' + month + '-' + strDate
    $(".select-date").val(date_result)
    console.log(date_result)

    $("#from-place").keyup(function () {
        let text = $("#from-place").val()
        if (text === "") {
            $("#from-result").html("出发")
        } else {
            $("#from-result").html(text)
        }
    })

    $("#destination-place").keyup(function () {
        let text = $("#destination-place").val()
        if (text === "") {
            $("#destination-result").html("目的")
        } else {
            $("#destination-result").html(text)
        }
    })

    $("#switch").click(function () {
        let from = $("#from-result").html()
        let des = $("#destination-result").html()
        console.log(from, des)
        if (from !== "出发" && des !== "目的") {
            $("#from-result").html(des)
            $("#destination-result").html(from)
        }
    })


})

function isUsername() {
    if ($("input[name='username']").val() === "") {
        $(".info").html("账号不得为空！")
        $(".info").slideToggle('3000')
        setTimeout(function () {
            $(".info").slideToggle('3000')
        },1500);
    }
}

function isPassword() {
    if ($("input[name='password']").val() === "") {
        $(".info").html("密码不得为空！")
        $(".info").slideToggle('3000')
        setTimeout(function () {
            $(".info").slideToggle('3000')
        },1500);
    }
}

function isSame() {
    if ($("input[name='password']").val() !== $("input[name='repeatpassword']").val()) {
        $(".info").html("两次密码不一致！")
        $(".info").slideToggle('3000')
        setTimeout(function () {
            $(".info").slideToggle('3000')
        },1500);
    }
}

function signAction() {
    setTimeout(function () {
        $(".signaction").slideToggle('3000')
    },1500);
}