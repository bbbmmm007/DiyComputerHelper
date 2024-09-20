package com.zhny.computer.controller;


import com.zhny.computer.service.impl.ProfileServiceImpl;
import com.zhny.computer.service.util.JsonResult;
import com.zhny.computer.vo.ConfigRequestVO;
import com.zhny.computer.vo.ConfigResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("profiles")
public class ProfileController extends BaseController {
    @Autowired
    private ProfileServiceImpl profileService;
    @RequestMapping("addUConfig")
    public JsonResult<String> saveUserConfig(ConfigRequestVO configRequestVO,HttpSession session) {
            Integer uid = getUidFromSession(session);
            String username = getUsernameFromSession(session);
            profileService.saveUConfig(configRequestVO,uid,username);
            return new JsonResult<>(SUCCESS);
    }
    @RequestMapping("showUconfig")
    public JsonResult<ConfigResponseVO> showUserConfig(HttpSession session) {
            Integer uid = getUidFromSession(session);
            ConfigResponseVO configResponseVO = profileService.showUConfig(uid);
            return new JsonResult<>(SUCCESS,configResponseVO);
    }
}


