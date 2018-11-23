package com.atguigu.springcloud.controller;

import com.netflix.hystrix.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptService;

@RestController
@Scope("prototype")
public class DeptController{
	@Autowired
	private DeptService service = null;
	@Autowired
	private DeptHystrix deptHystrix;

	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	//一旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
	public Dept get(@PathVariable("id") Long id)
	{
		System.out.println(this.hashCode());
		System.out.println(deptHystrix.hashCode());
	    deptHystrix.setId(id);
		return deptHystrix.execute();
	}

	@RequestMapping(value = "/test")
	public Dept test() {
		return service.get(1l);
	}

}