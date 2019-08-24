package com.interval.service.service.impl;

import com.interval.service.dao.AdminUserDao;
import com.interval.service.dao.SchoolDao;
import com.interval.service.dao.UserDao;
import com.interval.service.enumeration.RoleTypeEnum;
import com.interval.service.enumeration.UserStatusEnum;
import com.interval.service.enumeration.UserTypeEnum;
import com.interval.service.model.AdminUserEntity;
import com.interval.service.model.SchoolEntity;
import com.interval.service.model.UserEntity;
import com.interval.service.service.AdminUserService;
import com.interval.service.utils.MD5;
import com.interval.service.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
@Slf4j
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private AdminUserDao adminUserDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private SchoolDao schoolDao;
    @Override
    public R login(Map map, HttpServletRequest request) {
        //1.根据用户信息查询管理员
        map.put("password",MD5.md5(MapUtils.getString(map,"password")));
        List<AdminUserEntity> adminUserEntitys = adminUserDao.query(map);
        if (CollectionUtils.isEmpty(adminUserEntitys)){
            //2.管理员为空查询普通用户
            Map params = new HashMap();
            params.put("phone", MapUtils.getString(map,"account"));
            List<UserEntity> userList = userDao.query(params);
            if (CollectionUtils.isEmpty(userList) || (!StringUtils.equals(userList.get(0).getPassword(), MD5.md5(MapUtils.getString(map,"password"))))){
                return R.error("用户或密码错误");
            }
            if (userList.get(0).getStatus() == UserStatusEnum.DISABLE.getValue()){
                return R.error("此账户已被禁用");
            }
            //检查用户所属学校状态
            if (!Objects.isNull(userList.get(0).getSchoolId())){
                Map school = new HashMap();
                school.put("id",adminUserEntitys.get(0).getSchoolId());
                List<SchoolEntity> schoolEntitys = schoolDao.query(school);
                if (schoolEntitys.get(0).getStatus() == 1){
                    return R.error("您的学校已被禁用，请联系管理员");
                }
                request.getSession().setAttribute("userType", UserTypeEnum.USER.getValue());
                request.getSession().setAttribute("user",userList.get(0));
                return R.ok("登录成功").put("data",0);
            }
        }else {
            if (adminUserEntitys.get(0).getStatus() == 1){
                return R.error("该账户已被禁用，请联系管理员");
            }
            //如果为学校管理员，检查此学校状态
            if (adminUserEntitys.get(0).getRoleId() == RoleTypeEnum.ADMIN.getValue()){
                if(!Objects.isNull(adminUserEntitys.get(0).getSchoolId())){
                    Map school = new HashMap();
                    school.put("id",adminUserEntitys.get(0).getSchoolId());
                    List<SchoolEntity> schoolEntitys = schoolDao.query(school);
                    if(CollectionUtils.isNotEmpty(schoolEntitys)){}
                    if (schoolEntitys.get(0).getStatus() == 1){
                        return R.error("该账户所属学校已被禁用，请联系管理员");
                    }
                }

                request.getSession().setAttribute("userType",UserTypeEnum.ADMIN.getValue());
                request.getSession().setAttribute("user",adminUserEntitys.get(0));
                return R.ok("登录成功").put("data",0);
            }
        }
        return null;
    }
}
