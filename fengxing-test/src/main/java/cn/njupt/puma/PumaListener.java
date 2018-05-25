package cn.njupt.puma;

import com.alibaba.fastjson.JSONObject;
import com.dianping.puma.api.PumaClient;
import com.dianping.puma.api.PumaClientConfig;
import com.dianping.puma.core.dto.BinlogMessage;
import com.dianping.puma.core.event.Event;
import com.dianping.puma.core.event.RowChangedEvent;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

/**
 * Created by sunfei on 2018/5/25.
 */
@Slf4j
@Component
public class PumaListener {

    @PostConstruct
    public void init() {
        Thread pumaClientThread = new Thread(() -> {
            PumaClient pumaClient = new PumaClientConfig()
                    .setClientName("fengxing-test")
                    .setDatabase("OrderDishRecord")
                    .setTables(Lists.newArrayList("HBT_Order"))
                    .buildClusterPumaClient();

            while (!Thread.currentThread().isInterrupted()) {
                try {
                    BinlogMessage binlogMessage = pumaClient.get(1, 10, TimeUnit.SECONDS);
                    for (Event event : binlogMessage.getBinlogEvents()) {
                        if (event instanceof RowChangedEvent) {
                            System.out.println(JSONObject.toJSONString(event));
                        }
                    }
                } catch (Exception e) {
//                    log.error("error", e);
                }
            }

        });

        pumaClientThread.setName("puma-fengxing-test");

        pumaClientThread.setDaemon(true);

        pumaClientThread.start();

    }
}
