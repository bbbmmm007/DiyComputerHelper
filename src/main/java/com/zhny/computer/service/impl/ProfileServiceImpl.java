package com.zhny.computer.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhny.computer.entity.UserProfile;
import com.zhny.computer.mapper.AdminMapper;
import com.zhny.computer.mapper.ProfileMapper;
import com.zhny.computer.service.PrifileService;
import com.zhny.computer.vo.ConfigRequestVO;
import com.zhny.computer.vo.ConfigResponseVO;
import com.zhny.computer.vo.ItemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProfileServiceImpl implements PrifileService {
    @Autowired
    private ProfileMapper profileMapper;
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private ObjectMapper objectMapper;


    @Override
    public void saveUConfig(ConfigRequestVO configRequestVO,Integer uid,String username) {
        try {
            String configData = objectMapper.writeValueAsString(configRequestVO.getItems()); // 将商品列表转换为 JSON 字符串
            Long totalPrice = configRequestVO.getTotalPrice();
            UserProfile userProfile = new UserProfile();
            userProfile.setCreatedTime(new Date());
            userProfile.setUid(uid);
            userProfile.setUsername(username);
            userProfile.setConfigData(configData);
            userProfile.setTotalPrice(totalPrice);
            profileMapper.saveUConfig(userProfile);
        } catch (JsonProcessingException e) {
            // 处理 JSON 序列化异常
            throw new RuntimeException("序列化配置数据时出错", e);
        }
    }
    @Override
    public ConfigResponseVO showUConfig(Integer uid) {
        // 从数据库获取用户配置
        UserProfile userProfile = profileMapper.findConfigByUid(uid);
        if (userProfile != null) {
            try {
                // 反序列化 JSON 字符串为 Java 对象
                List<ItemVO> configItems = objectMapper.readValue(userProfile.getConfigData(),
                        objectMapper.getTypeFactory().constructCollectionType(List.class, ItemVO.class));

                // 创建 ConfigResponseVO 用于返回配置给前端
                ConfigResponseVO configResponseVO = new ConfigResponseVO();
                configResponseVO.setItems(configItems);
                configResponseVO.setTotalPrice(userProfile.getTotalPrice());
                configResponseVO.setCreatedTime(userProfile.getCreatedTime());
                return configResponseVO;
            } catch (JsonProcessingException e) {
                // 处理 JSON 反序列化异常
                throw new RuntimeException("反序列化配置数据时出错", e);
            }
        } else {
            throw new RuntimeException("未找到用户的配置");
        }
    }



    @Override
    public Integer deleteUConfig(Integer uid) {
        return profileMapper.deleteUConfig(uid);
    }
}
