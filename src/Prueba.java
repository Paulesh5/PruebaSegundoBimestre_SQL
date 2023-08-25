import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Prueba {
    static final String DB_URL="jdbc:mysql://localhost/PERSONAS";
    static final String USER="root";
    static final String PASS="root_bas3";
    static final String QUERY= "SELECT * FROM REGISTROS";
    private JLabel Titulo;
    private JPanel rootPanel;
    private JLabel codigo;
    private JTextField codigoIngreso;
    private JTextField cedulaIngreso;
    private JTextField nombreIngreso;
    private JTextField nacimientoIngreso;
    private JLabel cedula;
    private JLabel nombre;
    private JLabel nacimiento;
    private JComboBox signoIngreso;
    private JButton buscarCodigoButton;
    private JButton buscarNombreButton;
    private JButton buscarSignoButton;
    private JButton borrarButton;
    private JButton actualizarButton;
    private JButton ingresarButton;
    private JButton limpiarButton;

    public Prueba() {
        buscarCodigoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS)) {
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(QUERY + " WHERE Codigo=" + codigoIngreso.getText());

                    if (resultSet.next()) {
                        cedulaIngreso.setText(resultSet.getString("cedula"));
                        nombreIngreso.setText(resultSet.getString("nombre"));
                        nacimientoIngreso.setText(resultSet.getString("nacimiento"));
                        signoIngreso.setSelectedItem(resultSet.getString("signo"));

                    } else {
                        JOptionPane.showMessageDialog(rootPanel, "No se encontraron resultados para el código ingresado.", "Error", JOptionPane.ERROR_MESSAGE);
                        cedulaIngreso.setText("");
                        nombreIngreso.setText("");
                        nacimientoIngreso.setText("");
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        buscarNombreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS)) {
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(QUERY + " WHERE Nombre='" + nombreIngreso.getText() + "'");

                    if (resultSet.next()) {
                        codigoIngreso.setText(resultSet.getString("codigo"));
                        cedulaIngreso.setText(resultSet.getString("cedula"));
                        nacimientoIngreso.setText(resultSet.getString("nacimiento"));
                        signoIngreso.setSelectedItem(resultSet.getString("signo"));

                    } else {
                        JOptionPane.showMessageDialog(rootPanel, "No se encontraron resultados para el nombre ingresado.", "Error", JOptionPane.ERROR_MESSAGE);
                        cedulaIngreso.setText("");
                        nombreIngreso.setText("");
                        nacimientoIngreso.setText("");
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        buscarSignoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS)) {
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(QUERY + " WHERE Signo='" + signoIngreso.getSelectedItem() + "'");

                    if (resultSet.next()) {
                        codigoIngreso.setText(resultSet.getString("codigo"));
                        cedulaIngreso.setText(resultSet.getString("cedula"));
                        nombreIngreso.setText(resultSet.getString("nombre"));
                        nacimientoIngreso.setText(resultSet.getString("nacimiento"));

                    } else {
                        JOptionPane.showMessageDialog(rootPanel, "No se encontraron resultados para el signo ingresado.", "Error", JOptionPane.ERROR_MESSAGE);
                        cedulaIngreso.setText("");
                        nombreIngreso.setText("");
                        nacimientoIngreso.setText("");
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        borrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = codigoIngreso.getText();

                try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS)) {
                    String deleteQuery = "DELETE FROM REGISTROS WHERE Codigo=" + codigo;

                    Statement statement = connection.createStatement();
                    int rowsDeleted = statement.executeUpdate(deleteQuery);

                    if (rowsDeleted > 0) {
                        JOptionPane.showMessageDialog(rootPanel, "Registro eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        cedulaIngreso.setText("");
                        nombreIngreso.setText("");
                        nacimientoIngreso.setText("");
                        signoIngreso.setSelectedItem(null);
                    } else {
                        JOptionPane.showMessageDialog(rootPanel, "No se encontró ningún registro con el código ingresado.", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = codigoIngreso.getText();
                String cedula = cedulaIngreso.getText();
                String nombre = nombreIngreso.getText();
                String nacimiento = nacimientoIngreso.getText();
                String signo = (String) signoIngreso.getSelectedItem();

                try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS)) {
                    String updateQuery = "UPDATE REGISTROS SET Cedula='" + cedula + "', Nombre='" + nombre + "', Nacimiento='" + nacimiento + "', Signo='" + signo + "' WHERE Codigo=" + codigo;

                    Statement statement = connection.createStatement();
                    int rowsUpdated = statement.executeUpdate(updateQuery);

                    if (rowsUpdated > 0) {
                        JOptionPane.showMessageDialog(rootPanel, "Registro actualizado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(rootPanel, "No se encontró ningún registro con el código ingresado.", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = codigoIngreso.getText();
                String cedula = cedulaIngreso.getText();
                String nombre = nombreIngreso.getText();
                String nacimiento = nacimientoIngreso.getText();
                String signo = (String) signoIngreso.getSelectedItem();

                try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS)) {
                    String updateQuery = "INSERT INTO REGISTROS VALUES (" + codigo + ", '" + cedula + "', '" + nombre + "', '" + nacimiento + "', '" + signo + "')";

                    Statement statement = connection.createStatement();
                    int rowsUpdated = statement.executeUpdate(updateQuery);

                    if (rowsUpdated > 0) {
                        JOptionPane.showMessageDialog(rootPanel, "Registro actualizado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(rootPanel, "No se encontró ningún registro con el código ingresado.", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                codigoIngreso.setText("");
                cedulaIngreso.setText("");
                nombreIngreso.setText("");
                nacimientoIngreso.setText("año-mes-dia");
                signoIngreso.setSelectedItem("Aries");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Prueba");
        frame.setContentPane(new Prueba().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
