package com.github.nange.security.generator.service;

import com.github.nange.security.common.util.Query;
import com.github.nange.security.generator.mapper.GeneratorMapper;
import com.github.nange.security.generator.utils.GeneratorUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

/**
 * 代码生成器
 */
@Service
public class GeneratorService {
    @Autowired
    private GeneratorMapper generatorMapper;

    public List<Map<String, Object>> queryList(Query query) {
        Map<String, Object> map = new HashMap<>(16);
        map.put("offset", query.getPage() - 1);
        map.put("limit", query.getLimit());
        map.putAll(query);
        return generatorMapper.queryList(map);
    }

    public int queryTotal(Map<String, Object> map) {
        return generatorMapper.queryTotal(map);
    }

    public Map<String, String> queryTable(String tableName) {
        return generatorMapper.queryTable(tableName);
    }

    public List<Map<String, String>> queryColumns(String tableName) {
        return generatorMapper.queryColumns(tableName);
    }

    public byte[] generatorCode(String[] tableNames, String path, String mainModule, String author, String tablePrefix) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);

        for (String tableName : tableNames) {
            //查询表信息
            Map<String, String> table = queryTable(tableName);
            //查询列信息
            List<Map<String, String>> columns = queryColumns(tableName);
            //生成代码
            GeneratorUtils.generatorCode(table, columns, zip, author, path, mainModule,tablePrefix);
        }
        IOUtils.closeQuietly(zip);
        return outputStream.toByteArray();
    }
}
