package com.hash;

import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.IntStream;

/**
 * Created by sunfei on 2018/7/2.
 */
public class ConsistencyHashCluster extends Cluster {

    private SortedMap<Long, Node> virNodes = new TreeMap<>();

    private static final int VIR_NODE_COUNT = 32;

    private static final String SPLIT = "#";

    public ConsistencyHashCluster() {
        super();
    }

    @Override
    public void addNode(Node node) {
        nodes.add(node);
        IntStream.range(0, VIR_NODE_COUNT)
                .forEach(index -> {
                    long hash = hash(node.getIp() + SPLIT + index);
                    virNodes.put(hash, node);
                });

    }

    @Override
    public void remove(Node node) {
        nodes.removeIf(o -> node.getIp().equals(o.getIp()));
        IntStream.range(0, VIR_NODE_COUNT)
                .forEach(index -> {
                    long hash = hash(node.getIp() + SPLIT + index);
                    virNodes.remove(hash);
                });
    }

    @Override
    public Node get(String key) {
        long hash = hash(key);
        SortedMap<Long, Node> subMap = hash > virNodes.lastKey() ? virNodes : virNodes.tailMap(hash);
        if (subMap.isEmpty()) {
            return null;
        }
        return subMap.get(subMap.firstKey());
    }
}
