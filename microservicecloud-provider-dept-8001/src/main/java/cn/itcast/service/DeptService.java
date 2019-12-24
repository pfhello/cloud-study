package cn.itcast.service;

import cn.itcast.pojo.Dept;

import java.util.List;

public interface DeptService {

    public int add(Dept dept);

    public int updateDeptById(Dept dept);

    public Dept get(Long id);

    public List<Dept> list();

}
