package com.github.nange.security.modules.admin.vo;

import com.alibaba.fastjson.JSONObject;
import com.github.nange.security.common.vo.TreeNode;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class AccessRouteTree extends TreeNode implements Serializable {
    String name;
    String icon;
    String path;
    String component;
    String componentPath;
    /**
     * "meta": {
     * "title": "系统设置",
     * "cache": true
     * }
     */
    JSONObject meta;

    List<AccessRouteTree> nodes = new ArrayList<AccessRouteTree>();


    @Override
    public void setChildren(List<TreeNode> children) {
        super.setChildren(children);
        nodes = new ArrayList<AccessRouteTree>();
    }

    @Override
    public void add(TreeNode node) {
        super.add(node);
        AccessRouteTree n = new AccessRouteTree();
        BeanUtils.copyProperties(node, n);
        nodes.add(n);
    }
}
