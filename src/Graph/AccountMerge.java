package Graph;

import java.lang.reflect.Array;
import java.util.*;

public class AccountMerge {

    public static void main(String[] args){
        List<List<String>> accounts = Arrays.asList(Arrays.asList("John","johnsmith@mail.com","john_newyork@mail.com"),
                Arrays.asList("John","johnsmith@mail.com","john00@mail.com"),
                Arrays.asList("Mary","mary@mail.com"),
                Arrays.asList("John","johnnybravo@mail.com"));
        List<List<String>> res = accountsMerge(accounts);
        for(List<String> list : res){
            System.out.print("[ ");
            for(String st : list){
                System.out.print(st + " ");
            }
            System.out.print("]\n");
        }
    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();
        UnionFind uf = new UnionFind(accounts.size());
        HashMap<String, Integer> emailToAcc = new HashMap<>();

        for(int i = 0; i < accounts.size(); i++){
            List<String> acc = accounts.get(i);
            for(int j = 1; j < acc.size(); j++){
                String email = acc.get(j);
                if(emailToAcc.containsKey(email)){
                    uf.union(i, emailToAcc.get(email));
                }else{
                    emailToAcc.put(email, i);
                }
            }
        }

        Map<Integer,List<String>> emailGroup = new HashMap<>();

        for(Map.Entry<String, Integer> entry : emailToAcc.entrySet()){
            String email = entry.getKey();
            int index = entry.getValue();
            int leader = uf.find(index);
            emailGroup.computeIfAbsent(leader, k -> new ArrayList<>()).add(email);
        }

        for(Map.Entry<Integer, List<String>> entry : emailGroup.entrySet()){
            int index = entry.getKey();
            List<String> emails = entry.getValue();
            Collections.sort(emails);
            String name = accounts.get(index).get(0);
            List<String> mergedAccount = new ArrayList<>();
            mergedAccount.add(name);
            mergedAccount.addAll(emails);
            res.add(mergedAccount);
        }
        return res;
    }
}
