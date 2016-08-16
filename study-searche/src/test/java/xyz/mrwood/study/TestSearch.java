/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study;

import com.aliyun.opensearch.CloudsearchClient;
import com.aliyun.opensearch.CloudsearchSearch;
import com.aliyun.opensearch.object.KeyTypeEnum;
import org.junit.Test;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/**
 * 项目：study-java
 * 包名：xyz.mrwood.study
 * 功能：
 * 时间：2016-08-07 12:36
 * 作者：Mr.Kiwi
 */
public class TestSearch {

    @Test
    public void testS() throws IOException {

        String accesskey= "I9yti3iA1G7yd6ey";
        String secret =   "L9cHLbwMXtI3AHZGriHZ74roG9mJvy";
        String appName =  "fs_liquidation_platform_test";
        String host = "http://opensearch-cn-hangzhou.aliyuncs.com";
        Map<String, Object> opts = new HashMap<String, Object>();

        // 这里的host需要根据访问应用详情页中提供的的API入口来确定
        CloudsearchClient client = new CloudsearchClient(accesskey, secret , host, opts, KeyTypeEnum.ALIYUN);


        CloudsearchSearch search = new CloudsearchSearch(client);
        // 添加指定搜索的应用：
        search.addIndex("fs_liquidation_platform_test");
        // 指定搜索的关键词，这里要指定在哪个索引上搜索，如果不指定的话默认在使用“default”索引（索引字段名称是您在您的数据结构中的“索引到”字段。）
        search.setQueryString("'词典'");
        search.setQueryString("default:'词典'");
        search.setQueryString("index_name:'词典'");
        // 指定搜索返回的格式。
        search.setFormat("json");
        // 设定过滤条件
        search.addFilter("price>10");
        // 设定排序方式 + 表示正序 - 表示降序
        search.addSort("price", "+");
        // 返回搜索结果
        System.out.println(search.search());
    }

}
