# Scanner

## Data Types

#### [Primitive Data Types](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html)

 Java has 8 [primitive data types](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html): _byte_, _short_, _int_, _long_, _float_, _double_, _boolean_, and _char_.

#### [Scanner](https://docs.oracle.com/javase/7/docs/api/java/util/Scanner.html)

The _next_ methods scan for _tokens_ \(you can think of this as a word\), and the _nextLine_ methods reads from the Scanner's current location until the beginning of the next line.

```java
Scanner scan = new Scanner(System.in);

// a b c
// d e
// f
// g

scan.next(); // return the next token, a
scan.nextLine(); // return (space)c, because it reads from the current position until the beginning of the next line.
scan.nextLine(); // return d e
scan.next(); // return f

scan.hasNext();
scan.hasNextLine();

```

 ****_**nextInt\(\)**_ ****will scan the next token of input as an _int_, and _**nextDouble\(\)**_ ****will scan the next token of input as a _double_

{% hint style="info" %}
 When you read an entire line \(i.e.: _readLine\(\)_\), it reads from the current position until the beginning of the next line. Because of this, **a call to** _**nextLine\(\)**_ **may return an empty string** if there are no characters between the end of the last read and the beginning of the next line. 
{% endhint %}

**Sample Input**

```text
12
4.0
is the best place to learn and practice coding!
```

**Code**

```java
    a = scan.nextInt();
    b = scan.nextDouble();
    scan.nextLine(); 
    // returns everything after 4.0 until the beggining of the next line; 
    //because there are no chracters there, it returns an empty String.
    c = scan.nextLine();
```



