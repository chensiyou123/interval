<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <meta name="description" content="登录页面">
    <meta name="keywords" content="login">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="${request.contextPath }/image/favicon.png">
</head>
<body data-type="login">
<#include "common/taglib.ftl">
<div class="am-g tpl-g">
    <div class="tpl-login">
        <div class="tpl-login-content">
            <div class="tpl-login-logo"></div>
            <form class="am-form tpl-form-line-form">
                <div class="am-form-group">
                    <input type="text" class="tpl-form-input" id="account" placeholder="请输入账号">
                </div>
                <div class="am-form-group">
                    <input type="password" class="tpl-form-input" id="password" placeholder="请输入密码">
                </div>
                <div class="am-form-group">
                    <button type="button" class="am-btn am-btn-primary  am-btn-block tpl-btn-bg-color-success  tpl-login-btn" onclick="login()">提交</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script type="text/javascript" src="${request.contextPath }/amazeui/js/jquery.min.js"></script>
<script type="text/javascript" src="${request.contextPath }/amazeui/js/amazeui.min.js"></script>
<script type="text/javascript" src="${request.contextPath }/amazeui/js/app.js"></script>
<script type="text/javascript" src="${request.contextPath }/amazeui/js/theme.js"></script>
<script src="${request.contextPath }/common/js/layer/layer.js"></script>
<script src="${request.contextPath }/common/js/common.js"></script>
<script type="text/javascript" src="/js/login.js"></script>
</body>
</html>