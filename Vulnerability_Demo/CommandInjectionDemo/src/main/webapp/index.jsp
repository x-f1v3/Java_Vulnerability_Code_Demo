<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style>
    .center {
        display: block;
        margin-left: auto;
        margin-right: auto;
        width: 50%;
    }

    body {
        background-size: 100% 100%;
        line-height: 0.8;
    }



    .upload-btn-wrapper {
        position: relative;
        overflow: hidden;
        display: inline-block;
    }

    .upload-btn-wrapper input[type=file] {
        font-size: 500px;
        position: absolute;
        width: 1024px;
        height: 512px;
        left: -50%;
        top: 0;
        opacity: 0;
    }


</style>

<head>

</head>

<body>
<h1 style="text-align: center; font-size:50px; margin-top:50px; ">PING功能<h1>
    <h1 style="text-align: center; font-size:30px; margin-top:50px;">使用ping功能检查网络</h1>
    <div class="center">
        <form  class="center" action="/CommandInjection" method="get" style="width:512px">

            <a class="center" >输入地址：<input  type="text" name="command" ></a>

            <input  class="center" type="submit"  name="submit" >
        </form>

    </div>


    <div class="center">

    </div>

</body>


</html>
