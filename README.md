# dbsession
[![](https://jitpack.io/v/deckyfx/dbsession.svg)](https://jitpack.io/#deckyfx/dbsession)

Android user session stored in sqlite db, this is implementation of 

* deckyfx/dbhelper
* deckyfx/simpleadapter
* gson
* greendao

Add it in your root build.gradle at the end of repositories:

```gradle
allprojects {
	repositories {
	...
		maven { url 'https://jitpack.io' }
	}
}
```
Add the dependency

```gradle
dependencies {
    compile 'com.github.deckyfx:dbsession:-SNAPSHOT@aar'
}
```

## Sample Code


Create class to define your session data
```java

public class SessionData extends BaseItem {
    public String username;
}

```

Then init DBSession
```java
...
DBSession Session = new DBSession(getApplicationContext(), SessionData.class);
...

```

To save your user data
```java
...
Session.set(/* Json String, JSONObject instance, or SessionData instance*/);
...

```

To check if your user is stored or not
```java
...
Session.valid();
...

```

To clear user data
```java
...
Session.clear();
...

```

More sample is [here]

## Feature:

 * 
 
 
