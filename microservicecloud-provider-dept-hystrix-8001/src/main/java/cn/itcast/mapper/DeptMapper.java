package cn.itcast.mapper;

import cn.itcast.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptMapper {

    public int addDept(Dept dept);

    public int updateDeptById(Dept dept);

    public Dept findDeptById(Long id);

    public List<Dept> findAll();
}
