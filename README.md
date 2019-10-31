This is just a demo to remind me how Java works.

It assumes an accessible .jar JDBC driver for SQLite; the `run_server.bash` tool, which is _not_ very smart, assumes
it's local at sqlite-jdbc-3.27.2.1.jar.

The DB file will be created locally.

TODO: use prepared statements so we're not wide open to injection attacks :)
