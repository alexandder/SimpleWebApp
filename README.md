# SimpleWebApp
<p>Konfiguracja serwera Glassfish 4.0:</p>
<br/>
<ol>
  <li>Najpierw należy pobrać jar z bazą H2 np. ze <a href="http://hsql.sourceforge.net/m2-repo/com/h2database/h2/1.4.188/h2-1.4.188.jar">strony</a></li>
  <li>Skopiować pobrany jar do folderu $GlASSFISH_HOME$/glassfish/domains/domian1/lib/ext</li>
  <li>Uruchomić serwer (albo z poziomu IDE albo z linii poleceń) i w przeglądarce wejść w localhost:4848</li>
  <li>W lewym menu wejść do Resources/JDBC/JDBC Connection Pools i kliknąć new</li>
  <li>Uzupełnić Pool name: 	H2Pool</li>
  <li>Resource type: javax.sql.DataSource</li>
  <li>Database Driver Vendor: H2 i zaznaczyć enabled</li>
  <li>Dalej Datasource classname: org.h2.jdbcx.JdbcDataSource i ping enabled</li>
  <li>W additional properties User: sa, Password: aa, URL: jdbc:h2:~/app;AUTO_SERVER=TRUE</li>
  <li>Następnie zakończyć i sprawdzić czy klikając Ping pojawia się komuniakt sukcesu. Przejść do JDBC Resources</li>
  <li>Stworzyć nowy z JNDI Name: jdbc/H2Pool oraz Pool name: H2Pool, Status: enabled. Zachować</li>
</ol>
