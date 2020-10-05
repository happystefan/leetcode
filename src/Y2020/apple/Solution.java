package Y2020.apple;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Solution {

    //Do not change this method
    public static void main(String[] args) {
        // JUnitCore.main("Solution");

        MemDataStore ds = new MemDataStore();
        PlayListGenerator plg = new PlayListGenerator(ds);
        plg.saveSong("Song A", "3:30");
        plg.saveSong("Song B", "3:30");
        plg.saveSong("Song C", "3:00");
        plg.saveSong("Song D", "3:00");
        plg.saveSong("Song E", "4:00");
        // Case 1, expect: 10:00
        plg.createPlayList("myPlaylist", "10:00", "3:30");
        // Case 2, expect: 10:30
        plg.createPlayList("myPlaylist", "10:30", "4:00");
        // Case 2, expect: 0:00
        plg.createPlayList("myPlaylist", "5:00", "2:30");



        System.out.println("=======================================================================");


        ds = new MemDataStore();
        plg = new PlayListGenerator(ds);
        plg.saveSong("Song A", "1:00");
        plg.saveSong("Song B", "1:00");
        plg.saveSong("Song C", "1:00");
        plg.saveSong("Song D", "1:00");
        plg.saveSong("Song E", "1:00");
        plg.saveSong("Song F", "1:00");
        plg.saveSong("Song G", "1:00");
        plg.saveSong("Song H", "1:00");
        plg.saveSong("Song I", "1:00");
        plg.saveSong("Song J", "10:00");
        // Case 1, expect: Total duration = 9, # of songs = 9
        plg.createPlayList("myPlaylist", "9:00", "10:00");
        // Case 2, expect: Total duration = 10, # of songs = 1
        plg.createPlayList("myPlaylist", "10:00", "10:00");


    }

    //TODO: Write your tests here

    // ************************************************************************************************

    //TODO: Write your classes here


}

/**
 * Duration is a class to present time duration, currently only support "mm:ss" format.
 */
class Duration {
    private final int seconds;

    /**
     * Constructor of Duration.
     *
     * @param seconds number of seconds.
     */
    public Duration(int seconds) {
        this.seconds = seconds;
    }

    /**
     * Parses the string argument as number of seconds.
     *
     * @param str a {@code String} containing the {@code int}
     *            representation to be parsed
     * @return the integer value representing number of seconds.
     * @throws Exception if the string has invalid format.
     */
    public static int parseDuration(String str) throws Exception {
        Exception invalidFormatException = new Exception("Invalid input, " +
                "format of song 'length' is 3:26 - 3 minutes and 26 seconds");
        Exception durationTooLongException = new Exception(String.format("Invalid input, " +
                "length of song is too long - max length: %d", Integer.MAX_VALUE));
        if (str == null || str.length() == 0) throw invalidFormatException;
        if (!str.contains(":")) throw invalidFormatException;
        int idx = str.indexOf(':');
        String m = str.substring(0, idx);
        String s = str.substring(idx + 1);
        int mm = Integer.parseInt(m);
        int ss = Integer.parseInt(s);
        int duration = mm * 60 + ss;
        if (duration < 0) throw durationTooLongException;
        return duration;
    }

    /**
     * Convert the int argument as "mm:ss" format.
     *
     * @param seconds a {@code int}
     * @return the String value representing Duration.
     * @throws Exception if the string has invalid format.
     */
    public static String toString(int seconds) {
        int mm = seconds / 60;
        int ss = seconds % 60;
        return String.format("%d:%02d", mm, ss);
    }

    @Override
    public String toString() {
        return toString(this.seconds);
    }


    /**
     * Returns an {@code Duration} object holding the value
     * extracted from the specified {@code String} after parsed.
     *
     * @param str the string to be parsed.
     * @return an {@code Duration} object holding the value
     * represented by the string argument
     * @throws Exception if the string has invalid format.
     */
    public Duration valueOf(String str) throws Exception {
        return new Duration(parseDuration(str));
    }
}

/**
 * DataStore is a interface which used to store songs.
 */
interface DataStore {
    boolean saveSong(String title, String duration);
    Map<String, Integer> listSongsWithDurationNoMoreThan(int duration);
}

/**
 * MemDataStore implement a in-memory data store for DataStore interface.
 */
class MemDataStore implements DataStore {
    private final Logger log;
    private final Map<String, Integer> map;

    /**
     * Constructor of Duration.
     */
    public MemDataStore() {
        this(Logger.getLogger(MemDataStore.class.getName()));
    }

    /**
     * Constructor of Duration.
     *
     * @param log log.
     */
    public MemDataStore(Logger log) {
        this.log = log;
        this.map = new HashMap<>();
    }

    /**
     * Save the given songs (title and length to datastore).
     *
     * @param title title of the song.
     * @param length length of the song.
     * @return true if save successfully, false otherwise.
     */
    public boolean saveSong(String title, String length) {
        if (title == null || title.length() == 0) {
            log.log(Level.WARNING, "Invalid input, song 'tittle' can not be null or empty");
            System.out.println("FAILED");
            return false;
        }
        int duration = 0;
        try {
            duration = Duration.parseDuration(length);
        } catch (Exception e) {
            log.log(Level.WARNING, e.toString());
            System.out.println("FAILED");
            return false;
        }
        map.put(title, duration);
        log.log(Level.INFO, String.format("Song saved to MemDataStore, title : %s, length : %d seconds", title, duration));
        return true;
    }

