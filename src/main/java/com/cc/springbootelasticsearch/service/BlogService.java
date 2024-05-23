package com.cc.springbootelasticsearch.service;

import com.cc.springbootelasticsearch.dao.BlogMapper;
import com.cc.springbootelasticsearch.entity.Blog;
import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: CC
 * E-mail: 203717588@qq.com
 * Date: 2023/2/2
 * Time: 14:12
 * Description:
 */

@Service
public class BlogService {

    @Autowired
    private BlogMapper blogMapper;

    // 添加一个文档
    // 修改一个文档
    // 方法相同，若id已存在，则修改（不能单独修改一个字段，否则其它会被赋为null）
    public Blog saveDocs(Blog blog){
        return blogMapper.save(blog);
    }

    // 添加多个文档
    public Iterable<Blog> saveAll(List<Blog> blogs){
        return blogMapper.saveAll(blogs);
    }

    // 根据id删除文档
    public void delDocs(Long id){
        blogMapper.deleteById(id);
    }

    // 删除所有文档
    public void delAll(){
        blogMapper.deleteAll();
    }

    // 根据id查询一个文档
    public Blog findDocs(Long id){
        return blogMapper.findById(id).get();
    }

    // 查询所有文档
    public Iterable<Blog> findAll(){
        return blogMapper.findAll();
    }

    // 自定义方法：根据标题和内容查询，并分页排序
    public List<Blog> findByTitleAndContent(String t, String c, Pageable p){
        return blogMapper.findByTitleAndContent(t,c,p);
    }

    // ES提供多样性查询的工具类QueryBuilders，用于生成各种类型的查询对象，例如：词条/分页、模糊、通配符等
    public Iterable<Blog> search(QueryBuilder builder,Pageable pageable){
        return blogMapper.search(builder,pageable);
    }

}
