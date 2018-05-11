package io.renren.modules.data.controller;

import io.renren.common.utils.R;
import io.renren.modules.data.entity.Customer;
import io.renren.modules.data.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 机器管理控制器
 *
 * @author huyi
 * @create 2018/5/10 9:09
 */
@RequestMapping("customer")
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("listAll")
    public R listAll(){
        List<Customer> customers = customerService.queryAllCustomer();
        return R.ok().put("customers",customers);
    }

}
