package com.xinjian.wechat.mapper.service;

import com.xinjian.wechat.pojo.service.WeChatLinkMessage;

public interface WeChatLinkMessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WeChatLinkMessage record);

    int insertSelective(WeChatLinkMessage record);

    WeChatLinkMessage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WeChatLinkMessage record);

    int updateByPrimaryKey(WeChatLinkMessage record);
}