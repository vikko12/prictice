package com.vikko.demo.code.year2021.month7.batchQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.LinkedBlockingQueue;
import org.apache.commons.collections.CollectionUtils;

public class LotteryJoinQueue<T> {
    private static final int MAX_CANCLE_TIMES = 5;
    private static final int MAX_QUEUE_LENGTH = 100;
    private LinkedBlockingQueue<T> basket = new LinkedBlockingQueue<T>(MAX_QUEUE_LENGTH);
    private final QueueGo queueGo;
    private ReConnectService reConnectService;
    private  int cancleTimes = 0;
    private volatile  boolean isGo = false;

    public LotteryJoinQueue(QueueGo queueGo1) {
        this.queueGo = queueGo1;
        reConnectService = new ReConnectService(new ReConnectService.ReconnectInterface(){

            @Override
            public boolean re() {
                List<T> ts = popList(MAX_QUEUE_LENGTH);
                if(CollectionUtils.isEmpty(ts)) {
                    cancleTimes++;
                    if(cancleTimes == MAX_CANCLE_TIMES) {
                        isGo = false;
                        return true;
                    }
                }
                else {
                    queueGo.go(ts);
                }
                return false;
            }
        },2);
    }

    public T pop() {
        try {
            return basket.remove();
        }
        catch (NoSuchElementException e) {
            return null;
        }

    }

    public List<T> popList(int number) {
        if(basket.isEmpty()) {
            return null;
        }
        List<T> ts= new ArrayList<>(number);
        for(int i=0;i < number;i++) {
            try {
                ts.add(basket.remove());
            }
            catch (NoSuchElementException e) {
                break;
            }
        }
        return ts;
    }

    public void push(T t) {
        if(isGo==false) {
            isGo = true;
            reConnectService.reconnect();
        }
        try {
            basket.add(t);
        }catch (IllegalStateException e) {
            queueGo.go(popList(basket.size()));
            push(t);
        }
    }



    public interface QueueGo {
        public boolean go(Object content);
    }
}

