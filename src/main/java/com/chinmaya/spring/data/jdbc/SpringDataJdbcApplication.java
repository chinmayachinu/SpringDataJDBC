package com.chinmaya.spring.data.jdbc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SpringDataJdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJdbcApplication.class, args);
    }


    @Bean
    public CommandLineRunner myApplicationRunner(CustomerRepository customerRepository, JdbcTemplate jdbcTemplate) {
        return args -> {
            //use jdbc template without sql file as this is used by Spring JDBC
//            jdbcTemplate.execute("CREATE TABLE customer (id INTEGER PRIMARY KEY AUTO_INCREMENT,\n" +
//                    "    first_name VARCHAR(255) NOT NULL,\n" +
//                    "    last_name VARCHAR(255) NOT NULL)");
            Customer customer = new Customer(null, "Chinmaya", "Panigrahi");
            Customer result = customerRepository.save(customer);
            System.out.println("customer saved => " + result);
        };
    }
}

//@Service
//class StudentService {
//
//    @Autowired
//    private StudentRepository studentRepository;
//
//    Student saveStudent(Student student) {
//        Student result = studentRepository.save(student);
//        return result;
//    }
//
//    List<Student> getAllStudent() {
//        List<Student> all = (List<Student>) studentRepository.findAll();
//        return all;
//    }
//}
//
//@RestController
//class StudentController {
//
//    @Autowired
//    StudentService studentService;
//
//    @PostMapping("/")
//    String storeStudent(@RequestBody Student student) {
//        studentService.saveStudent(student);
//        return "student stored";
//    }
//
//    @GetMapping("/")
//    List<Student> getAllStudent() {
//        return studentService.getAllStudent();
//    }
//}