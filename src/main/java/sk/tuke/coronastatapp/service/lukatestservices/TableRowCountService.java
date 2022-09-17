package sk.tuke.coronastatapp.service.lukatestservices;

public interface TableRowCountService {

    int getRowCountOfLocalTable(String tableName);

    int getRowCountOfGovTableWithOffset(String tableName);

    int getRowCountOfGovTableNoOffset(String tableName);


}
