
Spring Boot Tutorial for Beginners (Java Framework)
https://www.youtube.com/watch?v=vtPkZShrvXQ&list=PLRujfXEG5VVNpHQ75D-kQSx_3yP-VafnT&index=1

http://localhost:8080/api/v1/person

For 2nd part of the tutorial:
Start a postgres instance:
docker run --name postgres-spring -e POSTGRES_PASSWORD=password -d -p 5432:5432 postgres:alpine

SasMacMini-2021:springdemo schmatthes$ docker exec -it postgres-spring bash
d2f9f47b5a37:/# psql -U postgres
postgres=# CREATE DATABASE demodb;
CREATE DATABASE
postgres=# \l
List of databases
Name    |  Owner   | Encoding |  Collate   |   Ctype    | ICU Locale | Locale Provider |   Access privileges   
-----------+----------+----------+------------+------------+------------+-----------------+-----------------------
demodb    | postgres | UTF8     | en_US.utf8 | en_US.utf8 |            | libc            | 
...
postgres=# \c demodb
You are now connected to database "demodb" as user "postgres".

In IDEA click at "SpringdemoApplication" (next to the hammer icon)
Configuration setting -> make sure that only one running instance is allowed

In console output you will see 1 migration (flyway) was executed.

We see also the new table "person" in psql tool:
demodb=# \d

Enable uuid generation in pqsl:
demodb=# CREATE EXTENSION "uuid-ossp";

Verify it:
demodb=# SELECT uuid_generate_v4();
or like this:
demodb=# INSERT INTO person (id, name) VALUES (uuid_generate_v4(), 'Maria Jones');




Current time stamp:
1:32

