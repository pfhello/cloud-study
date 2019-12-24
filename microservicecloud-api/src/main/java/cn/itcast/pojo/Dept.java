package cn.itcast.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@AllArgsConstructor //全参构造
@NoArgsConstructor //无参构造
@Data //get,set等方法
@Accessors(chain = true) //链式编程
public class Dept implements Serializable {

    private Long deptno;

    private String dname;

    private String dbSource;
    //来自哪个数据库,因为微服务可以一个服务对应一个数据库,同一个信息被存储到不同的数据库

}