    /**
     * Query and return all songs with duration no more than the given value.
     *
     * @param duration duration of the song.
     * @return All songs with duration no more than the given value.
     */
    public Map<String, Integer> listSongsWithDurationNoMoreThan(int duration) {
        Map<String, Integer> rslt = new HashMap<>();
        for (String key : this.map.keySet()) {
            if (map.get(key) > duration) continue;
            rslt.put(key, map.get(key));
        }
        return rslt;
    }
}

/**
 * PlayListGenerator can save songs and generate playList.
 */
class PlayListGenerator {
    private final Logger log = Logger.getLogger(PlayListGenerator.class.getName());
    private final DataStore ds;

    /**
     * Constructor of PlayListGenerator.
     *
     * @param ds data store used to store songs.
     */
    public PlayListGenerator(DataStore ds) {
        this.ds = ds;
    }

    /**
     * Save the given songs (title and length to datastore).
     *
     * @param title title of the song.
     * @param length length of the song.
     * @return true if save successfully, false otherwise.
     */
    public void saveSong(String title, String length) {
        boolean succeeded = this.ds.saveSong(title, length);
        System.out.println(succeeded ? "SUCCESS" : "FAILED");
    }

    /**
     * Create a playlist by printing out the total duration and songs the playlist contains.
     *
     * @param playListName name of the playlist.
     * @param duration maximum length of the playlist.
     * @param songLengthLimit limit for each songs duration in the playlist.
     */
    public void createPlayList(String playListName, String duration, String songLengthLimit) {
        if (playListName == null) {
            log.log(Level.WARNING, "Invalid input, playListName can not be null or empty");
            System.out.println("FAILED");
            return;
        }
        int playListDuration = 0;
        int songDurationLimit = 0;
        try {
            playListDuration = Duration.parseDuration(duration);
            songDurationLimit = Duration.parseDuration(songLengthLimit);
        } catch (Exception e) {
            log.log(Level.WARNING, e.toString());
            System.out.println("FAILED");
            return;
        }

        Map<String, Integer> songs = ds.listSongsWithDurationNoMoreThan(songDurationLimit);

        String[] titles = new String[songs.size()];
        int[] durations = new int[songs.size()];
        int i = 0;
        for (String title : songs.keySet()) {
            titles[i] = title;
            durations[i] = songs.get(title);
            i++;
        }

        if (durations.length == 0) {
            System.out.printf("%s, %s\n", playListName, Duration.toString(0));
            return;
        }

        int n = durations.length;

        // It's a typical 0-1 Knapsack problem.
        int[][] dp = new int[n + 1][playListDuration + 1];
        for (i = 1; i <= n; i++) {
            for (int j = 0; j <= playListDuration; j++) {
                if (j < durations[i - 1]) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - durations[i - 1]] + durations[i - 1]);
            }
        }

        int maxDuration = dp[n][playListDuration];
        System.out.printf("%s, %s\n", playListName, Duration.toString(maxDuration));

        // Backtrack to generate all selected songs.
        boolean[] selected = new boolean[n + 1];
        int c = playListDuration;
        for (i = n; i > 0; i--) {
            if (dp[i][c] == dp[i - 1][c]) {
                selected[i - 1] = false;
            } else {
                selected[i - 1] = true;
                c -= durations[i - 1];
            }
        }
        for (i = 0; i < n; i++) {
            if (selected[i]) {
                System.out.printf("%s, %s\n", titles[i], Duration.toString(durations[i]));
            }
        }
    }
}


// *********************************************************************************************************
// Following code are possible extending.
// Don't include those code at this moment to avoid over-engineering.
//

// Class Song is for further extending (when song has more and more properties, e.g. author, album, publish date, etc ).
// If we have a SQL DataStore in the future, save an Song object can also leverage ORM framework
class Song {
    private final String title;
    private final Duration duration;

    public Song(String title, Duration duration) {
        this.title = title;
        this.duration = duration;
    }
}

// ThreadSafeMemDataStore is a thread safe MemDataStore to allow accessed by multiple callers.
class ThreadSafeMemDataStore implements DataStore {
    private final MemDataStore memDataStore;
    private final Lock lock;

    public ThreadSafeMemDataStore() {
        memDataStore = new MemDataStore(Logger.getLogger(ThreadSafeMemDataStore.class.getName()));
        lock = new ReentrantLock();
    }

    public boolean saveSong(String title, String length) {
        lock.lock();
        boolean rslt = memDataStore.saveSong(title, length);
        lock.unlock();
        return rslt;
    }

    public Map<String, Integer> listSongsWithDurationNoMoreThan(int durattion) {
        lock.lock();
        Map<String, Integer> rslt = memDataStore.listSongsWithDurationNoMoreThan(durattion);
        lock.unlock();
        return rslt;
    }
}

// ObjectDataStore is a DataStore that can support complex query (e.g. SQL query).
interface ObjectDataStore extends DataStore {
    boolean saveSong(Song song);
    Map<String, Integer> listSongsWithFilter(String filter);
}

// SQLDataStore implement the ObjectDataStore interface.
class SQLDataStore implements ObjectDataStore {
    @Override
    public boolean saveSong(String title, String duration) {
        return false;
    }

    @Override
    public Map<String, Integer> listSongsWithDurationNoMoreThan(int duration) {
        return null;
    }

    @Override
    public boolean saveSong(Song song) {
        return false;
    }

    @Override
    public Map<String, Integer> listSongsWithFilter(String filter) {
        return null;
    }
}
