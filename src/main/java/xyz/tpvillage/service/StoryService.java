package xyz.tpvillage.service;

import xyz.tpvillage.entity.Story;

import java.util.List;

/**
 * @author: 朱兴平
 * @date: 2021/1/24
 */
public interface StoryService {

    /**
     * 获取故事列表
     * @return
     */
    List<Story> getList();
}
