package com.xinjian.wechat.mapper.service;

import com.xinjian.wechat.pojo.service.WeChatVideoMessage;

public interface WeChatVideoMessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WeChatVideoMessage record);

    int insertSelective(WeChatVideoMessage record);

    WeChatVideoMessage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WeChatVideoMessage record);

    int updateByPrimaryKey(WeChatVideoMessage record);
}