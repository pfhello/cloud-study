package cn.itcast.service;

import cn.itcast.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component //放入容器
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable cause) {
        return new DeptClientService() {
            @Override
            public boolean add(Dept dept) {
                return false;
            }

            @Override
            public Dept get(Long id) {
                return new Dept().setDeptno(id).setDname("该ID"+id+"没有对应的信息null")
                .setDbSource("no this database in mysql");
            }

            @Override
            public List<Dept> list() {
                return null;
            }

            @Override
            public boolean update(Dept dept) {
                return false;
            }

            @Override
            public Object discovery() {
                return null;
            }
        };
    }
}
