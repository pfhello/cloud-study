package cn.itcast.controller;

import cn.itcast.pojo.Dept;
import cn.itcast.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    //服务发现
    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept){
        return deptService.add(dept)>0;
    }

    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    //一旦调用方法失败并返回一个错误信息后,会自动调用@HystrixCommand标注好的方法
    @HystrixCommand(fallbackMethod = "processHystrix_get")
    //Hystrix熔断机制在DeptClientService接口集中处理,解耦
    public Dept get(@PathVariable("id") Long id){
        Dept dept = deptService.get(id);
        if (dept==null){
            throw new RuntimeException("该ID"+id+"没有对应信息");
        }
        return dept;
    }

    @RequestMapping(value="/dept/list",method = RequestMethod.GET)
    public List<Dept> list(){
        return deptService.list();
    }

    @RequestMapping(value="/dept/update",method = RequestMethod.POST)
    public boolean update(@RequestBody Dept dept){
        return deptService.updateDeptById(dept)>0;
    }

    @RequestMapping(value = "/dept/discovery",method = RequestMethod.GET)
    public Object discovery(){
        List<String> list=client.getServices();
        System.out.println("------------"+list);
        List<ServiceInstance> srcList = client.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance element:srcList){
            System.out.println(element.getServiceId()+"\t"+element.getHost()+"\t"+element.getPort()+"\t"+element.getUri());
        }
        return this.client;
    }

    public Dept processHystrix_get(@PathVariable("id") Long id){
        return new Dept().setDeptno(id).setDname("该ID"+id+"没有对应的信息null")
                .setDbSource("no this database in mysql");
    }
}
