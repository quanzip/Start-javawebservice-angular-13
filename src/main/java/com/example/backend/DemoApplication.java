package com.example.backend;

import com.example.backend.config.Employee;
import com.example.backend.config.QuanaqtConfig;
import com.example.backend.config.QuanzipConfig;
import com.example.backend.entity.Authority;
import com.example.backend.entity.People;
import com.example.backend.entity.People_;
import com.example.backend.entity.Soccer;
import com.example.backend.repository.AuthorityRepository;
import com.example.backend.repository.PeopleRepository;
import com.example.backend.service.event_publisher.Publisher;
import lombok.extern.java.Log;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.StandardEnvironment;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
// if in class: QuanaqtConfig there are no @Configuration for spring knows this is a bean to create
// then we must add following line
//@EnableConfigurationProperties({QuanaqtConfig.class, QuanzipConfig.class})
@PropertySources({
//        @PropertySource("classpath:application-employee.yml")
})
public class DemoApplication  implements CommandLineRunner {

    @Autowired
    private Publisher publisher;

    @Autowired
    PeopleRepository peopleRepository;

    @Autowired
    AuthorityRepository authorityRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(DemoApplication.class);

        StandardEnvironment environment = new StandardEnvironment();
        environment.setActiveProfiles("dev");

        springApplication.setEnvironment(environment);
        ConfigurableApplicationContext context = springApplication.run(args);
        QuanaqtConfig quanaqtConfig = context.getBean(QuanaqtConfig.class);
        QuanzipConfig quanzipConfig = context.getBean(QuanzipConfig.class);
        Employee employee = context.getBean(Employee.class);

        System.out.println(quanaqtConfig);
        System.out.println(quanzipConfig);
        System.out.println(employee);

        Publisher publisher = context.getBean(Publisher.class);
        publisher.goFishingPublisher();

        Soccer soccer = new Soccer(DemoApplication.class, "My Dinh, Ha Noi, Viet Nam", 25);
        publisher.playSoccerPublisher(soccer, LocalDateTime.now());
    }


//    @Conditional N???u kh??ng c?? @conditional s??? kh??ng th??? g???i ph????ng th???c  people.getAuthorities()
//    V?? khi n??y ph????ng th???c ???? n???m ngo??i session c???a hibernate, c?? @Conditional gi??p c??? ph????ng th???c ???????c
//    qu???n l?? b??n trong session c???a hibernate -> kh??ng l???i
//    - Nh??ng v???i case b??n d?????i, do mapping thu???c t??nh ???? g???i t???i getAuthorities() ho???c getAuthorities().size()
//    l??c n??o ????, d???n t???i list data ???? ???????c load v??o getAuthorities()
//    M???c ?????nh FetchType.Lazy s??? kh??ng loafd s???n data v??o property: authorities c???a People.

    @Override
    public void run(String... args) throws Exception {
//        peopleRepository.deleteAll();
//        authorityRepository.deleteAll();
//        Authority authority = new Authority(null, "VIEW");
//        People people = new People(null, "quan", "Pham Hong", passwordEncoder.encode("123456"), 5,1,
//                new HashSet<Authority>(){{
//                    add(authority);
//                }});
//        peopleRepository.save(people);
    }
}
