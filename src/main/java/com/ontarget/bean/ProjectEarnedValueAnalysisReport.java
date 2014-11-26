package com.ontarget.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by Owner on 11/22/14.
 */
public class ProjectEarnedValueAnalysisReport implements Serializable{

    private int month;
    private int year;

    private double totalBudgetedCost; // total cost
    private double cumulativePlannedValue; // PV
    private double cumulativeActualCost; // AC
    private double cumulativeEarnedValue; // EV
    private double costVariance; // CV=EV-AC
    private double scheduleVariance; // SV=EV-PV
    private double costPerformanceIndex; // CPI = EV/AC
    private double schedulePerformanceIndex; // SPI = EV/PV
    private double estimatedCostAtCompletion; // EAC

    public ProjectEarnedValueAnalysisReport() {
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getTotalBudgetedCost() {
        return totalBudgetedCost;
    }

    public void setTotalBudgetedCost(double totalBudgetedCost) {
        this.totalBudgetedCost = totalBudgetedCost;
    }

    public double getCumulativePlannedValue() {
        return cumulativePlannedValue;
    }

    public void setCumulativePlannedValue(double cumulativePlannedValue) {
        this.cumulativePlannedValue = cumulativePlannedValue;
    }

    public double getCumulativeActualCost() {
        return cumulativeActualCost;
    }

    public void setCumulativeActualCost(double cumulativeActualCost) {
        this.cumulativeActualCost = cumulativeActualCost;
    }

    public double getCumulativeEarnedValue() {
        return cumulativeEarnedValue;
    }

    public void setCumulativeEarnedValue(double cumulativeEarnedValue) {
        this.cumulativeEarnedValue = cumulativeEarnedValue;
    }

    public double getCostVariance() {
        return costVariance;
    }

    public void setCostVariance(double costVariance) {
        this.costVariance = costVariance;
    }

    public double getScheduleVariance() {
        return scheduleVariance;
    }

    public void setScheduleVariance(double scheduleVariance) {
        this.scheduleVariance = scheduleVariance;
    }

    public double getCostPerformanceIndex() {
        return costPerformanceIndex;
    }

    public void setCostPerformanceIndex(double costPerformanceIndex) {
        this.costPerformanceIndex = costPerformanceIndex;
    }

    public double getSchedulePerformanceIndex() {
        return schedulePerformanceIndex;
    }

    public void setSchedulePerformanceIndex(double schedulePerformanceIndex) {
        this.schedulePerformanceIndex = schedulePerformanceIndex;
    }

    public double getEstimatedCostAtCompletion() {
        return estimatedCostAtCompletion;
    }

    public void setEstimatedCostAtCompletion(double estimatedCostAtCompletion) {
        this.estimatedCostAtCompletion = estimatedCostAtCompletion;
    }

    @Override
    public String toString() {
        return "ProjectEarnedValueAnalysisReport{" +
                "month=" + month +
                ", year=" + year +
                ", totalBudgetedCost=" + totalBudgetedCost +
                ", cumulativePlannedValue=" + cumulativePlannedValue +
                ", cumulativeActualCost=" + cumulativeActualCost +
                ", cumulativeEarnedValue=" + cumulativeEarnedValue +
                ", costVariance=" + costVariance +
                ", scheduleVariance=" + scheduleVariance +
                ", costPerformanceIndex=" + costPerformanceIndex +
                ", schedulePerformanceIndex=" + schedulePerformanceIndex +
                ", estimatedCostAtCompletion=" + estimatedCostAtCompletion +
                '}';
    }
}
