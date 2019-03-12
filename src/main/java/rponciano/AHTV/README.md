# Auto Header Table View
Class created to make it easy to create the JavaFX TableView header. With this class, just instantiate and call a method for the header to be created based on the data class of the table.

This code<br>
![code](https://user-images.githubusercontent.com/6250218/54194513-2f8e8600-449b-11e9-906c-aef8acb97633.png)

Generate this result<br>
![result](https://user-images.githubusercontent.com/6250218/54194514-30271c80-449b-11e9-89fc-9086f742e2c2.png)

[Go to class!](https://github.com/rponciano/AHTV/blob/master/src/main/java/rponciano/AHTV/AutoHeaderTableView.java)

<b>VERY IMPORTANT:</b> To work, the classes used to model the table must have the get methods. See ![ModelExample1](https://github.com/rponciano/AHTV/blob/master/src/main/java/rponciano/AHTV/ModelExample1.java) and ![ModelExample2](https://github.com/rponciano/AHTV/blob/master/src/main/java/rponciano/AHTV/ModelExample2.java) for more info.

1. [How to run](#1-How-to-run)
2. [License](#2-License)

## 1. How to run

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites
1. JDK 8 161 (https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
```
java version "1.8.0_161"
Java(TM) SE Runtime Environment (build 1.8.0_161-b12)
Java HotSpot(TM) 64-Bit Server VM (build 25.161-b12, mixed mode)
```

2. Apache Maven 3.5.0 (https://maven.apache.org/docs/3.5.0/release-notes.html)

### Getting started

1. Download or clone this repo.

2. Inside root folder, execute 
```
mvn clean package install
```

3. Run the jar file
```
java -jar path/jar/file/...*.jar
```

You should see an interface and done! 

## 2. License

The code is under the [Common Creative License BY-NonCommercial](https://creativecommons.org/licenses/by-nc/4.0/legalcode)
