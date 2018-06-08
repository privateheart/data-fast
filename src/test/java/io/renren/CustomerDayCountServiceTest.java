package io.renren;

import io.renren.modules1.daycount.entity.DayCount;
import io.renren.modules1.daycount.service.CustomerDayCountService;
import io.renren.modules1.daycount.vo.CustomerDayCounts;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerDayCountServiceTest {

   @Autowired
   private CustomerDayCountService customerDayCountService;

    @Test
    public void test(){

        List<CustomerDayCounts> customerDayCounts = customerDayCountService.queryCustomerDayCounts(null, null, null, "Day");
        for (CustomerDayCounts cd : customerDayCounts){
            System.out.println("机器名称=="+cd.getCustomer());
            for (DayCount dayCount : cd.getDayCounts()){
                System.out.println("检测数量：" + dayCount.getFlowCount() + " 检测日期：" +dayCount.getCountDate());
            }
        }

    }

}
