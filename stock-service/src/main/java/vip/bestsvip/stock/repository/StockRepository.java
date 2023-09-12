package vip.bestsvip.stock.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import vip.bestsvip.stock.entity.Stock;

public interface StockRepository extends JpaRepository<Stock, Long>, JpaSpecificationExecutor<Stock> {
    Optional<Stock> findById(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE stock SET amount = amount - ?2 WHERE id = ?1" , nativeQuery = true)
    void dedcut(Long id,Long amount);
}