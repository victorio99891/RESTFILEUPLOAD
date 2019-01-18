package pl.wiktor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.wiktor.response.CustomResponse;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

@RestController
@RequestMapping("/REST")
public class FileController {

    @Autowired
    Environment environment;

    private String DOWNLOAD_DIRECTORY = null;


    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ResponseEntity<?> getHome() {
        return new ResponseEntity<>(new CustomResponse("Allright!", HttpStatus.OK), HttpStatus.OK);
    }

    @RequestMapping(value = "/fileUp", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile multipartFile) throws IOException {

        DOWNLOAD_DIRECTORY = environment.getProperty("download.file.directory");
        System.out.println(DOWNLOAD_DIRECTORY);

        File file = new File(DOWNLOAD_DIRECTORY + multipartFile.getOriginalFilename().toLowerCase());
        file.createNewFile();
        FileOutputStream fostr = new FileOutputStream(file);
        fostr.write(multipartFile.getBytes());
        fostr.close();
        return new ResponseEntity<>(new CustomResponse("File upload done!", HttpStatus.OK), HttpStatus.OK);
    }

    @RequestMapping(value = "/show/{photoName}", method = RequestMethod.GET)
    public ResponseEntity<?> getImage(@PathVariable("photoName") String photoName) throws IOException {

        DOWNLOAD_DIRECTORY = environment.getProperty("download.file.directory");

        File file = new File(DOWNLOAD_DIRECTORY + photoName.toLowerCase() + ".jpg");


        byte[] image = Files.readAllBytes(file.toPath());

        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
    }

    @RequestMapping(value = "/pdf/{pdfName}", method = RequestMethod.GET)
    public ResponseEntity<?> getPdf(@PathVariable("pdfName") String pdfName) throws IOException {

        DOWNLOAD_DIRECTORY = environment.getProperty("download.file.directory");

        File file = new File(DOWNLOAD_DIRECTORY + pdfName.toLowerCase() + ".pdf");


        byte[] image = Files.readAllBytes(file.toPath());

        return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF).body(image);
    }


}
