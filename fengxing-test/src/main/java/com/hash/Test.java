package com.hash;

/**
 * Created by sunfei on 2018/7/2.
 */
public class Test {

    public static void main(String[] args) {
        Cluster cluster = new ConsistencyHashCluster();
        cluster.addNode(new Node("c" + 5 + ".yywang.info", "192.168.0." + 5));
        cluster.addNode(new Node("c" + 6 + ".yywang.info", "192.168.0." + 6));
        System.out.println();
    }
}
