package com.jsjchai.distributed.lock.service;

/**
 * @author jsjchai.
 */
public interface InventoryService {

    /**
     * 扣减库存
     * @param id
     */
    void  deductionInventory(int id);
}
