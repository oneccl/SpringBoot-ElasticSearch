package com.cc.springbootelasticsearch.controller;

import com.cc.springbootelasticsearch.entity.Blog;
import com.cc.springbootelasticsearch.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: CC
 * E-mail: 203717588@qq.com
 * Date: 2023/2/2
 * Time: 14:34
 * Description:
 */

@RestController
public class BlogController {

    @Autowired
    private BlogService blogService;

    // 1、文档操作

    // 添加一个文档
    @RequestMapping("add.do")
    public Object add(){
        Blog blog = new Blog(9999L, "Elastic Search", "Elastic Search学习笔记", "Tom", "Java", 1, "9999", new Date(), null);
        return blogService.saveDocs(blog);
    }

    // 添加多个文档
    @RequestMapping("addMore.do")
    public Object addMore(Integer n){
        List<Blog> blogs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            blogs.add(new Blog(1000L+i, "Spring Boot", "Spring Boot学习笔记"+i, "Jack", "Spring", 0, "100"+i, new Date(), null));
        }
        return blogs;
    }

    // 修改单个文档
    @RequestMapping("edit.do")
    public Object edit(){
        Blog blog = new Blog(9999L, "Elastic Search(已修改)", "Elastic Search学习笔记(已修改)", "Tom", "Spring Data(已修改)", 1, "9999", new Date(), new Date());
        return blogService.saveDocs(blog);
    }

    // 查找单个文档
    @RequestMapping("find.do")
    public Object find(Long id){
        return blogService.findDocs(id);
    }

    // 查找所有文档
    @RequestMapping("findAll.do")
    public Object findAll(){
        return blogService.findAll();
    }

    // 删除文档
    @RequestMapping("remove.do")
    public Object remove(Long id){
        blogService.delDocs(id);
        return "successfully！";
    }

    // 删除所有文档
    @RequestMapping("rmAll.do")
    public Object rmAll(){
        blogService.delAll();
        return "successfully！";
    }

    // 2、搜索操作

    // 自定义方法：根据标题和内容查询，并分页、排序
    @RequestMapping("search.do")
    public Object search(String title,String content,Integer pageNo){
        // 方式1：
        // 当前页，ES默认从0开始
        if (pageNo == null){
            pageNo = 1;
        }
        // 根据blogId升序
        Sort sort = Sort.by(Sort.Direction.ASC, "blogId");
        // 每页条数
        int pageSize = 5;
        // 设置分页并排序
        Pageable page = PageRequest.of(pageNo-1, pageSize, sort);
        List<Blog> blogs = blogService.findByTitleAndContent(title, content, page);
        System.out.println("*****************************");
        System.out.println("title: "+title+" content: "+content);
        blogs.forEach(System.out::println);
        System.out.println("*****************************");
        return blogs;

        // 方式2：
//        if (pageNo == null){
//            pageNo = 1;
//        }
//        Sort sort = Sort.by(Sort.Direction.ASC, "blogId");
//        int pageSize = 5;
//        Pageable page = PageRequest.of(pageNo-1, pageSize, sort);
//        // 构建器
//        QueryBuilder builder = QueryBuilders.termQuery(title, content);
//        return blogService.search(builder,page);
    }

}
