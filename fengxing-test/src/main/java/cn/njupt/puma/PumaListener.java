package cn.njupt.puma;

import com.alibaba.fastjson.JSONObject;
import com.dianping.puma.api.PumaClient;
import com.dianping.puma.api.PumaClientConfig;
import com.dianping.puma.core.dto.BinlogMessage;
import com.dianping.puma.core.event.Event;
import com.dianping.puma.core.event.RowChangedEvent;
import com.dianping.squirrel.client.StoreKey;
import com.dianping.squirrel.client.impl.redis.RedisStoreClient;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by sunfei on 2018/5/25.
 */
//@Slf4j
//@Component
public class PumaListener {

    @Autowired
    @Qualifier("redisClient")
    private RedisStoreClient redisStoreClient;

    @PostConstruct
    public void init() {
        Thread pumaClientThread = new Thread(() -> {
            PumaClient pumaClient = new PumaClientConfig()
                    .setClientName("fengxing-test")
                    .setDatabase("OrderDishRecord")
                    .setTables(Lists.newArrayList("HBT_Order"))
                    .buildClusterPumaClient();

            long now = new Date().getTime();
            StoreKey storeKey = new StoreKey("category", "puma");
            boolean result = redisStoreClient.setnx(storeKey, now);
            if (result) {
                //获得锁，可以接收binlog
                //重启一个线程,2秒钟更新一下缓存
            } else {
                //判断是不是很久没有更新key了
                long timeStamp = redisStoreClient.get(storeKey);
                if (now - timeStamp > 10 * 6000) {
                    redisStoreClient.delete(storeKey);
                    redisStoreClient.setnx(storeKey, now);
                }
            }

            while (!Thread.currentThread().isInterrupted()) {
                try {
                    BinlogMessage binlogMessage = pumaClient.get(1, 10, TimeUnit.SECONDS);
                    for (Event event : binlogMessage.getBinlogEvents()) {
                        if (event instanceof RowChangedEvent) {
                            System.out.println(JSONObject.toJSONString(event));
                        }
                    }
                    pumaClient.ack(binlogMessage.getLastBinlogInfo());
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
