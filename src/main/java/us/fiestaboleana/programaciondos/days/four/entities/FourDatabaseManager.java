package us.fiestaboleana.programaciondos.days.four.entities;

import us.fiestaboleana.java.storage.SQLHolder;

import java.io.File;
import java.sql.*;
import java.util.UUID;

public class FourDatabaseManager {
    private SQLHolder holder;

    public FourDatabaseManager() {
        loadDatabase();
    }

    public void loadDatabase() {
        this.holder = new SQLHolder("database", new File(System.getProperty("user.home"), "Desktop"));
        this.holder.getDatabase().createTable("data", "ID VARCHAR(100),CLIENTE BLOB", "ID");
    }

    public void reload() {
        System.out.println("Reloading database...");
        loadDatabase();
    }

    public Connection getConnection() {
        return this.holder.getDatabase().getConnection();
    }

    public boolean exists(String id) {
        return this.holder.getDatabase().exists("data", "ID", id);
    }

    public void createUser(String id, boolean useSQLite) {
        Connection connection = null;
        String x = "INSERT IGNORE INTO data";
        if (useSQLite)
            x = "INSERT OR IGNORE INTO data";
        try {
            connection = this.holder.getDatabase().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(x + " (ID) VALUES (?)");
            try {
                if (!exists(id)) {
                    preparedStatement.setString(1, id);
                    preparedStatement.executeUpdate();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                    preparedStatement.getConnection().close();
                }
            } catch (Throwable throwable) {
                if (preparedStatement != null)
                    try {
                        preparedStatement.close();
                        preparedStatement.getConnection().close();
                    } catch (Throwable throwable1) {
                        throwable.addSuppressed(throwable1);
                    }
                throw throwable;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null)
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }

    public static FourCliente fromResultSet(ResultSet resultSet) {
        FourCliente cliente;
        byte[] bytes;
        try {
            bytes = resultSet.getBytes("CLIENTE");
            resultSet.close();
            Statement statement = resultSet.getStatement();
            statement.close();
            statement.getConnection().close();
            cliente = FourCliente.deserialize(bytes);
            return cliente;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return FourCliente.build(UUID.randomUUID().toString());
    }

    public FourCliente get(String id) {
        PreparedStatement statement = this.holder.getDatabase().selectAllFromData("database", "ID", id);
        FourCliente cliente;
        try {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                byte[] bytes = resultSet.getBytes("CLIENTE");
                resultSet.close();
                statement.close();
                statement.getConnection().close();
                cliente = FourCliente.deserialize(bytes);
                return cliente;
            } else {
                id = UUID.randomUUID().toString();
                createUser(id, true);
                resultSet.close();
                statement.close();
                statement.getConnection().close();
                return FourCliente.build(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                statement.getConnection().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return FourCliente.build(UUID.randomUUID().toString());
    }

    public void save(FourCliente cliente) {
        PreparedStatement statement = this.holder.getDatabase().updateDataSet("ID", "data", "CLIENTE=?");
        try {
            statement.setBytes(1, cliente.serialize());
            statement.setString(2, cliente.getId());
            statement.executeUpdate();
            System.out.println("Saved " + cliente.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                statement.getConnection().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
