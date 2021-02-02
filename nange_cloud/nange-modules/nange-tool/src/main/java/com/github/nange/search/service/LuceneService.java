package com.github.nange.search.service;


import com.github.nange.security.api.vo.search.IndexObject;
import com.github.nange.security.common.msg.TableResultResponse;

public interface LuceneService {

    void save(IndexObject indexObject);

    void update(IndexObject indexObject);

    void delete(IndexObject indexObject);

    void deleteAll();

    TableResultResponse page(Integer pageNumber, Integer pageSize, String keyword);
}
