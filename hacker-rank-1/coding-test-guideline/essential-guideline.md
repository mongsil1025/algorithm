# Essential Guideline

### Convert input string to allocated Array

```java
BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


String[] aItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

List<Integer> a = new ArrayList<>();

for (int i = 0; i < 3; i++) {
    int aItem = Integer.parseInt(aItems[i]);
    a.add(aItem);
}

String[] bItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

List<Integer> b = new ArrayList<>();

for (int i = 0; i < 3; i++) {
    int bItem = Integer.parseInt(bItems[i]);
    b.add(bItem);
}
```

