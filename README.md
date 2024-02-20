1. refactor the videoplayercontroller
2. save the last video in the videos table


Creating a db in production build

```java
public class DatabaseConfig {
    private static String getDatabasePath() {
        String userHome = System.getProperty("user.home");
        String osName = System.getProperty("os.name").toLowerCase();
        String dbFolder;

        if (osName.contains("win")) {
            dbFolder = userHome + "\\AppData\\Local\\YourAppName\\";
        } else if (osName.contains("mac")) {
            dbFolder = userHome + "/Library/Application Support/YourAppName/";
        } else { // Assume Linux or Unix
            dbFolder = userHome + "/.local/share/YourAppName/";
        }

        // Ensure directory exists
        new File(dbFolder).mkdirs();

        return dbFolder + "myvideosdb.db";
    }

    public static Connection connect() {
        String url = "jdbc:sqlite:" + getDatabasePath();
        // Connect to the database using this URL...
    }
}

```

