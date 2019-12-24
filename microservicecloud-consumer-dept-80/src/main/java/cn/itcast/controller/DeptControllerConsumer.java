package cn.itcast.controller;


import cn.itcast.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptControllerConsumer {

    /**
     * 使用restTemplate访问restful接口
     * (url,requestMap,ResponseBean.class)表示http的请求地址,请求参数,返回值类型
     */
    @Autowired
    private RestTemplate restTemplate;

    //private static final String REST_URL_PREFIX="http://127.0.0.1:8001";
    private static final String REST_URL_PREFIX="http://MICROSERVICECLOUD-DEPT";

    @RequestMapping(value = "/consumer/dept/add",method = RequestMethod.POST)
    public boolean add(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add",dept,boolean.class);
    }

    @RequestMapping(value = "/consumer/dept/get/{id}",method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id,Dept.class);
    }

    @RequestMapping(value = "/consumer/dept/list",method = RequestMethod.GET)
    public List<Dept> list(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);
    }

    @RequestMapping(value = "/consumer/dept/update",method = RequestMethod.POST)
    public boolean update(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/update",dept,boolean.class);
    }

    @RequestMapping(value = "/consumer/dept/discovery",method = RequestMethod.GET)
    public Object discovery(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/discovery",Object.class);
    }


}
