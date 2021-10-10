talentX 사이트의 문제

- 같은 이름의 device가 나오면 뒤에 1부터 순서대로 붙은 리스트를 반환

```java
public static List<String> deviceNamesSystem(List<String> devicenames) {
        Map<String, Integer> map = new HashMap<>();
        String str;
        for(int i = 0; i<devicenames.size(); i++){
            if(map.containsKey(devicenames.get(i))){
                str = devicenames.get(i);
                devicenames.remove(i);
                devicenames.add(i, str + map.get(str));
                map.put(str, map.get(str)+1);
            }else{
                map.put(devicenames.get(i), 1);
            }
            System.out.println(devicenames.get(i));
        }
        return devicenames;

    }
```

