Original Code can be found at https://repl.it/talk/learn/An-Introduction-to-Java/13450.


Playing around with commments:
```
class Main {
  public static void main(String[] args) {
    // This is a comment
    // This will be run
    // This will not do anything
    /*
    I can make
    a multi line
    comment
    */
  }
}
```

Printing objects:
```
class Main {
  public static void main(String[] args) {
    System.out.println("Hello, world!");    // => 'Hello, World!'
    System.out.println(9);
    System.out.println(new String[]{});
  }
}
```
Note that the String array prints the pointer to the location of the object in memory. To avoid this, one can iterate through the array or for other types of objects, override the toString() method.

Math operators:
```
class Main {
  public static void main(String[] args) {
    System.out.println(2+3);  // addition
    System.out.println(2-3);  //subtraction
    System.out.println(2*3);  // multiplication
    System.out.println(2/3);  // division - rounds down
    System.out.println(3%2);  // modulus - remainder of division
    System.out.println(2^3); // Bitwise XOR
    System.out.println(2&3); // Bitwise AND
    System.out.println(2|3); // Bitwise OR
    System.out.println(~2); // Bitwise NOT
  }
}
```
Bitwise operators work by comparing the bits in the same place and performing the relevant operation. (1 is true, and 0 is false).

Declaring and assigning variables:
```
class Main {
  public static void main(String[] args) {
    int num;
    num = 3;
    System.out.println(num);

    // Or, on one line
    int another_num = num;
    System.out.println(another_num); // Will print 3
  }
}
```

Different primitive types;
```
class Main {
  public static void main(String[] args) {
    // integers up to 2,147,483,647
    int i = 3;
    // integers up to 9,223,372,036,854,775,807
    long l = 314159265;
    // 64-bit floating-point number
    double d = 3.1415d;
    // 32-bit floating-point number (for saving memory)
    float f = 3.14f;
    // text
    String s = "Hello, World!";
    // single character
    char c = 'a';
    // true/false
    boolean b = false;
    
    int x = c;
    System.out.println(x); // Will print 97
  }
}
```
Note that the compiler will automatically extend or shorten the binary representation of different types when type casting. Be careful, since this can lead to arithmetic errors.

Assigning Arrays:
```
class Main {
  public static void main(String[] args) {
    // integer array of length 10
    int[] i = new int[10];

    // access elements with 0-based index, i.e. first element is 0, second is 1 e.t.c.
    i[0] = 1;
    i[6] = 32;


    // another way of defining arrays
    int[] i2 = {1,2,3};

    // use .length to find the length of the array
    System.out.println(i.length);
    System.out.println(i2.length);
    System.out.print(i);
    for(int e: i){
      System.out.print(e + ",");
    }
  }
}
```
You must iterate over the array to print its contents.

Comparing Strings to chars:
```
class Main {
  public static void main(String[] args) {
    char[] c = {'H','e','l','l','o'};
    String s = new String(c);
    System.out.println(s);

    // .length() is used to find the length of a String
    System.out.println(s.length());
    
    char a = 'a';
    char b = 'b';
    System.out.println(a+b);
    System.out.println(s+a);
  }
}
```
Although String can be thought of as an array of chars, the addition operator automatically does concatentation if there is a String as an argument. However, adding chars adds the binary represetations of each char.

Arraylists:
```
import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    ArrayList al = new ArrayList();
    al.add('a');
    al.add(3);
    al.add("Hi there!");
    // pushes to 0 index
    al.add(0,"First");
    System.out.println(al);
    System.out.println(al.size());  // => 4

    // remove removes by index, not value
    al.remove(0);
    System.out.println(al.size());  // => 3


    // also, you can set it to only 1 datatype
    ArrayList<String> sal = new ArrayList<String>();
    sal.add("Hi");
    sal.add(34);    // fails because it is not String
    
    sal.add(4, "f"); //IndexOutOfBoundsException
  }
}
```
Cannot add elements past the current size of the Arraylist.

```
import java.util.HashMap;

class Main {
  public static void main(String[] args) {
    // key is String, value is Integer
    // datatypes are different than normal
    // use Boolean, Character, Double for boolean,char,double
    HashMap<String, Integer> hm = new HashMap<String, Integer>();

    hm.put("John",23);
    hm.put("Anne",17);
    System.out.println(hm);
    // use get to find a specific value
    System.out.println(hm.get("Anne"));

    hm.remove("Anne");
    System.out.println(hm);
    
    HashMap<String, Integer[]> hash = new HashMap<String, Integer[]>();
    Integer[] ar = {new Integer(1),new Integer (2)};
    hash.put("Hi", ar);
    hash.put("Hello", ar);
    hash.get("Hi")[1] = new Integer(3);
    System.out.println(hash.get("Hello")[1]);
  }
}
```
Hashmaps can assign multiple keys to the same value. Changing the value will change the value for all keys assigned to it.

Control flow:
```
class Main {
  public static void main(String[] args) {
    System.out.println(1==1); // equal to
    System.out.println(2>1);  // greater than
    System.out.println(2<1);  // less than
    System.out.println(1>=1); // greater than or equal to
    System.out.println(2<=1); // less than or equal to
    System.out.println(2!=1); // not equal to
    
    int i = 1;
    long j = 1;
    System.out.print(i == j);
  }
}
```
Thought not avised, you can compare different types.

