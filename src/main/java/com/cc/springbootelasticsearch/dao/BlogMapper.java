package com.cc.springbootelasticsearch.dao;

import com.cc.springbootelasticsearch.entity.Blog;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: CC
 * E-mail: 203717588@qq.com
 * Date: 2023/2/2
 * Time: 14:00
 * Description:
 */

// Dao接口继承ElasticsearchRepository接口
// ElasticsearchRepository接口间接的继承了CrudRepository接口(增删改查)
// 泛型：Blog: 实体  Long: 实体主键类型
@Repository
public interface BlogMapper extends ElasticsearchRepository<Blog,Long> {

    // 和JPA一样，ElasticSearch也可以按规则自定义方法
    // 自定义方法: 根据标题和内容查询，并分页排序
    List<Blog> findByTitleAndContent(String title, String content, Pageable page);

}
