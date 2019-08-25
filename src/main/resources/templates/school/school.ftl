<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>学校管理</title>
    <meta name="description" content="学校管理">
    <meta name="keywords" content="login">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="${request.contextPath }/image/favicon.png">
</head>
<body data-type="widgets">
<#include "../common/taglib.ftl">
<div class="am-g tpl-g">
    <#include "../common/header.ftl">
    <#include "../common/left.ftl">
    <!-- 内容区域 -->
    <div class="tpl-content-wrapper">
        <input type="hidden" id="total" value="${Request.total}">
        <div class="row-content am-cf">
            <div class="row">
                <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
                    <div class="widget am-cf">
                        <!--标题-->
                        <div class="widget-head am-cf">
                            <div class="widget-title  am-cf">学校列表</div>
                        </div>
                        <div class="widget-body  am-fr">
                            <!--新增-->
                            <div class="am-u-sm-12 am-u-md-6 am-u-lg-6">
                                <div class="am-form-group">
                                    <div class="am-btn-toolbar">
                                        <div class="am-btn-group am-btn-group-xs">
                                            <button type="button" class="am-btn am-btn-default am-btn-success" onclick="javaScript:add()"><span class="am-icon-plus"></span> 新增</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!--查询-->
                            <div class="am-u-sm-12 am-u-md-12 am-u-lg-3">
                                <div class="am-input-group am-input-group-sm tpl-form-border-form cl-p">
                                    <input type="text" class="am-form-field school-name">
                                    <span class="am-input-group-btn">
            <button class="am-btn  am-btn-default am-btn-success tpl-table-list-field am-icon-search" type="button" onclick="javaScript:search()"></button>
          </span>
                                </div>
                            </div>
                            <!--列表-->
                            <div class="am-u-sm-12">
                                <table width="100%" class="am-table am-table-compact am-table-striped tpl-table-black " id="example-r">
                                    <thead>
                                    <tr>
                                        <th>id</th>
                                        <th>学校名称</th>
                                        <th>状态</th>
                                        <th>时间</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody id="tableData">
                                    </tbody>
                                </table>
                            </div>
                            <!--分页-->
                            <div class="am-u-lg-12 am-cf">
                                <div class="row">
                                    <div class="page-container"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="${request.contextPath }/common/js/layer/layer.js"></script>
    <script src="${request.contextPath }/common/js/common.js"></script>
    <script src="${request.contextPath }/common/js/pagination.js"></script>
    <script type="text/javascript" src="${request.contextPath }/js/school/school.js"></script>
</div>
</body>
</html>