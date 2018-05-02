package com.xinjian.wechat.mapper.service;

import com.xinjian.wechat.pojo.service.WeChatVoiceMessage;

public interface WeChatVoiceMessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WeChatVoiceMessage record);

    int insertSelective(WeChatVoiceMessage record);

    WeChatVoiceMessage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WeChatVoiceMessage record);

    int updateByPrimaryKey(WeChatVoiceMessage record);
}