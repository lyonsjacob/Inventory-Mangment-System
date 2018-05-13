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
	 * @return File name and path String.
	 */
	public String getFile() {

		JFileChooser fileSelect = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

		int returnValue = fileSelect.showOpenDialog(null);
		/*if (returnValue == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileSelect.getSelectedFile();
				selectedFile.getAbsolutePath();
				return selectedFile.getAbsolutePath();
		}
		*/
		File selectedFile = fileSelect.getSelectedFile();
		selectedFile.getAbsolutePath();
		return selectedFile.getAbsolutePath();
	}


}
