package vip.bestsvip.stock.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vip.bestsvip.api.dto.StockDto;
import vip.bestsvip.api.service.StockService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
;

@RestController
@RequestMapping("/stock")
public class StockController {
 
    @Autowired
    private StockService stockService;

    @GetMapping(value="/dedcut")
    public StockDto dedcut(@RequestParam("id") Long id, @RequestParam("amount") Long amount) {
        return stockService.dedcut(id, amount);
    }
    
}
