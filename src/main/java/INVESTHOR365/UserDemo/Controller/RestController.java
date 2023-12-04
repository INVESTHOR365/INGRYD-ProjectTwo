package INVESTHOR365.UserDemo.Controller;

import org.springframework.web.bind.annotation.*;
import java.io.*;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/project")
public class RestController {
    File file1 = new File("Message.txt");
    File file2 = new File("log.txt");

    @GetMapping("/getter")
    public String getMessage() {
        StringBuilder sb = new StringBuilder();
        String x;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file1))){
            while((x = bufferedReader.readLine()) != null){
                sb.append(x);
            }
        } catch (IOException az) {
            System.out.println(az.getMessage());
        }
        return sb.toString();
    }

    @GetMapping("/counter")
    public int getMessageCount() {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(file1))) {
            while (reader.readLine() != null) {
                count++;
            }

        } catch (IOException az) {
            System.out.println(az.getMessage());
        }
        return (count / 3);
    }

    @PostMapping("/poster")
    public String postMessage(@RequestBody String message) {
        try (BufferedWriter bufferedwriter1 = new BufferedWriter(new FileWriter(file1, true))) {
            bufferedwriter1.write(message + "#");

            try (BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file2, true))){
                bufferedWriter2.write("\nNew message created" + "#");
            }
        }


        catch (IOException az) {
            System.out.println(az.getMessage());
        }
        return "New message created successfully";
    }

    @GetMapping("/logs")
    public String getLog() {
        StringBuilder sb = new StringBuilder();
        String x;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("file2.txt"))){
            while((x = bufferedReader.readLine()) != null){
                sb.append(x);
            }
        } catch (IOException az) {
            System.out.println(az.getMessage());
        }
        return sb.toString();
    }
}
