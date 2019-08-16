package com.example.voizfonica;

import com.example.voizfonica.data.DongleRepository;
import com.example.voizfonica.data.PlanRepository;
import com.example.voizfonica.model.DonglePurchase;
import com.example.voizfonica.model.PostpaidPlans;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.example.voizfonica.data")
public class VoizFonicaApplication {

    public static void main(String[] args) {
        SpringApplication.run(VoizFonicaApplication.class, args);
    }
    @Bean
public CommandLineRunner dataLoader(PlanRepository repo, DongleRepository dongleRepo) {
        return args -> {
            repo.deleteAll();
            repo.save(new PostpaidPlans("prepaid","₹","Starter Pack","30 days","399","45 GB","100Mbps","30 Days"));
            repo.save(new PostpaidPlans("prepaid","₹","Best Value","180 days","999","50 GB","360Mbps","60 Days"));
            repo.save(new PostpaidPlans("prepaid","₹","Power User","60 days","1999","75GB","600Mbps","90 Days"));
            repo.save(new PostpaidPlans("postpaid","₹","Starter Pack","30 days","399","45 GB","100Mbps","30 Days"));
            repo.save(new PostpaidPlans("postpaid","₹","Best Value","180 days","999","50 GB","360Mbps","60 Days"));
            repo.save(new PostpaidPlans("postpaid","₹","Power User","60 days","1999","75GB","600Mbps","90 Days"));
            repo.save(new PostpaidPlans("dongle","₹","Starter Pack","30 days","399","45 GB","100Mbps","30 Days"));
            repo.save(new PostpaidPlans("dongle","₹","Best Value","180 days","999","50 GB","360Mbps","60 Days"));
            repo.save(new PostpaidPlans("dongle","₹","Power User","60 days","1999","75GB","600Mbps","90 Days"));
            dongleRepo.deleteAll();
            dongleRepo.save(new DonglePurchase("Dongle1","₹999"));
            dongleRepo.save(new DonglePurchase("Dongle2","₹1999"));
            dongleRepo.save(new DonglePurchase("Dongle3","₹2999"));
        };
    }
}