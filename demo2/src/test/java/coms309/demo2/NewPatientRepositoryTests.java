package coms309.demo2;

import coms309.demo2.model.NewPatient;
import coms309.demo2.repository.NewPatientRepository;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.hamcrest.MatcherAssert.assertThat;

@DataJpaTest
@Rollback(false)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class NewPatientRepositoryTests {

    @Autowired
    private NewPatientRepository newPatientRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateNewPatient(){
        NewPatient newPatient = new NewPatient();
        newPatient.setFirstName("Will");
        newPatient.setMiddleName("G");
        newPatient.setLastName("Postler");
        newPatient.setPhoneNumber("1234567890");
        newPatient.setEmailAddress("ryan@email.com");
        newPatient.setDateOfBirth("12/31/00");
        newPatient.setSsn("123456789");
        newPatient.setStreetAddress("123 Main St");
        newPatient.setCity("Ames");
        newPatient.setZip("52240");
        newPatient.setStateInitials("IA");
        newPatient.setInsurersName("Blue Cross");
        newPatient.setPolicyHolder("Me");
        newPatient.setGroupNumber("12345");
        newPatient.setPassword("password");

        NewPatient savedNewPatient = newPatientRepository.save(newPatient);

        NewPatient existPatient = entityManager.find(NewPatient.class, savedNewPatient.getId());

        assertThat(existPatient.getEmailAddress()).isEqualTo(newPatient.getEmailAddress());
    }


}
