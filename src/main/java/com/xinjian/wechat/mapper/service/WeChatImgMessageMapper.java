package com.xinjian.wechat.mapper.service;

import com.xinjian.wechat.pojo.service.WeChatImgMessage;

public interface WeChatImgMessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WeChatImgMessage record);

    int insertSelective(WeChatImgMessage record);

    WeChatImgMessage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WeChatImgMessage record);

    int updateByPrimaryKey(WeChatImgMessage record);
}