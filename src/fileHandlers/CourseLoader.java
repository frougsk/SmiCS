package fileHandlers;

import bases.Course;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class CourseLoader {
    // Attributes / Temp Storage
    private ArrayList<Course> bs = new ArrayList<>();
    private ArrayList<Course> master = new ArrayList<>();
    private ArrayList<Course> phd = new ArrayList<>();
    private ArrayList<Course> mit = new ArrayList<>();

    // Getters
    public ArrayList<Course> getBS() {
        bs = getCourses(Path.of("data", "ics_cmsc_courses.csv"));
        return bs;
    }

    public ArrayList<Course> getMasters() {
        master = getCourses(Path.of("data", "ics_mscs_courses.csv"));
        return master;
    }

    public ArrayList<Course> getPHD() {
        phd = getCourses(Path.of("data", "ics_phd_courses.csv"));
        return phd;
    }

    public ArrayList<Course> getMITS() {
        mit = getCourses(Path.of("data", "ics_mit_courses.csv"));
        return mit;
    }

    // Get Courses
    public ArrayList<Course> getCourses(Path path) {
        ArrayList<Course> courses = new ArrayList<>();
        System.out.println("Loading CSV from: " + path.toAbsolutePath());

        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            br.readLine(); // skip header

            while ((line = br.readLine()) != null) {
                String[] cDetails = line.split(",", 4);

                // Skip row if not enough columns (Line corrupted)
                if (cDetails.length < 4) {
                    System.out.println("Skipping invalid row: " + line);
                    continue;
                }

                String code = cDetails[0].trim();
                String name = cDetails[1].trim();
                int unit;
                String description = cDetails[3].trim();

                // Parse units
                try {
                    unit = Integer.parseInt(cDetails[2].trim());
                } catch (NumberFormatException ex) {
                    System.out.println("Skipping row with invalid units: " + line);
                    continue;
                }

                // Determine type from file name
                String file = path.getFileName().toString();
                String type;
                if (file.equals("ics_cmsc_courses.csv")) type = Course.BSCS;
                else if (file.equals("ics_mit_courses.csv")) type = Course.MIT;
                else if (file.equals("ics_mscs_courses.csv")) type = Course.MASTER;
                else type = Course.PHD;

                // Create and add course
                Course c = new Course(code, name, unit, description, type);
                courses.add(c);
            }

        } catch (IOException e) {
            System.out.println("Error reading courses: " + e.getMessage());
        }

        return courses;
    }
}
