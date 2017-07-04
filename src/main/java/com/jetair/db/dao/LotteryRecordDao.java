package com.jetair.db.dao;

import com.jetair.db.model.LotteryRecord;

public interface LotteryRecordDao {

    int insert(LotteryRecord record);

    LotteryRecord findById(Integer id);

    int update(LotteryRecord record);

}