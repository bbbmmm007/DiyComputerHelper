package com.zhny.computer.service;

import com.zhny.computer.vo.ConfigRequestVO;
import com.zhny.computer.vo.ConfigResponseVO;

public interface PrifileService {
    void saveUConfig(ConfigRequestVO configRequestVO,Integer uid,String username);
    ConfigResponseVO showUConfig(Integer uid);
    Integer deleteUConfig(Integer uid);
}
