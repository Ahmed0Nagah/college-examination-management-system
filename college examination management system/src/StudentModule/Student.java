
package StudentModule;

import java.util.*;


public class Student extends UserModule.User{
    
    private static int id = 100;

    Student ( String name , String password) {
	super ( name , password);
	id++;
    }

    @Override
    public int getID( ) {
	return id;
    }

//====================================================================================================================

public static int correctExam(String answer, String course, String examName) {
	FileHandler fileHandler = new FileHandler();
	
	String[] AllAnswers = fileHandler.fileData("Answers\\Answers.txt");
	String[] element = answer.split(",");
	
	int correctAnswers = 0;
	for (String allData1 : AllAnswers) {
		String[] FileContent = allData1.split(",");
		
		for (String Content : FileContent) {
			
			if (Content.equals(course)) {
				
				for (String Content2 : FileContent) {
					if (Content2.equals(examName)) {
						
						String s3 = "";
						for (int i = 2; i < FileContent.length; i++) {
							s3 += FileContent[i] + ",";
						}
						
						if (s3.isEmpty()) {
							break;
							
						}
						
						String[] str3 = s3.split(",");
						for (int j = 0; j < str3.length; j++) {
							if (element[j].equals(str3[j])) {
								
								correctAnswers++;
								
							}
							
						}
						
					}
				}
				
				break;
			}
		}
		
	}
	return correctAnswers;
}
// ====================================================================================================================

private boolean EnterForOnce(String id, String course, String examName) {   //  delete
	FileHandler fileHandler = new FileHandler();
	boolean d = false;
	String filePath = "students\\student_" + id + ".txt";
	
	boolean fileExists = fileHandler.checkFileExistence(filePath);
	
	if (fileExists) {
		String[] allData = fileHandler.fileData(filePath);
		
		boolean courseExists = false;
		boolean examExists = false;
		
		for (String data : allData) {
			String[] fileContent = data.split(",");
			for (int i = 0; i < fileContent.length - 1; i++) {
				String current = fileContent[i].trim();
				String next = fileContent[i + 1].trim();
				if (current.equals(course) && next.equals(examName)) {
					courseExists = true;
					examExists = true;
					
					break;
				}
			}
		}
		
		d = courseExists && examExists;
	}
	
	return d;
}


// =============================================(a)====================================================================
public void EnterExam( String course ) {
	FileHandler fileHandler = new FileHandler();
	String[] allData = fileHandler.fileData("src\\Student_"+this.id+".txt");
	for(String data : allData)
	{
		if( (data.equals(this.id+""))){
			for (String allData1 : allData) {

				if (allData1.contains(course)) {
					String[] exams = fileHandler.fileData("Exams\\Exams.txt");

					for (String exam : exams) {
						String[] examData = exam.split(",");
						for (String ex : examData) {
							if (ex.equals(course)) {

								int counter = 0;
								String examName = null;

								for (String examData1 : examData) {
									if (examData1.endsWith("?")) {
										counter++;
									}
									examName = examData[counter];

								}
								if (EnterForOnce(this.id+"", course, examName)) {
									break;
								} else {
									System.out.println(exam);
									String[] examInfo = exam.split(",");
									System.out.println("Exam name : " + examInfo[examInfo.length-4] );
									System.out.println("Subject : " + examInfo[examInfo.length-3] );
									System.out.println("Number of questions : " + examInfo[examInfo.length-2] );
									System.out.println("Exam duration : " + examInfo[examInfo.length-1] );
									System.out.println ("===================================================================================================================" );
									for(int index = 0 ; index < examInfo.length-4 ; index++)
									{
										System.out.println((index+1) + ") " +examInfo[index] );
									}
									Scanner input = new Scanner(System.in);
									String str = "";
									for (int q = 1; q <= counter; q++) {
										System.out.print("Enter the answer for question # " + q + " :");
										String answer = input.nextLine();
										str += answer + ",";
									}

									int degree = correctExam(str, course, examName);
									System.out.println("Your degree = " + degree);
									String Data = System.getProperty("line.separator") + course + "," + examName + ","+ degree;
									String [] arrayData= {Data};
									saveStudentDataInFile(this.id+"",arrayData);
									break;
								}
							}

						}
					}
					System.exit(0);
				}
			}
		}
		else
		{
			System.exit(0);
		}
	}
}


//// ===================================================================================================================
private void saveStudentDataInFile(String id, String[] data) {
	String filePath = "students\\student_" + id + ".txt";
	FileHandler fileHandler = new FileHandler();
	fileHandler.writeInFile(true, filePath, data);
}}

