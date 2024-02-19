package ru.sbertroika.service_for_db.TMS;
import ru.sbertroika.service_for_db.TMS.entities.Organization;
import ru.sbertroika.service_for_db.TMS.entities.Terminal;
import ru.sbertroika.service_for_db.TMS.entities.TerminalType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class JdbcService {
    private PreparedStatement prSt;
    private Statement st;
    ConnectionDB connectionDB = new ConnectionDB();

    public void getPreparedStatement(String query, String[] params) {
        try {
            prSt = connectionDB.getConnection().prepareStatement(query);
            for (int i = 1; i <= params.length; i++) {
                prSt.setString(i, params[i - 1]);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getStatement() {
        try {
            st = connectionDB.getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Terminal> getTerminalList() {
        List<Terminal> terminals = new ArrayList<>();
        getStatement();
        try {
            ResultSet rs = st.executeQuery(Queries.SELECT_TERMINAL_LIST.getValue());
            while (rs.next()) {
                Terminal terminal = new Terminal(rs.getObject(1, java.util.UUID.class),
                        rs.getString(2),
                        rs.getString(3),
                        getNameById(Queries.SELECT_TYPE_BY_ID, rs.getString(4)),
                        getNameById(Queries.SELECT_ORGANIZATION_BY_ID, rs.getString(5)));
                terminals.add(terminal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return terminals;
    }

    public List<TerminalType> getTypeList() {
        List<TerminalType> types = new ArrayList<>();
        getStatement();
        try {
            ResultSet rs = st.executeQuery(Queries.SELECT_TYPE_LIST.getValue());
            while (rs.next()) {
                TerminalType type = new TerminalType(rs.getObject(1, java.util.UUID.class),
                        rs.getString(2));
                types.add(type);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return types;
    }

    public List<Organization> getOrganizationList() {
        List<Organization> orgs = new ArrayList<>();
        getStatement();
        try {
            ResultSet rs = st.executeQuery(Queries.SELECT_ORGANIZATION_LIST.getValue());
            while (rs.next()) {
                Organization org = new Organization(rs.getObject(1, java.util.UUID.class),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4));
                orgs.add(org);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orgs;
    }

    public void deleteTerminalById(UUID id) {
        try {
            prSt = connectionDB.getConnection().prepareStatement(Queries.DELETE_TERMINAL_BY_ID.getValue());
            prSt.setObject(1, id);
            try {
                prSt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTYPEById(UUID id) {
        try {
            prSt = connectionDB.getConnection().prepareStatement(Queries.DELETE_TYPE_BY_ID.getValue());
            prSt.setObject(1, id);
            try {
                prSt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteOrganizationById(UUID id) {
        try {
            prSt = connectionDB.getConnection().prepareStatement(Queries.DELETE_ORGANIZATION_BY_ID.getValue());
            prSt.setObject(1, id);
            try {
                prSt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTerminalBySN(String serialNumber) {
        getPreparedStatement(Queries.DELETE_TERMINAL_BY_SN.getValue(), new String[]{serialNumber});
        try {
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getNameById (Queries query, String id) {
        try {
            prSt = connectionDB.getConnection().prepareStatement(query.getValue());
            prSt.setObject(1, UUID.fromString(id));
            try {
                ResultSet resultSet = prSt.executeQuery();
                if (resultSet.next()) {
                    return resultSet.getString(1);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getIdByName (Queries query, String name) {
        try {
            prSt = connectionDB.getConnection().prepareStatement(query.getValue());
            prSt.setObject(1, name);
            try {
                ResultSet resultSet = prSt.executeQuery();
                if (resultSet.next()) {
                    return resultSet.getString(1);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void disconnect() {
        try {
            if (st != null) {
                st.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (prSt != null) {
                prSt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (connectionDB.getConnection() != null) {
                connectionDB.getConnection().close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
