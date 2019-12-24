package cn.itcast.controller;


import cn.itcast.pojo.Dept;
import cn.itcast.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptControllerConsumer {

    @Autowired
    private DeptClientService deptClientService;

    @RequestMapping(value = "/consumer/dept/add", method = RequestMethod.POST)
    public boolean add(Dept dept) {
        return deptClientService.add(dept);
    }

    @RequestMapping(value = "/consumer/dept/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id) {
        return deptClientService.get(id);
    }

    @RequestMapping(value = "/consumer/dept/list", method = RequestMethod.GET)
    public List<Dept> list() {
        return deptClientService.list();
    }

    @RequestMapping(value = "/consumer/dept/update", method = RequestMethod.POST)
    public boolean update(Dept dept) {
        return deptClientService.update(dept);
    }

    @RequestMapping(value = "/consumer/dept/discovery", method = RequestMethod.GET)
    public Object discovery() {
        return deptClientService.discovery();
    }


}
