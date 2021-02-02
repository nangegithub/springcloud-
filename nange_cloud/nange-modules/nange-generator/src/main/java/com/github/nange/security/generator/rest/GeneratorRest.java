package com.github.nange.security.generator.rest;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.nange.security.common.msg.TableResultResponse;
import com.github.nange.security.common.util.Query;
import com.github.nange.security.generator.config.SwitchDB;
import com.github.nange.security.generator.service.GeneratorService;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/code/generator")
public class GeneratorRest {

    @Autowired
    private GeneratorService generatorService;

    @Autowired
    private SwitchDB switchDB;

    @Autowired
    private List<DruidDataSource> source;

    /**
     * 列表
     */
    @ResponseBody
    @RequestMapping("/dbs")
    public TableResultResponse<String> getDbList() {
        return new TableResultResponse(new Long(source.size()), source.stream().map(DruidDataSource::getName).collect(Collectors.toList()));
    }

    /**
     * 列表
     */
    @ResponseBody
    @RequestMapping("/page")
    public TableResultResponse<Map<String, Object>> list(@RequestParam Map<String, Object> params) {
        String dbName = String.valueOf(params.get("dbName"));
        switchDB.change(dbName);
        Query query = new Query(params);
        List<Map<String, Object>> result = generatorService.queryList(query);
        int total = generatorService.queryTotal(query);
        return new TableResultResponse(total, result);
    }

    /**
     * 生成代码
     */
    @RequestMapping("/build")
    public void code(String tables, String path, String mainModule, String author, String dbName, String tablePrefix, HttpServletResponse response) throws IOException {
        if (StringUtils.isNoneBlank(tables)) {
            switchDB.change(dbName);
            byte[] data = generatorService.generatorCode(tables.split(","), path, mainModule, author, tablePrefix);
            response.reset();
            response.setHeader("Content-Disposition", "attachment; filename=\"generator-code.zip\"");
            response.addHeader("Content-Length", "" + data.length);
            response.setContentType("application/octet-stream; charset=UTF-8");
            IOUtils.write(data, response.getOutputStream());
        }
    }
}
