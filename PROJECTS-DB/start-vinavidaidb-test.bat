set TEST_DB_HOME=%PROJECT_HOME%\PROJECTS-DB\TEST
set TEST_DB=vinavidaidbtest
java -cp %HSQL_HOME%\hsqldb.jar org.hsqldb.Server -port 9002 -database.0 file:%TEST_DB_HOME%\%TEST_DB% -dbname.0 %TEST_DB%