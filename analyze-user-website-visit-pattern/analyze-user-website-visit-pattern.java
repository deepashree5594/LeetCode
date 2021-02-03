class Solution {
    class Pair
    {
        int timestamp;
        String website;
        Pair(int t, String w)
        {
            this.timestamp = t;
            this.website = w;
        }
    }
    
    
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        if (username == null || username.length == 0)
              return new ArrayList();
        String res = "";
        HashMap<String, List<Pair>> map = new HashMap();
        for(int i = 0; i < username.length; i++)
        {
            map.putIfAbsent(username[i], new ArrayList());
            map.get(username[i]).add(new Pair(timestamp[i], website[i]));
        }
        
        HashMap<String, Integer> count_map = new HashMap();
        for (String user : map.keySet())
        {
            HashSet<String> set = new HashSet();
            List<Pair> list = map.get(user);
            Collections.sort(list, (a,b) -> a.timestamp - b.timestamp);
            for ( int i = 0; i < list.size(); i++ ) 
            {
                for ( int j = i+1 ; j < list.size() ; j++ ) 
                {
                    for ( int k = j+1 ; k < list.size(); k++ ) 
                    {
                        String s = list.get(i).website + " " + list.get(j).website + " " + list.get(k).website;
                        if (!set.contains(s))
                        {
                           count_map.put(s, count_map.getOrDefault(s, 0) + 1);
                           set.add(s);
                        }
                        if ( res == "" || count_map.get(s) > count_map.get(res) || (count_map.get(s) == count_map.get(res) && s.compareTo(res) < 0))
                        {
                                res = s;
                        }
                    }
                }
            } 
        }
        return Arrays.asList(res.split(" "));
    
    }
}