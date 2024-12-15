package StudentModule;

import java.io.*;

public class FileHandler {
void writeInFile( boolean isAppend , String filePath , String[] newData ) {
	try {
		BufferedWriter bw = new BufferedWriter( new FileWriter( new File( filePath ) , isAppend ) );
		for( int line = 0 ; line < newData.length ; line++ ) {
			bw.write( newData[ line ] ); bw.newLine( );
		} bw.flush( ); bw.close( );
	}
	catch( Exception e ) {
		System.out.println( e.getMessage( ) );
	}
}

//====================================================================================================================
int howManyLinesInFile( String filePath ) {
	int numOfLines = - 1;
	
	try( LineNumberReader lineNumberReader = new LineNumberReader( new FileReader( new File( filePath ) ) ) ) {
		lineNumberReader.skip( Long.MAX_VALUE ); numOfLines = lineNumberReader.getLineNumber( );
	}
	catch( Exception e ) {
		System.out.println( e.getMessage( ) );
	} return numOfLines;
}

//====================================================================================================================
String[] fileData( String filePath ) {
	
	String[] allData = new String[ new FileHandler( ).howManyLinesInFile( filePath ) ]; 
	try {
		BufferedReader br = new BufferedReader( new FileReader( filePath ) );
		for( int i = 0 ; i < allData.length ; i++ ) {
			allData[ i ] = br.readLine( );
		}
	}
	catch( Exception e ) {
		System.out.println( e.getMessage( ) );
	} return allData;
}
//====================================================================================================================
public boolean checkFileExistence( String filePath ) {
	File f = new File( filePath ); return f.exists( ) && ! f.isDirectory( );
}
//====================================================================================================================
}
