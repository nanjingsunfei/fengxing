package cn.njupt.od;

import com.dianping.cat.Cat;
import com.dianping.cat.message.Transaction;
import com.dianping.poi.enums.IShowBusinessEnum;
import com.dianping.poi.shopenrichment.DTO.ConditionDTO;
import com.dianping.poi.shopenrichment.DTO.QueuingInfoDTO;
import com.dianping.poi.shopenrichment.service.ShopEnrichmentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * Created by sunfei on 2017/12/20.
 */
public class Main {

    public static void main(String[] args) {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/appcontext-orderdish.xml");
//
//        ShopEnrichmentService shopEnrichmentService = (ShopEnrichmentService)applicationContext.getBean("shopEnrichmentService");
//        ConditionDTO conditionDTO = shopEnrichmentService.getEnrichCondition(IShowBusinessEnum.QUEUEN);
//
//        System.out.println(conditionDTO);
//        long totalCount = conditionDTO.getTotalCount();
//        long maxId = conditionDTO.getMaxId();
//        long minId = conditionDTO.getMinId();
//
//        List<QueuingInfoDTO> queuingInfoDTOs = shopEnrichmentService.getBatch(IShowBusinessEnum.QUEUEN, minId, 10l);
//        System.out.println();

        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date1 = dateFormat.parse("2017-11-12 12:23:12");
            Date date2 = dateFormat.parse("2017-11-12 12:23:40");
            Date date3 = dateFormat.parse("2017-11-12 12:23:15");
            Date date4 = dateFormat.parse("2017-11-12 12:23:32");
            List<Date> list = new ArrayList<Date>();
            list.add(date1);
            list.add(date2);
            list.add(date3);
            list.add(date4);
            Collections.sort(list, new Comparator<Date>() {
                public int compare(Date o1, Date o2) {
                    if (o1 == null || o2 == null) {
                        return 0;
                    }
                    if (o1.before(o2)) {
                        return 1;
                    } else if (o1.after(o2)) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            });

            System.out.println(list);
            Transaction transaction = Cat.newTransaction("t", "n");
            Cat.logEvent("tt", "nn");
            Transaction t2 = Cat.newTransaction("t2", "n2");
            t2.setSuccessStatus();
            t2.complete();
            transaction.setSuccessStatus();
            transaction.complete();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
