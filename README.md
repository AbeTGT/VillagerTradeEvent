![Version](https://img.shields.io/badge/Version-1.1-blue?style=for-the-badge&logo=appveyor)
# VillagerTradeEvent
Detect when players have traded with a villager, without the use of Paper server software. (Spigot)
Spigot: https://www.spigotmc.org/resources/villagertradeevent.104298/

Read the Docs! (If you get a malicious website warning, on Google Chrome, click Details, then click "visit this unsafe site".)
I don't intend on stealing any information at all, it's just JavaDocs.
https://oasisnetwork.xp3.biz/plugins/villagertradeevent/docs

# How to use
If you are on Maven, you can add the JitPack repository:
```xml
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
```

Otherwise, if you are using Gradle, you can add the JitPack repository:
```gradle
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
```

Make sure to change the "Tag" to the current version listed above (1.1). Maven dependency:
```xml
	<dependency>
	    <groupId>com.github.AbeTGT</groupId>
	    <artifactId>VillagerTradeEvent</artifactId>
	    <version>Tag</version>
	</dependency>
```
