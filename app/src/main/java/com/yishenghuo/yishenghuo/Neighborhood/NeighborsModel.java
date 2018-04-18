package com.yishenghuo.yishenghuo.Neighborhood;

/**
 * @author Lian
 * @create 2018/4/18
 * @Describe 邻居数据请求接口
 */
public interface NeighborsModel {
    //批量获取邻居数据
    void getNeighbors();

    //搜索指定邻居
    void getNeighbor();

}
