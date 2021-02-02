package com.github.nange.security.modules.admin.vo;


import com.github.nange.security.modules.admin.entity.User;

import java.util.List;

public class GroupUsers {
    List<User> members ;
    List<User> leaders;

    public GroupUsers() {
    }

    public GroupUsers(List<User> members, List<User> leaders) {
        this.members = members;
        this.leaders = leaders;
    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public List<User> getLeaders() {
        return leaders;
    }

    public void setLeaders(List<User> leaders) {
        this.leaders = leaders;
    }
}
