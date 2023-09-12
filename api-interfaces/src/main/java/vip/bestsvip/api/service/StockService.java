package vip.bestsvip.api.service;

import vip.bestsvip.api.dto.StockDto;

/**
 * 宣告接口
 */
public interface StockService { 
    StockDto dedcut(Long id, Long amount);
}