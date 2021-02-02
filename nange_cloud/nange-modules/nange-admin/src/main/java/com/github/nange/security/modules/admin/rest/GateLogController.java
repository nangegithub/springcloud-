package com.github.nange.security.modules.admin.rest;

import com.github.nange.security.common.msg.TableResultResponse;
import com.github.nange.security.common.rest.BaseController;
import com.github.nange.security.modules.admin.biz.GateLogBiz;
import com.github.nange.security.modules.admin.entity.GateLog;
import com.github.pagehelper.PageHelper;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.mapper.entity.Example;
@Controller
@RequestMapping("gateLog")
public class GateLogController extends BaseController<GateLogBiz, GateLog> {
    @RequestMapping(value = "/pageByOrder",method = RequestMethod.GET)
    @ResponseBody
    public TableResultResponse<GateLog> page(@RequestParam(defaultValue = "10") int limit, @RequestParam(defaultValue = "1")int offset, String name){
        Example example = new Example(GateLog.class);
        if(StringUtils.isNotBlank(name)) {
            example.createCriteria().andLike("menu", "%" + name + "%");
        }
        int count = baseBiz.selectCountByExample(example);
        PageHelper.startPage(offset, limit);
        return new TableResultResponse<GateLog>(count,baseBiz.selectByExample(example));
    }
}
