package com.summ.mapper;

import com.summ.model.JGoodsContract;
import com.baomidou.mybatisplus.mapper.AutoMapper;
import com.summ.model.response.GoodsContractRes;
import com.summ.model.response.GoodsCostRes;

import java.util.List;

/**
 *
 * JGoodsContract 表数据库控制层接口
 *
 */
public interface JGoodsContractMapper extends AutoMapper<JGoodsContract> {

    List<JGoodsContract> getGoodsListBySupplier(Integer supplierId);

    List<GoodsContractRes> getGoodsList();

    /**
     * 获取产品成本列表（对每个供应商）
     * @param goodsId
     * @return
     */
    List<GoodsCostRes> getGoodsCostList(Integer goodsId);
}