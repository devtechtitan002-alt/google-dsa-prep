import java.util.HashMap;
import java.util.Set;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
public class TimeBasedKeyValueStore {
    static class TimeMap {

        HashMap<String, List<Integer>> timestampsMap;
        HashMap<String, List<String>> strValuesMap;

        public TimeMap() {
           timestampsMap = new HashMap<>();
           strValuesMap = new HashMap<>();
        }
    
        public void set(String key, String value, int timestamp) {
           List<Integer> timeStampList = timestampsMap.get(key);
           List<String> valueList = strValuesMap.get(key);
           if( timeStampList == null ){
               timeStampList = new ArrayList<>();
           }
           if( valueList == null ){
               valueList = new ArrayList<>();
           }
           timeStampList.add(timestamp);
           valueList.add(value);
           timestampsMap.put(key, timeStampList);
           strValuesMap.put(key, valueList);
        }
    
        public String get(String key, int timestamp) {
          List<Integer> timeList = timestampsMap.get(key);
          if(timeList == null) return "";
          List<String> valueList = strValuesMap.get(key);
          int idx = binarySort(timeList, timestamp);
          return idx == -1 ? "" : valueList.get(idx); 
        }

        public int binarySort(List<Integer> timeStamps,int targetTimeStamp){
            int left=0,right=timeStamps.size()-1;
            while(left<=right){
               int mid=left+(right-left)/2; 
               int currNum=timeStamps.get(mid);
               if(currNum == targetTimeStamp){ return mid; }
               else if(currNum < targetTimeStamp){ left=mid+1; }
               else{ right=mid-1; }
            }
            return right == -1 ? -1 : right;
        }
    }
    public static void main(String[] args){
        TimeMap tMap = new TimeMap();
        tMap.set("love", "high", 10);
        tMap.set("love", "low", 20);
        System.out.println(tMap.get("love", 5));
        System.out.println(tMap.get("love", 10));
        System.out.println(tMap.get("love", 15));
        System.out.println(tMap.get("love", 20));
        System.out.println(tMap.get("love", 25));
    }
}
