package com.interval.service.service;
import com.interval.service.model.AppLoginModel;
import com.interval.service.utils.R;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 *
 *
 * @author nlife
 * @date 2019-01-14 20:07:26
 */
public interface AdminUserService{

    R login(Map map, HttpServletRequest request);

}

