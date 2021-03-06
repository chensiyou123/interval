<header>
    <!-- logo -->
    <div class="am-fl tpl-header-logo">
        <a href="/"><img src="${request.contextPath}/image/logob.png" alt=""></a>
    </div>
    <!-- 右侧内容 -->
    <div class="tpl-header-fluid">
        <!-- 侧边切换 -->
        <div class="am-fl tpl-header-switch-button am-icon-list">
            <span></span>
        </div>
        <!-- 其它功能-->
        <div class="am-fr tpl-header-navbar">
            <ul>
                <!-- 欢迎语 -->
                <li class="am-text-sm tpl-header-navbar-welcome">
                    <a href="javascript:;">欢迎你, <span>${Session.user.nickName}</span> </a>
                </li>
                <!-- 退出 -->
                <li class="am-text-sm">
                    <a href="javascript:logout();">
                        <span class="am-icon-sign-out"></span> 退出
                    </a>
                </li>
            </ul>
        </div>
    </div>
</header>