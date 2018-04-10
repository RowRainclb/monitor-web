package com.zhizus.forest.metrics.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCursor;
import com.zhizus.forest.metrics.dao.MetricChartDao;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Dempe on 2017/1/4.
 */
@Service
public class MetricChartService {

    private final static Logger LOGGER = LoggerFactory.getLogger(MetricChartService.class);

    public JSONArray groupByUri(String serviceName) {
        JSONArray array = new JSONArray();
        Document next = new Document();
        next.put("successCount", 95);
        next.put("message", "从2018年04月10日17:07:41开始一直每接入数据");
        next.put("status", "未处理");
        Document next2 = new Document();
        next2.put("message", "2018年04月10日17:07:59 接到了异常数据");
        next2.put("status", "已处理");
        array.add(next);
        array.add(next2);
        return array;
    }


}
