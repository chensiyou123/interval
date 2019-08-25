<div class="left-sidebar">
    <ul class="sidebar-nav">
        <#if Session.userType = 0>
            <li class="sidebar-nav-link">
                <a href="/web/main/index" <#if Request.checkUrl = 'index'>class="active"</#if> >
                    <i class="am-icon-home sidebar-nav-link-logo"></i> 首页
                </a>
            </li>
            <#if Session.user.roleId = 0>
                <li class="sidebar-nav-link">
                    <a href="/web/school/index" <#if Request.checkUrl = 'schoolIndex'>class="active"</#if> >
                        <i class="am-icon-hospital-o sidebar-nav-link-logo"></i> 学校管理
                    </a>
                </li>
                <li class="sidebar-nav-link">
                    <a href="/web/adminUser/index" <#if Request.checkUrl = 'adminIndex'>class="active"</#if> >
                        <i class="am-icon-female sidebar-nav-link-logo"></i> 学校管理员管理
                    </a>
                </li>
                <li class="sidebar-nav-link">
                    <a href="/web/order/index" <#if Request.checkUrl = 'orderIndex'>class="active"</#if> >
                        <i class="am-icon-mortar-board sidebar-nav-link-logo"></i> 订单查看
                    </a>
                </li>
                <li class="sidebar-nav-link">
                    <a href="/web/vipLayer/index" <#if Request.checkUrl = 'viplayerIndex'>class="active"</#if> >
                        <i class="am-icon-mortar-board sidebar-nav-link-logo"></i> 分成查看
                    </a>
                </li>
            </#if>
            <li class="sidebar-nav-link">
                <a href="/web/subject/index" <#if Request.checkUrl = 'subjectIndex'>class="active"</#if> >
                    <i class="am-icon-mortar-board sidebar-nav-link-logo"></i> 学科管理
                </a>
            </li>
            <li class="sidebar-nav-link">
                <a href="javascript:;" class="sidebar-nav-sub-title">
                    <i class="am-icon-book sidebar-nav-link-logo"></i> 题集管理
                    <span class="am-icon-chevron-down am-fr am-margin-right-sm sidebar-nav-sub-ico"></span>
                </a>
                <ul class="sidebar-nav sidebar-nav-sub"
                    <#if Request.checkUrl = 'chapterIndex'>style="display: block;"
                    <#elseif Request.checkUrl = 'auditIndex'>style="display: block;"
                        </#if>>
                    <li class="sidebar-nav-link">
                        <a href="/web/chapter/index" <#if Request.checkUrl = 'chapterIndex'>class="active"</#if> >
                            <i class="am-icon-mortar-board sidebar-nav-link-logo"></i> 章节管理
                        </a>
                    </li>
                    <li class="sidebar-nav-link">
                        <a href="/web/section/auditIndex" <#if Request.checkUrl = 'auditIndex'>class="active"</#if> >
                            <i class="am-icon-mortar-board sidebar-nav-link-logo"></i> 题集审核
                        </a>
                    </li>
                </ul>
            </li>
            <li class="sidebar-nav-link">
                <a href="javascript:;" class="sidebar-nav-sub-title">
                    <i class="am-icon-bookmark sidebar-nav-link-logo"></i> 随时学
                    <span class="am-icon-chevron-down am-fr am-margin-right-sm sidebar-nav-sub-ico"></span>
                </a>
                <ul class="sidebar-nav sidebar-nav-sub"
                        <#if Request.checkUrl = 'adminAuditIndex'>
                    style="display: block;"
                        </#if>>
                    <li class="sidebar-nav-link">
                        <a href="/web/anyTime/adminAuditIndex" <#if Request.checkUrl = 'adminAuditIndex'>class="active"</#if> >
                            <i class="am-icon-mortar-board sidebar-nav-link-logo"></i> 卡片审核
                        </a>
                    </li>
                </ul>
            </li>
            <li class="sidebar-nav-link">
                <a href="javascript:;" class="sidebar-nav-sub-title">
                    <i class="am-icon-gear sidebar-nav-link-logo"></i> 设置
                    <span class="am-icon-chevron-down am-fr am-margin-right-sm sidebar-nav-sub-ico"></span>
                </a>
                <ul class="sidebar-nav sidebar-nav-sub"
                        <#if Request.checkUrl = 'updatePass'>
                            style="display: block;"
                        <#elseif Request.checkUrl = 'vipSet'>
                            style="display: block;"
                        <#elseif Request.checkUrl = 'bannerIndex'>
                            style="display: block;"
                        <#elseif Request.checkUrl = 'reportIndex'>
                            style="display: block;"
                        <#elseif Request.checkUrl = 'appUplode'>
                            style="display: block;"
                        </#if>
                >
                    <li class="sidebar-nav-link">
                        <a href="/web/login/toUpdatePass" <#if Request.checkUrl = 'updatePass'>class="active"</#if> >
                            <span class="am-icon-lock sidebar-nav-link-logo"></span> 修改密码
                        </a>
                    </li>
                    <li class="sidebar-nav-link">
                        <a href="/web/vip/vipSet" <#if Request.checkUrl = 'vipSet'>class="active"</#if> >
                            <span class="am-icon-lock sidebar-nav-link-logo"></span> 会员设置
                        </a>
                    </li>
                    <li class="sidebar-nav-link">
                        <a href="/web/banner/index" <#if Request.checkUrl = 'bannerIndex'>class="active"</#if> >
                            <span class="am-icon-lock sidebar-nav-link-logo"></span> banner 设置
                        </a>
                    </li>
                    <li class="sidebar-nav-link">
                        <a href="/web/banner/appUplode" <#if Request.checkUrl = 'appUplode'>class="active"</#if> >
                            <span class="am-icon-lock sidebar-nav-link-logo"></span> APP上传
                        </a>
                    </li>
                    <li class="sidebar-nav-link">
                        <a href="/web/report/index" <#if Request.checkUrl = 'reportIndex'>class="active"</#if> >
                            <span class="am-icon-lock sidebar-nav-link-logo"></span> 错误反馈
                        </a>
                    </li>
                </ul>
            </li>
         <#elseif Session.userType = 1>
             <li class="sidebar-nav-link">
                 <a href="/web/section/toUserSectionList" <#if Request.checkUrl = 'userSectionIndex'>class="active"</#if> >
                     <i class="am-icon-home sidebar-nav-link-logo"></i> 题集上传
                 </a>
             </li>
             <li class="sidebar-nav-link">
                 <a href="/web/anyTime/userAnyTimeIndex" <#if Request.checkUrl = 'userAnyTimeIndex'>class="active"</#if> >
                     <i class="am-icon-home sidebar-nav-link-logo"></i> 随时学上传
                 </a>
             </li>
        </#if>

    </ul>
</div>