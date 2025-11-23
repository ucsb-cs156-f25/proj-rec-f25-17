package edu.ucsb.cs156.rec.seed;

import edu.ucsb.cs156.rec.entities.RequestType;
import edu.ucsb.cs156.rec.repositories.RequestTypeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RequestTypeSeeder implements CommandLineRunner {

  private final RequestTypeRepository repo;

  public RequestTypeSeeder(RequestTypeRepository repo) {
    this.repo = repo;
  }

  @Override
  public void run(String... args) {
    if (repo.findByRequestType("CS Department BS/MS program").isEmpty()) {
      RequestType rt = new RequestType();
      rt.setRequestType("CS Department BS/MS program");
      repo.save(rt);
    }

    if (repo.findByRequestType("Scholarship or Fellowship").isEmpty()) {
      RequestType rt = new RequestType();
      rt.setRequestType("Scholarship or Fellowship");
      repo.save(rt);
    }

    if (repo.findByRequestType("MS program (other than CS Dept BS/MS)").isEmpty()) {
      RequestType rt = new RequestType();
      rt.setRequestType("MS program (other than CS Dept BS/MS)");
      repo.save(rt);
    }

    if (repo.findByRequestType("PhD program").isEmpty()) {
      RequestType rt = new RequestType();
      rt.setRequestType("PhD program");
      repo.save(rt);
    }
  }
}
