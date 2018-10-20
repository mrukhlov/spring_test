package demo.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.intellij.lang.annotations.Language;
import demo.model.Seller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SellerDao implements Dao<Seller> {

    private static final Logger log = LogManager.getLogger(SellerDao.class);

//    @Language("sql")
    private static final String SELECT_ALL_USERS = "select * from seller";

    @Override
    public List<Seller>getAll() {
        List<Seller> sellers = new ArrayList<>();
        try (Connection con = DbConnector.getConnection();
            Statement stm = con.createStatement()
        ) {
            ResultSet rs = stm.executeQuery(SELECT_ALL_USERS);
            while (rs.next()) {
                sellers.add(mapToUser(rs));
            }
        } catch (SQLException e) {
            log.error("Failed to getAll.", e);
            return Collections.emptyList();
        }
        return sellers;
    }

    private static Seller mapToUser(ResultSet rs) throws SQLException {
        return new Seller()
                .setId(rs.getInt("id"))
                .setName(rs.getString("name"));
    }

}
