package com.jetair.db.dao;

import com.jetair.db.model.LotteryPassenger;

public interface LotteryPassengerDao {

    int insert(LotteryPassenger record);

    LotteryPassenger findById(Integer id);

    int update(LotteryPassenger record);

	LotteryPassenger findByOrderNo(String orderNo);

}