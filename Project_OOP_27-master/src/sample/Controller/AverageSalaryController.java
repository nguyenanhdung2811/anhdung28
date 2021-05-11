package sample.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.DAO.DatabaseConnect;
import sample.Model.PartTime;

import java.net.URL;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;

import sample.Model.*;

public class AverageSalaryController implements Initializable {
    private List<Employee> employeeList;
    private DatabaseConnect databaseConnect;

    @FXML
    private Button calavgbt, cancelbt;

    @FXML
    private TextField avgsal;

    @FXML
    private DatePicker datepicker;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            databaseConnect = new DatabaseConnect();
            employeeList = databaseConnect.getEmployList();
            System.out.println("Retrieve employees successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        calavgbt.setOnAction(event -> {
            System.out.println("call button ok");
            LocalDate date = datepicker.getValue();
            Double sum = 0.0;
            int count = 0;
            for (Employee employee:employeeList) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate temp_date = LocalDate.parse(employee.getTime_start(), formatter);
                if(temp_date.isBefore(date)) {
                    if(employee.getType().equals("Full Time")) {
                        sum += Double.parseDouble(((FullTime) employee).getSalary().replace(" triệu", ""));
                    } else if(employee.getType().equals("Part Time")) {
                        sum += Double.parseDouble(((PartTime) employee).getSalary().replace(" triệu", ""));
                    }
                    count++;
                }
            }

            System.out.println("Calculating average salary....");
            System.out.println("Do dai employlist: " + employeeList.size());
            System.out.println(sum);
            System.out.println(count);
            Double average_salary = sum / count;
            System.out.println(average_salary);
            avgsal.setEditable(true);
            DecimalFormat numberFormat = new DecimalFormat("#.00");
            String average_salary_converted = numberFormat.format(average_salary);
            avgsal.setText(average_salary_converted + " triệu");
            avgsal.setEditable(false);
        });

        cancelbt.setOnAction(event -> {
            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            stage.close();
        });
    }


}
