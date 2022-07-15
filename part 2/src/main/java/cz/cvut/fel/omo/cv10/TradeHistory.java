package cz.cvut.fel.omo.cv10;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.partitioningBy;

public class TradeHistory {

    public List<Transaction> transactions;

    public TradeHistory(List<Transaction> transctions) {
        this.transactions = transctions;
    }

    public List<Transaction> findAllTransactionsIn2011AndSortByValueAsc(){
        List<Transaction> newList = new ArrayList<Transaction>();
        for (Transaction transaction : this.transactions)
            if(transaction.getYear()==2011)
                newList.add(transaction);
        newList.sort(Comparator.comparing(Transaction::getValue));
        return newList;
    }

    public List<String> getUniqueCitiesSortedAsc(){
        List<String> newList = new ArrayList<String>();
        for (Transaction transaction : this.transactions)
            if(!newList.contains(transaction.getTrader().getCity()))
                newList.add(transaction.getTrader().getCity());
        Collections.sort(newList);
        return newList;
    }

    /*
    * String shall start with "Traders:" and use space as separator. E.g.: "Traders: Bob George"
    *
     */
    public String getSingleStringFromUniqueTradersNamesSortByNameAsc(){
        String traderStr = "Traders: ";

        List<String> newList = new ArrayList<String>();
        for (Transaction transaction : this.transactions) {
            if(!newList.contains(transaction.getTrader().getName())) {
                newList.add(transaction.getTrader().getName());
            }
        }
        Collections.sort(newList);
        
        Optional<String> list = newList.stream().reduce (   (firstName, secondName)-> 
                                                            firstName + " " + secondName
                                                        );
        traderStr += list.get();
        return traderStr;
    }

    public boolean isSomeTraderFromCity(String cityName){
        return this.transactions.stream().anyMatch (transaction-> transaction.getTrader().getCity()==cityName);
    }

    public Optional<Transaction> findSmallestTransactionUsingReduce(){
        Optional<Transaction> smallestTransaction = null;
        //Implement body here
        return smallestTransaction;
    }

    public Map<String, List<Trader>> getTradersByTown(){
        Map<String, List<Trader>> tradersByTown = new HashMap<String, List<Trader>>();
        //Implement body here
        return tradersByTown;
    }

    public Map<String, Long> getTradersCountsByTown(){
        Map<String, Long> tradersByTown = new HashMap<String, Long>();
        //Implement body here
        return tradersByTown;
    }

    public Map<Boolean, List<Transaction>> partitionTransactionsByTraderIsVegetarian(){
        Map<Boolean, List<Transaction>> transactionsBy = new HashMap<Boolean, List<Transaction>>();
        return transactionsBy;
    }
}
