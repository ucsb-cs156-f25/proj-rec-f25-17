package edu.ucsb.cs156.rec.seed;

import static org.junit.jupiter.api.Assertions.*;

import edu.ucsb.cs156.rec.repositories.RequestTypeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RequestTypeSeederIT {

  @Autowired private RequestTypeRepository requestTypeRepository;

  @Autowired private RequestTypeSeeder requestTypeSeeder;

  @Test
  public void testSeederInsertsTypeOneRequestType() {
    requestTypeRepository.deleteAll();
    requestTypeSeeder.run();

    var result = requestTypeRepository.findByRequestType("CS Department BS/MS program");
    assertTrue(result.isPresent(), "CS Department BS/MS program RequestType should be seeded");
  }

  @Test
  public void testSeederInsertsTypeTwoRequestType() {
    requestTypeRepository.deleteAll();
    requestTypeSeeder.run();

    var result = requestTypeRepository.findByRequestType("Scholarship or Fellowship");
    assertTrue(result.isPresent(), "Scholarship or Fellowship RequestType should be seeded");
  }

  @Test
  public void testSeederInsertsTypeThreeRequestType() {
    requestTypeRepository.deleteAll();
    requestTypeSeeder.run();

    var result = requestTypeRepository.findByRequestType("MS program (other than CS Dept BS/MS)");
    assertTrue(
        result.isPresent(), "MS program (other than CS Dept BS/MS) RequestType should be seeded");
  }

  @Test
  public void testSeederInsertsTypeFourRequestType() {
    requestTypeRepository.deleteAll();
    requestTypeSeeder.run();

    var result = requestTypeRepository.findByRequestType("PhD program");
    assertTrue(result.isPresent(), "PhD program");
  }

  @Test
  public void testSeederDoesNotInsertDuplicates() {

    long initialCount = requestTypeRepository.count();

    requestTypeSeeder.run();

    long afterSecondRun = requestTypeRepository.count();

    assertEquals(
        initialCount,
        afterSecondRun,
        "Seeder should not insert duplicates when run multiple times");
  }
}
