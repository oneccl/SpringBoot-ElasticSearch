package com.cc.springbootelasticsearch;

/**
 * Created with IntelliJ IDEA.
 * Author: CC
 * E-mail: 203717588@qq.com
 * Date: 2023/2/2
 * Time: 11:27
 * Description:
 */
public class DemoElasticSearch {

    // ElasticSearch
    // 简称ES，是一个开源的高扩展的分布式全文检索引擎，可以扩展到上百台服务器，处理PB级别的数据
    // ES是一个接近实时(NRT)的搜索平台(通常1s内)，就是一个索引数据库
    // ES是面向文档(Document Oriented)的，这意味着它可以存储整个对象或文档(Document)
    // ES不仅是存储，还可以索引(Index)每个文档的内容使之可以被搜索
    // 在ES中，可以对文档（而非成行成列的数据）进行索引、搜索、排序、过滤
    // 作用：通过简单的RESTful API让全文搜索变得更简单
    /*
    ElasticSearch 和 Solr 比较
    1、Solr利用Zookeeper进行分布式管理，而Elasticsearch自身带有分布式协调管理功能
    2、Solr支持更多格式的数据，而Elasticsearch仅支持json文件格式
    3、Solr官方提供的功能更多，而Elasticsearch本身更注重于核心功能，高级功能多有第三方插件提供
    4、Solr在传统的搜索应用中表现好于Elasticsearch，但在处理实时搜索应用时效率明显低于Elasticsearch
    */
    // 使用
    /*
    1、E:\tools\Elasticsearch\elasticsearch-7.6.2-windows-x86_64\elasticsearch-7.6.2\bin\elasticsearch.bat
    2、E:\tools\Elasticsearch\elasticsearch-head-master\elasticsearch-head-startup.bat
    3、http://localhost:9200/
    4、http://localhost:9100/
    */

}
