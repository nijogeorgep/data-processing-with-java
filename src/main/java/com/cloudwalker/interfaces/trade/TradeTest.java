/**
 *
 */
package com.cloudwalker.interfaces.trade;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author nijogeorgep
 *
 */
public class TradeTest {

    /**
     * @param args
     */
    public static void main(String[] args) {

        /*
         * final Trade myTrade= new Trade(); myTrade.setIssuer("VGUARD"); myTrade= new Trade();
         */


        // Trade Collection
        List<Trade> tradesCollection = new ArrayList<Trade>();
        tradesCollection.add(new Trade(110000, "GOOGLE", "NEW"));
        tradesCollection.add(new Trade(100000, "FACEBOOK", "OLD"));
        tradesCollection.add(new Trade(200000, "BMW", "NEW"));
        tradesCollection.add(new Trade(150000, "AUDI", "NEW"));
        tradesCollection.add(new Trade(100000, "ROLLS-ROYCE", "OLD"));
        tradesCollection.add(new Trade(300000, "FERRARI", "NEW"));
        tradesCollection.add(new Trade(190000, "UBER", "NEW"));
        tradesCollection.add(new Trade(500000, "GOOGLE", "NEW"));
        tradesCollection.add(new Trade(180000, "AMAZON", "OLD"));
        tradesCollection.add(new Trade(300000, "MERCEDES", "NEW"));
        tradesCollection.add(new Trade(170000, "LAMBORGINI", "NEW"));
        tradesCollection.add(new Trade(600000, "JEEP", "OLD"));

        // Functional Interface Implementations
        // ITrade newTradeChecker = (Trade t) -> t.getStatus().equals("NEW");
        // OR
        ITrade newTradeChecker = (t) -> t.getStatus().equals("NEW");

        ITrade bigTradeLambda = (t) -> t.getQuantity() > 100000;

        ITrade issuerBigNewTradeLambda = (t) -> {
            return t.getStatus().equals("NEW") && t.getQuantity() > 400000
                    && t.getIssuer().equals("GOOGLE");
        };

        // issuerBigNewTradeLambda function is passed
        List<Trade> issuerBigNewTradeLambdaList =
                TradeTest.filterTrades(issuerBigNewTradeLambda, tradesCollection);
        System.out.println("--------issuerBigNewTradeLambdaList--------");
        issuerBigNewTradeLambdaList.stream().forEach(
                t -> System.out.print(t.getIssuer() + "," + t.getQuantity() + "," + t.getStatus() + "|"));

        // bigTradeLambda function is passed
        List<Trade> bigTradeLambdaList = TradeTest.filterTrades(bigTradeLambda, tradesCollection);
        System.out.println("\n--------bigTradeLambdaList--------");
        bigTradeLambdaList.stream().forEach(
                t -> System.out.print(t.getIssuer() + "," + t.getQuantity() + "," + t.getStatus() + "|"));

        // newTradeChecker function is passed
        List<Trade> newTradeCheckerList = TradeTest.filterTrades(newTradeChecker, tradesCollection);
        System.out.println("\n--------newTradeCheckerList--------");
        newTradeCheckerList.stream().forEach(
                t -> System.out.print(t.getIssuer() + "," + t.getQuantity() + "," + t.getStatus() + "|"));

        Function<List<Trade>, Integer> aggegatedQuantity = t -> {
            int aggregatedQuantity = 0;
            /*
             * for (Trade tr : t) { aggregatedQuantity += tr.getQuantity(); }
             */

            aggregatedQuantity = t.stream().map((tr) -> tr.getQuantity()).reduce(0, Integer::sum);

            // aggregatedQuantity = t.stream().map((tr) -> tr.getQuantity()).sum();

            return aggregatedQuantity;
        };

        System.out.println("\n\n--------aggegatedQuantity--------");
        int totalQuantity = aggegatedQuantity.apply(tradesCollection);
        System.out.println("aggegatedQuantity : " + totalQuantity);

    }

    // Method that takes in list of trades and applies the lambda behavior for each
    // of the trade in the collection
    private static List<Trade> filterTrades(ITrade tradelambda, List<Trade> trades) {
        List<Trade> filteredTrades = new ArrayList<Trade>();

        for (Trade trade : trades) {
            if (tradelambda.check(trade)) {
                filteredTrades.add(trade);
            }
        }

        return filteredTrades;
    }

}
