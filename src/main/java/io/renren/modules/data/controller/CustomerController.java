package io.renren.modules.data.controller;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.common.utils.R;
import io.renren.modules.data.entity.Customer;
import io.renren.modules.data.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

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

    @RequestMapping("list")
    public R list(@RequestParam Map<String,Object> params){
        List<Customer> customers = customerService.queryList(params);
        int total = customerService.queryListCount(params);
        //查询列表数据
        Query query = new Query(params);
        PageUtils page = new PageUtils(customers, total, query.getLimit(), query.getPage());
        return R.ok().put("page",page);
    }
}
