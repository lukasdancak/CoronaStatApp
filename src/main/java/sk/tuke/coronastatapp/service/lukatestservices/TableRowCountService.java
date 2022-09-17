package sk.tuke.coronastatapp.service.lukatestservices;

public interface TableRowCountService {

    int getRowCountOfLocalTable(String tableName);

    int getRowCountOfGovTable(String tableName);


}
