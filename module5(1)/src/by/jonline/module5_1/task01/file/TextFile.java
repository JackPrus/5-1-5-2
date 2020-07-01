package by.jonline.module5_1.task01.file;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class TextFile extends File {

	public TextFile(String name) {
		super(name+".txt");
		
	}
	
	public void addTextToFile(String... text) {

		List<String> lines = new ArrayList<String>();
		for (String ss : text) {
			lines.add(ss);
		}

		try {
			if (isExist()) {

				Files.write(getPath(), lines, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
				System.out.println(String.format("В файл \"%s\" добавлен текст", getName()));
			} else {
				System.out.println(String.format("Файл \"%s\" не переименован. Его нет в указаной папке.", getName()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NullPointerException ee) {
			System.out.println("Текущий объект не может добавить текст в этот файл.");
		}

	}

	public void printFile() {

		List<String> lines;
		try {
			if (isExist()) {
				lines = Files.readAllLines(Paths.get(getDirectory().getWay() + getName()));
				for (String ss : lines) {
					System.out.println(ss);
				}
			} else {
				System.out.println("Печать невозможна. Указанный файл не найден");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	
}


}
