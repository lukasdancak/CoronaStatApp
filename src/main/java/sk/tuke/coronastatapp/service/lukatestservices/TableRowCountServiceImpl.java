package sk.tuke.coronastatapp.service.lukatestservices;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
public class TableRowCountServiceImpl implements TableRowCountService {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public int getRowCountOfLocalTable(String tableName) {
        tableName = "vaccination_contact";
        try {
            System.out.println("spustam query v getrowCountLocalTable");

            //var query = entityManager.createQuery("SELECT COUNT(*) FROM VaccinationContact")
            var query = entityManager.createNativeQuery("SELECT COUNT(*) FROM " + tableName + ";")

                    .getSingleResult();
            System.out.println(query);
            int i = Integer.valueOf(query.toString());

            System.out.println("koncim query v getrowCountLocalTable");
            return i;
        } catch (Exception e) {
            //e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int getRowCountOfGovTableWithOffset(String tableName) {
        return 0;
    }

    @Override
    public int getRowCountOfGovTableNoOffset(String tableName) {
        return 0;
    }
}
