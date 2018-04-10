package com.zhizus.forest.metrics.dao;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
//import com.zhizus.forest.metrics.gen.MetaConfig;
//import com.zhizus.forest.metrics.gen.MetaReq;
import org.bson.BasicBSONObject;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dempe on 2017/1/5.
 */
@Repository
public class MetricChartDao {

    private final static Logger LOGGER = LoggerFactory.getLogger(MetricChartDao.class);


    @Value("${mongo.database}")
    private String dbName;

    @Autowired
    private MongoClient mongoClient;

    private MongoDatabase db;

    @PostConstruct
    public void init() {
        this.db = mongoClient.getDatabase(dbName);
    }
}
