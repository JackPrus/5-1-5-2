package by.jonline.module5_1.task01;

import by.jonline.module5_1.task01.file.File;
import by.jonline.module5_1.task01.file.TextFile;

public class Tak01 {
	
	/*Создать объект класса Текстовый файл, используя классы Файл, Директория. 
	 * Методы: создать, переименовать, вывести на консоль содержимое, дополнить, удалить. 
	 */
	
	public static void main(String[] args)  {
		
		
		File file1 = new TextFile("first");
		file1.getDirectory().setWay("d:/программирование/5 блок/новая папка/");
		file1.createFile();
		file1.addTextToFile("новый текст ....новый текст");
		file1.deleteFile();
		file1.rename("second");
		file1.printFile();
		
		
		File file2 = new TextFile("first");
		file2.getDirectory().setWay("d:/программирование/5 блок/новая папка/");
		file2.createFile();
		file2.rename("фывафыва");
		file2.addTextToFile("фывафывафыыва");
		file2.printFile();
		
		
	}
}
