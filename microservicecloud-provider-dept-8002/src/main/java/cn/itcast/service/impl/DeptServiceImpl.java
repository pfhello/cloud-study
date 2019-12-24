package cn.itcast.service.impl;

import cn.itcast.mapper.DeptMapper;
import cn.itcast.pojo.Dept;
import cn.itcast.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;


    @Override
    public int add(Dept dept) {
        return deptMapper.addDept(dept);
    }

    @Override
    public int updateDeptById(Dept dept) {
        return deptMapper.updateDeptById(dept);
    }

    @Override
    public Dept get(Long id) {
        return deptMapper.findDeptById(id);
    }

    @Override
    public List<Dept> list() {
        return deptMapper.findAll();
    }
}
