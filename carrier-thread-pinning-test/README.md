# Carrier Thread Pinning Test

JEP-491 resolved Virtual Thread's carrier-thread pinning issue from JDK 24. So I tested it.

Ref) https://openjdk.org/jeps/491

## Runbook
1. Download JDK 21 and 24
2. Set SDK from `File > Project Structure > SDK`
   - ![img.png](https://github.com/user-attachments/assets/cf3dc348-f653-4b5b-ad3f-d8475fe1f962)
3. Run `VirtualThreadSynchronizedTest.java` or `PlatformThreadSynchronizedTest.java`

## Result
### JDK 21 + Platform Thread
synchronized tasks doesn't block other non-synchronized tasks.
All non-sync logics complete in about 1 second.
```
carrierThreadParallelism: 7
[sync][Thread-0][9 ms] Start: 0
[non-sync][Thread-1][9 ms] Start: 0
[non-sync][Thread-3][9 ms] Start: 1
[non-sync][Thread-5][9 ms] Start: 2
[non-sync][Thread-7][9 ms] Start: 3
[non-sync][Thread-9][9 ms] Start: 4
[non-sync][Thread-11][10 ms] Start: 5
[non-sync][Thread-13][10 ms] Start: 6
[non-sync][Thread-15][10 ms] Start: 7
[non-sync][Thread-17][10 ms] Start: 8
[non-sync][Thread-19][10 ms] Start: 9
[non-sync][Thread-21][10 ms] Start: 10
[non-sync][Thread-23][10 ms] Start: 11
[non-sync][Thread-25][11 ms] Start: 12
[non-sync][Thread-27][11 ms] Start: 13
[non-sync][Thread-1][1029 ms] End: 0
[non-sync][Thread-5][1029 ms] End: 2
[non-sync][Thread-7][1030 ms] End: 3
[non-sync][Thread-3][1029 ms] End: 1
[sync][Thread-0][1029 ms] End: 0
[non-sync][Thread-9][1030 ms] End: 4
[non-sync][Thread-11][1030 ms] End: 5
[non-sync][Thread-13][1030 ms] End: 6
[non-sync][Thread-15][1030 ms] End: 7
[non-sync][Thread-23][1030 ms] End: 11
[non-sync][Thread-25][1030 ms] End: 12
[non-sync][Thread-17][1031 ms] End: 8
[non-sync][Thread-19][1031 ms] End: 9
[non-sync][Thread-21][1031 ms] End: 10
[non-sync][Thread-27][1031 ms] End: 13
[sync][Thread-26][1031 ms] Start: 13
[sync][Thread-26][2036 ms] End: 13
[sync][Thread-24][2037 ms] Start: 12
[sync][Thread-24][3038 ms] End: 12
[sync][Thread-22][3038 ms] Start: 11
[sync][Thread-22][4043 ms] End: 11
[sync][Thread-20][4044 ms] Start: 10
[sync][Thread-20][5046 ms] End: 10
[sync][Thread-18][5046 ms] Start: 9
[sync][Thread-18][6052 ms] End: 9
[sync][Thread-16][6053 ms] Start: 8
[sync][Thread-16][7058 ms] End: 8
[sync][Thread-14][7059 ms] Start: 7
[sync][Thread-14][8060 ms] End: 7
[sync][Thread-12][8061 ms] Start: 6
[sync][Thread-12][9067 ms] End: 6
[sync][Thread-10][9067 ms] Start: 5
[sync][Thread-10][10073 ms] End: 5
[sync][Thread-8][10073 ms] Start: 4
[sync][Thread-8][11079 ms] End: 4
[sync][Thread-6][11080 ms] Start: 3
[sync][Thread-6][12085 ms] End: 3
[sync][Thread-4][12086 ms] Start: 2
[sync][Thread-4][13091 ms] End: 2
[sync][Thread-2][13092 ms] Start: 1
[sync][Thread-2][14096 ms] End: 1
```

### JDK 21 + Virtual Thread
synchronized tasks block other non-synchronized tasks: carrier-thread-pinning issue
Some non-sync logic takes much longer than 1 second due to carrier-thread-pinning issue (8 seconds in the example below).
```
carrierThreadParallelism: 7
[sync][][11 ms] Start: 0
[sync][][1029 ms] End: 0
[non-sync][][11 ms] Start: 0
[non-sync][][11 ms] Start: 1
[non-sync][][11 ms] Start: 2
[non-sync][][12 ms] Start: 3
[non-sync][][12 ms] Start: 4
[non-sync][][12 ms] Start: 5
[non-sync][][12 ms] Start: 6
[sync][][1034 ms] Start: 7
[sync][][2043 ms] End: 7
[sync][][2044 ms] Start: 6
[sync][][3048 ms] End: 6
[sync][][3049 ms] Start: 5
[sync][][4054 ms] End: 5
[sync][][4055 ms] Start: 4
[sync][][5057 ms] End: 4
[sync][][5058 ms] Start: 2
[sync][][6061 ms] End: 2
[non-sync][][1037 ms] Start: 7
[non-sync][][2044 ms] Start: 8
[non-sync][][3050 ms] Start: 9
[non-sync][][4055 ms] Start: 10
[non-sync][][5058 ms] Start: 11
[non-sync][][6064 ms] Start: 12
[sync][][6062 ms] Start: 3
[sync][][7069 ms] End: 3
[sync][][7070 ms] Start: 1
[non-sync][][7070 ms] End: 4
[non-sync][][7071 ms] End: 5
[non-sync][][7071 ms] End: 6
[non-sync][][7072 ms] End: 7
[non-sync][][7072 ms] End: 8
[non-sync][][7073 ms] End: 9
[non-sync][][7073 ms] End: 10
[non-sync][][7073 ms] End: 11
[non-sync][][7073 ms] End: 12
[non-sync][][7070 ms] Start: 13
[non-sync][][7070 ms] End: 0
[non-sync][][7070 ms] End: 1
[non-sync][][7070 ms] End: 2
[non-sync][][7070 ms] End: 3
[sync][][8073 ms] End: 1
[sync][][8073 ms] Start: 13
[non-sync][][8075 ms] End: 13
[sync][][9079 ms] End: 13
[sync][][9080 ms] Start: 12
[sync][][10084 ms] End: 12
[sync][][10085 ms] Start: 11
[sync][][11091 ms] End: 11
[sync][][11092 ms] Start: 10
[sync][][12095 ms] End: 10
[sync][][12095 ms] Start: 9
[sync][][13100 ms] End: 9
[sync][][13101 ms] Start: 8
[sync][][14104 ms] End: 8
```

### JDK 24 + Virtual Thread
synchronized tasks don't block other non-synchronized tasks.
All non-sync logics complete in about 1 second.
```
carrierThreadParallelism: 7
[sync][][13 ms] Start: 0
[non-sync][][13 ms] Start: 12
[non-sync][][13 ms] Start: 13
[non-sync][][13 ms] Start: 8
[non-sync][][13 ms] Start: 7
[non-sync][][13 ms] Start: 5
[non-sync][][13 ms] Start: 6
[non-sync][][13 ms] Start: 11
[non-sync][][13 ms] Start: 10
[non-sync][][13 ms] Start: 9
[non-sync][][13 ms] Start: 4
[non-sync][][13 ms] Start: 2
[non-sync][][13 ms] Start: 3
[non-sync][][13 ms] Start: 0
[non-sync][][13 ms] Start: 1
[non-sync][][1030 ms] End: 13
[non-sync][][1031 ms] End: 1
[non-sync][][1031 ms] End: 0
[non-sync][][1031 ms] End: 3
[non-sync][][1031 ms] End: 2
[non-sync][][1031 ms] End: 4
[non-sync][][1031 ms] End: 9
[non-sync][][1031 ms] End: 10
[non-sync][][1031 ms] End: 11
[non-sync][][1031 ms] End: 6
[non-sync][][1031 ms] End: 5
[non-sync][][1031 ms] End: 7
[non-sync][][1031 ms] End: 8
[non-sync][][1031 ms] End: 12
[sync][][1030 ms] End: 0
[sync][][1038 ms] Start: 13
[sync][][2043 ms] End: 13
[sync][][2045 ms] Start: 11
[sync][][3050 ms] End: 11
[sync][][3051 ms] Start: 12
[sync][][4057 ms] End: 12
[sync][][4057 ms] Start: 10
[sync][][5060 ms] End: 10
[sync][][5061 ms] Start: 9
[sync][][6066 ms] End: 9
[sync][][6067 ms] Start: 8
[sync][][7069 ms] End: 8
[sync][][7070 ms] Start: 7
[sync][][8076 ms] End: 7
[sync][][8076 ms] Start: 6
[sync][][9078 ms] End: 6
[sync][][9079 ms] Start: 4
[sync][][10084 ms] End: 4
[sync][][10085 ms] Start: 5
[sync][][11087 ms] End: 5
[sync][][11088 ms] Start: 3
[sync][][12089 ms] End: 3
[sync][][12090 ms] Start: 1
[sync][][13096 ms] End: 1
[sync][][13097 ms] Start: 2
[sync][][14098 ms] End: 2
```