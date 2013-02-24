set DEV_DB_HOME=%PROJECT_HOME%\PROJECTS-DB\DEV
set DEV_DB=vinavidaidb
java -cp %HSQL_HOME%\hsqldb.jar org.hsqldb.Server -database.0 file:%DEV_DB_HOME%\%DEV_DB% -dbname.0 %DEV_DB%