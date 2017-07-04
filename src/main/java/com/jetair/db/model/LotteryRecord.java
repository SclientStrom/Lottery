package com.jetair.db.model;

public class LotteryRecord {
    private Integer id;

    private String redBallRecord;

    private String blueBallRecord;

    private String type;

    private Integer recordId;

    private Integer betCount;

    private String point;
    
    private Integer times;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRedBallRecord() {
        return redBallRecord;
    }

    public void setRedBallRecord(String redBallRecord) {
        this.redBallRecord = redBallRecord == null ? null : redBallRecord.trim();
    }

    public String getBlueBallRecord() {
        return blueBallRecord;
    }

    public void setBlueBallRecord(String blueBallRecord) {
        this.blueBallRecord = blueBallRecord == null ? null : blueBallRecord.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Integer getBetCount() {
        return betCount;
    }

    public void setBetCount(Integer betCount) {
        this.betCount = betCount;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point == null ? null : point.trim();
    }

	public Integer getTimes() {
		return times;
	}

	public void setTimes(Integer times) {
		this.times = times;
	}
}