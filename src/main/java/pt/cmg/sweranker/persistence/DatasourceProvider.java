package pt.cmg.sweranker.persistence;

import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;

/**
 * @author Carlos Gonçalves
 */
@Singleton
@DataSourceDefinition(
    name = "java:global/SwerankerDataSource",
    className = "${datasource.javaclass}",
    user = "${database.user}",
    password = "${database.password}",
    serverName = "${database.host}",
    portNumber = 5432, // port must always be an integer
    databaseName = "${database.name}",
    properties = {"stringtype=unspecified", "fish.payara.log-jdbc-calls=true"},
    initialPoolSize = 1,
    maxPoolSize = 5)
public class DatasourceProvider {
}
