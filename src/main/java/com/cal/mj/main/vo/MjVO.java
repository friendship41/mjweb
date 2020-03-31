package com.cal.mj.main.vo;

import java.sql.Date;

public class MjVO
{
    private int mjSeq;
    private int customerTbNo;
    private String mjName;
    private String mjLoc;
    private Date mjDate;
    private String mjComment;
    private double mjLat;
    private double mjLng;

    private String mjdate;
    private String mjtime;
    private String mjloc1;
    private String mjloc2;

    private Date startDate;
    private Date endDate;

    private String ampm;
    private String hour;
    private String min;

    public int getMjSeq()
    {
        return mjSeq;
    }

    public void setMjSeq(int mjSeq)
    {
        this.mjSeq = mjSeq;
    }

    public int getCustomerTbNo()
    {
        return customerTbNo;
    }

    public void setCustomerTbNo(int customerTbNo)
    {
        this.customerTbNo = customerTbNo;
    }

    public String getMjName()
    {
        return mjName;
    }

    public void setMjName(String mjName)
    {
        this.mjName = mjName;
    }

    public String getMjLoc()
    {
        return mjLoc;
    }

    public void setMjLoc(String mjLoc)
    {
        this.mjLoc = mjLoc;
    }

    public Date getMjDate()
    {
        return mjDate;
    }

    public void setMjDate(Date mjDate)
    {
        this.mjDate = mjDate;
    }

    public String getMjComment()
    {
        return mjComment;
    }

    public void setMjComment(String mjComment)
    {
        this.mjComment = mjComment;
    }

    public double getMjLat()
    {
        return mjLat;
    }

    public void setMjLat(double mjLat)
    {
        this.mjLat = mjLat;
    }

    public double getMjLng()
    {
        return mjLng;
    }

    public void setMjLng(double mjLng)
    {
        this.mjLng = mjLng;
    }

    public void setMjLng(int mjLng)
    {
        this.mjLng = mjLng;
    }

    public String getMjdate()
    {
        return mjdate;
    }

    public void setMjdate(String mjdate)
    {
        this.mjdate = mjdate;
    }

    public String getMjtime()
    {
        return mjtime;
    }

    public void setMjtime(String mjtime)
    {
        this.mjtime = mjtime;
    }

    public String getMjloc1()
    {
        return mjloc1;
    }

    public void setMjloc1(String mjloc1)
    {
        this.mjloc1 = mjloc1;
    }

    public String getMjloc2()
    {
        return mjloc2;
    }

    public void setMjloc2(String mjloc2)
    {
        this.mjloc2 = mjloc2;
    }

    public Date getStartDate()
    {
        return startDate;
    }

    public void setStartDate(Date startDate)
    {
        this.startDate = startDate;
    }

    public Date getEndDate()
    {
        return endDate;
    }

    public void setEndDate(Date endDate)
    {
        this.endDate = endDate;
    }

    public String getHour()
    {
        return hour;
    }

    public void setHour(String hour)
    {
        this.hour = hour;
    }

    public String getMin()
    {
        return min;
    }

    public void setMin(String min)
    {
        this.min = min;
    }

    public String getAmpm()
    {
        return ampm;
    }

    public void setAmpm(String ampm)
    {
        this.ampm = ampm;
    }

    @Override
    public String toString()
    {
        return "MjVO{" +
                "mjSeq=" + mjSeq +
                ", customerTbNo=" + customerTbNo +
                ", mjName='" + mjName + '\'' +
                ", mjLoc='" + mjLoc + '\'' +
                ", mjDate=" + mjDate +
                ", mjComment='" + mjComment + '\'' +
                ", mjLat=" + mjLat +
                ", mjLng=" + mjLng +
                ", mjdate='" + mjdate + '\'' +
                ", mjtime='" + mjtime + '\'' +
                ", mjloc1='" + mjloc1 + '\'' +
                ", mjloc2='" + mjloc2 + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", ampm='" + ampm + '\'' +
                ", hour='" + hour + '\'' +
                ", min='" + min + '\'' +
                '}';
    }
}

