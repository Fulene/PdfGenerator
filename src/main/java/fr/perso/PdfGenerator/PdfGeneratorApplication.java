package fr.perso.PdfGenerator;

import fr.perso.PdfGenerator.services.PdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PdfGeneratorApplication implements CommandLineRunner {
	@Autowired
	PdfService pdfService;

	public static void main(String[] args) {
		SpringApplication.run(PdfGeneratorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		pdfService.generatePdf();
	}
}
