package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptService;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
@Scope("prototype")
public class DeptHystrix extends HystrixCommand<Dept> {
    private long id;

	public void setId(long id) {
		this.id = id;
	}

	public DeptHystrix() {
		super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
	}
	@Autowired
	private DeptService service = null;
	@Override
	protected Dept getFallback() {
		return new Dept().setDeptno(id).setDname("该ID：" + id + "没有没有对应的信息,null--@HystrixCommand")
				.setDb_source("no this database in MySQL");
	}

	@Override
	protected Dept run() throws Exception {
		Dept dept = service.get(id);
		if (null == dept) {
            throw new RuntimeException("该ID：" + id + "没有没有对应的信息");
        }
		return dept;
	}

}
