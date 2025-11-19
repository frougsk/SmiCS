package bases;

public class Course {
	// Attributes
	private final String courseCode;
	private final String courseName;
	private final int units;
	private final String description;
	private final String studentType;

	// Constants
	public static final String BSCS = "Bachelor";
	public static final String MASTER = "Master";
	public static final String PHD = "PhD";
	public static final String MIT = "Master in IT";
	
	// Constructor
	public Course(String code, String name, int units, String description, String type) {
		this.courseCode = code;
		this.courseName = name;
		this.units = units;
		this.description = description;
		this.studentType = type;
	}
	
	// Getters
	public String getCode() { return courseCode; }
	public String getCName() { return courseName; }
	public int getUnits() { return units; }
	public String getDesc() { return description; }
	public String getType() { return studentType; }
