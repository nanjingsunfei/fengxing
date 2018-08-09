package com.hash;

/**
 * Created by sunfei on 2018/7/2.
 */
public class NormalHashCluster extends Cluster {

    public NormalHashCluster() {
        super();
    }

    @Override
    public void addNode(Node node) {
        nodes.add(node);
    }

    @Override
    public void remove(Node node) {
        nodes.removeIf(o -> o.getIp().equals(node.getIp()) && o.getDomain().equals(node.getDomain()));
    }

    @Override
    public Node get(String key) {
        long hash = key.hashCode();
        long index = hash % nodes.size();
        return nodes.get((int)index);
    }

}
