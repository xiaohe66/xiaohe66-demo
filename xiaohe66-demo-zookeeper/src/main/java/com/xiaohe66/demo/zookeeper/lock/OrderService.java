package com.xiaohe66.demo.zookeeper.lock;

import com.xiaohe66.demo.zookeeper.lock.entity.Order;
import com.xiaohe66.demo.zookeeper.lock.entity.Product;
import com.xiaohe66.demo.zookeeper.lock.mapper.OrderMapper;
import com.xiaohe66.demo.zookeeper.lock.mapper.ProductMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @author xiaohe
 * @time 2021.05.27 17:14
 */
@Service
public class OrderService {

    private final ProductMapper productMapper;
    private final OrderMapper orderMapper;


    public OrderService(ProductMapper productMapper, OrderMapper orderMapper) {
        this.productMapper = productMapper;
        this.orderMapper = orderMapper;
    }


    @Transactional(rollbackFor = Exception.class)
    public void addOrder(Integer productId) {

        Product product = productMapper.getProduct(productId);
        if (product.getStock() <= 0) {
            throw new RuntimeException("超过库存");
        }

        int ret = productMapper.deductStock(productId);
        if (ret == 1) {
            Order order = new Order();

            order.setProductId(productId);
            order.setUserId(UUID.randomUUID().toString());

            orderMapper.insert(order);
        } else {

            throw new RuntimeException("创建订单失败, id = " + productId);
        }

    }

}
