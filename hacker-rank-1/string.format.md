# String.format

## Java String format\(\)

The **java string format\(\)** method returns the formatted string by given locale, format and arguments.

```java
String name="sonoo";  
String sf1=String.format("name is %s",name);  
String sf2=String.format("value is %f",32.33434);  
String sf3=String.format("value is %32.12f",32.33434);//returns 12 char fractional part filling with 0  
  
System.out.println(sf1);  
System.out.println(sf2);  
System.out.println(sf3);  

// RESULT
name is sonoo
value is 32.334340
value is 32.334340000000
```

#### Java String Format Specifiers

Here, we are providing a table of format specifiers supported by the Java String.



| Format Specifier | Data Type | Output |
| :--- | :--- | :--- |
| %a | floating point \(except _BigDecimal_\) | Returns Hex output of floating point number. |
| %b | Any type | "true" if non-null, "false" if null |
| %c | character | Unicode character |
| %d | **integer \(incl. byte, short, int, long, bigint\)** | **Decimal Integer** |
| %e | floating point | decimal number in scientific notation |
| %f | floating point | decimal number |
| %g | floating point | decimal number, possibly in scientific notation depending on the precision and value. |
| %h | any type | Hex String of value from hashCode\(\) method. |
| %n | none | Platform-specific line separator. |
| %o | integer \(incl. byte, short, int, long, bigint\) | Octal number \(8진수\) |
| %s | any type | String value |
| %t | Date/Time \(incl. long, Calendar, Date and TemporalAccessor\) | %t is the prefix for Date/Time conversions. More formatting flags are needed after this. See Date/Time conversion below. |
| %x | integer \(incl. byte, short, int, long, bigint\) | Hex string. \(16진수\) |

### Width, Padding Option

Apart from formatting, **we can set width, padding etc**. of any value. Let us see an example where we are setting width and padding for an integer value.

```java
String str1 = String.format("%d", 101);  
String str2 = String.format("|%10d|", 101);  // Specifying length of integer  
String str3 = String.format("|%-10d|", 101); // Left-justifying within the specified width  
String str4 = String.format("|% d|", 101);   
String str5 = String.format("|%010d|", 101); // Filling with zeroes 
String str6 = System.out.println(String.format("%,10d%,10d", 10000, -20000));

// RESULT
101
|       101|
|101       |
| 101|
|0000000101|
10,000 -20,000
```

### Octal, Hex String

```java
// x를 사용하면 16진수를 출력합니다.
// 아래 샘플에서는 10진수 2047이 16진수로 변환되서 출력 됩니다.
System.out.println(String.format("%10x%10x", 2047, 2047));
       7ff       7ff

// X를 대문자로 사용하면 16진수도 대문자로 출력됩니다.
System.out.println(String.format("%10X%10X", 2047, 2047));
       7FF       7FF

// o를 사용하면 8진수를 출력합니다. 아래 샘플에서는 10진수 2047이 8진수로 변환되서 출력 됩니다.
System.out.println(String.format("%10o%10o", 2047, 2047));
      3777      3777
```

### Hacker Rank 30 Days Challenge \(7/26\)

```java
static void solve(double meal_cost, int tip_percent, int tax_percent) {

    // For precise result we have to convert int to double
    double tip = meal_cost * ((double) tip_percent / (double) 100); 
    double tax = meal_cost * ((double) tax_percent / (double) 100);

    System.out.println(Math.round(meal_cost + tip + tax));

}
```

