This is just a demo to remind me how Java works.

# Summary
This is a stand-alone http app that maintains a simple list of key-value pairs. 

A request of the form `protocol://host/set/key/value` will set a KVP, overwriting if one already exists for that key.

A request of the form `protocl://host/get/key` or `protocl://host/get/key/key` etc will return a list of the associated
values, probably out of order.

# Installation
It assumes an accessible .jar JDBC driver for SQLite; the `run_server.bash` tool, which is _not_ very smart, assumes
it's local at sqlite-jdbc-3.27.2.1.jar.

The DB file will be created locally.

# TODO: 
- use prepared statements so w e're not wide open to injection attacks :)
- Add some formal testing.
- Learn modern best practice and coding standards for basically everything.
- Comment the code.
- Return requested values in order.
