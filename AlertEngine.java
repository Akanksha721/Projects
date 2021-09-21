package com.airwallex.codechallenge;

import com.airwallex.codechallenge.input.CurrencyConversionRate;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class AlertEngine {
    private final HashMap<String, List<CurrencyConversionRate>> lastFiveMinuteAvg;

    public AlertEngine() {
       this.lastFiveMinuteAvg = new HashMap<String, List<CurrencyConversionRate>>();
        
    }

    public void checkRate(CurrencyConversionRate currencyConversionRate) {
        this.updateFiveMinuteAvg(currencyConversionRate);

        double avgRate = this.calculateFiveMinuteAvg(currencyConversionRate.getCurrencyPair());

        double currentRate = currencyConversionRate.getRate();
        String currencyPair = currencyConversionRate.getCurrencyPair();
        Instant timestamp = currencyConversionRate.getTimestamp();

        if(currentRate > avgRate && (currentRate - avgRate)/avgRate >0.1)
        {
            System.out.println(
                    String.format("{ \"timestamp\": %.3f , \"currencyPair\": \"%s\", \"alert\": \"spotChange\" }",timestamp.toEpochMilli()/1000.0,currencyPair)
            );
        }
        else if (currentRate < avgRate && (avgRate - currentRate)/avgRate > 0.1) {
            System.out.println(
                    String.format("{ \"timestamp\": %.3f , \"currencyPair\": \"%s\", \"alert\": \"spotChange\" }",timestamp.toEpochMilli()/1000.0,currencyPair)
            );
        }
        
    }

    // calculate average
    private double calculateFiveMinuteAvg(String currencyPair) {
        if(!this.lastFiveMinuteAvg.containsKey(currencyPair)){      // is null
            return 0;
        }

        List<CurrencyConversionRate> ccrList = this.lastFiveMinuteAvg.get(currencyPair);

        double avg = ccrList.stream().mapToDouble(CurrencyConversionRate::getRate).sum();
        avg /= ccrList.size();

        return avg;
    }

    private void updateFiveMinuteAvg(CurrencyConversionRate currencyConversionRate) {
        double currentRate = currencyConversionRate.getRate();
        String currencyPair = currencyConversionRate.getCurrencyPair();
        Instant timestamp = currencyConversionRate.getTimestamp();

        if(this.lastFiveMinuteAvg.containsKey(currencyPair))
        {
            List<CurrencyConversionRate> currencyConversionRates = this.lastFiveMinuteAvg.get(currencyPair);
            Iterator<CurrencyConversionRate> iterator = currencyConversionRates.iterator();
            while(iterator.hasNext()){
                CurrencyConversionRate ccr = iterator.next();
                if(Duration.between(timestamp, ccr.getTimestamp()).toMinutes() >5){
                    currencyConversionRates.remove(ccr);
                }
            }
            currencyConversionRates.add(currencyConversionRate);
            this.lastFiveMinuteAvg.put(currencyPair, currencyConversionRates);
        }

        else{
            ArrayList<CurrencyConversionRate> ccrList = new ArrayList<>();
            ccrList.add(currencyConversionRate);
            this.lastFiveMinuteAvg.put(currencyPair, ccrList);
        }
    }

}