Boolean comparisons:
```class Main {
  public static void main(String[] args) {
    // AND - true if both are true
    System.out.println(true && true);
    // OR - true if either are true
    System.out.println(true || false);
    // NOT - swaps true with false and vice versa
    System.out.println(!true);
    // XOR - true if either are true but not both
    System.out.println(true^false);
    System.out.println(true^true);
    
    System.out.println(!(true&&true&&false)); //checks for at least one false
  }
}
```

If statements:
```
class Main {
  public static void main(String[] args) {

    // outputs "10 is greater than 5!"
    if (10>5) {
      System.out.println("10 is greater than 5!");
    } else {
      System.out.println("10 is not greater than 5");
    }

    int a = 10;

    // outputs "a is greater than 8"
    if (a<2) {
      System.out.println("a is less than 2");
    } else if (a<8) {
      System.out.println("a is less than 8");
    } else {
      System.out.println("a is greater than 8");
    }
    
    if (a<2) {
      System.out.println("a is less than 2");
    } else if (a>8) {
      System.out.println("a is greater than 8");
    } else if (a>5) {
      System.out.println("a is greater than 5");
    }
    //Prints "a is greater than 8"
  }
}
```
Will stop after first else if is valid.

For loops:
```
class Main {
  public static void main(String[] args) {
    // loops 10 times, incrementing i by 1 each time
    // (i++)
    for (int i=0;i<10;i++) {
      System.out.println(i);
    }


    char[] c_array = {'a','b','c','d'};
    // loos for each item in the array
    for (char c:c_array) {
      System.out.println(c);
    }
    //Another way to iterate through array.
    for (int i=0;i<c_array.length;i++) {
      System.out.println(c_array[i]);
    }
  }
}
```

While loops:
```
class Main {
  public static void main(String[] args) {
    int x = 3;

    // continues until x=6
    // because then 6*4 == 24
    while ((x*4)!=24) {
      System.out.println(x);
      x++;
    }
    
    while(true){
      System.out.print(true);
    }
    //this will print forever so dont do it
  }
}
```

Methods:
```
class Main {
  public static void main(String[] args) {
    sayHello();
    
    String farewell = sayGoodbye();
    System.out.println(farewell);

    System.out.println("3 is greater than 5: "+isGreaterThanFive(3));
    System.out.println("10 is greater than 5: "+isGreaterThanFive(10));

  }

  // public and static will be covered in a minute
  // void means the method doesn't return anything
  public static void sayHello() {
    System.out.println("Hello!");
  }

  // String means that the method returns a String
  public static String sayGoodbye() {
    return "Goodbye!";
  }

  // boolean so returns true/false
  public static boolean isGreaterThanFive(int n) {
    return (n>5);
  }
  
  public static int returnIntPlusFive(int n){
    n += 5;
    return n;
    n+5; //this code will not run
    }
}
```

Classes:
```
class Main {
  public static void main(String[] args) {
    // create a new 'instance' of the dog class, called George
    Dog George = new Dog("George");
    George.bark();
    George.live();
    George.eat(); // fails because eat() is private
    George.type; //Returns "Mammal"
  }
}

class Animal{
  String type = "Mammal";
  //All dogs will have this field.
}

class Dog extends Animal{
  // this is an attribute that all 
  // of our Dog objects will have
  String name;

  // this is called the constructor
  // it is called when the dog is created
  public Dog(String name) {
    // this. means that name applies the this dog
    // it means that it's name can be used elsewhere
    // in the class
    this.name = name;

    System.out.println("A dog called "+this.name+" was just created!");
  }

  // public means that it can be accessed by other classes
  public void bark() {
    System.out.println(this.name+" just said 'Woof!'");
  }

  public void live() {
    this.eat();
  }

  // private so cannot be accessed by other classes
  private void eat() {
    System.out.println(this.name+" is eating!");
  }
}
```

Static methods:
```
class Main {
  public static void main(String[] args) {
    // create a new instance of the Shop class
    Shop Amazon = new Shop();
    Amazon.buy();

    // static, so we can just do this
    Shop.buy();
    //or
    Shop.goods;

    Amazon.showDetails();

    // fails because it is not an instance
    // and the method is not static
    Shop.showDetails();
  }
}

class Shop {
  // static so don't need to instantiate in order to 
  // use the method
  
  static String goods = "stuff";
  
  public static void buy() {
    System.out.println("Buying!");
  }

  public void showDetails() {
    System.out.println("You have to create a instance for this to work");
  }
}
```

Scanner:
```
import java.util.Scanner;
import java.io.File;

class Main {
  public static void main(String[] args) {
    // creates a new Scanner looking at the string "Hello World"
    Scanner input_reader = new Scanner("Hello World");

    // outputs each word one at a time
    while (input_reader.hasNext()) {
      String input = input_reader.next();
      System.out.println(input);
    }
  }
}
```
Check out https://github.com/jathayde314/APCS/blob/master/ParticleSimulator/src/Main.java to see a scanner I have implemented before.

Scanning inputs:
```
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner input_reader = new Scanner(System.in);

    System.out.println("Enter some text: ");
    String input = input_reader.nextLine();
    System.out.println("You said: "+input);
  }
}
```
Also have done this before. Same file: https://github.com/jathayde314/APCS/blob/master/ParticleSimulator/src/Main.java

Error Handling;
```
import java.lang.ArithmeticException;

class Main {
  public static void main(String[] args) {
    
    try {
      System.out.println(1/0);
    } catch (ArithmeticException e) {
      System.out.println("Got error: "+e);
    }
  }
}
```
Check out this file:https://github.com/jathayde314/APCS/blob/master/FileReader.java for some IOExceptionHandling.


