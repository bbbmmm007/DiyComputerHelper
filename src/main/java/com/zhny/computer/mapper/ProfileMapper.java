package com.zhny.computer.mapper;

import com.zhny.computer.entity.AdminProfile;
import com.zhny.computer.entity.UserProfile;

public interface ProfileMapper {
    Void saveUConfig(UserProfile userProfile);
    UserProfile showUConfig(Integer uid);
    Void saveAConfig(AdminProfile adminProfile);
    UserProfile showAConfig();
    Integer deleteAConfig(Integer id);
    Integer deleteUConfig(Integer uid);
    UserProfile findConfigByUid(Integer uid);
}
