package vip.bestsvip.stock.service.impl;


import javax.transaction.Transactional;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vip.bestsvip.api.dto.StockDto;
import vip.bestsvip.api.service.StockService;
import vip.bestsvip.stock.entity.Stock;
import vip.bestsvip.stock.repository.StockRepository;

@DubboService // @DubboService兼容 @Service的 annotation，即使用沒有@Service，也可正常被本地項目調用
@Service      // 為了兼容性，例如之後不採用Dubble，還可以正常運行
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository stockRepository;

    /**
     * 使用SQL方式扣除，效率更佳
     * @return 
     */
    @Override
    public StockDto dedcut(Long id, Long amount) {

        stockRepository.dedcut(id, amount);
        Stock stock = stockRepository.findById(id).get();
        StockDto stockDto = new StockDto();
        stockDto.setId(stock.getId());
        stockDto.setName(stock.getName());
        stockDto.setAmount(stock.getAmount());
        return stockDto;
    }
}