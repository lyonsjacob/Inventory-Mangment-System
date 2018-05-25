package main;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

/**
 * Creates a file selector window and returns the filename and path.
 * @author Jacob Lyons N9507175
 *
 */
public class FileSelector {
	
	/**
	 * Creates a file selector window and returns the filename and path.
	 * 
	 * @author Jacob Lyons N9507175
	 * @return 
	 * @return File name and path String.
	 */
	public String getFile() {
		JFileChooser fileSelect = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		
		int returnValue = fileSelect.showOpenDialog(null);
		File selectedFile = fileSelect.getSelectedFile();
		return selectedFile.getAbsolutePath();
	}	
}