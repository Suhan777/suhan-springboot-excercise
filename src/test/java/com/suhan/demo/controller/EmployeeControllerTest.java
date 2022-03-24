package com.suhan.demo.controller;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.suhan.demo.models.Employee;
import com.suhan.demo.service.EmployeeService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(value = EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    Employee mockEmployee = new Employee("Suhan", "Muppavaram", "test@gmail.com");
    List<Employee> mockEmployees = Arrays.asList(new Employee("Suhan", "Muppavaram", "test@gmail.com"));
    List<Employee> mockEmployeesAll = Arrays.asList(new Employee("Suhan", "Muppavaram", "test@gmail.com"),
            new Employee("Barry", "Allen", "flash@gmail.com"));

    @Test
    void testGetAllEmployeeInfo() throws Exception {
        Mockito.when(employeeService.getAllEmployeeInfo()).thenReturn(mockEmployeesAll);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/employeeInfo")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(result.getResponse());
        String expectedResult = "[{\"firstName\":\"Suhan\",\"surName\":\"Muppavaram\",\"emailAddress\":\"test@gmail.com\"},{\"firstName\":\"Barry\",\"surName\":\"Allen\",\"emailAddress\":\"flash@gmail.com\"}]";
        assertEquals(expectedResult, result.getResponse().getContentAsString());
    }

    @Test
    void testGetEmployee() throws Exception {
        Mockito.when(employeeService.getEmployee("muppavaram")).thenReturn(mockEmployees);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/employeeInfo/muppavaram")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expectedResult = "[{\"firstName\":\"Suhan\",\"surName\":\"Muppavaram\",\"emailAddress\":\"test@gmail.com\"}]";
        assertEquals(expectedResult, result.getResponse().getContentAsString());
    }

    @Test
    void testNewEmployee() throws Exception{
        Mockito.when(employeeService.createEmployee(any(Employee.class))).thenReturn(mockEmployee);
        String expectedResult = "{\"firstName\":\"Suhan\",\"surName\":\"Muppavaram\",\"emailAddress\":\"test@gmail.com\"}";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/employeeInfo/addEmployee")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(mockEmployee));
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        assertEquals(expectedResult, result.getResponse().getContentAsString());
    }

    @Test
    void testNewEmployees() throws Exception {
        Mockito.when(employeeService.createEmployees(any())).thenReturn(mockEmployees);
        String expectedResult = "[{\"firstName\":\"Suhan\",\"surName\":\"Muppavaram\",\"emailAddress\":\"test@gmail.com\"}]";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/employeeInfo/addEmployees")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(mockEmployees));
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        assertEquals(expectedResult, result.getResponse().getContentAsString());
    }

    private static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
