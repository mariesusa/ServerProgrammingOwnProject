package ServerProgramming.PhysicalRecordings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ServerProgramming.PhysicalRecordings.domain.Condition;
import ServerProgramming.PhysicalRecordings.domain.ConditionRepository;
import ServerProgramming.PhysicalRecordings.domain.Format;
import ServerProgramming.PhysicalRecordings.domain.FormatRepository;
import ServerProgramming.PhysicalRecordings.domain.Genre;
import ServerProgramming.PhysicalRecordings.domain.GenreRepository;
import ServerProgramming.PhysicalRecordings.domain.Recording;
import ServerProgramming.PhysicalRecordings.domain.RecordingRepository;
import ServerProgramming.PhysicalRecordings.domain.User;
import ServerProgramming.PhysicalRecordings.domain.UserRepository;

@SpringBootApplication
public class PhysicalRecordingsApplication {
	
	private static final Logger log = LoggerFactory.getLogger(PhysicalRecordingsApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(PhysicalRecordingsApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner recordDemo(RecordingRepository rrepository, FormatRepository frepository, ConditionRepository crepository, GenreRepository grepository, UserRepository urepository) {
		return (args) -> {
			log.info("save new recordings");
			
			frepository.save(new Format("Cassette"));
			frepository.save(new Format("CD"));
			frepository.save(new Format("Vinyl"));
			
			crepository.save(new Condition("Mint"));
			crepository.save(new Condition("Mint-"));
			crepository.save(new Condition("VG+"));
			crepository.save(new Condition("VG"));
			crepository.save(new Condition("G+"));
			crepository.save(new Condition("F"));
			
			grepository.save(new Genre("Classical"));
			grepository.save(new Genre("Punk"));
			grepository.save(new Genre("Rock"));
			
			rrepository.save(new Recording("Garbage", "Garbage", 1995, "Mushroom Records", "Great debut", 4.00, frepository.findByFormat("Cassette").get(0), crepository.findByCondition("Mint").get(0), grepository.findByGenre("Rock").get(0)));
			rrepository.save(new Recording("Lagwagon", "Double Plaidium", 1997, "Fat Wreck Chords", "4th album", 39.47, frepository.findByFormat("Vinyl").get(0), crepository.findByCondition("Mint-").get(0), grepository.findByGenre("Punk").get(0)));
			rrepository.save(new Recording("Pyotr Ilyich Tchaikovsky/The London Symphony Orchestra, André Previn", "Swan Lake, Sleeping Beauty, The Nutcracker", 2014, "Warner Classics", "Ballet music", 5.29, frepository.findByFormat("CD").get(0), crepository.findByCondition("VG+").get(0), grepository.findByGenre("Classical").get(0)));
			
			User user1 = new User("user",
"$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin",
"$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("fetch all recordings");
			for (Recording recording : rrepository.findAll()) {
				log.info(recording.toString());
			}
		};
	}
}
