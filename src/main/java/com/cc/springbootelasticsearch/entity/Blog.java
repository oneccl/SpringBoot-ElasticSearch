package com.cc.springbootelasticsearch.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Author: CC
 * E-mail: 203717588@qq.com
 * Date: 2023/2/2
 * Time: 11:38
 * Description:
 */

@Data  // get()、set()方法
@AllArgsConstructor
@NoArgsConstructor
// @Document：作用于实体类，标记实体类为文档对象
// 属性：indexName:索引库的名称(类似数据库表名); shards:分片数，默认5; replicas:副本数，默认1
@Document(indexName = "blog", shards = 1, replicas = 1)
public class Blog {

    // 主键id，不会写到source里面
    @Id
    private Long blogId;

    // @Filed：作用于成员变量，标记文档的字段(类似数据库表的字段)
    // 属性：type:字段类型; index:是否索引，默认true; store:是否存储，默认false
    // FieldType.Text:文本类型
    @Field(type = FieldType.Text)
    private String title;

    @Field(type = FieldType.Text)
    private String content;

    @Field(type = FieldType.Text)
    private String author;

    // 博客所属分类
    // Keyword:内容作为一个整体不可拆分，文本类型
    @Field(type = FieldType.Keyword)
    private String category;

    // 0: 未发布（草稿） 1：已发布 2：已删除
    @Field(type = FieldType.Integer)
    private int status;

    // 序列号，用于给外部展示的id
    @Field(type = FieldType.Keyword)
    private String serialNum;

    // @JsonFormat：指定格式化方式
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @Field(type= FieldType.Date, format= DateFormat.custom, pattern="yyyy-MM-dd HH:mm:ss.SSS")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    @Field(type=FieldType.Date, format=DateFormat.custom, pattern="yyyy-MM-dd HH:mm:ss.SSS")
    private Date updateTime;

}
