package utils;

import java.util.ArrayList;
import java.util.List;

import common.types.Pair;
import monero.wallet.MoneroWallet;
import monero.wallet.model.MoneroAccount;
import monero.wallet.model.MoneroSubaddress;

/**
 * Prints the balances of the wallet.
 */
public class PrintAddresses {

  public static void main(String[] args) {
    
    // collect info about subaddresses
    List<Pair<String, List<Object>>> pairs = new ArrayList<Pair<String, List<Object>>>();
    MoneroWallet wallet = TestUtils.getWallet();
    List<MoneroAccount> accounts = wallet.getAccounts();
    for (MoneroAccount account : accounts) {
      add(pairs, "ACCOUNT", account.getIndex());
      add(pairs, "SUBADDRESS", 0);
      add(pairs, "LABEL", account.getLabel());
      add(pairs, "ADDRESS", account.getPrimaryAddress());
      add(pairs, "BALANCE", account.getBalance());
      add(pairs, "UNLOCKED", account.getUnlockedBalance());
      List<MoneroSubaddress> subaddresses = wallet.getSubaddresses(account.getIndex());
      for (MoneroSubaddress subaddress : subaddresses) {
        add(pairs, "ACCOUNT", account.getIndex());
        add(pairs, "SUBADDRESS", subaddress.getIndex());
        add(pairs, "LABEL", subaddress.getLabel());
        add(pairs, "ADDRESS", subaddress.getAddress());
        add(pairs, "BALANCE", subaddress.getBalance());
        add(pairs, "UNLOCKED", subaddress.getUnlockedBalance());
      }
    }
    
    // convert info to csv
    System.out.println(pairsToCsv(pairs));
  }
  
  private static void add(List<Pair<String, List<Object>>> pairs, String header, Object value) {
    Pair<String, List<Object>> pair = null;
    for (Pair<String, List<Object>> aPair : pairs) {
      if (aPair.getFirst().equals(header)) {
        pair = aPair;
        break;
      }
    }
    if (pair == null) {
      List<Object> vals = new ArrayList<Object>();
      pair = new Pair<String, List<Object>>(header, vals);
      pairs.add(pair);
    }
    pair.getSecond().add(value);
  }
  
  private static String pairsToCsv(List<Pair<String, List<Object>>> pairs) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < pairs.size(); i++) {
      sb.append(pairs.get(i).getFirst());
      if (i < pairs.size() - 1) sb.append(',');
      else sb.append('\n');
    }
    for (int i = 0; i < pairs.get(0).getSecond().size(); i++) {
      for (int j = 0; j < pairs.size(); j++) {
        sb.append(pairs.get(j).getSecond().get(i));
        if (j < pairs.size() - 1) sb.append(',');
        else sb.append('\n');
      }
    }
    return sb.toString();
  }
}
