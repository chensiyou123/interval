<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>首页</title>
    <meta name="description" content="首页">
    <meta name="keywords" content="login">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="${request.contextPath }/image/favicon.png">
</head>
<body  data-type="widgets">
<#include "common/taglib.ftl">
<div class="am-g tpl-g">
    <#include "common/header.ftl">
    <#include "common/left.ftl">
    <!-- 内容区域 -->
    <!-- 内容区域 -->
    <div class="tpl-content-wrapper">
        <div class="row-content am-cf">
            <div class="row  am-cf">
                <div class="am-u-sm-12 am-u-md-6 am-u-lg-6">
                    <div class="widget widget-primary am-cf">
                        <div class="widget-statistic-header">
                            今日收入
                        </div>
                        <div class="widget-statistic-body">
                            <div class="widget-statistic-value">
                                ￥<span id="todayMoney">${Request.todayIncome}</span>
                            </div>
                            <div class="widget-statistic-description"></div>
                            <span class="widget-statistic-icon am-icon-credit-card-alt"></span>
                        </div>
                    </div>
                </div>
                <div class="am-u-sm-12 am-u-md-6 am-u-lg-6">
                    <div class="widget widget-purple am-cf">
                        <div class="widget-statistic-header">
                            今日新增用户数
                        </div>
                        <div class="widget-statistic-body">
                            <div class="widget-statistic-value">
                                <span id="todayNewUser">${Request.todayUser}</span>
                            </div>
                            <div class="widget-statistic-description">
                            </div>
                            <span class="widget-statistic-icon am-icon-support"></span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row am-cf">
                <div class="am-u-sm-12 am-u-md-6">
                    <div class="widget am-cf">
                        <div class="widget-head am-cf">
                            <div class="widget-title am-fl">近七天收入趋势</div>
                        </div>
                        <div class="widget-body-md widget-body tpl-amendment-echarts am-fr" id="echarts-money"></div>
                    </div>
                </div>
                <div class="am-u-sm-12 am-u-md-6">
                    <div class="widget am-cf">
                        <div class="widget-head am-cf">
                            <div class="widget-title am-fl">近七天新增人数趋势</div>
                        </div>
                        <div class="widget-body-md widget-body tpl-amendment-echarts am-fr" id="echarts-user">

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="${request.contextPath }/amazeui/js/jquery.min.js"></script>
<script type="text/javascript" src="${request.contextPath }/amazeui/js/amazeui.min.js"></script>
<script type="text/javascript" src="${request.contextPath }/amazeui/js/amazeui.datatables.min.js"></script>
<script type="text/javascript" src="${request.contextPath }/amazeui/js/echarts.min.js"></script>
<script type="text/javascript" src="${request.contextPath }/amazeui/js/app.js"></script>
<script type="text/javascript" src="${request.contextPath }/amazeui/js/dataTables.responsive.min.js"></script>
<script type="text/javascript" src="${request.contextPath }/amazeui/js/theme.js"></script>
<script src="${request.contextPath }/common/js/layer/layer.js"></script>
<script src="${request.contextPath }/common/js/common.js"></script>
<script type="text/javascript" src="${request.contextPath }/js/index.js"></script>
</body>
</html>